package com.patikadev.livedata.model

data class LoginState(val isAdmin : Boolean ?= null, val isNormal : Boolean?= null, val name : String?= null, val age : Int?= null)