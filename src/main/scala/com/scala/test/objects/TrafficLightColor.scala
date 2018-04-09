package com.scala.test.objects

/**
  * Created by jufeng on 2018/4/9.
  */
object TrafficLightColor extends Enumeration{
  val Red ,Yellow, Green = Value

  // val Red = Value
  // val Yellow = Value
  //  val Green = Value

  /* val Red = Value(1,"Stop")
   val Yellow = Value(10)
   val Green = Value("Go")*/

  def main(args: Array[String]): Unit = {


    println(Yellow)

    for (c <- values)
      println(c.id +" : " +c)
  }
}
