package com.burcutopcu.unittesttrain.app

import android.content.Context
import com.burcutopcu.unittesttrain.di.MainActivityModule
import com.burcutopcu.unittesttrain.helper.DateHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyApplicationModule {

    @Provides
    @Singleton
    fun provideApplication(app: MyApplication): Context = app

    @Singleton
    @Provides
    fun provideApp(): MyApplication {
        return MyApplication()
    }

    @Singleton
    @Provides
    fun provideMainActivityModule(): MainActivityModule {
        return MainActivityModule()
    }

    @Singleton
    @Provides
    fun provideApiManager(): AppManager {
        return AppManager()
    }

    @Singleton
    @Provides
    fun provideDateHelper(): DateHelper {
        return DateHelper()
    }
}