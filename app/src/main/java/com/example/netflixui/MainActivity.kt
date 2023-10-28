package com.example.netflixui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixui.ui.theme.NetflixUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ){
                TopAppSection()
                NetflixContentChooser()
                FeaturedMovieSection()
                AddMovieLists("Watch It Again")
                AddMovieLists("Drama Movies")
                AddMovieLists("Action Movies")
                AddMovieLists("New Release")
                AddMovieLists("Watch It Again")
                AddMovieLists("Drama Movies")
                AddMovieLists("Action Movies")
                AddMovieLists("New Release")
            }
        }
    }
    @Composable

    fun TopAppSection(){
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 6.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

        ){
            Image(painter= painterResource(id = R.drawable.logo),contentDescription="icon",
                modifier = Modifier.size(100.dp)
                )
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(36.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "user",
                    modifier = Modifier
                        .padding(12.dp)
                        .size(36.dp)
                )
            }
        }
    }
    @Composable

    fun NetflixContentChooser() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 30.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ){
            Text(text="TV Shows", color=Color.LightGray, fontSize = 20.sp)
            Text(text = "Movies",color= Color.LightGray, fontSize = 20.sp)
            Row(){
                Text(text = "Categories",color= Color.LightGray, fontSize = 20.sp)
                Image(painter = painterResource(id = R.drawable.ic_drop_down), contentDescription = "drop down")
            }
        }
    }
    @Composable

    fun FeaturedMovieSection(){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.tb1), contentDescription ="",
                modifier = Modifier.size(280.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp, start = 60.dp, end = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = "British", color = Color.LightGray)
            Text(text = "Drama", color = Color.LightGray)
            Text(text = "Thriller", color = Color.LightGray)
            Text(text = "Emmy Winner", color = Color.LightGray)
        }
        Row(
            modifier = Modifier
                .padding(top = 40.dp, start = 80.dp, end = 80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = "")
                Text(text = "My List", color = Color.White,fontSize = 10.sp)
            }
            Button(
                onClick = {}, colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Play", color = Color.Black, fontSize = 18.sp)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.ic_info), contentDescription = "")
                Text(text = "Info", color = Color.White, fontSize = 10.sp)
            }
        }
        }
    }
    @Composable
    fun AddMovieLists(movieName:String){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
        Text(text = movieName, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.LightGray,
            modifier = Modifier.padding(top = 5.dp, start = 12.dp)
            )
            LazyRow(
//                modifier=Modifier.padding(top = 4.dp)
            ){
                itemsIndexed(getRandomMovieList()){
                    index, item ->  
                    MovieItemUiModel(imageRes = item.image)
                }
            }

        }
    }
    @Composable
    fun MovieItemUiModel(imageRes:Int){
        Image(painter = painterResource(id = imageRes), contentDescription ="",
        modifier = Modifier
            .padding(end = 8.dp)
            .height(140.dp)
            .width(120.dp)
        )
    }
    fun getRandomMovieList():List<MoviesItemsModel>{
        val listofMovies= mutableListOf<MoviesItemsModel>()
        listofMovies.add(MoviesItemsModel(R.drawable.tb2))
        listofMovies.add(MoviesItemsModel(R.drawable.tb3))
        listofMovies.add(MoviesItemsModel(R.drawable.tb4))
        listofMovies.add(MoviesItemsModel(R.drawable.tb6))
        listofMovies.add(MoviesItemsModel(R.drawable.tb1))
        listofMovies.add(MoviesItemsModel(R.drawable.tb5))
        listofMovies.add(MoviesItemsModel(R.drawable.tb8))
        listofMovies.add(MoviesItemsModel(R.drawable.tb9))
        listofMovies.add(MoviesItemsModel(R.drawable.tb10))
        listofMovies.shuffle()
        return listofMovies
    }
}
data class MoviesItemsModel(
    val image:Int
)

