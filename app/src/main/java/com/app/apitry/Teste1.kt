package com.app.apitry

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

//data class Posts(
//    @SerializedName("userId")
//    var userId : Int,
//    @SerializedName("id")
//    var id : Int,
//    @SerializedName("title")
//    var title : String,
//    @SerializedName("body")
//    var body : String
//)

data class Posts(var id :String, var title : String, var author : String,@SerializedName("story") var story : String,var moral : String)

interface Endpoint {

    @GET("stories")
    fun getPosts() : Call<List<Posts>>
}


//class Teste1 {
//
//    fun getData(cxt: Context, txt: TextView) {
//        val retrofitClient = NetworkUtils.getRetrofitInstance("https://shortstories-api.herokuapp.com/")
//        //https://jsonplaceholder.typicode.com
//
//        val endpoint = retrofitClient.create(Endpoint::class.java)
//        val callback = endpoint.getPosts()
//
//        callback.enqueue(object : Callback<List<Posts>> {
//            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
//                Toast.makeText(cxt, t.message, Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
//                response.body()?.forEach {
//                    txt.text = txt.text.toString().plus(it.title)
//                }
//            }
//        })
//
//    }
//}