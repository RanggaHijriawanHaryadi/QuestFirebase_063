package com.example.firebasepam.ui.viewmodel

import com.example.firebasepam.model.Mahasiswa

// Menyimpan input form ke dalam entity
fun MahasiswaEvent.toMhsModel() : Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    alamat = alamat,
    jenis_kelamin = jenis_kelamin,
    kelas = kelas,
    angkatan = angkatan
)