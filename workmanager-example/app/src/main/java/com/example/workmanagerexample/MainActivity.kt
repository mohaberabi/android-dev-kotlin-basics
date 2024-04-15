package com.example.workmanagerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Filter
import android.widget.Toast
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    companion object {
        const val keyCounter = "keyCounter"

    }

    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            //   initWorker()
            dowPeriodicWork()
        }
    }


    private fun initWorker() {

        val workManager = WorkManager.getInstance(applicationContext)

        val data: Data = Data.Builder()
            .putInt(keyCounter, 200)
            .build()
        val workManagerConstraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()
        val oneTimeWorkRequest = OneTimeWorkRequest
            .Builder(AppWorker::class.java)
            .setConstraints(workManagerConstraints)
            .setInputData(data)
            .build()

        val filterWorker = OneTimeWorkRequest
            .Builder(FilterWorker::class.java)
            .setConstraints(workManagerConstraints)
            .setInputData(data)
            .build()
        val compressWorker = OneTimeWorkRequest
            .Builder(CompresserWorker::class.java)
            .setConstraints(workManagerConstraints)
            .setInputData(data)
            .build()

        val downloadWorker = OneTimeWorkRequest
            .Builder(DownloadWorker::class.java)
            .setConstraints(workManagerConstraints)
            .setInputData(data)
            .build()

        val parallelWorkers = listOf<OneTimeWorkRequest>(
            filterWorker,
            compressWorker,
            downloadWorker,
            oneTimeWorkRequest
        )
        workManager.beginWith(filterWorker)
            .then(compressWorker)
            .then(oneTimeWorkRequest)
            .enqueue()

        // they are all mixed as they are executing in parallel manner
// workManager.beginWith(parallelWorkers)
//            .then(compressWorker)
//            .then(oneTimeWorkRequest)
//            .enqueue()
        workManager
            .getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this) {
                button.text = it.state.name

                if (it.state.isFinished) {
                    val data = it.outputData
                    val message = data.getString(AppWorker.keyOutput) ?: ""
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            }
    }


    private fun dowPeriodicWork() {
        val perioicWork =
            PeriodicWorkRequest
                .Builder(DownloadWorker::class.java, 16, TimeUnit.MINUTES)
                .build()
        val workManager = WorkManager.getInstance(applicationContext).enqueue(perioicWork)
    }
}