package com.example.a18_01_2023_fragmentversion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a18_01_2023_fragmentversion2.databinding.ActivityMainBinding
import com.example.a18_01_2023_fragmentversion2.fragments.CounterFragment

class MainActivity : AppCompatActivity() {
    private lateinit var counterFragment: CounterFragment
    private lateinit var binding : ActivityMainBinding
    private var counterFragmentList = ArrayList<CounterFragment>()

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

        binding.btnReset.setOnClickListener {
                    counterFragment.count = binding.edtCount.text.toString().toInt()
            for(counterFragment in counterFragmentList){
                counterFragment.count = binding.edtCount.text.toString().toInt()
            }
        }

        binding.btnAddCounterFragment.setOnClickListener {
                var counterFragment = CounterFragment()
                    var input = Bundle()
            input.putString("title",binding.edtCounterFragmentTitle.text.toString())
            input.putInt("count",binding.edtCount.text.toString().toInt())
            counterFragment.arguments = input;

            //FragmentTransaction
            var fragmentTransition = supportFragmentManager.beginTransaction()
            fragmentTransition.add(R.id.mainContainer,counterFragment,null)
            fragmentTransition.commit()
            counterFragmentList.add(counterFragment)
        }

        binding.btnRemoveCounterFragment.setOnClickListener {
            if(counterFragmentList.size == 0){
                return@setOnClickListener
            }
            supportFragmentManager.beginTransaction()
                .remove(counterFragmentList[0])
                .commit()
            counterFragmentList.removeAt(0)
        }
    }

    override fun onStart() {
        super.onStart()
        counterFragment.count = 0
    }
}