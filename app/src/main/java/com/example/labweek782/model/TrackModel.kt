package com.example.labweek782.model

data class TrackResponse(
    val track: List<Track>?
)

data class Track(
    val idTrack: String,
    val strTrack: String,
    val intDuration: Long
)