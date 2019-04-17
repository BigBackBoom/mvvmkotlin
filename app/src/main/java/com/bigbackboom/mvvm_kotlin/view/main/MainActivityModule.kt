package com.bigbackboom.mvvm_kotlin.view.main

import androidx.lifecycle.ViewModel
import com.bigbackboom.mvvm_kotlin.di.ViewModelKey
import com.bigbackboom.mvvm_kotlin.di.scope.FragmentScope
import com.bigbackboom.mvvm_kotlin.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}