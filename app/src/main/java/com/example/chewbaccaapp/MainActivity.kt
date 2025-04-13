package com.example.chewbaccaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.chewbaccaapp.data.network.models.PeopleData
import com.example.chewbaccaapp.ui.StarWarsViewModel
import com.example.chewbaccaapp.ui.theme.ChewbaccaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChewbaccaAppTheme {
               StarWarsListScreen()
            }
        }
    }
}

@Composable
fun StarWarsListScreen() {
    val viewModel: StarWarsViewModel = hiltViewModel()

    viewModel.getPeopleData()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()
            .padding(40.dp)) {
            StarWarsPeopleList()
        }
    }

}

@Composable
fun StarWarsPeopleList() {
    val viewModel: StarWarsViewModel = hiltViewModel()
    val peoplelist by viewModel.peopleList.collectAsState()

    LazyColumn {
        items(peoplelist) { people ->
            StarWarsItem(people)
        }
    }


}

@Composable
fun StarWarsItem(people: PeopleData) {
    Row() {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )

        Text(
            text = people.name,
            modifier = Modifier.padding(4.dp)
        )
    }
}
