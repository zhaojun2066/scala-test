package com.scala.test.conllections

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jufeng on 2018/4/12.
  */
object Test {

  def main(args: Array[String]): Unit = {

    // scala.collection.immutable  是不可变的集合
    //scala.collection.mutable 是可变的集合
    //默认scala 和 Predef包是倒入不可变的集合

    //其实已经有了sum
    List(1,2,3,4,5,6).sum
    val l:List[Int] = List(1,2,3,4,5,6)
    val s = l ::: List(9999) // ::: 和 ++ 一样
    val newlist = 90 :: s   // +: 一样,添加头
    val newlisr =newlist :+ 900  //添加尾部
    newlisr.foreach(println(_))
    println(newlisr.mkString(","))
    val set = Set(1,2,3,4,5,6) + 12
    val newset = set+99
    println(newset.mkString(","))


    //ArrayBuffer 可变Seq
    //追加
    var ab = ArrayBuffer(1,2,3,4)
    ab += 5
    println(ab.mkString( " | " ))
    ab += (6,7)
    println(ab.mkString( " | " ))
    var cd = ArrayBuffer(1,2)
    val ef = ab -- cd
    println(ef.mkString( " | " ))
    println(ab.mkString( " | " ))

    //可变集合 Seq Set Map 包含的操作符
    // coll += elem
    // coll += (elem1,elm2,..)
    // coll ++=coll2
    // coll -= ele,
    // coll -=(e1,e2,..)
    // coll --= coll2
    //一般而言用+ 添加到无顺序的Set Map 的集合
    // 而 +: :+ 是将元素添加到有先后顺序的集合的开头和末尾 Seq : coll :+elem ,elem +:coll

    //
    Vector(1,2,3) :+ 4 // 1,2,3,4
    1+: Vector(2,3,4,5)// 1,2,3,4,5

    //可变
    val numbers = ArrayBuffer(1,2,3)
    numbers+=4 //修改原来的集合
    //不可变集合,但是是var
    var nums = Set(1,2,3)
    val numss = nums+5
    println(nums.mkString("||")) // 1 ,2, 3
    nums += 78
    println(nums.mkString("||")) // 1 ,2, 3 , 78

    //汇总
    //集合有 Seq :有顺序 Vector 、Array ArrayBuffer
    // Map: 无顺序
    // Set:无顺序
    //List: 有顺序
    /**
      * 1 向后  :+ 或者向前 (+:) 追加元素到序列当中
      * 2 添加 (+) 元素到无先后次序的集合当中 Set
      * 3 用- 移除元素
      * 4 用++ 和-- 批量添加和移除元素
      * 5 对于列表List 优先使用 :: 和 ::: 操作
      * 6 改值操作有 += ++= -= --=
      * 7 对于集合我更喜欢++  &  --
      * 8我尽量不时候用++: +=: ++=:
      */



  }

  //递归求和，因为list.tail 仍然是一个集合
  def sum(list: List[Int]):Int = {
    if (list==Nil ) 0 else list.head + sum(list.tail)
  }
  //模式匹配
  def sums(list: List[Int]):Int = list match {
    case Nil => 0
    case h :: l => h + sums(l) // h list.head , l list.tail
  }



}
