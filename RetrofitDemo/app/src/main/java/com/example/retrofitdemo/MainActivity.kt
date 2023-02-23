package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitdemo.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var restService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        restService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        binding.apply {
            btnGetAll.setOnClickListener {
                getAllAlbum()
            }

            btnGetByUser.setOnClickListener {
                getAlbumByUserId(3)
            }

            btnGetTitleOfId3.setOnClickListener {
                getTitleOfId3()
            }
        }
    }

    private fun getTitleOfId3() {
        val responseLiveData: LiveData<Response<AlbumItem>> = liveData {
            val response = restService.getId3(3)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            Toast.makeText(
                this,
                it.body()?.title,
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    private fun getAlbumByUserId(i: Int) {
        binding.tvAlbums.text = ""

        val responseLiveData: LiveData<Response<Album>> = liveData {
            val response = restService.getAlbumByUserId(i)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    val strAlbum =
                        "User ID: ${albumItem.userId}" + "\n" + "ID: ${albumItem.id}" + "\n" + "Title: ${albumItem.title}" + "\n\n"
                    binding.tvAlbums.append(strAlbum)
                }
            }
        })
    }

    private fun getAllAlbum() {
        binding.tvAlbums.text = ""

        val responseLiveData: LiveData<Response<Album>> = liveData {
            val response = restService.getAlbum()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    val strAlbum =
                        "User ID: ${albumItem.userId}" + "\n" + "ID: ${albumItem.id}" + "\n" + "Title: ${albumItem.title}" + "\n\n"
                    binding.tvAlbums.append(strAlbum)
                }
            }
        })
    }
}