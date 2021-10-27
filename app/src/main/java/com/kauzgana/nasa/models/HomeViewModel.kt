package com.kauzgana.nasa.models

import android.provider.LiveFolders
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kauzgana.nasa.network.NasaApi
import com.kauzgana.nasa.network.NasaApiService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class HomeViewModel : ViewModel() {

    val _response = MutableLiveData<List<MarsProperty>>()

    val response :LiveData<List<MarsProperty>>
         get() = _response

    val _property = MutableLiveData<MarsProperty>()

    val property : LiveData<MarsProperty>
            get() = _property


    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {

             try {
                 var data = NasaApi.retrofitService.getProperties()
                 if (data.size > 0){
                     _property.value = data[0]
                     Log.i("data", property.value!!.imgSrcUrl)
                 }
             }catch (e: Exception){
                 //_response.value = "erooor " + e.message
                 Log.i("data", e.message.toString())
             }

         }

    }
}