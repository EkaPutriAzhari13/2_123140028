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
<img width="1919" height="1192" alt="Screenshot Desktop" src="https://github.com/user-attachments/assets/5bc5d42a-e48b-45ea-aa29-a4a22c823896" />

### Android
<img width="1080" height="2400" alt="Screenshot Android" src="https://github.com/user-attachments/assets/40ed487e-5097-4394-bb0d-aadddeae902e" />

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