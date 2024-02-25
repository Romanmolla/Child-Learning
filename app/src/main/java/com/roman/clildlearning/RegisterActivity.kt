package com.roman.clildlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnsignin = findViewById<Button>(R.id.btnSignIN)
        val etemail = findViewById<EditText>(R.id.etEmail)
        val etpassword = findViewById<EditText>(R.id.etPassword)
        val etusername = findViewById<EditText>(R.id.etUsername)


        btnsignin.setOnClickListener {

            val email = etemail.text.toString()
            val password = etpassword.text.toString()
            val username = etusername.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty())
                LoginActivity.auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Create Successful", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, "Account is not create", Toast.LENGTH_SHORT).show()
                }
        }

    }
}