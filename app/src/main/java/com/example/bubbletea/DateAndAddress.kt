package com.example.bubbletea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bubbletea.adapter.CheckOutFragmentAdapter
import com.example.bubbletea.data.Datasource
import com.example.bubbletea.databinding.FragmentDateAndAddressBinding

class DateAndAddress : Fragment() {

   private var binding : FragmentDateAndAddressBinding? = null

    private lateinit var recyclerView : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDateAndAddressBinding.inflate(inflater, container, false )
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding!!.CheckOutRecyclerView
        setLayout()

    }

    private fun setLayout(){
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CheckOutFragmentAdapter(Datasource().loadMenuList(), requireContext())
    }
}