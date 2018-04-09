package com.scala.test.array

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.collection.JavaConversions.mapAsScalaMap
/**
  * Created by jufeng on 2018/4/8.
  */
object Test {


  def test1()={

    //定长数组
    val nums = new  Array[Int](10) //初始化所有的数组都是0
    for (a <- nums) println(a)

    val a = new Array[String](10)//初始化为null
    val b =  Array("hello","world")//长度为2 且类型是推断出来的
    val c = b(0)//访问元素 (index)

    // Int Double 其他数字都对应java的基本类型的数组


    //变长数组
    val q = ArrayBuffer[Int]()
    val d = new ArrayBuffer[Int]
    //向尾部追加元素
    d += 1 //追加1
    d += (2,3,5,7) //继续追加 2357 多个元素
    d ++= Array(7,8,9) //追加其他数组
    d.trimEnd(5)//移除最后5个元素
    d.insert(2,10)//在第二位置插入10
    d.insert(2,11,12,13)//在第二位置插入任意多个元素
    d.remove(1)//删除指定位置的元素
    d.remove(1,3)//移除指定位置后多少个元素
    //定长数组和不定长数组转换
    val  e = d.toArray
    val f = e.toBuffer


    //遍历数组
    for (i<- 0 until d.length){  //until 不含最后一个length
      println(d(i))
    }

    for (j <- d){//直接取元素
      println(j)
    }

    //数组转换, yield 会产生新的集合或者数组，原来的集合和数组并不会受到影响
    val x = Array(1,2,3,4,5,6)
    val result = for (elem <- x) yield 2 * elem
    // result (2,4,6,8,10,12) ,得到了一个新的数组
    for(elem <- x if elem % 2 ==0) yield  2 * elem

    d.sum //求和
    d.max   //最大值
    d.min //最小
    val  i = d.sorted //排序
    d.mkString(",") //转换为string 逗号相隔
    d.mkString("<",",",">")

    //映射 元组

   //不可变
    val scores = Map[String,Int]("Alice"->100, "Bob"->78)
    //和上面等价 scores = Map[String,Int](("Alice",100), ("Bob",78))
   //可变
    val score = scala.collection.mutable.Map("Alice"->100, "Bob"->78)

    //取值
    val bobScore = scores("Bob")

    scores.contains("Bob") //检查key 是否存在
    var bobS = scores.getOrElse("Bob",0) // if (scores.contains("Bob")) scores("bob") else 0
   // println(scores("00")) //java.util.NoSuchElementException: key not found: 00

    score("Bob") = 99

    println(score("Bob"))

    score += ("Tom"->90,"Jun"->100) //追加



    println(score.mkString("|"))

    score -= "Tom" //移除key

    println(score.mkString("|"))

    val newScores = score + ("Hl"->90,"ZX"-> 99) //相加
    println(newScores.mkString("|"))

    newScores +=("H11l"->90,"ZX111"-> 99)
    println(newScores.mkString("|"))

    for ((k,v) <- score){
      print(k+"->"+v+"  ")
    }
    println()
    for (k <- score.keySet) print(k+ ",")
    println()
    val re_score = for ((k,v) <- score) yield (v,k) // kv 翻转
    for ((k,v) <- re_score){
      print(k+"->"+v+"  ")
    }
    println()
    //插入顺序
    //val moths = scala.collection.mutable.LinkedHashMap
    //moths("a"->"ns")
    // 引入这个，下面才可以转换 import scala.collection.JavaConversions.mapAsScalaMap
    val cc: scala.collection.mutable.Map[String,Int] = new java.util.HashMap[String,Int]()

    //元组
    val t = (1, 3.14 , "Fred")
    println(t._1)  // 元组是从1 开始访问的
    println(t _2)

    val ac = "Heelo WwiOld".partition(_.isUpper)
    println(ac _1)

    //输出对偶的数组 拉链操作
    val one = Array("!" , "@" ,"#")
    val two = Array(1,2,3)
    val there = one.zip(two)
    println(there.mkString("|"))
    for ((s,n) <- there){
      Console.print(s*n)
    }

    //转成map
    there.toMap

  }



  def main(args: Array[String]): Unit = {
    test1()
  }

}
