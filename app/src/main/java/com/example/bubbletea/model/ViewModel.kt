package com.example.bubbletea.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.bubbletea.data.Datasource
import java.text.NumberFormat


class ViewModel : ViewModel() {

    private var dataSet = Datasource().loadMenuList()

    private var _itemPrice = MutableLiveData<Double>()
    val itemPrice: LiveData<String> = Transformations.map(_itemPrice) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    private var _itemName = MutableLiveData<Int>()
    val itemName: LiveData<Int> = _itemName

    private var _imagePos = MutableLiveData<Int>()
    val imagePos: LiveData<Int> = _imagePos


    fun update(pos: Int) {
        val data = dataSet[pos]
        _itemName.value = data.productName
        _itemPrice.value = data.productPrice
        _imagePos.value = data.productImage

    }

    fun addToCart(){

    }




}