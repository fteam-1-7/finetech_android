package com.team17.fintech_team_17.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.team17.fintech_team_17.R
import com.team17.fintech_team_17.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val edtUsername = findViewById<EditText>(R.id.username) as EditText;
        val edtEmail = findViewById<EditText>(R.id.email) as EditText;
        val edtPassword = findViewById<EditText>(R.id.password) as EditText;
        val edtRepassword = findViewById<EditText>(R.id.repassword) as EditText;

        val btnSignup = findViewById<Button>(R.id.btnsignup) as Button;
        val btnSignin = findViewById<Button>(R.id.btnsignin) as Button;


        btnSignup.setOnClickListener{
            val name = edtUsername.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            val repassword = edtRepassword.text.toString()
            if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter data into the required fields", Toast.LENGTH_SHORT)
                    .show()
            } else if(!(password.equals(repassword))){
                Toast.makeText(this, "The passwords do not match", Toast.LENGTH_SHORT)
                    .show()

            }
            else{
                val usr = UserModel(name = name, email = email)
                Log.i("Register","usr made: " + usr.id)


                //Show message for successful registration
                Toast.makeText(this, "User Registered!", Toast.LENGTH_SHORT).show()

                //Return to Login screen
                val loginIntent = Intent(this, LoginActivity::class.java)
                startActivity(loginIntent)
            }
        }

        btnSignin.setOnClickListener{
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }


}