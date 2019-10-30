package com.burcutopcu.unittesttrain.di

import com.burcutopcu.unittesttrain.activity.MainActivity
import com.burcutopcu.unittesttrain.app.MyApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [MyApplicationModule::class, AndroidInjectionModule::class, ActivityBuilder::class])
interface MainActivityComponent{

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(activity: MainActivity): Builder

        fun build(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}