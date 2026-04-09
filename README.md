# Repository Tugas Pengembangan Aplikasi Mobile - Eka Putri 📱

Repository ini saya gunakan untuk menyimpan seluruh progres tugas mata kuliah Pengembangan aplikasi Mobile. Di sini saya belajar membangun aplikasi Android menggunakan **Kotlin** dan **Jetpack Compose**, mulai dari logika dasar sampai desain UI yang lebih kompleks.

---

## 📂 Daftar Proyek

### 1. [NewsFeedSimulator](./NewsFeedSimulator) (Tugas 2)
**Fokus: Logic & Asynchronous Programming**
Di tugas ini, saya belajar cara mengelola aliran data (data stream) secara real-time.
- **Isi Proyek**: Simulasi update berita otomatis menggunakan **Kotlin Flow** dan **Coroutines**.
- **Fitur**: Ada filter kategori berita dan fitur penghitung berita yang sudah dibaca.

### 2. [MyProfileApp](./MyProfileApp) (Tugas 3)
**Fokus: Dasar UI Compose**
Proyek awal untuk mengenal komponen dasar di Jetpack Compose.
- **Isi Proyek**: Tampilan profil sederhana dengan informasi statis.
- **Fitur**: Menampilkan foto profil, nama, dan detail kontak dasar.

### 3. [MyProfileAppV2](./MyProfileAppV2) (Tugas 4 )
**Fokus: Modern UI (Glassmorphism) & MVVM**
Ini adalah versi pengembangan dari aplikasi profil sebelumnya dengan tampilan yang jauh lebih niat dan rapi.
- **Isi Proyek**: Implementasi desain **Glassmorphism** dengan latar belakang **Aurora Gradient**.
- **Fitur Utama**: 
  - **Dark Mode**: Switch tema manual yang mengubah seluruh suasana warna aplikasi.
  - **Profile Strength**: Indikator (Progress Bar) yang menghitung seberapa lengkap saya mengisi data profil.
  - **Full Edit Mode**: Semua data profil (Bio, Email, HP, Lokasi) bisa diubah dan disimpan lewat ViewModel.

### 4. [NotesAppNavigation](./NotesAppNavigation) (Tugas 5 )
**Fokus: Navigation, State Management & CRUD**
Pada tugas ini, saya mengembangkan aplikasi catatan dengan navigasi yang lebih kompleks serta pengelolaan data secara dinamis.
- **Isi Proyek**: Aplikasi Notes dengan multi-screen menggunakan **Jetpack Compose Navigation**.
- **Fitur Utama**:
  - **Navigation System**: Menggunakan `Sealed Class` untuk routing yang terstruktur dan *type-safe*
  - **Bottom Navigation**: Navigasi antar halaman (Home, Favorites, Profile) dengan *state preservation*
  - **CRUD Notes**:
    - Create → Menambah catatan (`AddNoteScreen`)
    - Read → Menampilkan daftar & detail catatan (`NoteDetailScreen`)
    - Update → Edit catatan (`EditNoteScreen`)
  - **State Management**: Menggunakan `mutableStateListOf` untuk sinkronisasi data real-time
  - **UI Modern**: Material 3 dengan custom component, gradient, dan desain kartu estetik

---

## ⚙️ Cara Menjalankan Tugas
Kalau ingin mencoba menjalankan kodenya:
1. Clone repo ini ke laptop.
2. Buka salah satu folder tugas di atas (misalnya `MyProfileAppV2`) sebagai proyek utama di Android Studio.
3. Pastikan Gradle sudah selesai sinkronisasi (Sync).
4. Run di Emulator atau HP fisik (API 30+ disarankan).

---

## 👤 Identitas Mahasiswa
- **Nama**: Eka Putri Azhari Ritonga
- **NIM**: 123140028
- **Prodi**: Teknik Informatika - ITERA
