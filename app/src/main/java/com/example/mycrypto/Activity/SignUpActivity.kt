package com.example.mycrypto.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mycrypto.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = Firebase.auth
        signUpButton.setOnClickListener {
           val email = textEmailEditText.text.toString().trim()
           val password =textPasswordEditText.text.toString().trim()
           createAccount(email,password)
        }
        gotoSignInActivity.setOnClickListener {
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password:String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {
                it ->
            if(it.isSuccessful){
                Toast.makeText(this,"Successfully SignUp", Toast.LENGTH_SHORT).show()
                val user = auth.currentUser
                intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Wrong Credential", Toast.LENGTH_SHORT).show()

            }
        }
    }
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser!=null){
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            //  finish()
        }
    }
}