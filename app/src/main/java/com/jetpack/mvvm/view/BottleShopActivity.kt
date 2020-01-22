package com.jetpack.mvvm.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jetpack.mvvm.R
import com.jetpack.mvvm.model.adapter.BottleShopAdapter
import com.jetpack.mvvm.databinding.ActivityBottleShopBinding
import com.jetpack.mvvm.model.repositery.BottleShopRepo
import com.jetpack.mvvm.viewmodel.BottleShopViewModel
import kotlinx.android.synthetic.main.activity_bottle_shop.*

class BottleShopActivity : AppCompatActivity() {

    private lateinit var viewmodel: BottleShopViewModel
    private lateinit var binding: ActivityBottleShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Generate Associated Binding file for the Activity/Fragment Layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bottle_shop)

        // Set LifecycleOwner for Binding layout which used when liveData used in Binding Expression
        binding.lifecycleOwner = this

        binding.hasShops = false


        // BottleShopRepo Instance
        val repo = BottleShopRepo()

        // Instantiation with multi-args constructor
        viewmodel = ViewModelProvider(this, BottleShopViewModelFactory(repo)).get(BottleShopViewModel::class.java)


        // Observer
        viewmodel.getBreweries().observe(this, Observer { result ->
            binding.hasShops = !result.isNullOrEmpty()
            val bottleShopAdapter = BottleShopAdapter(result, null)
            binding.rvBottleShop.adapter = bottleShopAdapter
        })


        btClick.setOnClickListener {
            finish()
        }
    }

    /**
     * ViewModelProvider Factory where here we manufacture(create) instance with argument
     */

    class BottleShopViewModelFactory(private val bottleShopRepo: BottleShopRepo) : ViewModelProvider.Factory{

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(BottleShopRepo::class.java).newInstance(bottleShopRepo)
        }
    }
}
