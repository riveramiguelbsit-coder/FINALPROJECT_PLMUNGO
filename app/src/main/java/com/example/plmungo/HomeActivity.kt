package com.example.plmungo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Connect XML views
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)

        val btnFloorPlan = findViewById<Button>(R.id.btnFloorPlan)
        val btnCampusMap = findViewById<Button>(R.id.btnCampusMap)
        val btnAbout = findViewById<Button>(R.id.btnAbout)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Get account information
        val username = intent.getStringExtra("USERNAME") ?: "User"
        val accountType = intent.getStringExtra("ACCOUNT_TYPE") ?: "Student"

        tvWelcome.text = "Welcome, $username!\n$accountType Account"

        // 1. FLOOR PLAN
        btnFloorPlan.setOnClickListener {
            startActivity(
                Intent(this, FloorPlanActivity::class.java)
            )
        }

        // 2. CAMPUS MAP
        btnCampusMap.setOnClickListener {
            startActivity(
                Intent(this, CampusMapActivity::class.java)
            )
        }

        // 3. ABOUT PLMUN
        btnAbout.setOnClickListener {
            Toast.makeText(
                this,
                "About PLMUN page is not yet connected.",
                Toast.LENGTH_SHORT
            ).show()
        }

        // 4. MY PROFILE
        btnProfile.setOnClickListener {
            Toast.makeText(
                this,
                "My Profile page is not yet connected.",
                Toast.LENGTH_SHORT
            ).show()
        }

        // LOGOUT
        btnLogout.setOnClickListener {
            val logoutIntent = Intent(this, MainActivity::class.java)

            logoutIntent.flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(logoutIntent)
            finish()
        }
    }
}
