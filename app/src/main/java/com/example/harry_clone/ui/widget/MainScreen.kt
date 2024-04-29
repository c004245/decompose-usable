package com.example.harry_clone.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.harry_clone.R
import com.example.harry_clone.ui.HouseType

@Composable
fun MainScreen(onItemSelected: (HouseType) -> Unit) {
    val itemList = remember {
        listOf(
            HouseType.Gryffindor,
            HouseType.Slytherin,
            HouseType.Ravenclaw,
            HouseType.Hufflepuff
        )
    }

    Box(
        modifier = Modifier.background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {
        Loop
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen {

    }
}