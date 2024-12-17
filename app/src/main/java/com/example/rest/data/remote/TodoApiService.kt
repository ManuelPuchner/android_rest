package com.example.rest.data.remote

import com.example.rest.data.model.Todo
import retrofit2.http.*

interface TodoApiService {

    // GET: Alle Todos abrufen
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    // GET: Einzelnes Todo abrufen mit ID
    @GET("todos/{id}")
    suspend fun getTodoById(@Path("id") id: Int): Todo

    // POST: Neues Todo erstellen
    @POST("todos")
    suspend fun createTodo(@Body newTodo: Todo): Todo

    // PUT: Bestehendes Todo aktualisieren
    @PUT("todos/{id}")
    suspend fun updateTodo(@Path("id") id: Int, @Body updatedTodo: Todo): Todo

    // DELETE: Todo löschen
    @DELETE("todos/{id}")
    suspend fun deleteTodo(@Path("id") id: Int)
}
