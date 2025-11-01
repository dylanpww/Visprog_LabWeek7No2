package com.example.labweek782.model


data class ArtistResponse(
    val artists: List<Artist>?
)

data class Artist(
    val idArtist: String,
    val strArtist: String,
    val strArtistThumb: String
)
