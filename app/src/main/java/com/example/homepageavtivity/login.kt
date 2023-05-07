package com.example.homepageavtivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn2 = findViewById<Button>(R.id.loginbtn2)
        loginBtn2.setOnClickListener{
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
}