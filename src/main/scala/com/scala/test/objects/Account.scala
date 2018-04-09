package com.scala.test.objects

/**
  * Created by jufeng on 2018/4/9.
  */
class Account(val id:Int,initalBalance : Double) {
  //val id = Account.newUniqueNumber()
  private var balance = initalBalance
  def deposit(amout :Double): Unit ={
    balance += amout
  }
  def  currentBalance = balance
}

object Account{ //伴生对象 ，相当于定义静态方法

  def apply(initalBalance: Double ): Account = new Account(
   newUniqueNumber(),initalBalance
  )

  private var lastNumber = 0
  private def newUniqueNumber() = {
    lastNumber += 1
    lastNumber
  }


  def main(args: Array[String]): Unit = {
    var account = Account(200D)
  }
}


