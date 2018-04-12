package com.scala.test.operators

/**
  * Created by jufeng on 2018/4/12.
  */
class Fraction(n:Int, d:Int) {
 // def *(other: Fraction) =new Fraction(n * other.n,d* other.d)
}

object Fraction{
  def apply(n: Int, d: Int): Fraction = new Fraction(n, d)

  def unapply(arg: Fraction): Option[(Int, Int)] = {
    //if(arg.d == 0) None else Some((arg.n,arg.d))
    null
  }
}
