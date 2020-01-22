package com.jetpack.mvvm.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jetpack.mvvm.R
import com.jetpack.mvvm.databinding.ActivityMenuBinding
import com.jetpack.mvvm.viewmodel.MenuViewModel

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding
    lateinit var viewModel: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Generate Associated Binding file for corresponding Activity/Fragment Layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)



        // Instantiate respective ViewModel for the respective ViewModelOwner(Activity/Fragment)
        // Instantiation with no-arg constructor
        viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        binding.viewmodel = viewModel


        viewModel.intentMutableLiveData.observe(this, Observer { destClass ->
            val intent = Intent(this, destClass)
            startActivity(intent)
        })

    }
}
