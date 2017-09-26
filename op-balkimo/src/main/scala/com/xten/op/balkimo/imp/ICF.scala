package com.xten.op.balkimo.imp

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/5/15 
  * Time: 下午3:25 
  */
object ICF extends App{

  implicit def str2Int (value :String) = value.toInt

  sum("1",2)

  def sum(a :Int,b:Int)={

    val sum = a +b
    println(sum)
  }
}
