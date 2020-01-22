package com.jetpack.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jetpack.mvvm.R
import com.jetpack.mvvm.databinding.ActivityCounterBinding
import com.jetpack.mvvm.viewmodel.CounterViewModel
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity() {

    /*private lateinit var counterViewModel: CounterViewModel
    private lateinit var binding: ActivityCounterBinding*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         *  State of the Widget with ViewModel
         * */

        /*// Generate Associated Binding file for the Activity/Fragment Layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_counter)

        // ViewModel Instantiation with no-arg constructor
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        // Setting Object to XML Layout variable
        binding.viewmodel = counterViewModel

        // Counter Observer
        counterViewModel.counterLiveData.observe(this, Observer {
            tvCounter.text = it.toString()
        })*/


        /**
         *  State of the Widget without ViewModel
         * */

        setContentView(R.layout.activity_counter)

        btIncrement.setOnClickListener {
            tvCounter.text = (Integer.parseInt(tvCounter.text as String) + 3).toString()
        }

        btDecrement.setOnClickListener {
            tvCounter.text = (Integer.parseInt(tvCounter.text as String) - 1).toString()
        }
    }
}
