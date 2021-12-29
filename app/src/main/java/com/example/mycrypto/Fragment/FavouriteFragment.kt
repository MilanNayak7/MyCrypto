package com.example.mycrypto.Fragment

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.mycrypto.Activity.MainActivity
import com.example.mycrypto.Activity.SignUpActivity
import com.example.mycrypto.R
import com.example.mycrypto.Room.FavouriteViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_favourite.*


class FavouriteFragment : Fragment() {
       lateinit var viewModel:FavouriteViewModel
       lateinit var recyclerView: RecyclerView
       lateinit var btnLogOut:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favourite, container, false)
        recyclerView = view.findViewById(R.id.cryptoList)
        btnLogOut = view.findViewById(R.id.btnLogOut)
        btnLogOut.setOnClickListener {
            signOut() }

    return view
    }

    private fun signOut() {
        Firebase.auth.signOut()
      val intent = Intent(requireContext(),SignUpActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }


}
