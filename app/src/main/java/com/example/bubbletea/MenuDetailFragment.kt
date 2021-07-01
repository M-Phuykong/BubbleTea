package com.example.bubbletea

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.bubbletea.data.Datasource
import com.example.bubbletea.databinding.FragmentMenuDetailBinding
import com.example.bubbletea.model.ViewModel
import java.io.FileNotFoundException


class MenuDetailFragment : Fragment() {

    private var binding : FragmentMenuDetailBinding? = null
    private val sharedViewModel : ViewModel by activityViewModels()

    private val arg : MenuDetailFragmentArgs by navArgs()
    private var dataSet = Datasource().loadMenuList()
    private lateinit var productName : String
    private lateinit var productPrice : String
    private var productImage : Int = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentMenuDetailBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        //Getting the Argument value from [Nav_graph]
        productName = arg.productName
        productPrice = arg.productPrice
        productImage = arg.productImageInt

        //Transition Animation
        val anim = TransitionInflater.from(requireContext())
        enterTransition = anim.inflateTransition(R.transition.slide_in)
        sharedElementEnterTransition = anim.inflateTransition(R.transition.slide_in)




        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.menuDetailFragment = this

        try {
           val image = dataSet[productImage]
            binding!!.productImageImageIV.setImageResource(image.productImage)
            binding!!.productNameDetailTV.text = productName
            binding!!.productPriceDetailTV.text = productPrice

        } catch (e: FileNotFoundException){
            Toast.makeText(context, "FileNotFoundException", Toast.LENGTH_SHORT).show();
        }






    }


}