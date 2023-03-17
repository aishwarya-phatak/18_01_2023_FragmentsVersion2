package com.example.a18_01_2023_fragmentversion2.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a18_01_2023_fragmentversion2.databinding.CounterFragmentBinding

class CounterFragment : Fragment() {
    private lateinit var binding : CounterFragmentBinding

    var count = 0
    set(value){
        field = value
        binding.txtCount.text = "${count}"
    }

    var title : String = ""
    set(value){
        field = value
        binding.txtTitle.text = title
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CounterFragmentBinding.inflate(inflater)
        if(arguments != null){
            binding.txtTitle.text = arguments!!.getString("title")
            binding.txtCount.text = "${arguments!!.getInt("count")}"
        }

        initListeners()
        return binding.root
    }

    private fun initListeners(){
        binding.btnDecrement.setOnClickListener {
            binding.txtCount.text = "${--count}"
        }

        binding.btnIncrement.setOnClickListener {
            binding.txtCount.text = "${++count}"
        }
    }
}