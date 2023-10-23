package com.example.storyappsubmission.di

import android.content.Context
import com.example.storyappsubmission.data.UserRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserPreference
import com.dicoding.picodiploma.loginwithanimation.data.pref.dataStore
import com.example.storyappsubmission.retrofit.ApiConfig
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): StoryRepository {
        val pref = PreferenceLogin(context)
        val token= pref.getToken().toString()
        val database = StoryDataBase.getDatabase(context)
        val apiService = ApiConfig.getApiService()
        return StoryRepository(database, apiService,token)
    }
}