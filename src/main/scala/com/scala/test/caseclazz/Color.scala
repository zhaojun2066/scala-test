package com.scala.test.caseclazz

/**
  * Created by jufeng on 2018/4/18.
  * case 类模拟枚举
  */
sealed abstract class Color
case object Red extends Color
case object Yellow extends Color
case object Green extends Color

object c{
  def c(color:Color) = color match {
    case  Red => "stop"
    case Yellow => "care"
    case Green => "go"
  }
}
