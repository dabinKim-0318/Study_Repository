package com.ummaaack.myapplication.itemdecoration

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.myapplication.R
import com.ummaaack.myapplication.RecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint

data class Event(val value: Int) {
    val date: Int
        get() = value / 10

    val isHeader: Boolean
        get() = value % 10 == 0
}

@AndroidEntryPoint
class ItemDecorationTestActivity : AppCompatActivity() {
    private lateinit var adapter: StickyHeaderAdapter

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_decoration_test)

        adapter = StickyHeaderAdapter(events)

        val recyclerView = findViewById<RecyclerView>(R.id.rv)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(StickyHeaderItemDecoration(getSectionCallback()))
    }


    private fun getSectionCallback(): StickyHeaderItemDecoration.SectionCallback {
        return object : StickyHeaderItemDecoration.SectionCallback {
            override fun isHeader(position: Int): Boolean {
                return adapter.isHeader(position)
            }

            override fun getHeaderLayoutView(list: RecyclerView, position: Int): View? {
                return adapter.getHeaderView(list, position)
            }
        }
    }

    private val events: List<Event>
        get() {
            val result = mutableListOf<Event>()
            for (i in 0 until 100) {
                result.add(Event(i))
            }
            return result
        }

    class StickyHeaderItemDecoration(
        private val sectionCallback: SectionCallback //SectionCallback 상속한 익명객체를 아이템데코레이션 만들떄 넣기
    ) : RecyclerView.ItemDecoration() {

        override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            Log.e("ㅡㅡ", "=======================================")
            super.onDrawOver(c, parent, state)

            //현재 맨 위에 있는 view를 얻는다
            val topChild = parent.getChildAt(0) ?: return //0번쨰 인덱스의 ItemView를 얻는다
            Log.e("ㅡㅡ", "현재 헤더 View: $topChild") //맨 위에 있는 뷰

            //맨 위에있는 view의 position을 얻는다
            val topChildPosition = parent.getChildAdapterPosition(topChild) //ItemView의 position을 얻는다
            Log.e("ㅡㅡ", "현재 맨위 포지션: $topChildPosition") //맨 위에 있는 뷰의 position이니까 0

            //현재 맨 위에 있는 position을 이용해서 itemView를 얻는다(data까지 bind된)
            val currentHeader = sectionCallback.getHeaderLayoutView(parent, topChildPosition) ?: return//헤더뷰를 얻는다
            Log.e("ㅡㅡ", "현재 헤더 ItemView: $currentHeader")

            //그린다
            fixLayoutSize(parent, currentHeader, topChild.measuredHeight)

            //헤더뷰의 바닥부분이 접촉포인트->int타입
            val contactPoint = currentHeader.bottom
            Log.e("ㅡㅡ", "현재 해더 bottom : $contactPoint")

            //현재 헤더뷰의 bottom값을 이용해서 다음 view를 얻는다
            val childInContact: View = getChildInContact(parent, contactPoint) ?: return
            Log.e("ㅡㅡ", "다음 View: $childInContact")

            //다음 view를 이용해서 다음 view의 포지션을 얻는다
            val childAdapterPosition = parent.getChildAdapterPosition(childInContact)
            Log.e("ㅡㅡ", "다음 View 포지션: $childAdapterPosition")

            if (childAdapterPosition == -1) return //불필요할 것 같긴합

            when {
                //다음 뷰의 포지션을 이용해서 헤더인지 아닌지를 adapter를 통해 얻는다
                sectionCallback.isHeader(childAdapterPosition) -> {
                    moveHeader(c, currentHeader, childInContact)
                    Log.e("ㅡㅡ", "다음 포지션이 헤더?: 응")
                }
                //헤더가 아니다
                else -> {
                    drawHeader(c, currentHeader)
                    Log.e("ㅡㅡ", "다음 포지션이 헤더?: 아니")
                }
            }
        }


        private fun moveHeader(c: Canvas, currentHeader: View, nextHeader: View) {
            c.save() //캔퍼스를 사용하기 전(변형을 하기전:회전, 원점 이동 등....)환경을 save함수를 이용해서 저장
            //헤더가될 다음 nextHeader를 header위치로 이동시킨다
            c.translate(0f, nextHeader.top - currentHeader.height.toFloat())
            currentHeader.draw(c)
            c.restore() //캔퍼스를 변경해서 그린 후 restore()함수를 통해 캔퍼스를 사용하기 전 환경
        }

        private fun drawHeader(c: Canvas, header: View) {
            c.save()
            c.translate(0f, 0f)
            header.draw(c)
            c.restore()
        }

        //contactPoint를 뭔가 가공해서 View를 던진다
        private fun getChildInContact(parent: RecyclerView, contactPoint: Int): View? {
            var childInContact: View? = null
            for (i in 0 until parent.childCount) {
                val child = parent.getChildAt(i)
                if (child.bottom > contactPoint) {
                    if (child.top <= contactPoint) {
                        childInContact = child
                        break
                    }
                }
            }
            return childInContact
        }

        //todo
        //헤더 뷰를 측정하여 크기가 0보다 크고 그려질지 확인합니다.
        private fun fixLayoutSize(parent: ViewGroup, view: View, height: Int) {
            val widthSpec = View.MeasureSpec.makeMeasureSpec(
                parent.width,
                View.MeasureSpec.EXACTLY
            )
            val heightSpec = View.MeasureSpec.makeMeasureSpec(
                parent.height,
                View.MeasureSpec.EXACTLY
            )
            val childWidth: Int = ViewGroup.getChildMeasureSpec(
                widthSpec,
                parent.paddingLeft + parent.paddingRight,
                view.layoutParams.width
            )
            val childHeight: Int = ViewGroup.getChildMeasureSpec(
                heightSpec,
                parent.paddingTop + parent.paddingBottom,
                height
            )
            view.measure(childWidth, childHeight)
            view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        }

        interface SectionCallback {
            fun isHeader(position: Int): Boolean //헤더인가 유무
            fun getHeaderLayoutView(list: RecyclerView, position: Int): View? //position주면 View반환
        }
    }
}




