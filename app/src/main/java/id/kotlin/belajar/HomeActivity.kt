package id.kotlin.belajar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    val viewModel = ViewModelProviders.of(this)[HomeViewModel::class.java]
    viewModel.hello.observe(this, Observer { tv_home.text = it })
  }
}