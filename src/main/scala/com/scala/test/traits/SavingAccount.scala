package com.scala.test.traits

import com.scala.test.objects.Account

/**
  * Created by jufeng on 2018/4/10.
  */
/*class SavingAccount(id:Int,initBalance : Double) extends Account(id,initBalance) with ConsoleLogger with ShortLogger{

  //特质内的抽象字段必须被重写
  val maxLength = 20  // 这样写 注意构造器初始化顺序
  def withdraw(amount:Double) = {
    if (amount>balance) info("Insufficient funds")
    else balance -= amount
  }

}
object SavingAccount{
  def main(args: Array[String]): Unit = {
    //在构造对象的时候 加入这个特质，你就可以调用这个特质的方法，感觉有点注入的意思
    val acct = new SavingAccount(1,2000) with ConsoleLogger
    acct.log("jaj")



    // 最后的特质log方法被调用
    val acc = new SavingAccount(1,100) with ConsoleLogger with TimestampLogger with ShortLogger
    acc.withdraw(2000)

    val axx = new  SavingAccount(1,200) with ConsoleLogger with ShortLogger with TimestampLogger
    axx.withdraw(2000)

    //如果想要指定，可以用 super[ConsoleLogger].log(...)

  }
}
*/

class SavingAccount(id:Int,initBalance : Double) extends Account(id,initBalance) with ConsoleLogger {
  def withdraw(amount:Double) = {
    if (amount>balance) info("Insufficient funds")
    else balance -= amount
  }
}


object SavingAccount{
  def main(args: Array[String]): Unit = {
    // 最后的特质log方法被调用
    val acc = new SavingAccount(1,100) with ConsoleLogger with TimestampLogger with ShortLogger {
      override val maxLength: Int = 20
    }
    acc.withdraw(2000)

    val axx = new  SavingAccount(1,200) with ConsoleLogger with ShortLogger with TimestampLogger {
      override val maxLength: Int = 20
    }

    axx.withdraw(2000)
  }
}
