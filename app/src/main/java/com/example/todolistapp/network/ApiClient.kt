package com.example.todolistapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient

/**
 * Объект AppClient, который настраивает и предоставляет клиент Retrofit для выполнения сетевых запросов.
 */
object ApiClient {
    // Настройка клиента OkHttpClient с перехватчиком для добавления заголовка API-ключа к каждому запросу
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            chain ->
                val request = chain.request()

            // Создание нового запроса с добавленным заголовком API-ключа
                val newRequest = request.newBuilder()
                    .addHeader("X-Api-Key", "pdTovzgOf3K0GIPsVqK7RQ==UyBZr5f6odu4BFkw")
                    .build()

                chain.proceed(newRequest)
        }
        .build()

    // Настройка экземпляра Gson для преобразования JSON в объекты Kotlin и наоборот
    private val gson = GsonBuilder().setLenient().create()

    // Настройка и создание экземпляра Retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.api-ninjas.com/")// Базовый URL для всех запросов
        .client(okHttpClient)// Использование настроенного клиента OkHttpClient
        .addConverterFactory(GsonConverterFactory.create(gson))// Использование Gson для преобразования JSON
        .build()

    // Создание и предоставление экземпляра сервиса AnimalService для выполнения сетевых запросов
    val instance = retrofit.create(AnimalService::class.java)
}