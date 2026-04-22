package com.example.core_ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core_navigation.NavRoutes
import com.example.core_ui.R
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.BackgroundInput
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.LineColor
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.theme.nonColor

@Composable
fun NavigationBar(
    navController: NavController,
    currentRoute: String? = navController.currentBackStackEntry?.destination?.route
) {
    val selectedIndex = remember(currentRoute) {
        mutableStateOf(
            when (currentRoute) {
                NavRoutes.MainScreen.routes -> 1
                NavRoutes.Favorite.routes -> 2
                NavRoutes.Profile.routes -> 3
                else -> 0
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(BackgroundAvatar)
            .drawBehind {
                drawLine(
                    color = LineColor,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 1.dp.toPx()
                )
            }
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 8.dp),
                Arrangement.Center, Alignment.CenterHorizontally
            ) {
                FooterItem(painterResource(R.drawable.footer_main),"Главная",selectedIndex,1){
                    if (selectedIndex.value != 1) {
                        navController.navigate(NavRoutes.MainScreen.routes)
                        selectedIndex.value = 1
                    }
                }


            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 8.dp),
                Arrangement.Center, Alignment.CenterHorizontally
            ) {
                FooterItem( painterResource(R.drawable.footer_bookmark),"Избранное",selectedIndex,2){
                    if (selectedIndex.value != 2) {
                        navController.navigate(NavRoutes.Favorite.routes)
                        selectedIndex.value = 2
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(start = 8.dp),
                Arrangement.Center, Alignment.CenterHorizontally
            ) {
                FooterItem( painterResource(R.drawable.footer_profile),"Аккаунт",selectedIndex,3){
                    if (selectedIndex.value != 3) {
                        navController.navigate(NavRoutes.Profile.routes)
                        selectedIndex.value = 3
                    }
                }
            }
        }
    }
}
@Composable
fun FooterItem(
    painterResource: Painter,
    text: String,
    selectedIndex: MutableState<Int>,
    itemIndex: Int,
    onClick: () -> Unit,)
{
    Box(Modifier.width(64.dp).height(32.dp).clip(RoundedCornerShape(16.dp)).background(
        if(selectedIndex.value == itemIndex){BackgroundInput}else{nonColor}
    ).clickable{
        onClick.invoke()
    }, contentAlignment = Alignment.Center){
        Icon(
            painter =painterResource ,
            contentDescription = null,
            tint = if(selectedIndex.value == itemIndex){BrandGreen}else{TextPrimary},
            modifier = Modifier.size(24.dp)
        )
    }
    Spacer(Modifier.height(4.dp))
    NavLabelInactiveText(
        text = text,
        textColor = if(selectedIndex.value == itemIndex){BrandGreen}else{TextPrimary}
    )
}