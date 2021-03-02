package com.ajibsbaba.adopet

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import com.ajibsbaba.adopet.ui.theme.AdopetTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.adopet.Routes.DOG_LIST_DETAIL
import com.ajibsbaba.adopet.Routes.DOG_LIST_DETAIL_SCREEN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdopetTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SplashScreen) {

        composable(Routes.SplashScreen) {
            SplashScreen(navController = navController)
        }

        composable(Routes.DOG_LIST_SCREEN) {
            DogListScreen(navController = navController)
        }

        composable(
            route = DOG_LIST_DETAIL_SCREEN,
            arguments = listOf(navArgument(DOG_LIST_DETAIL) { type = NavType.IntType })
        ) {
            it.arguments?.getInt(DOG_LIST_DETAIL_SCREEN)?.let { dogID ->
                DogListDetailScreen(
                    navController,
                    dogID
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun MainView() {
    AdopetTheme {
        MainApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun MainDarkView() {
    AdopetTheme {
        MainApp()
    }
}