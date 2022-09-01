package com.ummaaack.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

data class CarForList(
    val car: String,
    val engine: String
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        //리스트뷰에 얹고 싶은 리스트 만들기
        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
            carList.add(CarForList("$i 번째 자동차", "$i 순위 엔진"))
        }

        val listView = findViewById<ListView>(R.id.listView)
        val adapter = ListViewAdapter(carList, this)
        listView.adapter = adapter

    }

    //BaseAdapter을 상속받아 Adapter 구현
    //사용자의 데이터를 받아 뷰(View)를 생성해주는 객체로 ListView와는 독립적으로 동작하는 객체입니다.
    //ListView는 Adpater로부터 생성된 뷰(View)를 받아 ListView의 한 항목으로 배치
    class ListViewAdapter(
        val carForList: ArrayList<CarForList>,
        val context: Context
    ) : BaseAdapter() {
        override fun getCount(): Int {
            return carForList.size
            //adapter가 아이템의 개수를 알아야 화면에 그릴 아이템 개수 조절 가능
            //그리고자 하는 아이템 리스트에서의 아이템 전체갯수
        }

        override fun getItem(p0: Int): Any {
            return carForList.get(p0)
            //p0은 listView의 순서임 해당 인덱스에 해당하는 아이템 정보 알려줌
            //그리고자 하는 아이템 리스트의 하나(포지션에 해당하는는
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
            //아이디를 포지션으로 해주겠다=포지션은 listView의 아이템의 인덱스
            //해당 포지션에 위치한 아이템 뷰의 아이디 설정
        }

        override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
            // getView( )가 리턴하는 객체가 하나의 텍스트 뷰나, 버튼 같은 하나의 뷰가 아니라 레이아웃일 수도 있다
            //여기서는 layout을 View로 return하고 싶기 때문에 수동으로 inflate해준다
            val rootView: View
            val holder: ViewHolder

            if (convertView == null) {
                Log.d("ㅡㅡㅡㅡㅡㅡㅡgetViewㅡㅡㅡㅡㅡㅡㅡ", "inflate합니다~")
                val layoutInflater = LayoutInflater.from(context)
                holder = ViewHolder()
                rootView = layoutInflater.inflate(R.layout.activity_second, null)

                //id를 holder에 담아둔다
              //  holder.carName = rootView.findViewById<TextView>(R.id.car_name)
            //    holder.carEngine = rootView.findViewById<TextView>(R.id.car_engine)

                rootView.tag = holder
            } else {
                //View의 tag를 이용해서 holder를 지정한다
                holder = convertView.tag as ViewHolder
                rootView = convertView
            }

            //찾은 view들의 text에 원하는 data를 bind해준다
            holder.carName?.text = carForList[pos].car
            holder.carEngine?.text = carForList[pos].engine

            //bind한 view객체를 return한다
            return rootView
        }
    }

    class ViewHolder {
        var carName: TextView? = null
        var carEngine: TextView? = null
    }

    override fun onStart() {
        super.onStart()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onDestroy")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onBackPressed")
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onUserLeaveHint")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt("하이", 111111111)
        }
        super.onSaveInstanceState(outState)
        Log.d("ㅡㅡㅡㅡㅡㅡㅡAㅡㅡㅡㅡㅡㅡㅡ", "onSaveInstanceState")
    }
}

