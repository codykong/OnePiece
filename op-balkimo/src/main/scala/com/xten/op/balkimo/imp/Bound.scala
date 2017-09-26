package com.xten.op.balkimo.imp

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/5/16 
  * Time: 下午3:08 
  */
object Bound extends App{

  val pair = new Pair(3,2)
  println(pair.smaller)
}

class Pair[T :Ordering](val first :T ,val second :T){
  def smaller(implicit ord:Ordering[T]) =
    if (ord.compare(first,second) < 0) first else second
}
