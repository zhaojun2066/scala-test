package com.scala.test.maths

import com.scala.test.objects.{Account, TrafficLightColor}

/**
  * Created by jufeng on 2018/4/17.
  */
object Test {

  def main(args: Array[String]): Unit = {

    var sign:Int=0
    val ch: Char = 1

    var a = ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        case  _  => sign = 0

    }

    val color = TrafficLightColor.Green
    color match {
      case TrafficLightColor.Red=> "Red"
      case TrafficLightColor.Green => "Green"
      case _ => "YELLOW"
    }

    //守卫,是一个Boolean表达式
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ if Character.isDigit(ch) => sign = Character.digit(ch,10)
      case _  => sign = 0
    }


    println(echoWhatYouGaveMe(0))
    println(echoWhatYouGaveMe(true))
    println(echoWhatYouGaveMe("hello"))
    println(echoWhatYouGaveMe(Nil))
    // trigger the sequence patterns
    println(echoWhatYouGaveMe(List(0,1,2)))
    println(echoWhatYouGaveMe(List(1,2)))
    println(echoWhatYouGaveMe(List(1,2,3)))
    println(echoWhatYouGaveMe(Vector(1,2,3)))
    // trigger the tuple patterns
    println(echoWhatYouGaveMe((1,2))) // two element tuple
    println(echoWhatYouGaveMe((1,2,3))) // three element tuple
    // trigger the constructor patterns
   // println(echoWhatYouGaveMe(Person("Melissa", "Alexander")))
   // println(echoWhatYouGaveMe(Dog("Suka")))
    // trigger the typed patterns
    println(echoWhatYouGaveMe("Hello, world"))
    println(echoWhatYouGaveMe(42))
    println(echoWhatYouGaveMe(42F))
    println(echoWhatYouGaveMe(Array(1,2,3)))
    println(echoWhatYouGaveMe(Array("coffee", "apple pie")))
   // println(echoWhatYouGaveMe(Dog("Fido")))
    println(echoWhatYouGaveMe(List("apple", "banana")))
    println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))
    // trigger the wildcard pattern
    println(echoWhatYouGaveMe("33d"))
    println(echoWhatYouGaveMe(Array(0)))
    println(echoWhatYouGaveMe(Array(1,2)))
    println(echoWhatYouGaveMe(Array(1,2,3)))
    println(echoWhatYouGaveMe(Array(0,1,2,3)))

    println(variableMatch(1))
    println(variableMatch(1.0))
    println(guardtest((1,1)))
    println(guardtest((2,3)))

  }

  //变量模式匹配
  //变量模式匹配给匹配到的值命名了一个变量名，因此你可以在推导符后面使用它
  def variableMatch(x:Any):String = x match {
    case i: Int => s"this is an int: $i"
    case otherValue => s"This is other value: $otherValue"
  }

  //守卫
  def guardtest(x: (Int,Int)):Int = x match {
    case (a,b) if a==b => a-b
    case (a,b) => a*b
  }

  def echoWhatYouGaveMe(x:Any): String= x match {
    case 0 => "Zero "
    case true => "true "
    case "hello" => "you said 'hello' "
    case Nil => "an empty List"
    //List patterns
    case List(0,_,_) => "a three-element list with 0 as the first element"
    case List(1,_*) => "a list beginning with 1, having any number of elements"
    case Vector(1,_*) => "a vector starting with 1, having any number of elements"
    case Array(0) => "(0)"
    case Array(x,y) => x+ " "+y
    case Array(x,_*) => x+ " ... "
    case Array(0,_*) => "0 ..."
      //tuple 原则
    case (a,b) =>  s"got $a and $b"
    case (a,b,c) => s"got $a, $b, and $c"

    // constructor patterns
  //  case Account(first,"Alex") => s"found an Alexander, first name = $first"
      // case Dog("Hel") => " "
    //type Patterns
    case s: String => s"you gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"thanks for the float: $f"
    case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
    case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
    case list: List[_] => s"thanks for the List: $list"
    case m: Map[_, _] => m.toString
    // the default wildcard pattern
    case _ => "Unknown"

  }


}
