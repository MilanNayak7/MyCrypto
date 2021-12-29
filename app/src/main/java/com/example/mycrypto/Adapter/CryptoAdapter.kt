package com.example.mycrypto.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mycrypto.Activity.MainActivity
import com.example.mycrypto.Crypto
import com.example.mycrypto.Data
import com.example.mycrypto.Fragment.FavouriteFragment
import com.example.mycrypto.R
import com.example.mycrypto.USDoller
import retrofit2.Callback

class CryptoAdapter(var context: Context, var data: List<Data>) :
    RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        val viewHolder =  CryptoViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
       val data = data[position]
        holder.id.text = data.id.toString()
        holder.name.text = data.name
        holder.symbol.text = data.symbol
        holder.cmc_rank.text= data.cmc_rank.toString()
        holder.itemView.setOnClickListener {
            Toast.makeText(context,"${data.id}",Toast.LENGTH_LONG).show()
            val intent = Intent(context,FavouriteFragment::class.java)
            intent.putExtra("Data_id",data.id.toString())
            intent.putExtra("Data_name",data.name.toString())
            intent.putExtra("Data_symbol",data.symbol.toString())
            intent.putExtra("Data_rank",data.cmc_rank.toString())
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id = itemView.findViewById<TextView>(R.id.txtId)
        var name = itemView.findViewById<TextView>(R.id.txtName)
        var symbol = itemView.findViewById<TextView>(R.id.txtSymbol)
        var cmc_rank = itemView.findViewById<TextView>(R.id.txtRank)

    }


}