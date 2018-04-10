package com.scala.test.traits

import java.io.PrintWriter
import java.util.Date

/**
  * Created by jufeng on 2018/4/10.
  */
trait FileLogger extends Logger{
   val our  = new PrintWriter("app.log") //特质构造器的一部分
  our.println("# " + new Date()) //同样也是特质的构造器一部分
  override def log(msg: String): Unit = {
    our.println(msg)
    our.flush()
  }
}
