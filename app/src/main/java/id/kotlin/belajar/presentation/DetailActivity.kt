package id.kotlin.belajar.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.belajar.R
import id.kotlin.belajar.model.User
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)
    setSupportActionBar(toolbar_detail)
    supportActionBar?.apply { setDisplayHomeAsUpEnabled(true) }
  }

  override fun onResume() {
    super.onResume()
    initialModel()
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return super.onSupportNavigateUp()
  }

  private fun initialModel() {
    val model = intent.getParcelableExtra<User>(User::class.java.simpleName)

    val name = "My name is ${model?.name}"
    tv_name.text = name

    val age = "I am ${model?.age} years old"
    tv_age.text = age
  }
}