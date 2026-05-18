package com.rapi.pocketwise

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.rapi.pocketwise.data.remote.GeminiService
import com.rapi.pocketwise.data.repository.FinanceRepositoryImpl
import com.rapi.pocketwise.presentation.PocketWiseScreen
import com.rapi.pocketwise.presentation.PocketWiseViewModel
import com.rapi.pocketwise.ui.theme.PocketWiseTheme

@Composable
fun App(
    geminiApiKey: String
) {
    PocketWiseTheme {
        val viewModel = remember {
            val geminiService = GeminiService(
                apiKey = geminiApiKey
            )

            val financeRepository = FinanceRepositoryImpl(
                geminiService = geminiService
            )

            PocketWiseViewModel(
                repository = financeRepository
            )
        }

        PocketWiseScreen(
            viewModel = viewModel
        )
    }
}
