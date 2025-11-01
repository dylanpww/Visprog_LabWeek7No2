package com.example.labweek782.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.labweek782.R
import com.example.labweek782.model.Album
import com.example.labweek782.viewmodel.MusicViewModel

@Composable
fun cardBawah(
    navController: NavController,
    album: Album
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .clickable {
                navController.navigate("album_detail/${album.idAlbum}")
            }
            .height(270.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF191E1E)
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(album.strAlbumThumb)
                        .crossfade(true)
                        .build(),
                    contentDescription = album.strAlbum,
                    modifier = Modifier
                        .size(200.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))


            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = album.strAlbum,
                    color = Color.LightGray,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
                Text(
                    text = "${album.intYearReleased} • ${album.strGenre}",
                    color = Color.LightGray,
                    fontSize = 15.sp
                )
            }
        }
    }
}



