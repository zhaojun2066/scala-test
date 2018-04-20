package com.scala.test.clazz

/**
  * Created by jufeng on 2018/4/19.
  *
  * 这个Point类有4个成员：变量x和y，方法move和toString。Scala基本的构造函数就包含在类签名之中（var x: Int, var y: Int），
  * 这跟其他很多语言都是不同的。方法move有两个整型参数，返回Unit类型的值()，返回值不代表任何信息，与类Java语言中的void类似
  * 。方法toString正好相反，它没有参数，但是返回String类型的值。由于toString覆盖了从AnyRef继承来的toString，因此它需要使用
  * 关键字override修饰。
  */
//构造函数可以通过提供默认值实现可选择的参数，
/**
  *
  没有使用val和var修饰的参数是私有的值（values），只对class内部可见。
  class Point(x: Int, y: Int)
  val point = new Point(1, 2)
  point.x  // <-- does not compile

  class Point(val x: Int, val y: Int)
  val point = new Point(1, 2)
  point.x = 3  // <-- does not compile

   如果只有var/val修饰，则字段总是对外可见的，即默认是public的
   如果连var/val也没有，则字段对外不可见，同时内部只读，不可改写，即默认是：private val
  */
class Point(var x:Int=0,var y:Int=0) {

  def move(dx:Int,dy:Int): Unit ={
    x += dx
    y += dy
  }

  override def toString: String = {
    s"($x,$y)"
  }
}

//伴生对象
object Point{
  def apply( x: Int,y: Int):Point={
    new Point(x,y)
  }

  def apply = new Point //调用默认值 x y

  def main(args: Array[String]): Unit = {
    val point1 = Point(1,2)
    point1.move(2,1)
    println(point1)

    val p2 = new Point(1)
    println(p2)

    val p3 = new Point(y=3)
    println(p3)

    val p4 = new Point(x=9)
    println(p4)


  }
}
