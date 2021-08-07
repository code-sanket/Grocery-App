package code.sanky.grocerapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import code.sanky.grocerapp.R
import code.sanky.grocerapp.models.Product
import com.bumptech.glide.Glide

class exclusiveItemsAdapters(val context: Context , val product: List<Product>)
    : RecyclerView.Adapter<exclusiveItemsAdapters.ProductViewHolder>(){

        inner class ProductViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
            var exProductImg : ImageView = itemView.findViewById(R.id.imgProduct)
            var exName : TextView = itemView.findViewById(R.id.tvName)
            var desc : TextView = itemView.findViewById(R.id.tvDescription)
            var price : TextView = itemView.findViewById(R.id.tvPrice)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.exclusive_offer , parent , false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.exName.text = product[position].name
        holder.desc.text = product[position].desc
        holder.price.text = product[position].price
        Glide.with(holder.itemView.context).load(product[position].picture).into(holder.exProductImg)
    }

    override fun getItemCount(): Int {
        return product.size
    }
}
