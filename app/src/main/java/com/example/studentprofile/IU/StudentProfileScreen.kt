package com.example.studentprofile.IU

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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

    // Estados individuales para cada sección abatible
    var showHobbies by remember { mutableStateOf(true) }
    var showPastimes by remember { mutableStateOf(true) }
    var showSports by remember { mutableStateOf(true) }
    var showInterests by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        // — Header —
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(vertical = 36.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Foto de perfil",
                        modifier = Modifier.size(60.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = profile.name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = profile.program,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = profile.semester,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // — Contenido —
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {

            // Sobre mí
            SectionTitle(title = "Sobre mí")
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(
                    text = profile.description,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(16.dp),
                    lineHeight = 20.sp
                )
            }

            // Botón interactivo info adicional
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedButton(
                onClick = { viewModel.toggleExtraInfo() },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = if (showExtraInfo) "▲  Ocultar información" else "▼  Ver información adicional",
                    fontSize = 13.sp
                )
            }

            // Info adicional
            if (showExtraInfo) {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        InfoRow(label = "Edad", value = "${profile.age} años")
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 6.dp),
                            color = MaterialTheme.colorScheme.outline
                        )
                        InfoRow(label = "Ciudad", value = profile.city)
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 6.dp),
                            color = MaterialTheme.colorScheme.outline
                        )
                        InfoRow(label = "Correo", value = profile.email)
                    }
                }
            }

            // — Secciones abatibles —
            CollapsibleSection(
                title = "Hobbies",
                expanded = showHobbies,
                onToggle = { showHobbies = !showHobbies },
                items = profile.hobbies
            )

            CollapsibleSection(
                title = "Pasatiempos",
                expanded = showPastimes,
                onToggle = { showPastimes = !showPastimes },
                items = profile.pastimes
            )

            CollapsibleSection(
                title = "Deportes favoritos",
                expanded = showSports,
                onToggle = { showSports = !showSports },
                items = profile.sports
            )

            CollapsibleSection(
                title = "Intereses personales",
                expanded = showInterests,
                onToggle = { showInterests = !showInterests },
                items = profile.interests
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun CollapsibleSection(
    title: String,
    expanded: Boolean,
    onToggle: () -> Unit,
    items: List<String>
) {
    Spacer(modifier = Modifier.height(12.dp))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column {
            // Encabezado clickeable
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title.uppercase(),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    letterSpacing = 2.sp
                )
                IconButton(
                    onClick = onToggle,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp
                        else Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (expanded) "Colapsar" else "Expandir",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Contenido animado
            AnimatedVisibility(visible = expanded) {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 14.dp)) {
                    items.forEach { item ->
                        ItemCard(text = item)
                    }
                }
            }
        }
    }
}