package com.dicoding.capstoneproject

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dicoding.capstoneproject.R
import com.dicoding.capstoneproject.ui.navigation.NavigationItem
import com.dicoding.capstoneproject.ui.navigation.Screen
import com.dicoding.capstoneproject.ui.screen.beranda.BerandaScreen
import com.dicoding.capstoneproject.ui.screen.keranjang.KeranjangScreen
import com.dicoding.capstoneproject.ui.screen.pencarian.PencarianScreen
import com.dicoding.capstoneproject.ui.screen.pengaturan.PengaturanScreen
import com.dicoding.capstoneproject.ui.screen.penjualan.PenjualanScreen
import com.dicoding.capstoneproject.ui.theme.CapstoneProjectTheme

@Composable
fun CapstoneProjectApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Beranda.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Beranda.route){
                BerandaScreen()
            }
            composable(Screen.Penjualan.route){
                PenjualanScreen()
            }
            composable(Screen.Pencarian.route){
                PencarianScreen()
            }
            composable(Screen.Keranjang.route){
                KeranjangScreen()
            }
            composable(Screen.Pengaturan.route){
                PengaturanScreen()
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.navigation_item_beranda),
                icon = Icons.Default.Home,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(R.string.navigation_item_penjualan),
                icon = Icons.Default.Add,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(R.string.navigation_item_pencarian),
                icon = Icons.Default.Search,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(R.string.navigation_item_keranjang),
                icon = Icons.Default.ShoppingCart,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(R.string.navigation_item_pengaturan),
                icon = Icons.Default.Settings,
                screen = Screen.Beranda
            ),

            )
        BottomNavigation() {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            navigationItems.map {item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = {Text(item.title)},
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CapstoneProjectAppPreview(){
    CapstoneProjectTheme {
        CapstoneProjectApp()
    }
}

