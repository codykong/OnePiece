package com.xten.op.balkimo.imp

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/5/15 
  * Time: 下午4:28 
  */
object ImplicitValue extends App{
  add(2)

  def add(a :Int)(implicit b:User): Unit ={
    println(a+b.value)
  }
}
object User{
  implicit val b:User = new User(3)
}

class User( val value :Int = 0){
}
