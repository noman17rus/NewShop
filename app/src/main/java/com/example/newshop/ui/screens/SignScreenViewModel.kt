package com.example.newshop.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignScreenViewModel : ViewModel() {

    private val _signScreenState = MutableStateFlow(SignScreenState())
    val signScreenState = _signScreenState.asStateFlow()
    var userName by mutableStateOf("")
        private set
    fun updateName(name: String){
        userName = name
        checkUserInfo()
    }
    var eMail by mutableStateOf("")
        private set
    fun updateEmail(email: String){
        eMail = email
        checkUserInfo()
    }
    var userLastName by mutableStateOf("")
        private set
    fun updateLastName(lastName: String){
        userLastName = lastName
        checkUserInfo()
    }
    fun checkUserInfo() {
        if (userName.isEmpty()) {
            _signScreenState.update {
                it.copy(isEmptyName = true)
            }
        } else {
            _signScreenState.update {
                it.copy(isEmptyName = false)
            }
        }
        if (eMail.isEmpty()) {
            _signScreenState.update {
                it.copy(isEmptyEmail = true)
            }
        } else {
            _signScreenState.update {
                it.copy(isEmptyEmail = false)
            }
        }
        if (userLastName.isEmpty()) {
            _signScreenState.update {
                it.copy(isEmptyLastName = true)
            }
        } else {
            _signScreenState.update {
                it.copy(isEmptyLastName = false)
            }
        }
    }
}