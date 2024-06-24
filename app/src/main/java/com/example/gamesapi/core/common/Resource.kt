package com.example.gamesapi.core.common

sealed class Resource<T>(val data : T?=null,val msg : String?=null) {

    class Success<T>(data : T) : Resource<T>(data = data)
    class Error<T>(msg : String) : Resource<T>(msg=msg)
    class Loadings<T> : Resource<T>()
}