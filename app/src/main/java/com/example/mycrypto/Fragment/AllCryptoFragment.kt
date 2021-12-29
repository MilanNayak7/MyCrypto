package com.example.mycrypto.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycrypto.Adapter.CryptoAdapter
import com.example.mycrypto.Crypto
import com.example.mycrypto.NewService
import com.example.mycrypto.R
import com.example.mycrypto.RetroService
import kotlinx.android.synthetic.main.fragment_all_crypto.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AllCryptoFragment : Fragment() {
   lateinit var adapter: CryptoAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val View = inflater.inflate(R.layout.fragment_all_crypto, container, false)
        getCryptoData()

        return View
    }

    private fun getCryptoData() {
        val crypto = NewService.cryptoInstance.getCrypto()
        crypto.enqueue(object : Callback<Crypto> {
            override fun onResponse(call: Call<Crypto>, response: Response<Crypto>) {
                val cry = response.body()
                if (cry != null) {
                    Log.d("Milan", cry.toString())
                    adapter = CryptoAdapter(requireContext(),cry.data,this)
                    cryptoList.adapter = adapter
                    cryptoList.layoutManager  = LinearLayoutManager(requireContext())

                }
            }
            override fun onFailure(call: Call<Crypto>, t: Throwable) {
                Log.d("Milan", "Error in fetching data")
            }
        })
    }




}