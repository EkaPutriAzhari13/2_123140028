# Praktikum Pemrograman Perangkat Bergerak - Minggu 1

## Data Mahasiswa
- **Nama:** Eka Putri Azhari Ritonga
- **NIM:** 123140028

## Penjelasan Singkat
Project ini merupakan aplikasi sederhana "Hello World" yang dibuat menggunakan **Kotlin Multiplatform (KMP)** dengan bantuan **Compose Multiplatform**.

Fitur yang ditampilkan pada aplikasi ini meliputi:
- Pesan sapaan berupa "Halo, [Nama Mahasiswa]!"
- Nomor Induk Mahasiswa (NIM)
- Informasi platform yang sedang digunakan (Android atau Desktop)

## Hasil Tampilan
Berikut adalah hasil running aplikasi pada masing-masing platform:

### Desktop
<img  />

### Android
<img  />

---

## Susunan Direktori
- `/composeApp` → Berisi kode utama yang digunakan bersama di berbagai platform
  - `commonMain` → Menyimpan logika inti serta tampilan UI berbasis Compose yang bisa dipakai di semua platform
  - `jvmMain` → Kode khusus untuk menjalankan aplikasi di Desktop (JVM)
  - `androidMain` → Kode yang digunakan khusus untuk platform Android

## Cara Menjalankan di Desktop
Untuk menjalankan aplikasi versi desktop melalui Windows, jalankan perintah berikut di terminal:

```bash
.\gradlew.bat :composeApp:run
