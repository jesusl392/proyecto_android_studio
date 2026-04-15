package com.example.studentprofile.model

data class StudentProfile(
    val name: String,
    val program: String,
    val semester: String,
    val description: String,
    val age: Int,
    val city: String,
    val email: String,
    val hobbies: List<String>,
    val pastimes: List<String>,
    val sports: List<String>,
    val interests: List<String>
)