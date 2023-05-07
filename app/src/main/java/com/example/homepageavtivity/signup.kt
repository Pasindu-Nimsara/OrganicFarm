package com.example.homepageavtivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val loginBtn2 = findViewById<Button>(R.id.signupbtn2)
        loginBtn2.setOnClickListener {
            val Intent = Intent(this, login::class.java)
            startActivity(Intent)
        }
    }
}