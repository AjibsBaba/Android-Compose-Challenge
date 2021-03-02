package com.ajibsbaba.adopet

data class Dog(
    val id: Int,
    val name: String,
    val breed: String,
    val color: String,
    val weight: Int,
    val age: Int,
    val story: String,
    val imageId: String,
)


val imageData = listOf(
    "https://www.pexels.com/photo/4390804/download/?search_query=rottweiler&tracking_id=94hz7wtr5wp",
    "https://www.pexels.com/photo/4052809/download/?search_query=pitbull&tracking_id=94hz7wtr5wp",
    "https://www.pexels.com/photo/3726314/download/?search_query=husky%20dog&tracking_id=94hz7wtr5wp",
    "https://www.pexels.com/photo/1242419/download/?search_query=doberman&tracking_id=94hz7wtr5wp",
    "https://www.pexels.com/photo/3930940/download/?search_query=bulldog&tracking_id=94hz7wtr5wp",
    "https://www.pexels.com/photo/1458922/download/?search_query=poodle&tracking_id=94hz7wtr5wp"
)

val dogList = listOf(
    Dog(1, "Jack","Rottweiler", "Black", 24,
        3, "A Rottweiler found on the streets of london", imageData[0]),
    Dog(2, "Don","Pit bull", "White", 9,
        1, "A Pit bull previously owned put out for adoption",
        imageData[1]),
    Dog(3, "Bob","Siberian Husky", "Black", 5,
    7, "Siberian Husky found lost in the bleak mid winter", imageData[2]),
    Dog(4, "Jon","Doberman", "Black", 13,
    7, "Doberman put out for adoption by owner", imageData[3]),
    Dog(5, "Layo", "BullDog", "White", 5,
    2, "Young dog abandoned on the streets", imageData[4]),
    Dog(6, "Dan", "Poodle", "Black", 12,
    6, "Newly born Asian Poodle", imageData[5])
)