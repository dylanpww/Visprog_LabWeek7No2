package com.example.labweek782.data.repository


import com.example.labweek782.data.service.MusicService
import com.example.labweek782.model.AlbumDetailResponse
import com.example.labweek782.model.ArtistResponse
import com.example.labweek782.model.MusicResponse
import com.example.labweek782.model.TrackResponse


class MusicRepository(private val api: MusicService) {
    suspend fun getAlbum(): MusicResponse {
        return api.searchAlbums(artistName = "Bruno Mars")
    }

    suspend fun getAlbumDetail(albumId: String): AlbumDetailResponse {
        return api.getAlbumDetail(albumId = albumId)
    }

    suspend fun getAlbumTracks(albumId: String): TrackResponse{
        return api.getAlbumTracks(albumId = albumId)
    }

    suspend fun getArtist(): ArtistResponse {
        return api.searchArtist(artistName = "Bruno Mars")
    }
}