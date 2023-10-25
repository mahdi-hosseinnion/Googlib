package com.ssmmhh.googlib.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ssmmhh.googlib.ServiceLocator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val apiService = ServiceLocator.createBookApiService()

    val bookListStateFlow = MutableStateFlow<List<String?>>(listOf())

    fun fetchBookListByQuery(query: String?) {
        viewModelScope.launch {
            val volumes = apiService.listRepos(query)
            val bookList = volumes.items?.map { it?.volumeInfo?.title }
            bookListStateFlow.value = bookList ?: emptyList()
        }
    }
}