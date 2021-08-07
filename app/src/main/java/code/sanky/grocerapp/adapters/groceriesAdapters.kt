package code.sanky.grocerapp.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import code.sanky.grocerapp.R
import code.sanky.grocerapp.activities.Product_Description
import code.sanky.grocerapp.models.GroceriesModel
import code.sanky.grocerapp.util.ColorPicker
import com.bumptech.glide.Glide

class groceriesAdapters(val context: Context , val groceries : List<GroceriesModel>)
    : RecyclerView.Adapter<groceriesAdapters.GroceriesViewHolder>(){

    inner class GroceriesViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        var groPics : ImageView = itemView.findViewById(R.id.groceriesProduct)
        var groName : TextView = itemView.findViewById(R.id.groceriesName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceriesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.groceries_layout , parent , false)
        return GroceriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceriesViewHolder, position: Int) {
        holder.groName.text = groceries[position].groName
        Glide.with(holder.itemView.context).load(groceries[position].groPics).into(holder.groPics)

        holder.itemView.setOnClickListener {
            val intent = Intent(context , Product_Description ::class.java)
            intent.putExtra("NAME" , groceries[position].groName)
            intent.putExtra("PICS" , groceries[position].groPics)
            context.startActivities(arrayOf(intent))
        }
    }

    override fun getItemCount(): Int {
       return groceries.size
    }


}