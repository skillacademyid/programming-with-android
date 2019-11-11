package id.kotlin.belajar.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.belajar.R
import id.kotlin.belajar.model.User
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

  private val user = User(
      name = "Budi Oktaviyan",
      age = 32
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)
    btn_open.setOnClickListener { toDetail() }
  }

  private fun toDetail() {
    startActivity(
        Intent(
            this,
            DetailActivity::class.java
        ).apply {
          putExtra(
              User::class.java.simpleName,
              user
          )
        }
    )
  }
}