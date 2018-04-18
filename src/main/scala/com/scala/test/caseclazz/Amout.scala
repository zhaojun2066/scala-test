package com.scala.test.caseclazz

/**
  * Created by jufeng on 2018/4/18.
  * case 样例类 必须带有参数，会自动生成apply 和unapply方，切参数默认是都是val
  *
  * ​sealed关键字可以修饰类和特质（特质）。密封类提供了一种约束：不能在类定义的文件之外定义任何新的子类
  *
  * sealed 其修饰的trait，class只能在当前文件里面被继承；
  * sealed 在检查模式匹配的时候，用sealed修饰目的是让scala知道这些case的所有情况，scala就能够在编译的时候进行检查，看你写的代码是否有没有漏掉什么没case到，减少编程的错误。
  */
sealed abstract class Amout {

}

case class Dollar(value: Double) extends Amout

case class Currency(value:Double,unit: String) extends Amout

//单利对象的样例对象
case object Nothing extends Amout


object Amout{
  def t(a:Amout):String = a match {
    case Dollar(v) => "$ " +v
    case Currency(_,u) => "Oh noes, I got " + u
    case Nothing => "nothing"
  }

  def main(args: Array[String]): Unit = {
    println(t(Dollar(4)))

    //case 类的copy
    val amt = Currency(10,"Jf")
    val price = amt.copy()
    val p2 = amt.copy(value = 90)
    println(amt)
    println(price)
    println(p2)
  }
}
