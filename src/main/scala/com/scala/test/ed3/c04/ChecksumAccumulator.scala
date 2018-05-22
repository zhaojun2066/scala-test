package com.scala.test.ed3.c04

import scala.collection.mutable

/**
  * Created by jufeng on 2018/5/17.
  */
class ChecksumAccumulator {

  private var sum = 0 ;//类型推断，var 是变量,可以改变，scala 默认权限是public

  /*def add(b: Byte) = {
    sum += b
  }
  def checksum(): Int = {
    return ~(sum & 0xFF) +1 // return 可以省略掉，scala 可以推断最后一个表达式的值
  }*/

  // 如果只是在一行就可以搞定的事情 ，还可以省略掉{}
  //无参数，甚至可以不写()
  def add(b: Byte): Unit = sum += b
  def checksum: Int = ~(sum & 0xFF) +1

}

object ChecksumAccumulator{
 // val acc = new ChecksumAccumulator
 // val csa = new ChecksumAccumulator
  private val cache = mutable.Map.empty[String,Int]
  def  calculate(s: String): Int = {
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      s.toCharArray.foreach(c => acc.add(c.toByte))
      val cs = acc.checksum
      cache += (s-> cs)
      cs
    }
  }
}
