package com.example.rest.data.remote

import com.example.rest.data.model.Todo
import retrofit2.http.GET
interface TodoApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}