package com.example.loveapi.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.loveapi.data.local.dao.LoveDao
import com.example.loveapi.data.local.db.LoveDataBase
import com.example.loveapi.api.LoveApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    fun provideOnBoardPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("shared",Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): LoveDataBase =
        Room.databaseBuilder(context, LoveDataBase::class.java, "LoveDataBase").allowMainThreadQueries().build()

    @Provides
    fun provideDao(loveDataBase: LoveDataBase): LoveDao{
        return loveDataBase.getHistoryDao()
    }
    @Provides
    fun provideRetrofitService(): LoveApiService {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoveApiService::class.java)
    }
}