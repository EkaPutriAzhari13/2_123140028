package com.example.newsreaderapp.data.repository

import com.example.newsreaderapp.data.local.ArticleDao
import com.example.newsreaderapp.data.local.ArticleEntity
import com.example.newsreaderapp.domain.Article
import com.example.newsreaderapp.domain.repository.NewsRepository
import com.example.newsreaderapp.domain.repository.Resource
import io.ktor.client.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(
    private val client: HttpClient,
    private val dao: ArticleDao
) : NewsRepository {

    // Kumpulan Berita Indonesia Baru (Biar beda dari sebelumnya)
    private val beritaPool = listOf(
        ArticleEntity(101, "Festival Bunga Nusantara 2024: Ribuan Wisatawan Padati Lokasi", "Keindahan warna-warni bunga dari seluruh penjuru Indonesia memukau pengunjung di taman bunga nasional.", "https://images.unsplash.com/photo-1490750967868-88aa4486c946?q=80&w=600&auto=format&fit=crop", "https://www.indonesia.travel"),
        ArticleEntity(102, "Inovasi Mobil Listrik Buatan Mahasiswa Indonesia Go International", "Tim robotik universitas ternama berhasil menciptakan prototype mobil listrik hemat energi yang siap diuji di sirkuit luar negeri.", "https://images.unsplash.com/photo-1593941707882-a5bba14938c7?q=80&w=600&auto=format&fit=crop", "https://www.ristekdikti.go.id"),
        ArticleEntity(103, "Resep Dessert Pink Viral: Cara Mudah Membuat Strawberry Souffle", "Tips dan trik membuat hidangan penutup yang lembut dan manis untuk keluarga di rumah.", "https://images.unsplash.com/photo-1565958011703-44f9829ba187?q=80&w=600&auto=format&fit=crop", "https://www.cookpad.com"),
        ArticleEntity(104, "Tren Fashion Pastel 2024: Warna Pink Soft Jadi Primadona", "Para desainer ternama memprediksi warna-warna lembut akan mendominasi panggung gaya busana tahun ini.", "https://images.unsplash.com/photo-1525507119028-ed4c629a60a3?q=80&w=600&auto=format&fit=crop", "https://www.vogue.com"),
        ArticleEntity(105, "Tips Merawat Tanaman Hias di Dalam Ruangan Agar Tetap Segar", "Panduan praktis bagi pemula yang ingin memulai hobi berkebun di lahan terbatas atau apartemen.", "https://images.unsplash.com/photo-1485955900006-10f4d324d411?q=80&w=600&auto=format&fit=crop", "https://www.dekoruma.com"),
        ArticleEntity(106, "Eksplorasi Keindahan Pantai Tersembunyi di Timur Indonesia", "Surga tersembunyi dengan pasir putih dan air laut jernih yang belum banyak terjamah oleh wisatawan.", "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?q=80&w=600&auto=format&fit=crop", "https://www.pesona.indonesia"),
        ArticleEntity(107, "Manfaat Meditasi Pagi untuk Kesehatan Mental dan Fokus Kerja", "Hanya dengan 10 menit setiap pagi, Anda bisa meningkatkan produktivitas dan menjaga ketenangan pikiran.", "https://images.unsplash.com/photo-1506126613408-eca07ce68773?q=80&w=600&auto=format&fit=crop", "https://www.halodoc.com"),
        ArticleEntity(108, "Review Gadget Terbaru: Smartphone dengan Kamera Super Jernih", "Mengulas fitur-fitur unggulan ponsel flagship terbaru yang baru saja diluncurkan di pasar Indonesia.", "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?q=80&w=600&auto=format&fit=crop", "https://www.gadgetin.com")
    )

    override fun getArticles(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())

        val localArticles = dao.getAllArticles().map { it.toArticle() }
        emit(Resource.Loading(data = localArticles))

        try {
            delay(1000)
            
            // Mengambil 6 berita secara acak dari pool yang baru
            val randomArticles = beritaPool.shuffled().take(6)

            dao.clearArticles()
            dao.insertArticles(randomArticles)

            val updatedArticles = dao.getAllArticles().map { it.toArticle() }
            emit(Resource.Success(updatedArticles))

        } catch (e: Exception) {
            emit(Resource.Error(
                message = "Gagal memuat berita terbaru. Periksa koneksi internet Anda.",
                data = localArticles
            ))
        }
    }

    override suspend fun getArticleById(id: Int): Article? {
        return dao.getArticleById(id)?.toArticle()
    }

    private fun ArticleEntity.toArticle() = Article(
        id = id,
        title = title,
        description = content,
        imageUrl = imageUrl,
        url = url
    )
}
