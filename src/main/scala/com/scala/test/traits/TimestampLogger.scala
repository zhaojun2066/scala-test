package com.scala.test.traits

import java.util.Date

/**
  * Created by jufeng on 2018/4/10.
  */
trait TimestampLogger extends Logger{

  override def log(msg: String): Unit = {
    println(new Date+ " : " + msg)
  }
}
