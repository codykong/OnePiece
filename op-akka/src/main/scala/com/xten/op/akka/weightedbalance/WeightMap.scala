package com.xten.op.akka.weightedbalance



import scala.collection.mutable
import scala.util.Random

/**
  * Description: 
  * User: kongqingyu
  * Date: 2017/9/5 
  */
class WeightMap[T] {

  private final val map : java.util.NavigableMap[Double,T] = new java.util.TreeMap[Double,T]()
  private final val random = new Random()
  private var total : Double = 0

  private final val elements = mutable.HashMap.empty[String,String]


  def add(ele :T , weight : Double) = {
    if(weight <=0) throw new IllegalArgumentException("must have weight")
    total += weight
    map.put(total,ele)
  }

  def select():T = {
    val index = random.nextDouble() * total
    map.ceilingEntry(index).getValue
  }

}

object WeightMap {

  def apply[T](elements : Map[T,Double]): WeightMap[T] = {

    val map = new WeightMap[T]()
    elements.foreach(p => map.add(p._1,p._2))
    map
  }

}
