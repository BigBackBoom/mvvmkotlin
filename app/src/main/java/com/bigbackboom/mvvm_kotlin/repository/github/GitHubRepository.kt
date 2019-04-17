package com.bigbackboom.mvvm_kotlin.repository.github

import com.bigbackboom.mvvm_kotlin.data.remote.GitHubAPI
import com.bigbackboom.mvvm_kotlin.model.Repo
import com.bigbackboom.mvvm_kotlin.repository.CallbackBuilder
import javax.inject.Inject

class GitHubRepository @Inject constructor(private val gitHubAPI: GitHubAPI) : GitHubRepoInterface {

    override fun getUserRepositories(
        username: String,
        onSuccess: (List<Repo>) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        gitHubAPI.getUserRepository(username)
            .enqueue(CallbackBuilder(onSuccess, onError).create())
    }
}
