package com.ummaaack.myapplication.observe


interface Observer {
    fun update()
}

//관찰자 1
class Dog: Observer {
    override fun update() {
        println("멍멍")
    }
}

//관찰자 2
class Cat: Observer {
    override fun update() {
        println("야옹")
    }
}

class Owner {
    val observerList = mutableListOf<Observer>()

    fun register(observer:Observer){
        observerList.add(observer)
    }

   fun notifyUpdate(){
       for(observe in observerList){
           observe.update()
       }
   }
}

fun main(){
    val owner=Owner()
    val dog=Dog()
    val cat=Cat()

    owner.register(dog) //옵져버 등록
    owner.register(cat) //옵져버 등록

    owner.notifyUpdate() //오너가 신호를 보냄 = 이벤트 발생
}