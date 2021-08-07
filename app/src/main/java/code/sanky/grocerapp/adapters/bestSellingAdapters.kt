package code.sanky.grocerapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import code.sanky.grocerapp.R
import code.sanky.grocerapp.models.BestSellingModel
import com.bumptech.glide.Glide

class bestSellingAdapters(val context: Context , val bestSelling : List<BestSellingModel>)
    : RecyclerView.Adapter<bestSellingAdapters.BestSellingViewHolder>(){

    inner class BestSellingViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        var bstProduct : ImageView = itemView.findViewById(R.id.bstProduct)
        var bstName : TextView = itemView.findViewById(R.id.tvBstName)
        var bstPrice : TextView = itemView.findViewById(R.id.tvBstPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellingViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.best_selling , parent , false)
        return BestSellingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestSellingViewHolder, position: Int) {
        holder.bstName.text = bestSelling[position].name
        holder.bstPrice.text = bestSelling[position].price
        Glide.with(holder.itemView.context).load(bestSelling[position].picture).into(holder.bstProduct)
    }

    override fun getItemCount(): Int {
        return bestSelling.size
    }
}