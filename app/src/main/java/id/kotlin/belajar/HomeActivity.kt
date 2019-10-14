package id.kotlin.belajar

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), HomeView {

  private lateinit var progressBar: ProgressBar
  private lateinit var recyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    progressBar = findViewById(R.id.pb_home)
    recyclerView = findViewById(R.id.rv_home)

    val presenter = HomePresenter(this)
    presenter.discoverMovie()
  }

  override fun onShowLoading() {
    progressBar.visibility = View.VISIBLE
  }

  override fun onHideLoading() {
    progressBar.visibility = View.GONE
    recyclerView.visibility = View.VISIBLE
  }

  override fun onResponse(results: List<Result>) {
    recyclerView.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
    recyclerView.adapter = HomeAdapter(results)
  }

  override fun onFailure(error: Throwable) {
    Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
  }
}