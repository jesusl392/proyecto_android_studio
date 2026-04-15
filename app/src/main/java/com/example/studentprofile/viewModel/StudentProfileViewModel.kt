package com.example.studentprofile.viewModel

import androidx.lifecycle.ViewModel
import com.example.studentprofile.model.StudentProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StudentProfileViewModel : ViewModel() {

    private val _showExtraInfo = MutableStateFlow(false)
    val showExtraInfo: StateFlow<Boolean> = _showExtraInfo

    private val _profile = MutableStateFlow(
        StudentProfile(
            name = "Jesús Santiago Lozano Peña",
            program = "Ingeniería de Sistemas",
            semester = "5° Semestre",
            description = "Estudiante apasionado por el desarrollo de software y la tecnología. " +
                    "Me gusta aprender nuevas herramientas y trabajar en proyectos creativos.",
            age = 19,
            city = "Bogotá, Colombia",
            email = "jesusslozano@ucundinamarca.edu.co",
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


    fun toggleExtraInfo() {
        _showExtraInfo.value = !_showExtraInfo.value
    }
}