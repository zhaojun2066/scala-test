package com.scala.test.traits

/**
  * Created by jufeng on 2018/4/10.
  */
trait ShortLogger extends Logger{
  val maxLength:Int
  override def log(msg: String): Unit = {
    if (msg.length <= maxLength){
      println(msg)
    }else{
      println(msg.substring(0,maxLength-1)+"...")
    }
  }
}
