package com.example.bubbletea

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bubbletea.databinding.FragmentMenuDetailBinding
import com.example.bubbletea.model.ViewModel


class MenuDetailFragment : Fragment() {

    private var binding : FragmentMenuDetailBinding? = null
    private val sharedViewModel : ViewModel by activityViewModels()
    private val arg : MenuDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentMenuDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        //Getting the Argument value from [Nav_graph]
        //Updating ViewModel with adapter's information (position)
        sharedViewModel.update(arg.productPos)

        //Transition Animation
        val anim = TransitionInflater.from(requireContext())
        enterTransition = anim.inflateTransition(R.transition.slide_in)
        sharedElementEnterTransition = anim.inflateTransition(R.transition.slide_in)

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            menuDetailFragment = this@MenuDetailFragment
            viewModel = sharedViewModel
        }

    }

    fun moveToNextScreen(){
        val action  = MenuDetailFragmentDirections.actionMenuDetailFragmentToDateAndAddress()
        findNavController().navigate(action);
    }


}