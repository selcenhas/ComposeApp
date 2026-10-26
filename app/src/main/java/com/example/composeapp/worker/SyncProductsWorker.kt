package com.example.composeapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.composeapp.data.repository.ProductsRepository
import com.example.composeapp.utils.Constants
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SyncProductsWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val repository: ProductsRepository,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            repository.refreshProducts().fold(
                onSuccess = { Result.success() },
                onFailure = {
                    if (runAttemptCount < Constants.MAX_RUN_ATTEMPTS) Result.retry() else Result.failure()
                }
            )
        } catch (_: Exception) {
            if (runAttemptCount < Constants.MAX_RUN_ATTEMPTS) Result.retry() else Result.failure()
        }
    }
}
