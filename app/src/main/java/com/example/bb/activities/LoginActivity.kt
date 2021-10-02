package com.example.bb.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bb.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button = findViewById<Button>(R.id.button_login)
        val email = findViewById<EditText>(R.id.editTextTextPersonName)
        val password = findViewById<EditText>(R.id.editTextTextPersonName2)

        button.setOnClickListener{

            when {
                email.text.toString().isEmpty() -> {
                    Toast.makeText(this,"Need email", Toast.LENGTH_LONG).show()
                }
                password.text.toString().isEmpty() ->
                    Toast.makeText(this,"Need password", Toast.LENGTH_LONG).show()
                else -> startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }
}