package com.example.itemsazanew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            when(it.itemId){


                R.id.nav_home -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT ).show()
                R.id.nav_message -> Toast.makeText(applicationContext, "Clicked Feedback", Toast.LENGTH_SHORT ).show()
                R.id.nav_payment -> Toast.makeText(applicationContext, "Clicked Payment", Toast.LENGTH_SHORT ).show()
                R.id.nav_packages -> Toast.makeText(applicationContext, "Clicked Packages", Toast.LENGTH_SHORT ).show()
                R.id.nav_settings -> Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_SHORT ).show()
                R.id.nav_help -> Toast.makeText(applicationContext, "Clicked Help", Toast.LENGTH_SHORT ).show()
                R.id.nav_about -> Toast.makeText(applicationContext, "Clicked AboutUs", Toast.LENGTH_SHORT ).show()
                R.id.nav_logout -> Toast.makeText(applicationContext, "Clicked Logout", Toast.LENGTH_SHORT ).show()
            }

            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){

            return true
        }


        return super.onOptionsItemSelected(item)
    }
}