package com.scala.test.ed3.c07

import java.io.File

import scala.io.Source

/**
  * Created by jufeng on 2018/5/18.
  */
class ForTest {

  def fileLines(file: File)={
    Source.fromFile(file).getLines().toList
  }

  def grep(files:List[File],pattern: String) = {

    //嵌套的for循环
    for{
      f <- files
      if f.isFile
      if f.getName.endsWith(pattern)
      line <- fileLines(f)
      if line.trim.matches(pattern)
    }println(f + ": "+ line.trim)
  }
}
