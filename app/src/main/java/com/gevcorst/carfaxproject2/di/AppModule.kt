@file:OptIn(ExperimentalCoroutinesApi::class)

package com.gevcorst.carfaxproject.di

import com.gevcorst.carfaxproject2.repository.CarListRepository
import com.gevcorst.carfaxproject2.repository.database.CarObjectDAO
import com.gevcorst.carfaxproject2.repository.network.CarFaxJsonObjectAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providesCoroutineScope(): CoroutineScope {
        // Run this code when providing an instance of CoroutineScope
        return CoroutineScope(SupervisorJob() + Dispatchers.Default)
    }

    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }


    @Singleton
    @Provides
    fun getCarListRepository(
        database: CarObjectDAO, carListService: CarFaxJsonObjectAPIService,
        ioDispatcher: CoroutineDispatcher
    ): CarListRepository {
        return CarListRepository.getInstance(database, carListService)
    }
}
