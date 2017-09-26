package com.xten.op.balkimo.zip

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/6/27 
  * Time: 下午5:38 
  */
object ZipCase extends App{

  val values = List.range(1,5)

  val sum = (values,values).zipped map(_*_) sum

  println(sum)

}
