package com.example.todolistapp.network

import com.example.todolistapp.model.Animal
import retrofit2.Call
import retrofit2.http.GET

/**
 * Интерфейс AnimalService, который определяет сетевые запросы к API.
 */
interface AnimalService {
    /**
     * Получает список животных с именем "dog" от API.
     *
     * @return Call, который возвращает список объектов Animal.
     */
    @GET("v1/animals?name=dog")
    fun fetchAnimalList(): Call<List<Animal>>
}