package com.example.taskinternshala.ui.productadd

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.taskinternshala.databinding.FragmentProductAddBinding
import com.example.taskinternshala.model.AddProductRequestBody
import com.example.taskinternshala.utils.Toast
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class ProductAddFragment : Fragment() {

    //creating Binding instance
    private var _binding: FragmentProductAddBinding? = null
    private val binding: FragmentProductAddBinding get() = _binding!!

    //initialise viewModel instance
    private  var  viewModel = get<ProductAddViewModel>()
    private var productType = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentProductAddBinding.inflate(layoutInflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Add Products"

        binding.rd.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.radioProduct.id -> {
                    productType = binding.radioProduct.text.toString()
                }
                binding.radioService.id -> {
                    productType = binding.radioService.text.toString()
                }
            }
        }
        binding.btnAdd.setOnClickListener {
            val productName = binding.etProductName.text.toString().trim { it <= ' ' }
            val sellingPrice = binding.etProductPrice.text.toString().trim { it <= ' ' }
            val tax = binding.etProductTax.text.toString().trim { it <= ' ' }



            Log.d("TAG", "onCreateView:$productType")
            when {
                //checking fields are empty or not
                TextUtils.isEmpty(productName) -> {
                    Toast.showToast("please enter product name")
                    return@setOnClickListener
                }
                TextUtils.isEmpty(sellingPrice) -> {
                    Toast.showToast("please enter price")
                    return@setOnClickListener
                }
                TextUtils.isEmpty(tax) -> {
                    Toast.showToast("please enter price")
                    return@setOnClickListener
                }
                TextUtils.isEmpty(productType) -> {
                    Toast.showToast("please select type")
                    return@setOnClickListener
                }
                else -> {
                   addProducts(product_type = productType, product_name = productName, price = sellingPrice, tax = tax)
                }
            }
        }
        binding.cancel.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }


    /**
     * addProducts function take data class [AddProductRequestBody] as a parameter and send
     * data using @Post on api
     */
    private fun addProducts(
        product_name: String,
        product_type: String,
        price: String,
        tax: String,
    ) {
        viewModel.viewModelScope.launch {
            val addProductRequestBody =
                AddProductRequestBody(product_name, product_type, price, tax)
            viewModel.addProduct(addProductRequestBody)
            Toast.showToast("Added successfully")
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    fun onRadioButtonClicked(view: View) {
//        if (view is RadioButton) {
//            // Is the button now checked?
//            val checked = view.isChecked
//            // Check which radio button was clicked
//            when (view.getId()) {
//                R.id.rb1 ->
//                    if (checked) {
//                        Log.d("rb1", "onRadioButtonClicked: ")
//                    }
//                R.id.rb2 ->
//                    if (checked) {
//                        Log.d("rb2", "onRadioButtonClicked: ")
//                    }
//            }
//        }
//    }
}