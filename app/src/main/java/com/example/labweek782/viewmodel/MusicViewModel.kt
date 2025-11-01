package com.example.labweek782.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labweek782.data.container.RetrofitInstance.api
import com.example.labweek782.model.Album
import com.example.labweek782.data.repository.MusicRepository
import com.example.labweek782.model.AlbumDetailResponse
import com.example.labweek782.model.Artist
import com.example.labweek782.model.ArtistResponse
import com.example.labweek782.model.Track
import com.example.labweek782.model.TrackResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class MusicViewModel() : ViewModel() {
    private val repository = MusicRepository(api)
    private val _albums = MutableStateFlow<List<Album>>(emptyList())
    val albums: StateFlow<List<Album>> = _albums

    private val _artist = MutableStateFlow<List<Artist>>(emptyList())
    val artist: StateFlow<List<Artist>> = _artist
    private val _albumDetail = MutableStateFlow<AlbumDetailResponse?>(null)
    val albumDetail: StateFlow<AlbumDetailResponse?> = _albumDetail
    private val _albumTracks = MutableStateFlow<List<Track>>(emptyList())
    val albumTracks: StateFlow<List<Track>> = _albumTracks

    init {
        fetchAlbums()
        fetchArtist()
    }

    private fun fetchAlbums() {
        viewModelScope.launch {
            try {
                val response = repository.getAlbum()
                _albums.value = response.album ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun fetchArtist() {
        viewModelScope.launch {
            try {
                val response = repository.getArtist()
                _artist.value = response.artists ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchAlbumDetail(albumId: String) {
        viewModelScope.launch {
            try {
                val response = repository.getAlbumDetail(albumId)
                _albumDetail.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchAlbumTracks(albumId: String) {
        viewModelScope.launch {
            try {
                val response = repository.getAlbumTracks(albumId)
                _albumTracks.value = response.track ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun formatDuration(milliseconds: Long): String {
        val totalSeconds = milliseconds / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format("%d:%02d", minutes, seconds)
    }

}

