package com.scala.test.serializa

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jufeng on 2018/4/10.
  */
@SerialVersionUID(42L)  class Person  extends Serializable{
  val age = 20
  val friends = new ArrayBuffer[Person]() //ok scala 集合类都是可序列化的
}

object Person{
  def main(args: Array[String]): Unit = {
    val fred = new Person
    import java.io._
    val out = new ObjectOutputStream(new FileOutputStream("D:\\me\\scala-test\\src\\main\\scala\\com\\scala\\test\\serializa\\Person.bak"))
    out.writeObject(fred)
    out.close()

    val in = new ObjectInputStream(new FileInputStream("D:\\me\\scala-test\\src\\main\\scala\\com\\scala\\test\\serializa\\Person.bak"))
    val savaFred = in.readObject().asInstanceOf[Person]
    println(savaFred.age)


  }
}
