package com.example.harry_clone.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harry_clone.R
import com.example.harry_clone.ui.HouseType
import com.example.harry_clone.ui.widget.lottie.LoopLottieAnimation
import com.example.harry_clone.ui.widget.main.MainPager

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
        modifier = Modifier
            .background(colorResource(id = R.color.background))
            .fillMaxSize()
    ) {
        LoopLottieAnimation(rawId = R.raw.lightning)

        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(128.dp))
            Image(
                painterResource(id = R.drawable.logo),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(288.dp)
                    .height(120.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(24.dp))
            MainPager(
                list = itemList,
                onItemSelected = onItemSelected,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)

            )
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen {

    }
}