package com.roman.clildlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.auth.FirebaseAuth
import com.roman.clildlearning.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding

    companion object{
        lateinit var auth: FirebaseAuth
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        //Api splashscreen used
        installSplashScreen()
        //firebaseauth install
        auth = FirebaseAuth.getInstance()
        //binding install
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val btnlogin = findViewById<Button>(R.id.btnLogIn)
//        val btnsignup = findViewById<Button>(R.id.btnSignUp)

        //binding used
        binding.btnLogIn.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty())
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, MainActivity2::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, "Account is not create", Toast.LENGTH_SHORT).show()
                }
        }


//            Toast.makeText(this, "Feel all box", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)

        binding.btnSignUp.setOnClickListener {

            Toast.makeText(this, "Feel this box", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)

            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}