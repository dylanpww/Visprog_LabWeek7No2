package com.example.labweek782.data.service


import com.example.labweek782.model.AlbumDetailResponse
import com.example.labweek782.model.ArtistResponse
import com.example.labweek782.model.MusicResponse
import com.example.labweek782.model.TrackResponse
import retrofit2.http.GET
import retrofit2.http.Query



interface MusicService {
    @GET("searchalbum.php")
    suspend fun searchAlbums(
        @Query("s") artistName: String
    ): MusicResponse

    @GET("search.php")
    suspend fun searchArtist(
        @Query("s") artistName: String
    ): ArtistResponse

    @GET("album.php")
    suspend fun getAlbumDetail(
        @Query("m") albumId: String
    ): AlbumDetailResponse


    @GET("track.php")
    suspend fun getAlbumTracks(
        @Query("m") albumId: String
    ): TrackResponse

}