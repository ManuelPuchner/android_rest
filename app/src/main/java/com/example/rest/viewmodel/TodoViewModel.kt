package com.example.rest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rest.data.model.Todo
import com.example.rest.data.remote.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class TodoViewModel : ViewModel() {
    private val _todos = MutableStateFlow<List<Todo>>(listOf(
        Todo(1,1, "Video Projekt", false)
    ))
    val todos: StateFlow<List<Todo>> get() = _todos
    init {
        fetchTodos()
    }
    private fun fetchTodos() {
        viewModelScope.launch {
            delay(3000)
            try {
                val response = RetrofitInstance.api.getTodos()
                _todos.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}