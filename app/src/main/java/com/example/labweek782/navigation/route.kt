package com.example.labweek782.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.labweek782.view.AlbumDetail
import com.example.labweek782.view.Soal2View
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


@Composable
fun Router(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "view_awal"
    ){
        composable("view_awal"){
            Soal2View(navController = navController)
        }
        composable(
            route = "album_detail/{albumId}",
            arguments = listOf(navArgument("albumId") { type = NavType.StringType })
        ) { backStackEntry ->
            val albumId = backStackEntry.arguments?.getString("albumId")
            AlbumDetail(albumId = albumId)
        }

    }
}