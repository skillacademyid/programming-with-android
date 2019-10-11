package id.kotlin.belajar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    val itemAdapter = findViewById<RecyclerView>(R.id.rv_detail)
    itemAdapter.adapter = DetailAdapter()
  }
}