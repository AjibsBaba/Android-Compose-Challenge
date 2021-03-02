package com.ajibsbaba.adopet

import com.ajibsbaba.adopet.Dog


object Routes {

    const val SplashScreen = "splash_screen"
    const val DOG_LIST_SCREEN = "dog_list"
    const val DOG_LIST_DETAIL = "dog_ID"
    const val DOG_LIST_DETAIL_SCREEN = "dog_list_detail/{$DOG_LIST_DETAIL}"

    fun createDogListDetailDirection(dog: Dog) = "dog_list_detail/${dog.id}"
}