package com.bigbackboom.mvvm_kotlin.view.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.bigbackboom.mvvm_kotlin.R
import com.bigbackboom.mvvm_kotlin.di.ViewModelFactory
import com.bigbackboom.mvvm_kotlin.view.manager.FragmentManager
import com.bigbackboom.mvvm_kotlin.viewmodel.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mMainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.addFragmentToActivity(supportFragmentManager, mMainFragment, R.id.contentFrame)
    }
}
