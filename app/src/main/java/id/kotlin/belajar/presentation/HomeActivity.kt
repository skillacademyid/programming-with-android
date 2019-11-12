package id.kotlin.belajar.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.support.DaggerAppCompatActivity
import id.kotlin.belajar.R
import id.kotlin.belajar.presentation.HomeViewState.Failed
import id.kotlin.belajar.presentation.HomeViewState.Loading
import id.kotlin.belajar.presentation.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  private val viewModel: HomeView by lazy {
    ViewModelProviders
        .of(this, viewModelFactory)
        .get(HomeViewModel::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    val adapter = HomeAdapter()
    rv_home.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
    rv_home.adapter = adapter

    viewModel.states.observe(this, Observer { state ->
      adapter.state = state
      if (state is Failed) Log.e(HomeActivity::class.java.simpleName, "${state.error}")
      pb_home.visibility = if (state is Loading) View.VISIBLE else View.GONE
    })

    viewModel.paged.observe(this, Observer { page -> adapter.submitList(page) })
  }
}