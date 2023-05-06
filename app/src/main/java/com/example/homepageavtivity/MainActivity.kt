package com.example.homepageavtivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homepageavtivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mList: ArrayList<DataItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        prepareData()

        val adapter = MainAdapter(mList)
        binding.mainRecyclerView.adapter =  adapter

    }

    private fun prepareData(){

        //best seller
        val bestSellerList = ArrayList<RecyclerItem>()
        bestSellerList.add(RecyclerItem(R.drawable.cabbage, offer = "Cabbage"))
        bestSellerList.add(RecyclerItem(R.drawable.peas, offer = "Peas"))
        bestSellerList.add(RecyclerItem(R.drawable.carrot, offer = "Carrot"))
        bestSellerList.add(RecyclerItem(R.drawable.potatoes, offer = "Potatoes"))
        bestSellerList.add(RecyclerItem(R.drawable.tomatoes, offer = "Tomatoes"))
        bestSellerList.add(RecyclerItem(R.drawable.broccoli, offer = "Broccoli"))

        //clothing

        val clothingList = ArrayList<RecyclerItem>()

        clothingList.add(RecyclerItem(R.drawable.apple, offer = "Apple"))
        clothingList.add(RecyclerItem(R.drawable.mango, offer = "Mango"))
        clothingList.add(RecyclerItem(R.drawable.orange, offer = "Oranges"))
        clothingList.add(RecyclerItem(R.drawable.grapes, offer = "Grapes"))
        clothingList.add(RecyclerItem(R.drawable.watermelon, offer = "Watermelon"))
        clothingList.add(RecyclerItem(R.drawable.banana, offer = "Bananas"))

        mList.add(DataItem(DataItemType.BANNER, Banner(R.drawable.vegetext)))
        mList.add(DataItem(DataItemType.BEST_SELLER,bestSellerList))
        mList.add(DataItem(DataItemType.BANNER,Banner(R.drawable.fruitstext)))
        mList.add(DataItem(DataItemType.CLOTHING,bestSellerList))
        mList.add(DataItem(DataItemType.BANNER,Banner(R.drawable.spicestext)))
        mList.add(DataItem(DataItemType.BEST_SELLER,bestSellerList))



    }
}