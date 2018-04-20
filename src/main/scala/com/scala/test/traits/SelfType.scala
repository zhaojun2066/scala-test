package com.scala.test.traits

/**
  * Created by jufeng on 2018/4/11.
  * 自身类型并不会被自动继承,子类必须是Exception的子类或者trait 在加一个this:Exception 或者是Exception子类
  */
trait SelfType extends Logger{
  this: Exception =>
   def log(): Unit = {
    println(getMessage)
  }
}

/*
自身类型并不会被trait class 自动继承
class Child extends SelfType{
  override def log(msg: String): Unit = {}
}
trait Children extends SelfType{
  override def log(msg: String): Unit = {}
}
*/
trait Childs extends SelfType{
   this: IndexOutOfBoundsException =>
   override def log(msg: String): Unit = {}
}

class Childss extends SelfType{
  this: IndexOutOfBoundsException =>
  override def log(msg: String): Unit = {}
}
class Child extends IndexOutOfBoundsException with SelfType{
  override def log(msg: String): Unit = {}
}
