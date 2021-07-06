package com.example.bubbletea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bubbletea.data.Datasource
import com.example.bubbletea.databinding.FragmentMenuBinding
import com.example.bubbletea.model.ViewModel


class MenuFragment : Fragment() {

    private var binding : FragmentMenuBinding? = null
    private val sharedViewModel : ViewModel by activityViewModels()

    private lateinit var recyclerView : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentMenuBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            menuFragment = this@MenuFragment
            lifecycleOwner = viewLifecycleOwner
        }

        recyclerView = binding!!.recyclerView
        setLayout()


    }

    private fun setLayout(){
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MenuFragmentAdapter(Datasource().loadMenuList(), requireContext())


    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null

    }
}