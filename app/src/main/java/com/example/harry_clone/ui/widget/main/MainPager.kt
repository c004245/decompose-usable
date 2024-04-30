package com.example.harry_clone.ui.widget.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.harry_clone.R
import com.example.harry_clone.ui.HouseType
import com.example.harry_clone.ui.widget.util.harryPotterFont
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlin.math.absoluteValue
import com.google.accompanist.pager.calculateCurrentOffsetForPage


@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun MainPager(
    list: List<HouseType>,
    modifier: Modifier = Modifier,
    onItemSelected: (HouseType) -> Unit
) {
    val pagerState = rememberPagerState { list.size }

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        pageSpacing = 16.dp) {page ->
        val logo = list[page].logo
        val name = list[page].name
        val pageOffset = calculatePageOffset(pagerState = pagerState, page = page )
        Column(
            Modifier
                .clickable(
                    true,
                    onClick = { onItemSelected.invoke(list[page]) }
                )
                .graphicsLayer {
                                lerp (
                                start = ScaleFactor(0.55f, 0.55f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale.scaleX
                        scaleY = scale.scaleY
                    }

                    alpha = lerp(
                        start = ScaleFactor(0.5f, 0.5f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).scaleX
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = logo),
                contentDescription = "",
                modifier = Modifier.size(320.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = harryPotterFont,
                color = colorResource(id = R.color.white),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun calculatePageOffset(pagerState: androidx.compose.foundation.pager.PagerState, page: Int): Float {
    val currentPageOffset = pagerState.currentPage + pagerState.currentPageOffsetFraction

    return (page - currentPageOffset).absoluteValue
}
