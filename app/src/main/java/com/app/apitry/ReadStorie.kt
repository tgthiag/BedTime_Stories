package com.app.apitry

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import com.app.apitry.databinding.ActivityReadStorieBinding
import java.util.*

lateinit var mTTS : TextToSpeech
private lateinit var binding: ActivityReadStorieBinding
class ReadStorie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReadStorieBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.readTitle.text = intent.getStringExtra("titulo")
        var body = intent.getStringExtra("body")
        var body2 = body?.replace(",\"", "\",")?.replace(".\"", "\".")?.replace("Ass","Donkey")?.replace("Cock","Rooster")
        var body3 = body2?.replace(". ", ".\n")
        binding.readBody.text = body3

        binding.playBt.setOnClickListener {
            mTTS = TextToSpeech(this,TextToSpeech.OnInitListener { status ->
                if (status != TextToSpeech.ERROR){
                    mTTS.setLanguage(Locale.US)
                    mTTS.setSpeechRate(0.5F)
                    mTTS.setPitch(0.8F)
                    mTTS.speak(body3,TextToSpeech.QUEUE_FLUSH,null,null)
                }
            })
        }
    }
}