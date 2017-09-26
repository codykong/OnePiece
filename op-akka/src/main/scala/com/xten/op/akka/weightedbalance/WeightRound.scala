package com.xten.op.akka.weightedbalance

import scala.collection.mutable


/**
  * Description: 
  * User: kongqingyu
  * Date: 2017/9/5 
  */
object WeightRound {


  def main(args: Array[String]): Unit = {

    val map = mutable.HashMap.empty[Int,Double]

    for (i <- 1 to 3 ) {
      map.put(i,i)
    }

    val weightMap = WeightMap[Int](map.toMap)

    for (i <- 1 to 100) {
      println(weightMap.select())
    }
  }

}
