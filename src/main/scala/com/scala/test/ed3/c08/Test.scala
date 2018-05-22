package com.scala.test.ed3.c08


/**
  * Created by jufeng on 2018/5/21.
  *  函数字面量或者值编译器最终会生成相应的FunctionN的类，调用传入参数的时候，实际调用的是FunctionN的apply方法
  */
class Test {

  (x: Int) => x + 1000 //函数字面量的定义

  //函数值的定义,是不需要写返回值的类型的
  val increase = (x: Int) => x +1
  //多条语句用{}
  val inc  = (x: Int) => {
    println("We")
    x+1
  }

  //部分函数,部分函数一个表达式，在表达式中并不会给出函数需要的所有参数
  def sum (a: Int,b: Int,c: Int) = a + b + c
  //基于sum创建一个部分函数
  val a = sum _ //其实把一个方法转换为一个函数了，转换成函数值了
  val b = sum(1,_: Int,3)

  //闭包
  var more = 3
  val addMore = (x: Int) => x + more  // 闭包能捕获到之后这个自由变量的变化
  more = 10

  def makeIncr(more: Int) = (x: Int) => x + more  // 返回一个函数
  val incr1 = makeIncr(1)  // 此时more 绑定的more 是1
  val incr999 = makeIncr(999)// 此时more 绑定的more 是999

  //可变参数
  def echo(args: String*) = {
    args.foreach(println)
  }


}

object Test{
  def main(args: Array[String]): Unit = {
    val numbers = List(1,2,3,4)
    numbers.foreach((x: Int) => println(x)) // 字面量的用法
    numbers.filter((x:Int) => x> 3)
    numbers.filter((x) => x>0) //函数字面量的简写
    numbers.filter(x => x> 7)

    //占位符语法：如果每个参数在表达式中只出现一次，就可以用占位符来表示,下划线只是代表第几个参数，不能重读使用针对一个参数
    numbers.filter(_ > 0)
    numbers.foreach(println)

    numbers.foreach(println _) //替换整个参数列表，所以改下划线是整个参数列表的占位符，注意需要空格，否则编译器会认为println_ 是一个单独的方法
    //println _ 其实是编写了一个部门应用的函数

    val t = new Test
    t.a(1,2,3)
    println(t.b(2))// 内部原理是b.apply(2) 调用了sum（1,2,3）

    println("addMore: " + t.addMore(2))

    var s = 0
    numbers.foreach( s += _)// 同样 闭包函数也能修改外部的s 变量的值,也就是包内的修改，对包外也是可见的
    println("s==> "+s)
    println("incr1==> "+t.incr1(9))
    println("incr999==> "+t.incr999(1))

  }


}
