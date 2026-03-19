package com.example.myprofileapp.data

data class ProfileUiState(
    val name: String = "Eka Putri Azhari Ritonga",
    val bio: String = "Seorang mahasiswa yang tertarik dalam pengembangan aplikasi mobile dan desain UI/UX.",
    val email: String = "eka.123140028@student.itera.ac.id",
    val phone: String = "085187081046",
    val location: String = "Lampung, Indonesia",

    val editName: String = "",
    val editBio: String = "",
    val editEmail: String = "",
    val editPhone: String = "",
    val editLocation: String = "",

    val isDarkMode: Boolean = false, // HARUS ADA INI
    val isEditMode: Boolean = false
) {
    // Tombol Save aktif jika Nama tidak kosong DAN ada perubahan data
    val isSaveEnabled: Boolean
        get() = editName.isNotBlank() && (
                editName != name ||
                        editBio != bio ||
                        editEmail != email ||
                        editPhone != phone ||
                        editLocation != location
                )

    // Menghitung persentase kelengkapan profil (Opsional, untuk progress bar jika butuh)
    val completeness: Float
        get() {
            var filled = 0f
            if (name.isNotBlank()) filled += 1f
            if (bio.isNotBlank()) filled += 1f
            if (email.isNotBlank()) filled += 1f
            if (phone.isNotBlank()) filled += 1f
            if (location.isNotBlank()) filled += 1f
            return filled / 5f
        }
}