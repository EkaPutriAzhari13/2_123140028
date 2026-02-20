# Simulator Aliran Berita - Kotlin Multiplatform

**Nama:** Eka Putri Azhari Ritonga (123140028)
**Mata Kuliah:** Pengembangan Aplikasi Mobile (Pertemuan ke-2)

## Gambaran Umum
Proyek ini adalah sebuah aplikasi konsol "News Feed Simulator" yang memanfaatkan kekuatan **Kotlin Coroutines** dan **Kotlin Flow**. Aplikasi ini dirancang untuk menunjukkan bagaimana data dapat diproses secara asinkron dan reaktif dalam ekosistem KMP.

## Detail Teknis Implementasi
1. **Pembuatan Flow (`flow { ... }`)**: Berfungsi sebagai generator data berita yang memancarkan informasi baru setiap interval 2 detik tanpa mengganggu jalannya program utama.
2. **Manipulasi Aliran Data (Operators)**:
    - **Penyaringan (`filter`)**: Memastikan hanya berita bertema teknologi ("Tech") yang diteruskan ke tahap berikutnya.
    - **Transformasi (`map`)**: Mengubah data berita menjadi format judul headline yang lebih terbaca.
3. **Manajemen State (`StateFlow`)**: Menggunakan `MutableStateFlow` untuk melacak jumlah artikel yang telah diproses secara real-time, memungkinkan pemantauan status aplikasi yang efisien.
4. **Eksekusi Paralel (`async/await`)**: Mensimulasikan pengambilan detail berita dari sumber eksternal secara asinkron, mengoptimalkan waktu tunggu.
5. **Keamanan Konkurensi (`coroutineScope`)**: Mengatur lingkup coroutine di dalam terminal operator untuk menjamin eksekusi yang terstruktur dan aman.

## Instruksi Menjalankan Aplikasi
Aplikasi ini berjalan pada modul JVM. Ikuti langkah berikut untuk mengeksekusi:
1. Buka project menggunakan Android Studio atau IntelliJ IDEA.
2. Cari berkas `NewsFeedTask.kt` di direktori `src/jvmMain/kotlin/com/example/Tugas2_123140028/`.
3. Gunakan ikon 'Run' (panah hijau) yang terletak di baris fungsi `main()`.
4. Pilih opsi **'Run NewsFeedTaskKt'**.
5. Pantau output simulasi langsung melalui jendela Run di bagian bawah.
