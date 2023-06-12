package com.dicoding.capstoneproject.ui.screen.penjualan

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PenjualanScreen(
    modifier: Modifier = Modifier
){
    PenjualanContent()
}

@Composable
fun PenjualanContent(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Penjualan")
    }

}

