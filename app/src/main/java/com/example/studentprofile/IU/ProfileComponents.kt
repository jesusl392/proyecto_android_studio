package com.example.studentprofile.IU

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title.uppercase(),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        letterSpacing = 2.sp,
        modifier = Modifier.padding(top = 20.dp, bottom = 8.dp)
    )
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ItemCard(text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 3.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "—",
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = text,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Composable
fun ItemList(items: List<String>) {
    items.forEach { item ->
        ItemCard(text = item)
    }
}