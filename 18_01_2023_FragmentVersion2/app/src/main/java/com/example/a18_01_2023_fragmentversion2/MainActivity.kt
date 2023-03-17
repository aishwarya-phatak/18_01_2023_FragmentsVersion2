package com.example.a18_01_2023_fragmentversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a18_01_2023_fragmentversion2.databinding.ActivityMainBinding
import com.example.a18_01_2023_fragmentversion2.fragments.CounterFragment

class MainActivity : AppCompatActivity() {
    private lateinit var counterFragment: CounterFragment
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeFragments()
        initListeners()
    }
    private fun initializeFragments(){
        counterFragment = supportFragmentManager.findFragmentById(R.id.counterFragment) as CounterFragment
    }
    private fun initListeners(){
        binding.btnAddCounterFragment.setOnClickListener {

        }
    }
}