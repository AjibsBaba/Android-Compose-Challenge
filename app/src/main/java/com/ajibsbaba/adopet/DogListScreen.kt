package com.ajibsbaba.adopet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.adopet.ui.theme.AdopetTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage



@Composable
fun DogListScreen(
    navController: NavController
) {
    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white))
                .padding(start = 24.dp, top = 16.dp, end = 24.dp)
        ) {
            Row {
                Text(
                    text = stringResource(id = R.string.adopt),
                    color = colorResource(id = R.color.almost_black),
                    style = LocalTextStyle.current.copy(
                        fontSize = 32.sp,
                    )
                )
            }


            Card(
                backgroundColor = colorResource(id = R.color.white),
                elevation = 1.dp, shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            ) {
            }

            Spacer(modifier = Modifier.requiredHeight(16.dp))

            Surface(color = colorResource(id = R.color.white)) {
                LazyRow {
                    items(dogList) { dog ->
                        DogListFilter(dog)
                    }
                }
            }

            Spacer(modifier = Modifier.requiredHeight(8.dp))

            DogList(
                onItemClicked = { currentDog ->
                    navController.navigate(Routes.createDogListDetailDirection(dogList[currentDog]))
                }
            )
        }
    }
}

@Composable
fun DogList(onItemClicked: (index: Int) -> Unit) {
    Surface(color = colorResource(id = R.color.white)) {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .clickable { onItemClicked }
        ) {
            itemsIndexed(dogList) { index, dog ->
                DogListItem(dog, index, onItemClicked)
            }
        }
    }
}

@Composable
fun DogListItem(dog: Dog, index: Int, onItemClicked: (index: Int) -> Unit) {
    Card(
        backgroundColor = colorResource(id = R.color.white),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(
            top = 16.dp, start = 2.dp, end = 2.dp
        )
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { onItemClicked(index) })
        ) {

            CoilImage(data = dog.imageId) { imageState ->
                when (imageState) {
                    is ImageLoadState.Success -> {
                        Card(
                            modifier = Modifier.padding(8.dp),
                            shape = RoundedCornerShape(46.dp)
                        ) {
                            MaterialLoadingImage(
                                result = imageState,
                                contentDescription = null,
                                fadeInEnabled = true,
                                fadeInDurationMs = 600,
                                modifier = Modifier
                                    .height(96.dp)
                                    .width(96.dp),
                                contentScale = ContentScale.FillBounds,
                                skipFadeWhenLoadedFromMemory = true
                            )
                        }
                    }
                    is ImageLoadState.Error -> Text(text = "Error")
                    is ImageLoadState.Loading -> Text(text = "Loading")
                    is ImageLoadState.Empty -> Text(text = "Empty")
                }
            }

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                Text(
                    text = dog.name,
                    modifier = Modifier.padding(start = 6.dp),
                    style = LocalTextStyle.current.copy(
                        color = colorResource(id = R.color.almost_black),
                        fontSize = 20.sp,
                    )
                )
                Row(
                    modifier = Modifier
                        .height(24.dp)
                        .padding(top = 8.dp)
                ) {

                    Text(
                        text = dog.story,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .height(24.dp),
                        style = LocalTextStyle.current.copy(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.almost_black),
                            textAlign = TextAlign.Center
                        )
                    )
                }

                Spacer(Modifier.requiredHeight(12.dp))

                Row {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = colorResource(id = R.color.purple),
                        modifier = Modifier
                            .padding(6.dp)
                            .width(50.dp)
                            .height(24.dp)
                    ) {
                        Text(
                            text = dog.color,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(4.dp),
                            style = LocalTextStyle.current.copy(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = colorResource(id = R.color.purple),
                        modifier = Modifier
                            .padding(6.dp)
                            .width(50.dp)
                            .height(24.dp)
                    ) {
                        Text(
                            text = dog.breed,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(4.dp),
                            style = LocalTextStyle.current.copy(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        backgroundColor = colorResource(id = R.color.purple),
                        modifier = Modifier
                            .padding(6.dp)
                            .width(50.dp)
                            .height(24.dp)
                    ) {
                        Text(
                            text = "${dog.age} year",
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .padding(4.dp),
                            style = LocalTextStyle.current.copy(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.white),
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DogListFilter(dog: Dog) {
    Card(
        backgroundColor = colorResource(id = R.color.white),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(start = 4.dp, top = 2.dp, end = 4.dp, bottom = 2.dp)
            .width(75.dp)
            .height(30.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            CoilImage(data = dog.imageId) { imageState ->
                when (imageState) {
                    is ImageLoadState.Success -> {
                        Card(
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            MaterialLoadingImage(
                                result = imageState,
                                contentDescription = null,
                                fadeInEnabled = true,
                                fadeInDurationMs = 600,
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(20.dp),
                                contentScale = ContentScale.FillBounds,
                                skipFadeWhenLoadedFromMemory = true
                            )
                        }
                    }
                    is ImageLoadState.Error -> Text(text = "Error")
                    is ImageLoadState.Loading -> Text(text = "Loading")
                    is ImageLoadState.Empty -> Text(text = "Empty")
                }
            }

            Text(
                text = dog.breed,
                modifier = Modifier.padding(start = 4.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.almost_black),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun ListPreview() {
    AdopetTheme(){
        DogListScreen(navController = rememberNavController())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkListPreview() {
    AdopetTheme(darkTheme = true) {
        DogListScreen(navController = rememberNavController())
    }
}