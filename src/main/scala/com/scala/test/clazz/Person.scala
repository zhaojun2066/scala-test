package com.scala.test.clazz

import scala.beans.BeanProperty

/**
  * Created by jufeng on 2018/4/8.
  */


class Person {

   @BeanProperty  var name :String = _ //这样会生成java风格的set和get 方法 ，和scala 风格的get和set方法

  var age = 0 // 默认生成 getter and setter 都是public的 age()  age_=(v:Int)
  private var gender = 1  // private生成 getter and setter 都是private的

  val fly = false //val 放入变量 只有getter方法被生成，生成的java的代码是私有的final 和 getter 方法

  private [this] var score = 90 //只能被当前对象访问，对象私有

  def this(age:Int){  //辅助构造器
    this() //调用默认的主构造器
    this.age = age
  }

  def this(age:Int,name:String){//辅助构造器
    this(age)
    this.name = name
  }
}

object Person{
  def main(args: Array[String]): Unit = {
    val p = new Person()
    val p2 = new Person(12)
    val p3 = new Person(12,"Tom")


  }
}
