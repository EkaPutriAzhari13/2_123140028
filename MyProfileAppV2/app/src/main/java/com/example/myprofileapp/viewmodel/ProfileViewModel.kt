package com.example.myprofileapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myprofileapp.data.ProfileUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    // TAMBAHKAN FUNGSI INI AGAR ERROR DI MAINACTIVITY HILANG
    fun toggleDarkMode(enabled: Boolean) {
        _uiState.update { it.copy(isDarkMode = enabled) }
    }

    fun toggleEditMode() {
        _uiState.update { currentState ->
            if (!currentState.isEditMode) {
                currentState.copy(
                    isEditMode = true,
                    editName = currentState.name,
                    editBio = currentState.bio,
                    editEmail = currentState.email,
                    editPhone = currentState.phone,
                    editLocation = currentState.location
                )
            } else {
                currentState.copy(isEditMode = false)
            }
        }
    }

    fun updateEditName(v: String) { _uiState.update { it.copy(editName = v) } }
    fun updateEditBio(v: String) { _uiState.update { it.copy(editBio = v) } }
    fun updateEditEmail(v: String) { _uiState.update { it.copy(editEmail = v) } }
    fun updateEditPhone(v: String) { _uiState.update { it.copy(editPhone = v) } }
    fun updateEditLocation(v: String) { _uiState.update { it.copy(editLocation = v) } }

    fun saveProfile() {
        _uiState.update { it.copy(
            name = it.editName,
            bio = it.editBio,
            email = it.editEmail,
            phone = it.editPhone,
            location = it.editLocation,
            isEditMode = false
        ) }
    }
}