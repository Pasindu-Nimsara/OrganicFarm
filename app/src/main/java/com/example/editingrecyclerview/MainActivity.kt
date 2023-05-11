package com.example.editingrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.editingrecyclerview.model.PackageData
import com.example.editingrecyclerview.view.PackageAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var addsBtn : FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var userList: ArrayList<PackageData>
    private lateinit var packageAdapter: PackageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList = ArrayList()

        addsBtn = findViewById(R.id.addingbtn)
        recv = findViewById(R.id.mRecycler)

        packageAdapter = PackageAdapter(this,userList)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = packageAdapter

        addsBtn.setOnClickListener{addInfo()}

    }

    private fun addInfo() {

        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)
        val packageName = v.findViewById<EditText>(R.id.packageN)
        val packagePrice = v.findViewById<EditText>(R.id.packageP)
        val addDialog = AlertDialog.Builder(this)
        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
            dialog,_->
            val names = packageName.text.toString()
            val prices = packagePrice.text.toString()
            userList.add(PackageData("Name: $names", "Price: $prices"))
            packageAdapter.notifyDataSetChanged()
            Toast.makeText(this, "Adding New Package Successful", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
            dialog,_->
            dialog.dismiss()
            Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
        }
        addDialog.create()
        addDialog.show()

    }
}