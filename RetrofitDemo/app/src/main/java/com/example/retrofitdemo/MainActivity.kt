package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitdemo.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnGetAll.setOnClickListener {
                getAllAlbum()
            }

            btnGetByUser.setOnClickListener {
                getAlbumByUserId(3)
            }
        }
    }

    private fun getAlbumByUserId(i: Int) {
        binding.tvAlbums.text = ""
        val restService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Album>> = liveData {
            val response = restService.getAlbumByUserId(i)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    val strAlbum = "User ID: ${albumItem.userId}" + "\n" + "ID: ${albumItem.id}" + "\n" + "Title: ${albumItem.title}" + "\n\n"
                    binding.tvAlbums.append(strAlbum)
                }
            }
        })
    }

    private fun getAllAlbum() {
        binding.tvAlbums.text = ""
        val restService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Album>> = liveData {
            val response = restService.getAlbum()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    val strAlbum = "User ID: ${albumItem.userId}" + "\n" + "ID: ${albumItem.id}" + "\n" + "Title: ${albumItem.title}" + "\n\n"
                    binding.tvAlbums.append(strAlbum)
                }
            }
        })
    }
}