package com.example.labweek782.model

data class MusicResponse(
    val album: List<Album>?
)

data class Album(
    val idAlbum: String,
    val strAlbum: String,
    val strArtist: String,
    val intYearReleased: String,
    val strGenre: String,
    val strAlbumThumb: String
)