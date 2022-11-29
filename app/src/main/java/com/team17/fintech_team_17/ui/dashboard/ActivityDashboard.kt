package com.team17.fintech_team_17.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.team17.fintech_team_17.ui.register.RegisterActivity

class ActivityDashboard : AppCompatActivity() {

    val testList = arrayOf("Testing", "One", "Two", "Three")
    private lateinit var dAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.team17.fintech_team_17.R.layout.activity_dashboard)


        // Initialize Firebase Auth
        dAuth = FirebaseAuth.getInstance()


        val dashboardListView =
            findViewById<ListView>(com.team17.fintech_team_17.R.id.dashboard_paymentHistory)
        val btnPay = findViewById<Button>(com.team17.fintech_team_17.R.id.dashboard_buttonPayNow)

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, testList
        )

        dashboardListView.adapter = arrayAdapter

        //val fbDB = FBConnect()
/*
        btnPay.setOnClickListener() {
            fbDB.putUser("Jessy", "testTwo@gmail.com")
            fbDB.addUser()
            }
*/


    }

    override fun onDestroy() {
        super.onDestroy()
        dAuth.signOut()
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = dAuth.currentUser
        if (currentUser == null) {
            startActivity(Intent(this, RegisterActivity::class.java))
        } else {
            //updateUI(currentUser)
        }
    }


}