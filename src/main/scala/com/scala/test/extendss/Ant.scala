package com.scala.test.extendss

/**
  * Created by jufeng on 2018/4/9.
  *  应该避免复写的字段 在父类构造器被调用或者使用
  */
class Ant extends Creature{
  override val range = 2 //这样重写，可能会有父类数组大小为0 的情况
}

//这样解决
class Cat extends {
  override val range = 2
}with Creature
