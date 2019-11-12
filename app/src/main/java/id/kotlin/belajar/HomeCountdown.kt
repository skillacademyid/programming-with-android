package id.kotlin.belajar

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class HomeCountdown(
    context: Context,
    params: WorkerParameters
) : Worker(context, params) {

  override fun doWork(): Result {
    val message = inputData.getString(HomeActivity.STATUS)
    Log.d(HomeCountdown::class.java.simpleName, message ?: "Sending message...")

    val output = Data.Builder().putString(RESULT, "Jobs complete!").build()
    return Result.success(output)
  }

  companion object {

    const val RESULT = "result"
  }
}