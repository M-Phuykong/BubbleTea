package com.example.bubbletea

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bubbletea.model.MenuList


class MenuFragmentAdapter(
    val dateset : List<MenuList>,
    val context : Context
) :
    RecyclerView.Adapter<MenuFragmentAdapter.MenuFragmentHolder>() {

    class MenuFragmentHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var productNameTextView : TextView = view.findViewById(R.id.productName)
        var productPriceTextView : TextView = view.findViewById(R.id.productPrice)
        var productImageImageView : ImageView = view.findViewById(R.id.productImage)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuFragmentHolder {
        val adapterLayout : View = LayoutInflater.from(parent.context).inflate(R.layout.menulist_item, parent, false)

        return  MenuFragmentHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MenuFragmentHolder, position: Int) {
        val item = dateset[position]
        holder.productNameTextView.text = item.productName
        holder.productPriceTextView.text = item.productPrice.toString()
        holder.productImageImageView.setImageResource(item.productImage)

    }

    override fun getItemCount(): Int {
        return dateset.size

    }


}