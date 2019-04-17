package com.bigbackboom.mvvm_kotlin.view.manager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object FragmentManager{

    fun addFragmentToActivity(fragmentManager: FragmentManager, fragment: Fragment, fragmentId: Int){
        checkNotNull(fragmentManager)
        checkNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
        transaction.add(fragmentId, fragment)
        transaction.commit()
    }
}