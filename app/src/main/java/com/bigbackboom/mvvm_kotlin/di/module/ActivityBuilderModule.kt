package com.bigbackboom.mvvm_kotlin.di.module

import androidx.lifecycle.ViewModelProvider
import com.bigbackboom.mvvm_kotlin.di.ViewModelFactory
import com.bigbackboom.mvvm_kotlin.di.scope.ActivityScope
import com.bigbackboom.mvvm_kotlin.view.main.MainActivity
import com.bigbackboom.mvvm_kotlin.view.main.MainActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

}
