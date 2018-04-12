package com.scala.test.operators

import scala.collection.mutable

/**
  * Created by jufeng on 2018/4/12.
  */
object Test {

  def main(args: Array[String]): Unit = {

    //中置操作符
    1 to 10 // 1.to(10)
    1 -> 10 //1.->(10)

    //后置操作符
    1 toString // 1.toString()

    //前置操作符
    //+ - ！ ~ 都是前置操作符 如-a 相当于转为a.unary_-

    //赋值操作符
    //a 操作符= b 等同于 a = a 操作符 b
    // a += b 等同于虎 a = a + b


    // :: 操作符是右结合的,下面列表
    1 :: 2 :: Nil
    //等同于
    1 :: (2 :: Nil)

    // 2::Nil 的意思是 Nil.::(2)


    //apply 、update 方法

    val scores = new mutable.HashMap[String,Int]()
    scores("Bob") = 90 // 调用 scores.update("Bob",90)
    val bobScore = scores("Bob") //调用 scores.apply("Bob")

    //apply 对象经常用到伴生对象中，涌过来构造对象，而不是显示的使用new

    //unapply  相当于apply的反向操作，apply接受构造参数，然后将他们变成对象，unapply是接受一个对象，然后提取其中的值，通常这些是当初用来构造该对象的值



    val Number(n) = "111"  //匹配到n 给n赋值

    println(n)
  }



}

object Number{
  def unapply(arg: String): Option[Int] = {
    try {
      Some(Integer.parseInt(arg))
    }catch {
      case ex: NumberFormatException => None
    }
  }
}

//提取任意长度的值的序列
object Names{
  def unapplySeq(input:String):Option[Seq[String]] ={
    if (input.trim=="") None else Some(input.trim.split("\\s+"))
  }
}


