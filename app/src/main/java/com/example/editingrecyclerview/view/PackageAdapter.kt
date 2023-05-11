package com.example.editingrecyclerview.view

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.editingrecyclerview.R
import com.example.editingrecyclerview.model.PackageData

class PackageAdapter (val c: Context,val packageList: ArrayList<PackageData>):RecyclerView.Adapter<PackageAdapter.PackageViewHolder>()
{

    inner class PackageViewHolder(val v:View):RecyclerView.ViewHolder(v){

        var name:TextView
        var price:TextView
        var mMenus:ImageView

        init {
            name = v.findViewById<TextView>(R.id.mTitle)
            price = v.findViewById<TextView>(R.id.mSubTitle)
            mMenus = v.findViewById(R.id.mMenus)
            mMenus.setOnClickListener{popupMenus(it)}
        }

        private fun popupMenus(v:View) {

            val position = packageList[adapterPosition]
            val popupMenus = PopupMenu(c,v)
            popupMenus.inflate(R.menu.show_menu)
            popupMenus.setOnMenuItemClickListener {

                when(it.itemId){
                    R.id.editText->{
                        val v = LayoutInflater.from(c).inflate(R.layout.add_item,null)
                        val name = v.findViewById<EditText>(R.id.packageN)
                        val price = v.findViewById<EditText>(R.id.packageP)
                            AlertDialog.Builder(c)
                                .setView(v)
                                .setPositiveButton("Ok"){
                                    dialog,_->
                                    position.packageName = name.text.toString()
                                    position.packagePrice = price.text.toString()
                                    notifyDataSetChanged()
                                    Toast.makeText(c,"Package Edited",Toast.LENGTH_SHORT).show()
                                    dialog.dismiss()

                                }
                                .setNegativeButton("Cancel"){
                                    dialog,_->
                                    dialog.dismiss()

                                }
                                .create()
                                .show()


                        true
                    }
                    R.id.deleteText->{

                        AlertDialog.Builder(c)
                            .setTitle("Delete")
                            .setIcon(R.drawable.baseline_warning_24)
                            .setMessage("Are you sure delete this package")
                            .setPositiveButton("Yes"){

                                dialog,_->
                                packageList.removeAt(adapterPosition)
                                notifyDataSetChanged()
                                Toast.makeText(c,"Deleted Package",Toast.LENGTH_SHORT).show()
                                dialog.dismiss()

                            }
                            .setNegativeButton("No"){

                                dialog,_->
                                dialog.dismiss()
                            }
                            .create()
                            .show()



                        true
                    }
                    else-> true
                }

            }

            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                .invoke(menu,true)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item,parent, false)
        return PackageViewHolder(v)
    }

    override fun getItemCount(): Int {
        return packageList.size
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        val newList = packageList[position]
        holder.name.text = newList.packageName
        holder.price.text = newList.packagePrice
    }
}