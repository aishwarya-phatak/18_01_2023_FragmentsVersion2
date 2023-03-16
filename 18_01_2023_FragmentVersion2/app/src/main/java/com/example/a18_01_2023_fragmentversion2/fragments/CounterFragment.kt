package com.example.a18_01_2023_fragmentversion2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a18_01_2023_fragmentversion2.databinding.CounterFragmentBinding

class CounterFragment : Fragment() {
    private lateinit var binding : CounterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}