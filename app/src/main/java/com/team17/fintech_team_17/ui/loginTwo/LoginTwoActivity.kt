package com.team17.fintech_team_17.ui.loginTwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.team17.fintech_team_17.R
import com.team17.fintech_team_17.databinding.ActivityLoginBinding
import com.team17.fintech_team_17.ui.dashboard.ActivityDashboard
import com.team17.fintech_team_17.ui.register.RegisterActivity


class LoginTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var lAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_two)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val edtUsername = binding.username
        val edtPassword = binding.password
        val btnLogin = binding.login
        val loading = binding.loading

        val signup = binding.signup

        lAuth = FirebaseAuth.getInstance()



        signup.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
            finish()

        }

        btnLogin.setOnClickListener(){
            val email = edtUsername.text.toString()
            val password = edtPassword.text.toString()
            val success = loginUser(email, password,Intent(this, ActivityDashboard::class.java))



        }



    }

    fun loginUser(email: String, password: String, nextActivity: Intent): Boolean{

        var loggedIn = false

        lAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    loggedIn = true
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(
                        baseContext, "Login Successful.",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(nextActivity)
                    finish()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        return loggedIn
    }


}