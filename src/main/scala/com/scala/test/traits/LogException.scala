package com.scala.test.traits

/**
  * Created by jufeng on 2018/4/10.
  * 特质也也可以扩展或者叫继承类，
  * 也可以直接继承其他特质
  * 继承或者扩展该特质LogException的类，也会自动继承Exception类
  * 但是如果子类已经继承了其他类，如果是Exception的子类是可以的，如果是不相关的类，是不可以的
  */
trait LogException  extends Exception with Logger{
  override def log(msg: String): Unit = println(msg)
}
