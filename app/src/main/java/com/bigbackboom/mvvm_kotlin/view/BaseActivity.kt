package com.bigbackboom.mvvm_kotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bigbackboom.mvvm_kotlin.AndroidApplication


abstract class BaseActivity : AppCompatActivity() {

//    private lateinit var activityComponent: ActivityComponent
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        activityComponent = DaggerActivityComponent.builder()
//            .applicationComponent((application as AndroidApplication).getApplicationComponent())
//            .activityModule(ActivityModule(this))
//            .build()
//    }
//
//    fun getComponent(): ActivityComponent {
//        return activityComponent
//    }
//
//    protected fun addFragment(containerViewId: Int, fragment: Fragment) {
//        val fragmentTransaction = this.supportFragmentManager.beginTransaction()
//        fragmentTransaction.add(containerViewId, fragment)
//        fragmentTransaction.commit()
//    }
}