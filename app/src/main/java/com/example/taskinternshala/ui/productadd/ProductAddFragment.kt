package com.example.taskinternshala.ui.productadd

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.taskinternshala.databinding.FragmentProductAddBinding
import com.example.taskinternshala.model.AddProductRequestBody
import com.example.taskinternshala.utils.Toast
import kotlinx.coroutines.launch

class ProductAddFragment : Fragment() {


    private var _binding: FragmentProductAddBinding? = null
    private val binding: FragmentProductAddBinding get() = _binding!!

    private val viewModel: ProductAddViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductAddBinding.inflate(layoutInflater, container, false)
        
        (activity as AppCompatActivity).supportActionBar?.title = "Add Products"

        binding.btnAdd.setOnClickListener {
            val productName = binding.etProductName.text.toString().trim { it <= ' ' }
            val sellingPrice = binding.etProductPrice.text.toString().trim { it <= ' ' }
            val tax = binding.etProductTax.text.toString().trim { it <= ' ' }
            var productType: String? = null

          //  on click item radio gruop select
                    binding.rd.setOnCheckedChangeListener { _, checkedId ->
                     productType = when(checkedId){
                            binding.rb1.id ->
                                binding.rb1.text.toString()
                            binding.rb2.id ->
                               binding.rb2.text.toString()
                            else -> return@setOnCheckedChangeListener Toast.showToast("Please select one")
                        }
                        Log.d("TAG", "$productType")
                    }
            Log.d("TAG", "onCreateView:$productType")
            when{
                TextUtils.isEmpty(productName) ->{
                    Toast.showToast("please enter product name")
                    return@setOnClickListener
                }
                TextUtils.isEmpty(sellingPrice) ->{
                    Toast.showToast("please enter price")
                    return@setOnClickListener
                }
                TextUtils.isEmpty(tax) ->{
                    Toast.showToast("please enter price")
                    return@setOnClickListener
                }
                TextUtils.isEmpty(productType) ->{
                    Toast.showToast("please select type")
                    return@setOnClickListener
                }
                else -> {
                    productType?.let { it1 -> addProducts(productName, it1,sellingPrice,tax) }
                }
            }
        }
        binding.cancel.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
    private fun addProducts(product_name:String, product_type: String,price:String,tax:String) {
        viewModel.viewModelScope.launch {
            val addProductRequestBody = AddProductRequestBody(product_name, product_type,price,tax)
            viewModel.addProduct(addProductRequestBody)
            Toast.showToast("Added successfully")
            findNavController().popBackStack()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}