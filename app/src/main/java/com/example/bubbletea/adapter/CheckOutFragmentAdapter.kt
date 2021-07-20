package com.example.bubbletea.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bubbletea.R
import com.example.bubbletea.model.MenuList
import java.text.NumberFormat

class CheckOutFragmentAdapter(
    private val dateset: List<MenuList>,
    val context: Context
    ):
        RecyclerView.Adapter<CheckOutFragmentAdapter.CheckoutFragmentHolder>() {


    class CheckoutFragmentHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val checkOutImageView : ImageView = view.findViewById(R.id.checkout_IV)
        val checkOutName: TextView = view.findViewById(R.id.checkout_OrderName)
        val checkOutPrice: TextView = view.findViewById(R.id.checkout_OrderPrice)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CheckoutFragmentHolder {

        val adapterLayout : View =
            LayoutInflater.from(parent.context).inflate(R.layout.checkout_order_layout, parent, false)
        return CheckoutFragmentHolder(adapterLayout)

    }

    override fun onBindViewHolder(
        holder: CheckoutFragmentHolder,
        position: Int
    ) {
        val item = dateset[position]
        holder.checkOutName.text = context.getString(item.productName)
        holder.checkOutPrice.text = context.getString(R.string.price, NumberFormat.getCurrencyInstance().format(item.productPrice))
        holder.checkOutImageView.setImageResource(item.productImage)

    }




    override fun getItemCount(): Int { return dateset.size }

}










