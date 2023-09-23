package com.yt.fooddeliveryappui.screens.activities

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.yt.fooddeliveryappui.BaseActivity
import com.yt.fooddeliveryappui.commonui.DrawerContent
import com.yt.fooddeliveryappui.model.drawerContent
import com.yt.fooddeliveryappui.screens.bottomNavigation.BottomBar
import com.yt.fooddeliveryappui.screens.bottomNavigation.HomeNavigation
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.ui.theme.orange

class HomeActivity : BaseActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    override fun Content() {
        val scaffoldState: ScaffoldState = rememberScaffoldState()
        val navHostController = rememberNavController()
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(lightGray)
        ) {
            Scaffold(
                bottomBar = {
                    BottomBar(navController = navHostController)
                },
                drawerContent = {
                    Spacer(modifier = Modifier.height(20.dp))
                    drawerContent.forEach {
                        DrawerContent(drawer = it, isline = it.name != "Security")
                    }
                },
                scaffoldState = scaffoldState,
                drawerBackgroundColor = orange
                ) {
                HomeNavigation(navHostController = navHostController,scaffoldState)
            }
        }
    }


}