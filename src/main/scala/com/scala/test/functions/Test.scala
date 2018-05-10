package com.scala.test.functions

/**
  * Created by jufeng on 2018/4/12.
*/
object Test {

  val num = 3.14
  val fun = math.ceil _ // _ 将ceil 方法转成了函数，在scala中你无法直接操作方法，而只能直接操作函数

  def main(args: Array[String]): Unit = {
    println(fun(num))

    val s = Array(3.14,1.42,2.0).map(fun).mkString(" , ")
    println(s)


    //匿名函数
    val triple = (x:Double) => x*3
    //等同于下面
    def triple2 (x:Double) = x*3

    //还可以将匿名函数直接传递给另一个函数
    val ss =Array(3.14,1.42,2.0).map((x:Double) => 3 * x).mkString(" , ")
    println(ss)

    //定义参数为函数的函数
    //这里的参数是接受Double 参数和返回Double 的任何函数，类型写作： 函数名: (参数类型 ...) =>  结果类型
    def valueAtOntQuarter(f: (Double) => Double) = f(2.5)
    val  a = valueAtOntQuarter(math.ceil _)
    println("a=> " + a)
    val b = valueAtOntQuarter(math.sqrt _)
    println("b=> " + b)

    //产生另一个函数的函数
    def mulBy(factor: Double) = (x: Double) => factor * x
    //mulBy 返回 (x: Double) =>Double 类型的函数
    val q = mulBy(5)
    val c = q(20)
    println("c=> " +c)
    val d = mulBy(5)(20) // 还可以这样调用
    println("d=> " +d)


    //类型推断
    valueAtOntQuarter((x:Double) =>3 * x)
    valueAtOntQuarter((x) =>3 * x)
    valueAtOntQuarter(x =>3 * x)
    //下面是最新简单的,如果参数在=> 右侧只出现一次，就可以用_代替它
    val  e = valueAtOntQuarter(3 * _)
    println("e=> " +e)

    (1 to 9).map(0.1 * _)
    (1 to 9).map("*" * _).foreach(println(_))

    (1 to 9).filter(_ % 2 == 0 ).foreach(println _)

    val  g = "hello a has littter less".split(" ").sortWith(_.length < _.length)
    println(g.mkString(" , "))

    //柯里化
    def mul(x: Int,y:Int) = x * y
    //柯里化后
    def mulOne (x:Int) = (y: Int) => x * y
    //调用
    println(mulOne(7)(8))
    //再来一次最简答的
    def mulOnes(x:Int)(y:Int) = x*y
    println(mulOnes(7)(8))


    //控制抽象
    def runThread(block: () => Unit): Unit ={
      new Thread(){
        override def run(){block()}
      }.start()
    }

    runThread(() => println("Hello"))

    //换名调用表示法 声调() 换成 :
    def runThread2(block: => Unit): Unit ={
      new Thread(){
        override def run(){block}
      }.start()
    }
    runThread2(println("Hello"))

    //换名调用参数
    def untils(condition: => Boolean)(block: => Unit): Unit ={
      if (!condition){
        block
        untils(condition)(block)
      }
    }

    var x = 10
    untils(x==0){
      x -=1
      println(x)
    }

    delayed(time)

    println(getUser(address,"jufeng",25))

  }

  def time() = {
    println("get Time")
    System.nanoTime
  }

  def delayed( t: Long) ={
    println("t => " +t)
  }

  def address(name: String,age: Int)={
    name +" : " +age + " on langfang"
  }

  def getUser(f: (String,Int) => String,name: String,age: Int) = {
      f(name,age)
  }
}
