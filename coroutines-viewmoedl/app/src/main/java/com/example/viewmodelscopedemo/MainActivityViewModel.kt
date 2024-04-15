package com.example.viewmodelscopedemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.viewmodelscopedemo.model.User
import com.example.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivityViewModel : ViewModel() {

    private val repo = UserRepository()
//    private val myJob = Job()
//    private val myScope = CoroutineScope(Dispatchers.IO + myJob)


    private val _users = MutableLiveData<List<User>>(emptyList())
//    private val _users2 = LiveData(Dispatchers.IO) {
//
//
//    }


    val users: LiveData<List<User>>
        get() = _users

    fun getUserData() {

        viewModelScope.launch {
            var result = emptyList<User>()
            withContext(Dispatchers.IO) {
                result = repo.getUsers()
            }

            _users.value = result

        }
//        myScope.launch {
//
//        }

    }

//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//    }


}