# 🚀 PRAKTIKUM MINGGU 8 - Enhancement Notes App

Aplikasi Notes ini telah dikembangkan dengan menambahkan fitur berbasis platform serta menerapkan konsep **Dependency Injection (DI)** menggunakan **Koin** untuk pengelolaan dependensi yang lebih rapi.

---

## 🏛️ Desain Arsitektur

Struktur aplikasi disusun secara modular untuk memisahkan tanggung jawab antar komponen seperti UI, data, dan layanan platform.

```mermaid
graph LR
    subgraph Presentation Layer
        MainUI --> ListUI
        MainUI --> SettingUI
        ListUI --> StatusNetworkUI
        SettingUI --> InfoDeviceUI
    end

    subgraph DI Container
        KoinModule[Koin Module]
    end

    subgraph Core Layer
        VM[NoteViewModel] --> Repo[NoteRepository]
        Repo --> DB[(SQLDelight)]
        Repo --> Pref[(DataStore)]
    end

    subgraph Platform Layer
        DevInfo[Device Info Service]
        NetCheck[Network Service]
        Batt[Battery Service]
        AndroidSide[Android Impl]
    end

    KoinModule --> VM
    KoinModule --> DevInfo
    KoinModule --> NetCheck

    VM --> NetCheck
    SettingUI --> DevInfo
    SettingUI --> Batt
```

---

## 📚 Penjelasan Fitur

1. **Implementasi Dependency Injection**  
   Koin digunakan untuk mengatur dan menyediakan dependency antar komponen seperti ViewModel dan Repository.

2. **Informasi Perangkat (Device Info)**  
   Menggunakan pendekatan *expect/actual* untuk mengambil data perangkat secara multiplatform.

3. **Pemantauan Jaringan (Network Monitor)**  
   Status koneksi diamati secara real-time menggunakan Flow.

4. **Tampilan Informasi Device**  
   Detail perangkat ditampilkan pada halaman pengaturan (Settings).

5. **Status Koneksi**  
   Indikator Online/Offline ditampilkan pada halaman utama aplikasi.

6. **Manajemen Dependency Terpusat**  
   Semua dependency dikelola dalam satu modul Koin agar lebih terstruktur.

---

## 📊 Penilaian

| Aspek | Persentase | Keterangan |
| :--- | :---: | :--- |
| Dependency Injection | 25% | Sudah diterapkan dengan Koin |
| Multiplatform Pattern | 25% | expect/actual digunakan |
| Integrasi Antarmuka | 20% | UI berjalan dengan baik |
| Struktur Arsitektur | 20% | Modular dan terorganisir |
| Kualitas Kode | 10% | Bersih dan mudah dipahami |
| Bonus ⭐ | +10% | Fitur Battery Info |

---

## 🖼️ Preview Aplikasi

| Halaman Utama (Online) | Menu Settings |
| :---: | :---: |
| ![](screenshot/Home+Online.jpg) | ![](screenshot/Setting%20+%20Battery%20Info.jpg) |

| Halaman Offline | Profil & Favorit |
| :---: | :---: |
| ![](screenshot/Offline.jpg) | ![](screenshot/Profile.jpg) |

---

## 🎬 Demo Singkat

Link video (±45 detik): [YouTube / Drive Link](URL_VIDEO_DEMO)  
*(Menampilkan fitur DI, info perangkat, status jaringan, dan battery info)*

---

## 👤 Data Mahasiswa

- Nama: Eka Putri Azhari R.  
- NIM: 123140028  
- Branch: `week-8`  

---

*Pengembangan Aplikasi Mobile - ITERA*
