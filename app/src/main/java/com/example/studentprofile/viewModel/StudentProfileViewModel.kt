package com.example.studentprofile.viewModel

import androidx.lifecycle.ViewModel
import com.example.studentprofile.model.StudentProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StudentProfileViewModel : ViewModel() {

    // Estado que controla si la info adicional está visible o no
    private val _showExtraInfo = MutableStateFlow(false)
    val showExtraInfo: StateFlow<Boolean> = _showExtraInfo

    // Datos del perfil
    private val _profile = MutableStateFlow(
        StudentProfile(
            name = "Juan David Pérez García",
            program = "Ingeniería de Software",
            semester = "5° Semestre",
            description = "Estudiante apasionado por el desarrollo de software y la tecnología. " +
                    "Me gusta aprender nuevas herramientas y trabajar en proyectos creativos.",
            age = 21,
            city = "Bogotá, Colombia",
            email = "juan.perez@ucundinamarca.edu.co",
            hobbies = listOf(
                "Programar aplicaciones móviles",
                "Escuchar música",
                "Ver series de tecnología"
            ),
            pastimes = listOf(
                "Leer libros de ciencia ficción",
                "Jugar videojuegos",
                "Ver documentales"
            ),
            sports = listOf(
                "Fútbol",
                "Ciclismo",
                "Natación"
            ),
            interests = listOf(
                "Inteligencia Artificial",
                "Desarrollo móvil",
                "Ciberseguridad",
                "Open Source"
            )
        )
    )
    val profile: StateFlow<StudentProfile> = _profile

    // Función interactiva: mostrar u ocultar información adicional
    fun toggleExtraInfo() {
        _showExtraInfo.value = !_showExtraInfo.value
    }
}