package com.scala.test.extendss

/**
  * Created by jufeng on 2018/4/9.
  */
class Item(val name:String,val price:Double) {

  /**
    *
    * @param other  必须为Any 否则不会override
    * @return
    */
  override def equals(other: scala.Any): Boolean = {
    val that = other.asInstanceOf[Item]
    if (that == null)false
    else name.equals(that.name) && price == that.price
  }


  override def hashCode(): Int = {
    val state = Seq(name, price)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
