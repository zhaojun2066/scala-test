package com.scala.test.objects

/**
  * Created by jufeng on 2018/4/8.
  *
  */
object Singleton {

  private var number = 0
  def newNumber() = {number +=1 ; number}

  // 调用 newNumber时候，Singleton构造器会被首次调用，切只会执行一次

  def main(args: Array[String]): Unit = {
   val a =Singleton.newNumber()
    println(a)
  }
}
