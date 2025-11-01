package com.example.labweek782.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.labweek782.viewmodel.MusicViewModel

@Composable
fun Soal2View(navController: NavController, viewModel: MusicViewModel = viewModel()){

    val artists by viewModel.artist.collectAsState()
    val albumState = viewModel.albums.collectAsState()
    val albums = albumState.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF282828)
            )


    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(artists) {artist->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(
                            color = Color(0xFF191E1E)
                        )
                ) {
                    Text(
                        text = artist.strArtist,
                        color = Color.LightGray,
                        fontSize = 20.sp,
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
                        .padding(horizontal = 10.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(artist.strArtistThumb)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        modifier = Modifier
                            .size(400.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Albums",
                        color = Color.LightGray
                    )
                }
            }

            item {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .height(800.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(albums) { album ->
                        cardBawah(navController, album)
                    }
                }
            }

        }
    }
}

