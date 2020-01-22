package com.jetpack.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jetpack.mvvm.R
import com.jetpack.mvvm.databinding.TwoWaBindingClass

class DataBindingDemoActivity : AppCompatActivity() {

    private lateinit var binding: TwoWaBindingClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_demo)


    }
}
