package com.bigbackboom.mvvm_kotlin

import com.bigbackboom.mvvm_kotlin.di.component.ApplicationComponent
import com.bigbackboom.mvvm_kotlin.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AndroidApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = initializeInjector()

    private fun initializeInjector() : ApplicationComponent{
        return DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }
}
