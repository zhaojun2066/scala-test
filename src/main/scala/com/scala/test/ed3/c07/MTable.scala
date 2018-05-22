package com.scala.test.ed3.c07

/**
  * Created by jufeng on 2018/5/21.
  */
class MTable {

  def makeRowSeq(row: Int)=
    for(col <- 1 to row) yield {
      val prod = (row * col).toString
      val padding = " " *  (4 - prod.length)
      padding + prod
    }

  def makeRow(row: Int) = makeRowSeq(row).mkString

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }
}

object MTable{
  def main(args: Array[String]): Unit = {
    println(new MTable().multiTable())
  }
}

/**
   1
   2   4
   3   6   9
   4   8  12  16
   5  10  15  20  25
   6  12  18  24  30  36
   7  14  21  28  35  42  49
   8  16  24  32  40  48  56  64
   9  18  27  36  45  54  63  72  81
  10  20  30  40  50  60  70  80  90 100
  */
