package com.bigbackboom.mvvm_kotlin.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import com.bigbackboom.mvvm_kotlin.R
import com.bigbackboom.mvvm_kotlin.databinding.FragmentMainBinding
import com.bigbackboom.mvvm_kotlin.di.ViewModelFactory
import com.bigbackboom.mvvm_kotlin.viewmodel.MainViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment @Inject constructor() : DaggerFragment() {

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.activity?.let {
            mMainViewModel = ViewModelProviders.of(it, mViewModelFactory).get(MainViewModel::class.java)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // setup DataBinding
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val binding = FragmentMainBinding.bind(view) // この時点でxmlとインスタンスの繋がる(bind)

        binding.apply {
            viewmodel = mMainViewModel
            lifecycleOwner = this@MainFragment.viewLifecycleOwner
        }

        return view
    }
}