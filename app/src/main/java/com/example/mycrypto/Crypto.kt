package com.example.mycrypto

data class Crypto(
    val data:List<Data>
)
data class Data(
    val id:Int,
    val name:String,
    val symbol:String,
  //  val quote:Quote,
    val cmc_rank:Int

)
//data class Quote(
//  val USD:USDoller
//)
//data class USDoller(
//    val price:Int
//)

