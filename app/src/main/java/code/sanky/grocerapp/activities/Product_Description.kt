package code.sanky.grocerapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import code.sanky.grocerapp.R
import code.sanky.grocerapp.databinding.ActivityMainBinding
import code.sanky.grocerapp.databinding.ActivityProductDescriptionBinding

class Product_Description : AppCompatActivity() {
    lateinit var binding: ActivityProductDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back2.setOnClickListener {
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }

        val name = intent.getStringExtra("NAME")
        binding.title.text = name
        if (name == "Cooking Oil" || name == "Drinks"){
            binding.desc.text = "1Ltr,Price"
        }else{
            binding.desc.text = "1Kg,Price"
        }

        val img = intent.getIntExtra("PICS" , 0)
        binding.imagePro.setImageResource(img)


    }
}