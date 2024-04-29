package com.example.harry_clone.ui.widget.lottie

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState


@Composable
fun LoopLottieAnimation(
    @RawRes rawId: Int,
    modifier: Modifier = Modifier
) {
    val animationSpec = remember { LottieAnimationSpec.RawRes(rawId) }
    val animationState = rememberLottieAnimationState(imageAssetDelegate = com.airbnb.lottie.ImageAssetDelegate(), enableMergePaths = false, autoPlay = true, repeatCount = Int.MAX_VALUE, initialProgress = 0f)

    LottieAnimation(
        spec = animationSpec,
        animationState = animationState,
        modifier = modifier)
}