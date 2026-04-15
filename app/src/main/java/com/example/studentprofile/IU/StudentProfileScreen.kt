package com.example.studentprofile.IU

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentprofile.viewModel.StudentProfileViewModel

@Composable
fun StudentProfileScreen(
    viewModel: StudentProfileViewModel = viewModel()
) {
    val profile by viewModel.profile.collectAsStateWithLifecycle()
    val showExtraInfo by viewModel.showExtraInfo.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // — Header con foto y nombre —
        Spacer(modifier = Modifier.height(16.dp))

        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = profile.name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "${profile.program} · ${profile.semester}",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()

        // — Descripción personal —
        Spacer(modifier = Modifier.height(12.dp))
        SectionTitle(title = "Sobre mí")
        Text(
            text = profile.description,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        // — Botón interactivo —
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.toggleExtraInfo() }) {
            Text(text = if (showExtraInfo) "Ocultar información adicional" else "Ver información adicional")
        }

        // — Info adicional (visible u oculta) —
        if (showExtraInfo) {
            Spacer(modifier = Modifier.height(12.dp))
            SectionTitle(title = "Información adicional")
            InfoRow(label = "Edad", value = "${profile.age} años")
            InfoRow(label = "Ciudad", value = profile.city)
            InfoRow(label = "Correo", value = profile.email)
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

        // — Hobbies —
        SectionTitle(title = "Hobbies")
        ItemList(items = profile.hobbies)

        Spacer(modifier = Modifier.height(8.dp))

        // — Pasatiempos —
        SectionTitle(title = "Pasatiempos")
        ItemList(items = profile.pastimes)

        Spacer(modifier = Modifier.height(8.dp))

        // — Deportes —
        SectionTitle(title = "Deportes favoritos")
        ItemList(items = profile.sports)

        Spacer(modifier = Modifier.height(8.dp))

        // — Intereses —
        SectionTitle(title = "Intereses personales")
        ItemList(items = profile.interests)

        Spacer(modifier = Modifier.height(24.dp))
    }
}