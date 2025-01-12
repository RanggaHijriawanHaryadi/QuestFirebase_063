package com.example.firebasepam.ui.viewmodel

import com.example.firebasepam.model.Mahasiswa

// data class Variable yang menyimpan data input form
data class MahasiswaEvent(
    val nim: String="",
    val nama: String="",
    val alamat: String="",
    val jenis_kelamin: String="",
    val kelas: String="",
    val angkatan: String="",
)

// Menyimpan input form ke dalam entity
fun MahasiswaEvent.toMhsModel() : Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenis_kelamin = jenis_kelamin,
    kelas = kelas,
    angkatan = angkatan
)