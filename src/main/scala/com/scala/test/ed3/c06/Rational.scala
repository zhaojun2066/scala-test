package com.scala.test.ed3.c06

/**
  * Created by jufeng on 2018/5/18.
  */
class Rational(n: Int,d: Int) {
  require(d!=0) //前置条件，d 分母不能为0
  private val g =  gcd(n.abs,d.abs)
  val numer: Int = n / g
  val denom: Int = d / g
  def this(n: Int) = this(n,1);//辅助构造函数，分母为1

  override def toString: String = s"create $n / $d"  //字符串插值
  /*def add(that: Rational): Rational = {
    new Rational(numer*that.denom + that.numer*denom,denom*that.denom)
  }*/

  /**
    * 定义加法
    * @param that
    * @return
    */
  def +(that: Rational): Rational = {
    new Rational(numer*that.denom + that.numer*denom,denom*that.denom)
  }
  def +(a: Int): Rational  = {
    new Rational(this.numer + a*this.denom,this.denom)
  }

  def -(that: Rational): Rational = {
    new Rational(this.numer* that.denom - that.numer*this.denom,this.denom*that.denom)
  }

  def -(i: Int): Rational = {
    new Rational(numer - i* denom,denom)
  }

  def *(that: Rational): Rational = {
    new Rational(this.numer *that.numer + this.denom*that.denom)
  }

  def *(i: Int): Rational = {
    new Rational(numer*i,denom)
  }

  def lessThen(that: Rational): Boolean = {
    this.numer *that.denom < that.numer *this.denom
  }
  def max(that: Rational): Rational = if(lessThen(that)) that else this

  private def gcd(a: Int,b: Int): Int ={
    if (b==0) a else gcd(b,a % b)
  }




}


object Rational{
  def main(args: Array[String]): Unit = {
    println(new Rational(2) + 1)
    implicit def intToRational(x: Int) = new Rational(x) //
    println(2 + (new Rational(8,9)))
  }
}

// r*2 ok
// 2 * r not ok，不过可以定义一个隐式转换的方法   implicit def intToRational(x: Int) = new Rational(x)

