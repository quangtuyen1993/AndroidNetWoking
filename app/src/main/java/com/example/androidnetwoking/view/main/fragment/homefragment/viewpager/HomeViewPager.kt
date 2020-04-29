package com.example.androidnetwoking.view.main.fragment.homefragment.viewpager

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.androidnetwoking.R
import com.example.androidnetwoking.data.model.Product
import com.example.androidnetwoking.data.model.ProductTypes
import com.example.androidnetwoking.databinding.DialogProductInsertBinding
import com.example.androidnetwoking.databinding.FragmentHomeViewPagerBinding
import com.example.androidnetwoking.view.adapter.ProductAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

class HomeViewPager : Fragment(), ProductAdapter.ItemClick {
    lateinit var binding: FragmentHomeViewPagerBinding;

    lateinit var adapter: ProductAdapter
    lateinit var dialogProduct: Dialog
    lateinit var bindingDialog: DialogProductInsertBinding

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var vm: HomeViewPagerViewModel
    lateinit var productAdapter: ProductAdapter


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private var productTypes: ProductTypes? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            productTypes = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_view_pager, container, false)
        vm = ViewModelProvider(this, factory)[HomeViewPagerViewModel::class.java]
        productAdapter = ProductAdapter()
        productAdapter.setItemClick(this)
        binding.rv.adapter = productAdapter
        binding.rv.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.product = vm
        binding.lifecycleOwner = viewLifecycleOwner
        vm.onFetchList(productTypes!!)
        binding.imgBt.setOnClickListener { onInsert() }
        createDialogLayout()
        return binding.root
    }


    private fun onUpdate(product: Product) {
        bindingDialog.btUpdate.visibility = View.VISIBLE
        bindingDialog.btInsert.visibility = View.GONE
        vm.onShowItemUpdate(product)
        dialogProduct.show()
    }

    private fun onInsert() {
        bindingDialog.btUpdate.visibility = View.GONE
        bindingDialog.btInsert.visibility = View.VISIBLE
        vm.onShowInsert()
        dialogProduct.show()

    }


    companion object {
        @JvmStatic
        fun newInstance(productType: ProductTypes) =
            HomeViewPager().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, productType)
                }
            }
    }

    override fun clickUpdate(product: Product) {
        onUpdate(product)
    }

    override fun clickDelete(product: Product) {
        vm.onDelete(product)
    }

    private fun createDialogLayout() {
        dialogProduct = Dialog(requireContext(),R.style.ThemeOverlay_MaterialComponents_Dialog_Alert)
        bindingDialog = DataBindingUtil.inflate(
            LayoutInflater.from(requireActivity()),
            R.layout.dialog_product_insert,
            null,
            false
        )


        dialogProduct.setTitle("Manager Product")
        dialogProduct.setContentView(bindingDialog.root)

        bindingDialog.btInsert.setOnClickListener {
            vm.onInsertProduct()
            dialogProduct.dismiss()
        }
        bindingDialog.btUpdate.setOnClickListener {
            vm.onUpdateProduct()
            dialogProduct.dismiss()
        }
        bindingDialog.btDismiss.setOnClickListener {
            dialogProduct.dismiss()
        }
        bindingDialog.viewmodel = vm
        bindingDialog.lifecycleOwner = requireActivity()


    }

}
