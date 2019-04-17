package com.bigbackboom.mvvm_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bigbackboom.mvvm_kotlin.repository.github.GitHubRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val githubRepo: GitHubRepository) : ViewModel() {

    val displayText: MutableLiveData<String> = MutableLiveData()
    val editText: MutableLiveData<String> = MutableLiveData()
    val isProgressVisible: MutableLiveData<Boolean> = MutableLiveData()

    fun onLoadButtonClick(){
        loadRepositoryData(editText.value.toString())
    }

    private fun loadRepositoryData(username: String) {

        // reset
        isProgressVisible.postValue(true)
        displayText.postValue("")

        githubRepo.getUserRepositories(
                username,
                {
                    Log.d("MainViewModel", it.toString())
                    val stringBuilder = StringBuilder()

                    it.forEach { repo ->
                        stringBuilder.append(repo.fullName + "\n")
                    }
                    displayText.postValue(stringBuilder.toString())
                    isProgressVisible.postValue(false)
                },
                {
                    Log.d("MainViewModel", it.toString())
                })
    }
}