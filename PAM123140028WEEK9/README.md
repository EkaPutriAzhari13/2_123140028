# Praktikum Pemrograman Perangkat Bergerak - Minggu 9

## Identitas
- **Nama** : Eka Putri Azhari Ritonga
- **NIM**  : 123140028
- **Kelas**: RA

## Gambaran Umum
Project ini merupakan pengembangan aplikasi **PocketWise**, yaitu aplikasi pencatat keuangan pribadi berbasis **Kotlin Multiplatform** yang terhubung dengan **Gemini API**.
Aplikasi ini memungkinkan pengguna mencatat pengeluaran berdasarkan jumlah uang, kategori, serta catatan tambahan. Seluruh data yang dimasukkan akan diproses secara lokal untuk menghasilkan ringkasan seperti total pengeluaran, jumlah transaksi, serta kategori dengan pengeluaran terbesar.
Selain itu, aplikasi juga memanfaatkan AI untuk memberikan insight serta rekomendasi penghematan berdasarkan data pengguna.

## Fitur Aplikasi
Beberapa fitur utama yang tersedia:
- Input data pengeluaran (nominal, kategori, dan catatan)
- Menampilkan daftar riwayat pengeluaran
- Perhitungan total pengeluaran secara otomatis
- Menampilkan jumlah transaksi dan kategori dominan
- Integrasi dengan **Gemini API** untuk analisis keuangan
- Prompt khusus yang difokuskan untuk kebutuhan mahasiswa
- Indikator loading saat proses AI berlangsung
- Penanganan berbagai error (API key, timeout, limit, dll)

## Integrasi AI
Aplikasi PocketWise memanfaatkan **Gemini API** untuk membantu analisis pengeluaran pengguna.

Alur kerjanya:
1. Pengguna menginput data pengeluaran
2. Aplikasi menghitung ringkasan secara lokal
3. Data ringkasan dikirim ke Gemini API
4. AI menghasilkan analisis serta saran penghematan
5. Hasil ditampilkan ke pengguna

Perlu diperhatikan bahwa semua perhitungan numerik tetap dilakukan oleh aplikasi agar hasilnya konsisten dan akurat.

## Perancangan Prompt
Prompt untuk AI disusun dengan struktur berikut:
- **Peran**: AI bertindak sebagai asisten keuangan mahasiswa
- **Tujuan**: Memberikan analisis dan rekomendasi hemat
- **Aturan**:
  - Menggunakan Bahasa Indonesia
  - Tidak menambahkan data di luar input
  - Tidak menyarankan produk finansial tertentu
  - Fokus pada pengeluaran harian
- **Format Output**:
  1. Ringkasan kondisi keuangan
  2. Pengeluaran terbesar
  3. Pola pengeluaran
  4. Potensi risiko
  5. Rekomendasi penghematan
  6. Target keuangan minggu berikutnya

## Penanganan Error & Mode Cadangan
Aplikasi dirancang untuk mengatasi berbagai kondisi error, seperti:
- API key tidak tersedia atau tidak valid
- Input prompt kosong
- Request ke Gemini tidak valid
- Model tidak ditemukan
- Terkena limit atau quota API
- Timeout saat request
- Tidak ada respons dari AI
- Data pengeluaran belum tersedia
- Nominal tidak valid

Jika layanan AI tidak dapat digunakan (misalnya karena limit), aplikasi tetap memberikan analisis sederhana berbasis perhitungan lokal sebagai fallback.

## Cara Menjalankan (Android Studio)
1. Gunakan branch **week9**
2. Clone atau download repository: https://github.com/EkaPutriAzhari13/2_123140028.git
3. Buka folder project di Android Studio
4. Tunggu hingga proses **Gradle Sync** selesai
5. Klik tombol **Run**
6. Pilih emulator atau perangkat Android

## Tampilan Aplikasi

<table>
<tr>
 <td align="center"><b>Input Data</b></td>
 <td align="center"><b>Ringkasan</b></td>
 <td align="center"><b>Loading</b></td>
 <td align="center"><b>Analisis AI</b></td>
 <td align="center"><b>Error State</b></td>
</tr>
<tr>
 td>
</tr>
</table>