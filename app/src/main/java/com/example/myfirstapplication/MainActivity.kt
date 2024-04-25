package com.example.myfirstapplication

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.etEmailAddress)
        val password = findViewById<EditText>(R.id.etPassword)

        findViewById<Button>(R.id.btnLoginButton).setOnClickListener {
            // write logic to handle the button
            val submittedEmail = email.text.toString()
            val submittedPassword = password.text.toString()

            /*
             TODO: Create the logic to verify user login details,
              EMAIL should be valid,
              Password must have 8 length including small/capital letters with digit and special characters
             */
            var isValidEmail = false
            var isValidPassword = false

            val pattern = Patterns.EMAIL_ADDRESS

            isValidEmail = pattern.matcher(submittedEmail).matches()?: false //validate email
            isValidPassword = submittedPassword.matches("[0-9a-zA-Z\\W]{8}".toRegex()) //validate password

            when (Pair(isValidEmail, isValidPassword)){
                Pair(true, true) -> Toast.makeText(applicationContext,"Login Successful",Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(applicationContext,"Login Unsuccessful",Toast.LENGTH_SHORT).show()
            }
        }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}