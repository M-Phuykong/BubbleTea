package com.example.bubbletea.data

import com.example.bubbletea.R
import com.example.bubbletea.model.MenuList

class Datasource {

    fun loadMenuList() : List<MenuList>{

        return listOf<MenuList>(
            MenuList(R.string.bubbleTea_A, 2.5, R.drawable.image_1),
            MenuList(R.string.bubbleTea_B, 1.5, R.drawable.image_2),
            MenuList(R.string.bubbleTea_C, 5.5, R.drawable.image_3),
            MenuList(R.string.bubbleTea_D, 3.0, R.drawable.image_4),
            MenuList(R.string.bubbleTea_E, 2.75, R.drawable.image_5),
            MenuList(R.string.bubbleTea_F, 4.25, R.drawable.image_6)
            )




    }



}