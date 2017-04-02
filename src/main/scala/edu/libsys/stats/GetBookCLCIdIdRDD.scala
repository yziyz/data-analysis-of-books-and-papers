package edu.libsys.stats

import edu.libsys.Main
import org.apache.spark.rdd.RDD

object GetBookCLCIdIdRDD {

  //获得图书id与中图分类号的元组
  def work(book_id_CLCId: String): RDD[(String, Int)] = {

    //分割符
    val delimiter01 = ","

    //返回RDD
    Main.spark.sparkContext
      .textFile(book_id_CLCId).map(line => {
      val tokens = line.split(delimiter01)
        .map(_.trim)
      //结果类似(H152,1)
      tokens(1) -> tokens(0).toInt
    })
  }
}