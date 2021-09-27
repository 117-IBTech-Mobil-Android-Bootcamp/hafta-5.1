package com.patikadev.livedata.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.LiveData


class MyViewModel : ViewModel() {

    private var isDone = false

    private val _datasReceived = MutableLiveData<String>()
    val datasReceived: LiveData<String> = _datasReceived

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error


    /*private val _loginState = MediatorLiveData<LoginState>()
    val loginState: MediatorLiveData<LoginState> = _loginState

    val age = MutableLiveData<Int>()
    val name = MutableLiveData<String>()*/



   /* init {
         _loginState.addSource(age){
             loginState.value =   LoginState(age = it)

         }

         _loginState.addSource(name){
             loginState.value =   LoginState(name = it)

         }

    }*/


    /* val greetingsMessage = Transformations.map(_user) {
         if (it.isAdmin) {
             "Hoşgeldin yönetici  ${it.name}"
         } else if(it.isNormal){
             "Başarıyla giriş yaptınız ${it.name}"
         }
         else{
             ""
         }

     }*/


    /*fun dataIsFetched() {
         _isOperationDone.value = isDone


        _loginState.value = LoginState(isAdmin = false, isNormal = true, name = "Ali,")
        age.value = 3
        name.value = "ali"

    }*/

    fun setStatus() {
        isDone = !isDone
        if(isDone) {
            _datasReceived.value = "Data is received recently"

        }
        else{
            //dosomethings to determine what error is occurred
                //
                    //
                        //
            _error.value = ErrorType.ANDROID_OS_IS_NOT_ELIGABLE.errorString

        }

    }

}