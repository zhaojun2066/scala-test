package com.scala.test.extendss

import scala.util.Random

/**
  * Created by jufeng on 2018/4/9.
  */
object Test {

  def main(args: Array[String]): Unit = {

    //匿名子类的方式
    val fred = new Person("tom",12) {
      override def description(say: String): String = {
        toString
      }

      override def id: Int = Random.nextInt()

      override val address: String = "beijing  china "
    }

    println(fred.description("rr"))
  }
}
