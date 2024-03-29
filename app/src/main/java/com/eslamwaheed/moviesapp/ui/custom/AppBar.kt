package com.eslamwaheed.moviesapp.ui.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBarWithArrow(
    title: String?,
    pressOnBack: () -> Unit
) {
    Row {
        Spacer(modifier = Modifier.width(10.dp))

        Image(
            imageVector = Icons.Filled.ArrowBack,
            colorFilter = ColorFilter.tint(Color.White),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable {
                    pressOnBack()
                }
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = title ?: "",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
