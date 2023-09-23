package com.yt.fooddeliveryappui.screens.bottomNavigation.screens

import android.content.Context
import android.os.Parcelable
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yt.fooddeliveryappui.R
import com.yt.fooddeliveryappui.commonui.*
import com.yt.fooddeliveryappui.model.listOfFood
import com.yt.fooddeliveryappui.screens.activities.CartActivity
import com.yt.fooddeliveryappui.screens.activities.DetailActivity
import com.yt.fooddeliveryappui.ui.theme.lightGray
import com.yt.fooddeliveryappui.utils.launchActivity
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.parcelize.WriteWith


@Composable
fun HomeTab(
    scaffoldState: ScaffoldState
)  {

        val context = LocalContext.current
        val scope = rememberCoroutineScope()

        val horizontalScrollState = rememberScrollState()
        val verticalScrollState = rememberScrollState()
        val search = remember { mutableStateOf("") }
        val lists by remember { mutableStateOf(listOf("Restaurants")) }
        var currentListValue by remember { mutableStateOf("Restaurants") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(verticalScrollState)
                .background(lightGray)
                .padding(bottom = 50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CommonIconButton(icon = R.drawable.nav_bar){
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
                CommonIconButton(icon = R.drawable.cart){
                    context.launchActivity<CartActivity> {  }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, start = 30.dp)
            ) {
                Text34_700(text = "Best Restaurants\nNear You", color = Color.Black)
            }

            if (currentListValue == "Restaurants")
                FoodTabUi(context)
        }

}

@Composable
fun FoodTabUi(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
    ) {
        listOfFood.forEach { food ->
            FoodEachRow(food) {
                context.launchActivity<DetailActivity> {
                    putExtra("data", food)
                }
            }
            Spacer(modifier = Modifier.height(16.dp)) // Add spacing between cards
        }
    }
}



