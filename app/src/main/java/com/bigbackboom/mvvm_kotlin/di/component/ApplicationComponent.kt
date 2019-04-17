package com.bigbackboom.mvvm_kotlin.di.component

import com.bigbackboom.mvvm_kotlin.AndroidApplication
import com.bigbackboom.mvvm_kotlin.di.module.ActivityBuilderModule
import com.bigbackboom.mvvm_kotlin.di.module.ApplicationModule
import com.bigbackboom.mvvm_kotlin.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    RepositoryModule::class,
    ActivityBuilderModule::class,
    AndroidInjectionModule::class
])
interface ApplicationComponent : AndroidInjector<AndroidApplication> {

//    // 依存解決を行うクラスを定義
//    fun inject(androidApplication: AndroidApplication)
//
//    // ActivityComponentのために公開
//    fun context(): Context

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: AndroidApplication): Builder

        fun build(): ApplicationComponent
    }
}