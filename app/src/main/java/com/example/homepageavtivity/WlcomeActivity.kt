package com.example.homepageavtivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WlcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wlcome)

        val loginBtn = findViewById<Button>(R.id.loginbtn)
        loginBtn.setOnClickListener{
            val Intent = Intent(this, login::class.java)
            startActivity(Intent)
        }


        val signupBtn = findViewById<Button>(R.id.signupbtn)
        signupBtn.setOnClickListener{
            val Intent = Intent(this, signup::class.java)
            startActivity(Intent)
        }
    }
}