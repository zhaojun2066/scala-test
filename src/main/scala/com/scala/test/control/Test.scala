package com.scala.test.control

/**
  * Created by jufeng on 2018/4/4.
  * scala 没有switch语句
  *
  */
class Test {

  def test(x:Int):Int={
    if (x>0) 1 else -1
  }

  def  test01(x:Int)={
    val s = if (x>0) 1 else -1
    println(s)

    // 下面相当于返回Unit Unit 相当于(),也相当于void
    if(x>0) 1 //等同于下面
    if (x>0) 1 else ()

     var  n=0
    if (x>0) {n = x*2; n =x-1}


    //块逻辑 是{} 中的语句,最后一个表达式的值是块的返回值
    val distance = {val dx = x-0;val dy = x-8; math.sqrt(dx*dy)}

    //一个赋值动作是没有值的，可以说他们的值都是Unit类型的
    //如：
    var j = 2
    val a ={j = j * 2 ; j -= 1} //此时 a 是Unit

    //串在一起赋值是不对
    //var c = b = 1 ,b=1 返回的是Unit

    //打印
    println("dd")//换行
    print("")
    printf("hell0,%s","jun")

    //读取控制台输入：
    val  name = readLine("Yourn name: ")
    println("Your age:")
    val age = readInt()
  }

  def test03() = {
    var r=1;
    var n = 100
    while (n>0){
      r = r*n
      n -=1
    }

    //  1 to n 返回 1 到n 之内的数字 包含1 和n，i的集合是集合的类型，所以不用定义
    for(i <- 1 to n){
      r = r * i
    }

    //util 不包含上线区间
    val s = "hello"
    var sum = 0
    for (i <- 0 until  s.length ){
      sum += s(i)
    }
    //等同于下面
    var total = 0
    for (ch <- "Hello") total+=ch

    //多个表达式 或者叫生成器
    for (i <- 1.to(3) ; j <- 1 to 3 ) print(j+"_"+i)
    //每个生成器都可以带一个返回Boolean的if语句
    for (i <- 1 to 3 ; j <- 1 to 2 if i!=j) print(( 10 * i + j) + " ")

    //引入变量
    for (i <- 1 to 3 ; from = 4-i ;j <- from to 3) print(( 10 * i + j) + " ")
     // 12 22 23 31 32 33
    //yield 每次迭代会生成集合的一个值  ,叫做for循环的推导式
    var vector = for (i <- 1 to 10 ) yield i % 3
   // vector (1,2,0,1,2,0,1,2,0,1)

    //for推导式 生成的集合是和第一个生成器是类型兼容
    for (c <- "Hello" ; i<- 0 to 1) yield (c+i).toChar // "HIeflmlmop"

    //还可以花括号
    for {i <- 1 to 3
         from = 4-i
         j <- from to 3
    } print(( 10 * i + j) + " ")


  }

  def fac(n:Int)= {
    var r= 1
    for (i<- 1 to 20 ) r = r*i
    r // 返回值
  }

  //递归必须有返回值
  def fac1(n:Int) : Int = if (n<0) 1 else n* fac1(n-1)

  //默认值,
  def dccorate(str:String,left:String = "[",right: String = "]"):String = {
     left + str + right
  }

  //变长参数，就是类型Seq的参数
  def sum (args: Int*) = {
    var result = 0
    for (arg <- args) result += arg

    result
  }

  var s = sum(1,2,2)
 // var s2 = sum(1 to 5)1 to 5 不是Seq类型 会错误
  var s3 = sum(1 to 5: _*) //1 to 5 这样就转换为了Seq类型

  def  test11() ={
    //懒赋值，只有当用到的时候，才会打开文件赋值，切只有一次
    lazy val words = scala.io.Source.fromFile("D:\\me\\scala-test\\src\\main\\scala\\com\\scala\\test\\App.scala").mkString
    words
  }





}
