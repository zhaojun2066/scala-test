package com.scala.test.options

import scala.collection.mutable

/**
  * Created by jufeng on 2018/4/18.
  */
object Test {
  def main(args: Array[String]): Unit = {
    val map = mutable.HashMap[String,Int]("a" -> 10)
    val a = map.get("a")
    println(a.get)
  }

}
