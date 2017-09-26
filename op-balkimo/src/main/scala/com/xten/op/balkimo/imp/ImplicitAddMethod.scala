package com.xten.op.balkimo.imp


/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/5/12 
  * Time: 下午3:32 
  */
object ImplicitAddMethod extends App{

//  implicit def file2Rich(file:File) = new RichFile(file)


  val file = new File
  import com.xten.op.balkimo.imp.Files.Int2String

  implicit def Int2String(value :String) = value.toInt

//  file.add("123")



}

object Files{
  implicit def Int2String(value :String) = value.toInt

}

class File(){


  def add(value:Int):String={
    val newValue = s"add Success:${value}"
    println(newValue)
    newValue
  }

}


object RichFile{
  implicit def file2Rich(file:File) = new RichFile(file)

}
class RichFile(val file:File){
  def read(value :String)={

    println(s"file is : ${file}, read Success:${value}")
  }
}
