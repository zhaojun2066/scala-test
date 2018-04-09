/**
 * Created by jufeng on 2018/4/8.
 */
package com.scala.test.objects;

/**
 * 对象不能提供构造器参数，这点和类的区别
 * object 就是一个单利模式
 * 伴生对象，object 的名字和class名字一样，这样就打到了既有实例方法又有静态方法
 * 类和它的伴生对象可以互相访问私有，它们必须在同一个源文件中
 * 继承：
 *    1 extends  final 和java一样
 *    2 重写方法必须有override
 *    3  只有主构造器可以调用超类的主构造器
 *    4 你可以重写字段
 **/