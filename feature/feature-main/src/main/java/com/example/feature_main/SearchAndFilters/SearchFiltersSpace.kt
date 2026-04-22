package com.example.feature_main.SearchAndFilters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.TextPrimary
import com.example.feature_main.R

@Composable
fun SearchFiltersSpace(){
    Box(Modifier.size(56.dp).clip(RoundedCornerShape(28.dp)).background(BackgroundAvatar), contentAlignment = Alignment.Center){
        Icon(
            painter = painterResource(R.drawable.filters_icon),
            contentDescription = null,
            tint = TextPrimary,
            modifier = Modifier.size(24.dp)
        )
    }
}