package id.kotlin.belajar.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerAppCompatActivity
import id.kotlin.belajar.R
import id.kotlin.belajar.data.Result
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), HomeView {

  @Inject
  lateinit var presenter: HomePresenter

  private lateinit var progressBar: ProgressBar
  private lateinit var recyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    progressBar = findViewById(R.id.pb_home)
    recyclerView = findViewById(R.id.rv_home)

    presenter.discoverMovie()
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDetach()
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