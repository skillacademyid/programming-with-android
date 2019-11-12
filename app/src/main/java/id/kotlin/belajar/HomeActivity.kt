package id.kotlin.belajar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    val workManager = WorkManager.getInstance(this)
    val request = OneTimeWorkRequest.Builder(HomeCountdown::class.java).build()
    btn_count.setOnClickListener { workManager.enqueue(request) }

    workManager.getWorkInfoByIdLiveData(request.id).observe(this, Observer { workInfo ->
      val state = workInfo.runAttemptCount.toString()
      tv_number.text = state
    })
  }

  companion object {

    const val STATUS = "status"
  }
}