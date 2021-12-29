package com.example.mycrypto.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycrypto.Crypto
import com.example.mycrypto.Data
import com.example.mycrypto.R
import retrofit2.Callback

class CryptoAdapter(var context: Context, var data: List<Data>,private val listener:ItemClicked) :
    RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        val viewHolder =  CryptoViewHolder(view)
        view.setOnClickListener {
         listener.onItemClicked(data[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
       val data = data[position]
        holder.id.text = data.id.toString()
        holder.name.text = data.name
        holder.symbol.text = data.symbol
        holder.cmc_rank.text= data.cmc_rank.toString()

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
    interface ItemClicked{
        fun onItemClicked(item:Int)
    }

}