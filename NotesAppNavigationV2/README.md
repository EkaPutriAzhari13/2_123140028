# 📝 Notes App Pro - Praktikum Minggu 7

Notes App Pro adalah aplikasi pencatatan berbasis Android yang dikembangkan sebagai bagian dari tugas praktikum minggu ke-7. Aplikasi ini dirancang dengan pendekatan *offline-first*, sehingga data tetap dapat diakses tanpa koneksi internet, serta dilengkapi fitur pencarian, pengaturan preferensi, dan tampilan modern.

## 📌 Gambaran Umum
Aplikasi ini memungkinkan pengguna untuk mengelola catatan dengan mudah, mulai dari menambahkan, mengedit, hingga menghapus data. Selain itu, tersedia juga fitur pencarian cepat, pengelompokan favorit, serta pengaturan tampilan sesuai preferensi pengguna.

## 🚀 Fitur Utama

### 💾 Penyimpanan Data (SQLDelight)
- Data disimpan secara lokal menggunakan SQLite melalui SQLDelight.
- Mendukung operasi CRUD (Create, Read, Update, Delete).
- Query lebih aman karena menggunakan pendekatan type-safe.

### 🔍 Pencarian & Pengurutan
- Pencarian catatan dapat dilakukan secara real-time.
- Menggunakan sistem *debounce* untuk menjaga performa tetap optimal.
- Tersedia opsi pengurutan (terbaru / terlama) sesuai kebutuhan pengguna.

### ⚙️ Pengaturan Pengguna (DataStore)
- Mendukung perubahan tema (Light / Dark Mode).
- Preferensi disimpan menggunakan Jetpack DataStore.
- Pengaturan tetap tersimpan meskipun aplikasi ditutup.

### ✨ Tampilan & Interaksi
- Menangani berbagai state seperti loading, empty, dan content.
- Input reminder menggunakan date picker dan time picker.
- UI modern berbasis Material 3 yang responsif.

### 🌐 Integrasi API (Opsional)
- Menggunakan Ktor Client sebagai dasar koneksi ke API eksternal.
- Dapat dikembangkan untuk sinkronisasi data online.

## 🗄️ Struktur Database

```sql
CREATE TABLE noteEntity (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    description TEXT NOT NULL,
    content TEXT NOT NULL,
    reminder TEXT NOT NULL,
    isFavorite INTEGER NOT NULL DEFAULT 0,
    createdAt INTEGER NOT NULL DEFAULT 0
);
## 📸 Tampilan Aplikasi

### 🎥 Demo Video
*(Silakan tambahkan link video demo berdurasi ±45 detik di bagian ini)*

### Preview (Update Minggu 7)
| Halaman Utama & Pencarian | Pengaturan (Dark Mode) |
| :---: | :---: |
| ![Notes](screenshot/Notes_Search.jpg) | ![Settings](screenshot/Settings_Dark.jpeg) |

| Daftar Favorit | Tambah Catatan (Date & Time Picker) |
| :---: | :---: |
| ![Favorites](screenshot/Favorites_New.jpg) | ![Add](screenshot/Add_Picker.jpg) |

## 🧭 Navigasi Halaman
- **Home** → Menampilkan seluruh catatan lengkap dengan fitur pencarian dan favorit.
- **Settings** → Digunakan untuk mengatur tema serta urutan tampilan data.
- **Favorites** → Berisi kumpulan catatan yang telah ditandai sebagai favorit.
- **Profile** → Menampilkan informasi pengguna.
- **Add/Edit Note** → Form untuk menambahkan atau mengedit catatan, termasuk pengaturan tanggal dan waktu.

## 🛠️ Teknologi
- SQLDelight sebagai database lokal
- Jetpack DataStore untuk menyimpan preferensi pengguna
- Ktor Client untuk kebutuhan komunikasi API (opsional)
- Jetpack Compose untuk membangun tampilan UI
- Navigation Compose untuk pengelolaan navigasi
- Material 3 sebagai standar desain antarmuka

---

## 👤 Identitas Pengembang
Eka Putri Azhari Ritonga (123140028)
