package com.example.labweek782

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labweek782.data.container.RetrofitInstance
import com.example.labweek782.data.repository.MusicRepository
import com.example.labweek782.navigation.Router
import com.example.labweek782.ui.theme.LabWeek782Theme
import com.example.labweek782.view.Soal2View
import com.example.labweek782.viewmodel.MusicViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Router()
        }
    }
}

