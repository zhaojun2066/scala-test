package com.scala.test.traits

/**
  * Created by jufeng on 2018/4/10.
  *  多个特质用with关键添加
  *  java 所有的接口都可以做scala的特质来使用
  *  scala 只能有一个超类 ，但可以有任意数量的特质
  */
trait ConsoleLogger extends Logger with Cloneable with Serializable{
  def log(msg: String): Unit = { //不需要写override,因为是实现抽象的方法，否则还是需要写的
    println(msg)
  }
}
