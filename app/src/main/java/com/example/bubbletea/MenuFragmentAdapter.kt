package com.example.bubbletea

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bubbletea.model.MenuList
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MenuFragmentAdapter(
    private val dateset: List<MenuList>,
    val context: Context
) :
    RecyclerView.Adapter<MenuFragmentAdapter.MenuFragmentHolder>() {

    class MenuFragmentHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var productNameTextView: TextView = view.findViewById(R.id.productName)
        var productPriceTextView: TextView = view.findViewById(R.id.productPrice)
        var productImageImageView: ImageView = view.findViewById(R.id.productImage)
        var addProductToCart: FloatingActionButton =
            view.findViewById(R.id.addToCart_FloatingButton)


        fun bind(id: String) {
            ViewCompat.setTransitionName(productImageImageView, id)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuFragmentHolder {
        val adapterLayout: View =
            LayoutInflater.from(parent.context).inflate(R.layout.menulist_item, parent, false)

        adapterLayout.setOnClickListener {
            movetoDetailMenu(MenuFragmentHolder(adapterLayout))
        }


        return MenuFragmentHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: MenuFragmentHolder, position: Int) {
        val item = dateset[position]
        holder.productNameTextView.text = item.productName
        holder.productPriceTextView.text = item.productPrice.toString()
        holder.productImageImageView.setImageResource(item.productImage)
        holder.bind(item.toString())



        holder.addProductToCart.setOnClickListener {
            movetoDetailMenu(holder)

        }


    }

    override fun getItemCount(): Int {
        return dateset.size

    }

    fun makeText() {
        Toast.makeText(context, "OnClickListener in Adapter is being clicked", Toast.LENGTH_LONG)
            .show();
    }

    fun movetoDetailMenu(holder: MenuFragmentHolder) {
        val action =
            MenuFragmentDirections.actionMenuFragmentToMenuDetailFragment(holder.productNameTextView.text.toString())
        holder.view.findNavController().navigate(action)


    }


}