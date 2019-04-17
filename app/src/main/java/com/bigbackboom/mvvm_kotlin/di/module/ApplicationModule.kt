package com.bigbackboom.mvvm_kotlin.di.module

import android.content.Context
import com.bigbackboom.mvvm_kotlin.AndroidApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun provideApplicationContext(application: AndroidApplication): Context

}
