package com.example.harry_clone.ui.detail

import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.harry_clone.base.BaseActivity
import com.example.harry_clone.ui.HouseType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity: BaseActivity() {

    companion object {
        const val KEY_HOUSE = "house"
    }

    private val house by lazy { intent.getSerializableExtra(KEY_HOUSE) as HouseType }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen(house)
        }
    }
}