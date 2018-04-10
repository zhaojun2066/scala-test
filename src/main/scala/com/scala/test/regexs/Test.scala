package com.scala.test.regexs

/**
  * Created by jufeng on 2018/4/10.
  */
object Test {
  def main(args: Array[String]): Unit = {

    //正在表达式
    val numPattern = "[0-9]+".r
     //val pp = """\s+[0-9]+\s+""".r   // 包含反斜杠或者引号使用 """原始"""
    //val pp = "\\s+[0-9]+\\s+".r  和上面一样

    for (m <- numPattern.findAllIn("89 hello,90d jj 000")) println(m)

    println(numPattern.findFirstIn("89 hello,90d jj 000"))
    println(numPattern.findFirstMatchIn("89 hello,90d jj 000"))
    println(numPattern.findPrefixOf("89 hello,90d jj 000").get)

    println(numPattern.replaceAllIn("89 hello,90d jj 000","BBBB"))
    println(numPattern.replaceFirstIn("89 hello,90d jj 000","BBBB"))

    //正在表达式组，可以让我们方便的获取正在表达式的子表达式，在想要提取的子表达式两侧加上括号即可
    val pGroup = "([0-9]+) ([a-z]+)".r
    for (pGroup(num,item) <-pGroup.findAllIn("99 bottoes, 98 botties")){
      println(num);println(item)
    }


  }

}
