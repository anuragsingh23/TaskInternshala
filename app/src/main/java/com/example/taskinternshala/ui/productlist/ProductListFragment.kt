package com.example.taskinternshala.ui.productlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskinternshala.application.TaskApp
import com.example.taskinternshala.databinding.FragmentProductListBinding
import com.example.taskinternshala.model.ProductsItem
import com.example.taskinternshala.utils.Status
import org.koin.android.ext.android.get


class ProductListFragment : Fragment() {

    // creating ViewBinding instance using backing property get() = ..
    private var _binding: FragmentProductListBinding? = null
    private val binding : FragmentProductListBinding get()= _binding!!

    private  var  viewModel = get<ProductListViewModel>()
    //later initialize of adapter class
    private lateinit var adapter: ProductListAdapter

  //  private val viewModel : ProductListViewModel by viewModels()
    private var list = ArrayList<ProductsItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

       _binding = FragmentProductListBinding.inflate(layoutInflater , container ,false)

        (activity as AppCompatActivity).supportActionBar?.title = "Products & Services"

        //observe the status of response of api and save it into list
        viewModel.myResponse.observe(viewLifecycleOwner){
            when(it){
                is Status.Failure -> {
                   binding.progressBar2.isVisible = true
                }
                is Status.Success -> {
                    loadRecyclerView(it.value as ArrayList<ProductsItem>)
                }
                is Status.NetworkError -> {
                    binding.etError.isVisible = true
                }
            }
        }

        //this is used for navigation to Add Product fragment
        binding.addFab.setOnClickListener {
            navigateToAddNewProductScreen()
        }
        return binding.root
    }

    //setup recyclerView
    //it take list of ProductsItem as param
    private fun loadRecyclerView(list: ArrayList<ProductsItem>){
        adapter = ProductListAdapter(list)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(TaskApp.instance,LinearLayoutManager.VERTICAL,false)

        binding.recyclerView.adapter = adapter
    }

    // navigate to second fragment(ProductAddFragment.kt) using navigation component
    private fun navigateToAddNewProductScreen(){
        val action = ProductListFragmentDirections.actionProductListFragmentToProductAddFragment()
        findNavController().navigate(action)
    }

    //
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}