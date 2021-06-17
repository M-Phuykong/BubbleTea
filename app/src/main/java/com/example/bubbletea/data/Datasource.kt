package com.example.bubbletea.data

import com.example.bubbletea.R
import com.example.bubbletea.model.MenuList

class Datasource {

    fun loadMenuList() : List<MenuList>{

        return listOf<MenuList>(
            MenuList("Bubble Tea A", 2.5, R.drawable.image_1),
            MenuList("Bubble Tea B", 1.5, R.drawable.image_2),
            MenuList("Bubble Tea C", 5.5, R.drawable.image_3),
            MenuList("Bubble Tea D", 3.0, R.drawable.image_4),
            MenuList("Bubble Tea E", 2.75, R.drawable.image_5),
            MenuList("Bubble Tea F", 4.25, R.drawable.image_6)
            )




    }



}