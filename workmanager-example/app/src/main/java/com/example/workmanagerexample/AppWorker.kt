package com.example.workmanagerexample

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date

class AppWorker(
    private val context: Context,

    private val params: WorkerParameters
) : Worker(
    context, params,
) {

    companion object {
        const val keyOutput = "keyOutput"
    }

    override fun doWork(): Result {

        return try {
            val count = inputData
                .getInt(
                    MainActivity.keyCounter,
                    0
                )
            for (i in 0..count) {
                Log.i("worker", i.toString() + " WORKERRRR")
            }
            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())
            val outPutData = Data.Builder()
                .putString(keyOutput, currentDate)
                .build()
            Result.success(outPutData)
        } catch (e: Exception) {
            Result.failure()
        }

    }
}