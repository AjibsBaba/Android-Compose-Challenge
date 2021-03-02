package com.ajibsbaba.adopet

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.adopet.ui.theme.AdopetTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.imageloading.ImageLoadState
import dev.chrisbanes.accompanist.imageloading.MaterialLoadingImage

@Composable
fun DogListDetailScreen(
    navController: NavController,
    dogID: Int
) {

    val dog = dogList.find { dog -> dog.id == dogID }

    Column {

        CoilImage(
            data = dog!!.imageId,
        ) { imageState ->
            when (imageState) {
                is ImageLoadState.Success -> {
                    Card(
                        shape = RoundedCornerShape(bottomEnd =5.dp, bottomStart = 5.dp)
                    ) {
                        MaterialLoadingImage(
                            result = imageState,
                            contentDescription = null,
                            fadeInEnabled = true,
                            fadeInDurationMs = 20,
                            modifier = Modifier.height(360.dp),
                            alignment = Alignment.Center,
                            contentScale = ContentScale.FillBounds,
                            skipFadeWhenLoadedFromMemory = true
                        )
                    }
                }
                is ImageLoadState.Error -> Text(text = "Loading")
                is ImageLoadState.Loading -> Text(text = "Loading")
                is ImageLoadState.Empty -> Text(text = "Loading")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(2.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.age),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )
                    Text(
                        text = dog.age.toString(),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )
                }
            }

            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(2.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .height(60.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.color),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )
                    Text(
                        text = dog.color,
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )
                }
            }

            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .width(60.dp)
                        .height(50.dp)
                        .padding(top = 8.dp, bottom = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.sex),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )

                    Text(
                        text = dog.story,
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )
                }
            }

            Card(
                modifier = Modifier.padding(start = 8.dp, top = 8.dp),
                shape = RoundedCornerShape(6.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .width(60.dp)
                        .height(50.dp)
                        .padding(top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.weight),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )
                    Text(
                        text = (dog.weight).toString(),
                        style = LocalTextStyle.current.copy(
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.almost_black),
                        )
                    )
                }
            }
        }

        Text(
            text = dog.name,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, end = 16.dp),
            style = LocalTextStyle.current.copy(
                fontSize = 24.sp,
                color = colorResource(id = R.color.almost_black),
            )
        )

        Text(
            text = stringResource(R.string.search),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            style = LocalTextStyle.current.copy(
                fontSize = 14.sp,
                color = colorResource(id = R.color.almost_black),
            )
        )

        Spacer(Modifier.requiredHeight(24.dp))

        Card(
            shape = RoundedCornerShape(10.dp),
            backgroundColor = colorResource(id = R.color.purple),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(start = 24.dp ,end = 24.dp)
        ) {
            Text(
                text = stringResource(R.string.adopt),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 16.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.white),
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun CardView() {
    AdopetTheme {
        DogListDetailScreen(navController = rememberNavController(), dogID = 2)
    }
}