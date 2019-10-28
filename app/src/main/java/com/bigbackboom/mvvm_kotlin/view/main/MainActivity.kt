package com.bigbackboom.mvvm_kotlin.view.main

import android.os.Bundle
import com.bigbackboom.mvvm_kotlin.R
import com.bigbackboom.mvvm_kotlin.view.manager.FragmentManager
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
