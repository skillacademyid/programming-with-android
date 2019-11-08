package id.kotlin.belajar.presentation

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import dagger.android.support.DaggerAppCompatActivity
import id.kotlin.belajar.R
import id.kotlin.belajar.data.Result
import id.kotlin.belajar.databinding.ActivityHomeBinding
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), HomeViewModelCallback {

  @Inject
  lateinit var viewModel: HomeViewModel

  private lateinit var binding: ActivityHomeBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
        this,
        R.layout.activity_home)
        .apply { viewModel = this@HomeActivity.viewModel }
        .also { viewModel.discoverMovie() }
  }

  override fun onDestroy() {
    super.onDestroy()
    viewModel.onDetach()
  }

  override fun onSuccess(results: List<Result>) {
    binding.rvHome.addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
    binding.rvHome.adapter = HomeAdapter(results)
  }

  override fun onError(error: Throwable) {
    Log.e(HomeActivity::class.java.simpleName, "${error.printStackTrace()}")
  }
}