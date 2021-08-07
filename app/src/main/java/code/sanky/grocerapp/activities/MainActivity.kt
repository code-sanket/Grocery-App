package code.sanky.grocerapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import code.sanky.grocerapp.R
import code.sanky.grocerapp.adapters.bestSellingAdapters
import code.sanky.grocerapp.adapters.exclusiveItemsAdapters
import code.sanky.grocerapp.adapters.groceriesAdapters
import code.sanky.grocerapp.databinding.ActivityMainBinding
import code.sanky.grocerapp.models.BestSellingModel
import code.sanky.grocerapp.models.GroceriesModel
import code.sanky.grocerapp.models.Product

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var exAdapter : exclusiveItemsAdapters
    lateinit var bstAdapters: bestSellingAdapters
    lateinit var groceriesAdapters: groceriesAdapters
    var productList = mutableListOf<Product>()
    var groceriesList = mutableListOf<GroceriesModel>()
    var bestSellingList = mutableListOf<BestSellingModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        dataExclusive()
        dataGroceries()
        dataBestSelling()
        setUpRecyclerViews()
    }

    private fun dataExclusive(){
        productList.add(Product("$4.99" , "Apple",R.drawable.app1,"7Pcs,Priceg"))
        productList.add(Product("$5.99" , "Avocado",R.drawable.ava1,"7Pcs,Priceg"))
        productList.add(Product("$6.99" , "Banana",R.drawable.banana1,"7Pcs,Priceg"))
        productList.add(Product("$2.99" , "BlueBerry",R.drawable.blue1,"7Pcs,Priceg"))
        productList.add(Product("$3.99" , "Carrot",R.drawable.carrot1,"7Pcs,Priceg"))
        productList.add(Product("$8.99" , "Drink",R.drawable.drink1,"7Pcs,Priceg"))
        productList.add(Product("$8.99" , "Wheat",R.drawable.wheat1,"7Pcs,Priceg"))
    }

    private fun dataGroceries(){
        groceriesList.add(GroceriesModel(R.drawable.d2 , "Pulses"))
        groceriesList.add(GroceriesModel(R.drawable.rice1 , "Rice"))
        groceriesList.add(GroceriesModel(R.drawable.drink1 , "Drinks"))
        groceriesList.add(GroceriesModel(R.drawable.cherry1 , "Cherries"))
        groceriesList.add(GroceriesModel(R.drawable.lemon1, "Lemon"))
        groceriesList.add(GroceriesModel(R.drawable.oil1 , "Cooking Oil"))
    }

    private fun dataBestSelling(){
        bestSellingList.add(BestSellingModel("$4.99" , "Avocado" , R.drawable.ava1))
        bestSellingList.add(BestSellingModel("$5.99" , "Apple" , R.drawable.app1))
        bestSellingList.add(BestSellingModel("$6.99" , "Watermelon" , R.drawable.melon1))
        bestSellingList.add(BestSellingModel("$7.99" , "Cherries" , R.drawable.cherry1))
        bestSellingList.add(BestSellingModel("$8.99" , "Rice" , R.drawable.rice1))
        bestSellingList.add(BestSellingModel("$10.99" , "Wheat" , R.drawable.wheat1))
        bestSellingList.add(BestSellingModel("$11.99" , "Lemon" , R.drawable.lemon1))
    }

    private fun setUpRecyclerViews(){
        exAdapter = exclusiveItemsAdapters(this , productList)
        binding.exclusiveRecyclerView.layoutManager = LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        binding.exclusiveRecyclerView.adapter = exAdapter

        groceriesAdapters = groceriesAdapters(this , groceriesList)
        binding.groRecycler.layoutManager = LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        binding.groRecycler.adapter = groceriesAdapters

        bstAdapters = bestSellingAdapters(this , bestSellingList)
        binding.bestSellingRecyclerView.layoutManager = LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        binding.bestSellingRecyclerView.adapter = bstAdapters
    }
}