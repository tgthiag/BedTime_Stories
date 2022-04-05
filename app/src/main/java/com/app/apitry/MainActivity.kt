package com.app.apitry

import android.os.Bundle
import android.text.Layout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.apitry.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//data class Movie(var title: String, var description: String)

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        //Teste1().getData(this,binding.textView)

        //var lists = listOf<String>("Thiago", "Diego", "Talita", "Genilda", "Gildete")
        var lists = arrayOf<List<String>>(
            listOf<String>(this.getString(R.string.question1), this.getString(R.string.hint1)),
            listOf<String>(this.getString(R.string.question2), this.getString(R.string.hint2)),
            listOf<String>(this.getString(R.string.question3), this.getString(R.string.hint3)),
            listOf<String>(this.getString(R.string.question4), this.getString(R.string.hint4)),
            listOf<String>(this.getString(R.string.question5), this.getString(R.string.hint5)),
            listOf<String>(this.getString(R.string.question6), this.getString(R.string.hint6)),
            listOf<String>(this.getString(R.string.question7), this.getString(R.string.hint7)),
            listOf<String>(this.getString(R.string.question8), this.getString(R.string.hint8))
        )
        var recicler: RecyclerView = binding.recicle


        val retrofitClient = NetworkUtils.getRetrofitInstance("https://shortstories-api.herokuapp.com/")
        //https://jsonplaceholder.typicode.com

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()

        callback.enqueue(object : Callback<List<Posts>> {
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                //Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                Toast.makeText(this@MainActivity, "Verify your internet connection.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.body() != null) {
                    Adapter(this@MainActivity,response.body()!!)
                    Toast.makeText(this@MainActivity,"é OKKKK",Toast.LENGTH_SHORT).show()

                    recicler.adapter = Adapter(this@MainActivity,response.body()!!)
                    recicler.layoutManager = LinearLayoutManager(this@MainActivity)
                } else {
                    Toast.makeText(this@MainActivity,"é nuuulo",Toast.LENGTH_SHORT).show()
                }
            }

//                response.body()?.forEach {
//                    txt.text = txt.text.toString().plus(it.title)
        })



    }
}