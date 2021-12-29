package com.example.mycrypto

data class Crypto(
    val data:List<Data>
)
data class Data(
    val id:Int,
    val name:String,
    val symbol:String,
 //   val quote:Quotes
    val cmc_rank:Int

)
//data class Quotes(
//  val USD:USDoller
//)
//data class USDoller(
//    val price:Int
//)

