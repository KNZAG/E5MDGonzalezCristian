package com.example.e4mdgonzalezcristian

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.e4mdgonzalezcristian.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Sacyl.svg/2560px-Sacyl.svg.png"
        Glide.with(this).load(url).into(binding.logoHospital)

        binding.logoHospital.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}