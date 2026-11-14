package com.example.plmungo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.plmungo.HomeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etIdNumber: EditText
    private lateinit var btnLogin: Button
    private lateinit var rgAccountType: RadioGroup
    private lateinit var rbStudent: RadioButton
    private lateinit var rbAdmin: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etIdNumber = findViewById(R.id.etIdNumber)
        btnLogin = findViewById(R.id.btnLogin)
        rgAccountType = findViewById(R.id.rgAccountType)
        rbStudent = findViewById(R.id.rbStudent)
        rbAdmin = findViewById(R.id.rbAdmin)

        btnLogin.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val username = etUsername.text.toString().trim()
        val idNumber = etIdNumber.text.toString().trim()

        if (username.isEmpty() || idNumber.isEmpty()) {
            Toast.makeText(
                this,
                "Please fill in all fields",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (rgAccountType.checkedRadioButtonId == -1) {
            Toast.makeText(
                this,
                "Please select account type",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (rbStudent.isChecked) {
            if (username == "Juan Dela Cruz" &&
                idNumber == "2026001") {
                openHomePage(username, "Student")
            } else {
                Toast.makeText(
                    this,
                    "Invalid Student Account",
                    Toast.LENGTH_SHORT
                ).show()
            }

        } else if (rbAdmin.isChecked) {
            if (username == "admin" &&
                idNumber == "ADMIN001") {
                openHomePage(username, "Admin")
            } else {
                Toast.makeText(
                    this,
                    "Invalid Admin Account",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun openHomePage(
        username: String,
        accountType: String
    ) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("USERNAME", username)
        intent.putExtra("ACCOUNT_TYPE", accountType)
        startActivity(intent)
        finish()
    }
}