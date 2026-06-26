# UAS_2443001_MuhammadAzefa_MobileProgramming
# Buku Tamu Digital

## Deskripsi Aplikasi

Buku Tamu Digital adalah aplikasi berbasis Android yang dibuat menggunakan Kotlin Jetpack Compose untuk mencatat data tamu, keperluan kunjungan, serta laporan kunjungan secara digital.

Aplikasi ini dikembangkan sebagai tugas besar/UAS mata kuliah Mobile Programming.

## Teknologi yang Digunakan

* Kotlin
* Jetpack Compose
* Room Database
* MVVM Architecture
* Android Studio

## Fitur Aplikasi

### 1. Data Tamu

* Menambahkan data tamu
* Mengubah data tamu
* Menghapus data tamu
* Menampilkan daftar tamu

### 2. Data Keperluan

* Menambahkan data keperluan kunjungan
* Menghapus data keperluan
* Menampilkan daftar keperluan

### 3. Data Kunjungan

* Memilih tamu
* Memilih keperluan
* Menambahkan tanggal dan jam kunjungan
* Menyimpan data kunjungan

### 4. Laporan Kunjungan

* Menampilkan seluruh riwayat kunjungan
* Menampilkan nama tamu, keperluan, tanggal, dan jam kunjungan

## Struktur Database

### Tabel Guest

| Field    | Tipe              |
| -------- | ----------------- |
| id       | Int (Primary Key) |
| nama     | String            |
| instansi | String            |
| email    | String            |
| noHp     | String            |

### Tabel Purpose

| Field          | Tipe              |
| -------------- | ----------------- |
| id             | Int (Primary Key) |
| nama_keperluan | String            |

### Tabel Visit

| Field     | Tipe              |
| --------- | ----------------- |
| id        | Int (Primary Key) |
| guestId   | Int (Foreign Key) |
| purposeId | Int (Foreign Key) |
| tanggal   | String            |
| jam       | String            |

## Relasi Database

* Satu tamu dapat memiliki banyak kunjungan (One to Many).
* Satu keperluan dapat digunakan pada banyak kunjungan (One to Many).

## Screenshot Aplikasi

### Halaman Data Tamu

![Guest Screen](screenshots/WhatsApp%20Image%202026-06-27%20at%201.11.55%20AM.jpeg)

### Halaman Data Keperluan

![Purpose Screen](screenshots/WhatsApp%20Image%202026-06-27%20at%201.11.55%20AM%20(1).jpeg)

### Halaman Form Kunjungan

![Visit Screen](screenshots/WhatsApp%20Image%202026-06-27%20at%201.11.55%20AM%20(2).jpeg)

### Halaman Laporan Kunjungan

![Report Screen](screenshots/WhatsApp%20Image%202026-06-27%20at%201.11.55%20AM%20(3).jpeg)

## Author

Nama : Muhammad Azefa
NIM : 2443001
Program Studi : D3 Teknik Informatika
