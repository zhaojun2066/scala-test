package com.scala.test.implicits

/**
  * Created by jufeng on 2018/5/9.
  *
  *隐式参数
    scala > def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate
    scala > implicit val currentTaxRate = 0.08F
    scala > val tax = calcTax(50000F) // 4000.0

隐式地转换类型
  scala> val i: Int = 3.5 //直接报错
  加上这句：
  scala> implicit def double2Int(d: Double) = d.toInt
  再运行，没报错
  scala> val i: Int = 3.5  //i=3
  */

//隐式调用函数
class SwingType{
  def  wantLearned(sw : String) = println("兔子已经学会了 "+sw)
}
object swimming{
  implicit def getType(s : AminalType) = new SwingType
}
class AminalType

object Test {
  def main(args: Array[String]): Unit = {
    import  swimming._
    val rabbit = new AminalType
    rabbit.wantLearned("breaststroke")         //蛙泳
  }
}
