package com.bogdan.quizapppp.modules

import com.bogdan.quizapppp.helpers.DataManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class AppModule {
    @Provides
    @ActivityScoped
    fun createDataManager(): DataManager{
        return DataManager()
    }
}