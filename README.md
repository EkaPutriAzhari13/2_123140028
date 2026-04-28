# 📱 Repository Tugas Pengembangan Aplikasi Mobile

Repository ini berisi kumpulan hasil pengerjaan tugas selama mengikuti mata kuliah **Pengembangan Aplikasi Mobile**. Setiap proyek merupakan bagian dari proses pembelajaran dalam membangun aplikasi Android menggunakan **Kotlin** dan **Jetpack Compose**, mulai dari konsep dasar hingga implementasi fitur yang lebih kompleks.

---

## 📂 Daftar Proyek

### 1. [NewsFeedSimulator](./NewsFeedSimulator) (Tugas 2)
**Fokus: Asynchronous Programming & Data Stream**  
Proyek ini mensimulasikan aliran berita yang diperbarui secara berkala.
- Menggunakan **Kotlin Flow** dan **Coroutines**
- Filter kategori berita
- Penghitung jumlah berita yang telah dibaca

---

### 2. [MyProfileApp](./MyProfileApp) (Tugas 3)
**Fokus: Dasar UI dengan Jetpack Compose**  
Latihan awal dalam membangun antarmuka pengguna.
- Menampilkan profil sederhana
- Data statis seperti nama, foto, dan kontak

---

### 3. [MyProfileAppV2](./MyProfileAppV2) (Tugas 4)
**Fokus: Modern UI & Arsitektur MVVM**  
Pengembangan dari aplikasi profil dengan tampilan lebih modern.
- Desain **Glassmorphism** dan **Aurora Gradient**
- Fitur:
  - Dark Mode
  - Profile Strength Indicator
  - Edit profil secara dinamis melalui ViewModel

---

### 4. [NotesAppNavigation](./NotesAppNavigation) (Tugas 5)
**Fokus: Navigation & CRUD**  
Aplikasi catatan dengan navigasi multi-halaman.
- Menggunakan **Jetpack Compose Navigation**
- CRUD (Create, Read, Update)
- Bottom Navigation dengan state tersimpan
- UI berbasis Material 3

---

### 5. [NewsReaderApp](./NewsReaderApp) (Tugas Praktikum Minggu 6)
**Fokus: Networking & Local Database**  
Aplikasi pembaca berita dengan dukungan offline.
- Integrasi API menggunakan **Ktor Client**
- Penyimpanan lokal dengan **Room Database**
- Fitur:
  - Offline caching
  - Shimmer loading
  - Chrome Custom Tabs
  - Dark Mode

---

### 6. [NotesAppNavigationV2](./NotesAppNavigationV2) (Tugas Praktikum Minggu 7)
**Fokus: Local Persistence & Preferences**  
Pengembangan lanjutan aplikasi Notes dengan penyimpanan data yang lebih kuat.
- Menggunakan **SQLDelight** (database)
- **DataStore** untuk preferensi pengguna
- Fitur:
  - Offline-first system
  - Pencarian dan sorting real-time
  - Pengaturan tema
  - Date & Time Picker

---

### 7. [NotesAppNavigationV3](./NotesAppNavigationV3) (Tugas Praktikum Minggu 8)
**Fokus: Dependency Injection & Platform Integration**  
Versi terbaru dari aplikasi Notes dengan penerapan Dependency Injection serta integrasi fitur berbasis platform.

- Menggunakan **Koin** untuk mengelola dependency (ViewModel, Repository, Service)
- Implementasi **expect/actual** untuk mendukung multiplatform
- Fitur utama:
  - **Device Info** → Menampilkan informasi perangkat
  - **Network Status** → Indikator koneksi internet secara real-time
  - **Battery Info (Bonus)** → Informasi kondisi baterai
- Struktur aplikasi dibuat lebih modular dan scalable
- Semua dependency terpusat dalam satu modul Koin

---

## ⚙️ Cara Menjalankan Project

Langkah menjalankan salah satu proyek:
1. Clone repository ini
2. Buka folder proyek yang diinginkan di Android Studio
3. Tunggu proses Gradle Sync hingga selesai
4. Jalankan aplikasi pada emulator atau perangkat fisik (disarankan API 30+)

---

## 👤 Identitas Mahasiswa

- **Nama**: Eka Putri Azhari Ritonga  
- **NIM**: 123140028  
- **Program Studi**: Teknik Informatika - ITERA  

---

✨ *Repository ini akan terus diperbarui seiring perkembangan pembelajaran.*
