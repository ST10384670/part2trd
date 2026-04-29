package com.example.part2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        // FIXED: No more R.id.main error
        val rootView = findViewById<android.view.View>(android.R.id.content)

        ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // UI
        val tvRole = findViewById<TextView>(R.id.tvRole)
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etUserId = findViewById<EditText>(R.id.etUserId)

        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnDashboard = findViewById<Button>(R.id.btnDashboard)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Role support (POE requirement)
        val role = intent.getStringExtra("ROLE") ?: "Student"
        tvRole.text = "User Role: $role"

        // UPDATE PROFILE
        btnUpdate.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val userId = etUserId.text.toString()

            if (name.isEmpty() || email.isEmpty() || userId.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "Profile Updated Successfully!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // DASHBOARD NAVIGATION
        btnDashboard.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // LOGOUT
        btnLogout.setOnClickListener {
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}