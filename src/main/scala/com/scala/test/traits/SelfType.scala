package com.scala.test.traits

/**
  * Created by jufeng on 2018/4/11.
  */
trait SelfType extends Logger{
  this: Exception =>
   def log(): Unit = {
    println(getMessage)
  }
}
