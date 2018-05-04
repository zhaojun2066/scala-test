package com.scala.test.conllections

import scala.collection.mutable
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

    var names = List("ajun","jevin","hurrican")
    println(names.map(_.toUpperCase).mkString(","))

    println(names.flatMap(ulcase(_)).mkString(" | "))

    //reduceLeft  ((1-7)-2) -9 从左侧到右侧开始组合减法
    println(List(1,7,2,9).reduceLeft(_ - _))

    //1- (7-(2-9)) 从右侧最后两个元素开始组合做减法
    println(List(1,7,2,9).reduceRight(_ - _))

    // 0-1-7-2-9
    println(List(1,7,2,9).foldLeft(0)(_ - _))

    //计算某个字符串中字母出现的频率
    val freq = scala.collection.mutable.Map[Char,Int]()
    for(c <- "Mississippi") freq(c) = freq.getOrElse(c,0)+1

    //拉链操作
    val prices = List(5.0,20,9.09)
    val skus = List(10,33,34)
    println(prices.zip(skus).map(p => p._1 * p._2)) // [(),(),()] 得到List[元组]
    println(prices.zip(skus).map(p => p._1 * p._2)sum) // [(),(),()] 得到List[元组]


    //视图懒计算，可以重新计算
    val powers = (0 until 1000).view.map(math.pow(10,_)) // .force强制计算
    println(powers(1))
    println(powers(1))

    //java scala 集合互操作
    //javaConversions

    // 引入这个，下面才可以转换 import scala.collection.JavaConversions.mapAsScalaMap
    import scala.collection.JavaConversions.mapAsScalaMap
    val cc: scala.collection.mutable.Map[String,Int] = new java.util.HashMap[String,Int]()

    //线程安全的集合
    //scala 提供了六种特质，你可以将他们混入
    //SynchronizedBuffer SynchronizedMap SynchronizedPriorityQueue SynchronizedQueue SynchronizedSet SynchronizedStack
    val scores = new mutable.HashMap[String,Int]() with mutable.SynchronizedMap[String,Int]
    //最好还是使用java.util.concurrent ，比如 ConcurrentHashMap，你可以将java.util.concurrent 中集合转换为scala集合来使用

    //大型集合的并行
    // coll.par.sum ,par方法产出当前集合的一个并行实现
    val ccc = ArrayBuffer(23,22,44,66)
    println(ccc.par.count(_ % 2 ==0))
    //并行 for,s输出顺序是无法预知的
    for(i <- (0 to 50).par) print(i +  " ")

    println()

    var m= Map[String,String]()
    m += ("a"-> "b")
    println("m-> " + m("a"))
    val list = List(3,5,2,10,6)
    println(list.sortBy(e => (e)).takeRight(6))

    val alist = List(A(5,3),A(2,3),A(2,4))
    alist.sortBy(w => (w.score,w.weight))(Ordering.Tuple2(Ordering.Double.reverse, Ordering.Double.reverse) )
      .foreach(println(_))




  }

  def ulcase(s:String) = Vector(s.toUpperCase(),s.toLowerCase())

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

case class A(score: Double,weight: Double)
