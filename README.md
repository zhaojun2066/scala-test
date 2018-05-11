##scala-test

Stream 
Views 

case 中置表示法  
类型约束 

##型变
    对于一个带类型参数的类型，比如 List[T]，如果对A及其子类型B，满足 List[B]也符合 List[A]的子类型，
    那么就称为covariance(协变)，如果 List[A]是 List[B]的子类型，即与原来的父子关系正相反，则称为
    contravariance(逆变)
    1）trait Queue[T] {} 
    这是非变情况。这种情况下，当类型S是类型A的子类型，则Queue[S]不可认为是Queue[A]的子类型或父类型，
    这种情况是和Java一样的。 
    
    2）trait Queue[+T] {} 
    这是协变情况。这种情况下，当类型S是类型A的子类型，则Queue[S]也可以认为是Queue[A}的子类型，
    即Queue[S]可以泛化为Queue[A]。也就是被参数化类型的泛化方向与参数类型的方向是一致的，所以称为协变。 
    
    3）trait Queue[-T] {} 
    这是逆变情况。这种情况下，当类型S是类型A的子类型，则Queue[A]反过来可以认为是Queue[S}的子类型。
    也就是被参数化类型的泛化方向与参数类型的方向是相反的，所以称为逆变。 

###协变
     _____               _____________ 
    |     |             |             |
    |  A  |             |  List[ A ]  |
    |_____|             |_____________|
       ^                       ^ 
       |                       | 
     _____               _____________ 
    |     |             |             |
    |  B  |             |  List[ B ]  |
    |_____|             |_____________|  
    
###逆变
     _____               _____________ 
    |     |             |             |
    |  A  |             |  List[ B ]  |
    |_____|             |_____________|
       ^                       ^ 
       |                       | 
     _____               _____________ 
    |     |             |             |
    |  B  |             |  List[ A ]  |
    |_____|             |_____________|  
    
    
### 类型层级
    Any是所有类型的超类型，也叫做顶部类型。它定义了一些通用的方法，例如equals，hashCode，toString。
    Any有两个直接的子类：AnyVal和AnyRef。
    
    AnyVal表示值类型。有9个预定义的值类型，并且它们是非空的：Double，Float，Long，Int，Short，Byte，
    Char，Unit，Boolean。Unit是不代表任何信息的值类型。Unit类型只有一个实例，记作()。所有函数都必须
    返回某个值，因此有时Unit可以作为返回类型。
    
    AnyRef表示引用类型。所有非值类型都被定义为引用类型。在Scala中所有用户自定义的类型都是AnyRef的子
    类型。如果在Java运行环境使用Scala，则AnyRef与java.lang.Object是相对应的。
### 类型转换
    byte->short->int->long->float->double
            ↑
            char
            
### Noting Null
    Nothing是所有类型（包含Null）的子类型，也叫做底部类型。没有值具有Nothing类型。一个常见用法是用Nothing表示非终
    止状态，例如抛出的异常，程序退出，死循环（也就是说，它是一个无法计算出值的表达式的类型，或者是无
    法正常返回的方法的类型）。
    
    Null是所有引用类型的子类型（也就是AnyRef的所有子类型的子类型）。Null只有一个值，使用关键字null表
    示。Null主要是为了支持与其他JVM语言协同工作的，在Scala代码中几乎从来都不会用到。我们后面将会讲解
    可以取代null的其他选择。

### 类
    Scala中的类是创建对象的原型。类中可以包含方法，值，变量，类型，对象，特征和类，这些都叫做成员。
    类型，对象和特征将在后面讲解。
    见：com.scala.test.clazz.Point
    
### 主构造函数的参数（类参数）
    那么接下来的问题就是要讨论不管是主构造函数列表中的参数还是类体中的字段，它们的可见性到底怎样定义？
    
    首先，要说明的是：var/val限定的是变量是否可读写，与可见性无关，即对外可见；public和private声明的才是
    可见性，但是在省略这些关键字时还是有默认值的，情况如下：
    
    如果只有var/val修饰，则字段总是对外可见的，即默认是public的
    如果连var/val也没有，则字段对外不可见，同时内部只读，不可改写，即默认是：private val
    第二条不适用于case class，case class的类参数在不指定val/var修饰时，会自动编译为public val，即对外只读，
    如果需要case class的字段外部可写，可以显式地指定var关键字！
    
    规则如下：
    
    对于var修饰的参数：外部可读/可改写 （实际上是：编译器为该类参数（字段）自动生成了getter和setter）
    对于val修饰的参数：外部可读/不可改写（实际上是：编译器为该类参数（字段）只生成了getter没有生成setter）
    对于private var修饰的参数：内部可读/可改写 （编译器不会为私有类参数（字段）自动生成getter和setter）
    对于private val修饰的参数：内部可读/不可改写 （编译器不会为该类参数（字段）自动生成getter和setter）
### 特质
    类和对象是可以扩展特质的，但是特质是不无法实例化的
    见 traits.IntIterator.scala
    
### case class
    case 样例类 必须带有参数，会自动生成apply 和unapply方，且参数默认是都是val, 并且通过值做比较
    case 是不可变的，但可以通过copy 拷贝和修改对象
    
###   PartialFunction
  