package com.example.labweek782.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.labweek782.viewmodel.MusicViewModel

@Composable
fun AlbumDetail(
    albumId: String?,
    viewModel: MusicViewModel = viewModel()
) {

    LaunchedEffect(albumId) {
        albumId?.let {
            viewModel.fetchAlbumDetail(it)
            viewModel.fetchAlbumTracks(it)
        }
    }
    val detailState = viewModel.albumDetail.collectAsState()
    val details = detailState.value?.album ?: emptyList()

    val trackState = viewModel.albumTracks.collectAsState()
    val tracks = trackState.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF282828)
            )
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(details) { detail ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(
                            color = Color(0xFF191E1E)
                        )
                ) {
                    Text(
                        text = detail.strAlbum,
                        fontSize = 20.sp,
                        color = Color.LightGray,
                        modifier = Modifier
                            .padding(top = 30.dp)
                    )
                }



                Card(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(
                        modifier = Modifier

                            .fillMaxWidth()
                            .background(
                                color = Color(0xFF191E1E)
                            )

                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(detail.strAlbumThumb)
                                .crossfade(true)
                                .build(),
                            contentDescription = detail.strAlbum,
                            modifier = Modifier
                                .size(450.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                        ) {
                            Text(
                                text = detail.strAlbum,
                                color = Color.LightGray,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(vertical = 10.dp)
                            )
                            Text(
                                text = "${detail.intYearReleased} • ${detail.strGenre}",
                                color = Color.LightGray,
                                fontSize = 15.sp,
                            )
                            Text(
                                text = detail.strDescriptionEN?:"dari API nya ga ada description",
                                fontSize = 15.sp,
                                color = Color.LightGray,
                                modifier = Modifier
                                    .padding(vertical = 15.dp)
                            )
                        }


                    }

                }
            }

            item {
                Text(
                    text = "Tracks",
                    color = Color(0xFFAF9F67),
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .padding(horizontal = 10.dp)
                )
            }

            itemsIndexed(tracks) { index, track ->

                Column(
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .padding(horizontal = 20.dp)

                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(30.dp)
                                    .background(
                                        color = Color(0xFF403C23),
                                        shape = RoundedCornerShape(10.dp)
                                    )
                            ) {
                                Text(
                                    text = "${index + 1}",
                                    color = Color(0xFFAF9F67),
                                    fontSize = 20.sp
                                )

                            }
                            Spacer(
                                modifier = Modifier
                                    .width(10.dp)
                            )
                            Text(
                                text = track.strTrack,
                                color = Color.LightGray,
                                fontSize = 20.sp
                            )
                        }


                        Text(
                            text = viewModel.formatDuration(track.intDuration),
                            color = Color.LightGray,
                            fontSize = 15.sp,
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(color = Color.Gray)
                    )
                }

            }


        }
    }
}
