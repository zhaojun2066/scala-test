package com.scala.test.extendss

/**
  * Created by jufeng on 2018/4/9.
  * 动物感知范围，用整数表示
  * 初始化顺序问题
  * 实例化Ant 对象时候 env 大小为0，因为rang 调用getter 方法是子类ant的，此时ant 的range 还未进行初始化，range 默认是0
  */
class Creature {
  val range: Int = 10 //感知范围
  val env: Array[Int] = new Array[Int](range)



}
