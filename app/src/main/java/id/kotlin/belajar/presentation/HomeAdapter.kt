package id.kotlin.belajar.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.belajar.R
import id.kotlin.belajar.data.Result
import id.kotlin.belajar.databinding.ItemHomeBinding
import id.kotlin.belajar.presentation.HomeAdapter.HomeViewHolder

class HomeAdapter(private val results: List<Result>) : Adapter<HomeViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
    return HomeViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_home,
            parent,
            false
        )
    )
  }

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    holder.binding.apply {
      viewModel = HomeAdapterViewModel(results[holder.adapterPosition])
      executePendingBindings()
    }
  }

  override fun getItemCount(): Int {
    return results.count()
  }

  inner class HomeViewHolder(val binding: ItemHomeBinding) : ViewHolder(binding.root)
}