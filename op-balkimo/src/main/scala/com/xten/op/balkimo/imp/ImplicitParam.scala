package com.xten.op.balkimo.imp

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/5/15 
  * Time: 下午7:17 
  */
object ImplicitParam extends App{

  def smaller[T](a :T ,b :T)(implicit order:T =>Ordered[T]) ={
    if (order(a) < b) a else b
  }

}
