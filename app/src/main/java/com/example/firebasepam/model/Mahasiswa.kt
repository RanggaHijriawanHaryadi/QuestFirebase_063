package com.example.firebasepam.model


data class Mahasiswa (
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenis_kelamin: String,
    val kelas: String,
    val angkatan: String,
    val judul_skripsi: String,
    val dsn_pembimbing1: String,
    val dsn_pembimbing2: String
){
    constructor(): this("","","","","","", "","","")
}
