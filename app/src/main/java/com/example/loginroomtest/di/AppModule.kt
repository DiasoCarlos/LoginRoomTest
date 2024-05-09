package com.example.loginroomtest.di

import android.content.Context
import androidx.room.Room
import com.example.loginroomtest.core.AppConstants.Companion.USER_TABLE
import com.example.loginroomtest.data.local.UserDao
import com.example.loginroomtest.data.local.UserDatabase
import com.example.loginroomtest.data.repository.UserRepositoryImplement
import com.example.loginroomtest.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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

}