package com.team17.fintech_team_17.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.team17.fintech_team_17.R
import com.team17.fintech_team_17.ui.dashboard.ActivityDashboard
import com.team17.fintech_team_17.ui.loginTwo.LoginTwoActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var rAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val edtUsername = findViewById<EditText>(R.id.username) as EditText;
        val edtEmail = findViewById<EditText>(R.id.email) as EditText;
        val edtPassword = findViewById<EditText>(R.id.password) as EditText;
        val edtRepassword = findViewById<EditText>(R.id.repassword) as EditText;

        val btnSignup = findViewById<Button>(R.id.btnsignup) as Button;
        val btnSignin = findViewById<Button>(R.id.btnsignin) as Button;

        rAuth = FirebaseAuth.getInstance()


        btnSignup.setOnClickListener{

            //Add user to user dataclass
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
                Log.i("Register","usr made: " + usr.id + " : " + usr.name)

                //Add user to firebase database
                /*
                FirebaseConnect.putUser(usr.id.toString(), usr.name, usr.email, password)
                FirebaseConnect.addUser()

                 */

                //Add user to Firebase Authentication
                val dashboardIntent = Intent(this, ActivityDashboard::class.java)
                val success = createUser(usr.email, edtPassword.text.toString(), dashboardIntent)
                if (success == true) {
                    startActivity(dashboardIntent)
                }


                //Show message for successful registration
                //Toast.makeText(this, "User Registered!", Toast.LENGTH_SHORT).show()


            }
        }

        btnSignin.setOnClickListener{
            val loginIntent = Intent(this, LoginTwoActivity::class.java)
            startActivity(loginIntent)
            finish()
        }
    }

    fun createUser(email: String, password: String, nextActivity: Intent): Boolean {
        var created = false
        rAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT)
                        .show()
                    val user = rAuth.currentUser
                    created = true

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
        return created
    }


}