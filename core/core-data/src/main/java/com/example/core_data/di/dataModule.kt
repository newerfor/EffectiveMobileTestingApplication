package com.example.core_data.di

import com.example.core_data.RepositoryImpl
import com.example.core_data.local.dao.CoursesDao
import com.example.core_data.local.database.CoursesDatabase
import com.example.core_data.local.database.DataBaseProvider
import com.example.core_data.local.localRepository.LocalDataSource
import com.example.core_data.local.localRepository.LocalRepositoryImpl
import com.example.core_data.mapper.Mapper
import com.example.core_data.remote.api.ApiClient
import com.example.core_data.remote.api.ApiService
import com.example.core_data.remote.remoteRepository.RemoteDataSource
import com.example.core_data.remote.remoteRepository.RemoteRepositoryImpl
import com.example.core_domain.repository.CoursesRepository
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named

val dataModule = module {
    single<CoursesRepository> {
        RepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get(),
            mapper = get()
        )
    }
    single<CoursesDatabase> {
        DataBaseProvider.getDatabase(androidContext())
    }

    // 2. Dao
    single<CoursesDao> {
        get<CoursesDatabase>().coursesDao()
    }

    // 3. Mapper
    single { Mapper() }

    // 4. ApiService (два экземпляра с разными квалификаторами)
    single<ApiService>(qualifier = named("main")) {
        ApiClient.mainInstance
    }

    single<ApiService>(qualifier = named("backup")) {
        ApiClient.secondInstance
    }

    // 5. LocalDataSource
    single<LocalDataSource> {
        LocalRepositoryImpl(dao = get())
    }

    // 6. RemoteDataSource
    single<RemoteDataSource> {
        RemoteRepositoryImpl(
            apiService = get(qualifier = named("main")),
            secondApiService = get(qualifier = named("backup"))
        )
    }

    // 7. CoursesRepository
    single<CoursesRepository> {
        RepositoryImpl(
            localDataSource = get(),
            remoteDataSource = get(),
            mapper = get()
        )
    }
}