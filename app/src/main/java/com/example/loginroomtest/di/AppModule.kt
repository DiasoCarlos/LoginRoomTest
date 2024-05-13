package com.example.loginroomtest.di

import android.content.Context
import androidx.room.Room
import com.example.loginroomtest.core.AppConstants.Companion.BASE_URL
import com.example.loginroomtest.core.AppConstants.Companion.USER_TABLE
import com.example.loginroomtest.data.local.UserDao
import com.example.loginroomtest.data.local.UserDatabase
import com.example.loginroomtest.data.remote.AnticipoNominaApis
import com.example.loginroomtest.data.repository.AnticipoNominaRepositoryImplement
import com.example.loginroomtest.data.repository.UserRepositoryImplement
import com.example.loginroomtest.domain.repository.UserRepository
import com.example.loginroomtest.domain.valida_rfc.repository.AnticipoNominaApisRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //ROOM

    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext context : Context
    ) : UserDatabase{

        return Room
            .databaseBuilder(
                context = context,
                klass = UserDatabase::class.java,
                USER_TABLE
            ).build()

    }

    @Singleton
    @Provides
    fun provideUserDao(
        userDatabase: UserDatabase
    ) : UserDao{

        return userDatabase.UserDao()

    }

    @Provides
    @Singleton fun provideUserRepository(
        userDao: UserDao
    ) : UserRepository{

        return UserRepositoryImplement(
            userDao = userDao
        )

    }

    //RETROFIT

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client : OkHttpClient) : Retrofit {

        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

    }

    @Provides
    @Singleton
    fun provideAnticipoNominaServices(retrofit: Retrofit) : AnticipoNominaApis {

        return retrofit.create(AnticipoNominaApis::class.java)

    }

    @Provides
    @Singleton
    fun provideAnticipoNominaRepository(
        service : AnticipoNominaApis
    ) : AnticipoNominaApisRepository{

        return AnticipoNominaRepositoryImplement(
            service
        )

    }

}