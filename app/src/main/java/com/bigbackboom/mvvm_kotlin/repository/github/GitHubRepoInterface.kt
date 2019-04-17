package com.bigbackboom.mvvm_kotlin.repository.github

import com.bigbackboom.mvvm_kotlin.model.Repo

interface GitHubRepoInterface {
    fun getUserRepositories(username: String, onSuccess: (List<Repo>) -> Unit, onError: (t: Throwable) -> Unit)
}