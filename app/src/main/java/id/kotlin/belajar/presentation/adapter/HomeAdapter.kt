package id.kotlin.belajar.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.belajar.R
import id.kotlin.belajar.data.HomeResponse.Result
import id.kotlin.belajar.presentation.HomeViewState
import id.kotlin.belajar.presentation.HomeViewState.Page
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_loading.view.*

class HomeAdapter(
    diffCallback: ItemCallback<Result> = HomeItemCallback
) : PagedListAdapter<Result, ViewHolder>(diffCallback) {

  lateinit var state: HomeViewState

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return when (viewType) {
      HomeAdapterType.RESULT.ordinal -> {
        HomeViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_home,
                    parent,
                    false
                )
        )
      }
      HomeAdapterType.LOADING.ordinal -> {
        LoadingViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_loading,
                    parent,
                    false
                )
        )
      }
      else -> throw RuntimeException("Illegal view type")
    }
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    when (holder) {
      is HomeViewHolder -> {
        getItem(holder.adapterPosition)?.let { holder.bind(it) }
      }
      is LoadingViewHolder -> {
        holder.bind(state)
      }
    }
  }

  override fun getItemViewType(position: Int): Int {
    return when (position) {
      itemCount.minus(1) -> HomeAdapterType.LOADING.ordinal
      else -> HomeAdapterType.RESULT.ordinal
    }
  }

  inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(result: Result) {
      with(itemView) {
        tv_title.text = result.title
        tv_overview.text = result.overview
      }
    }
  }

  inner class LoadingViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(state: HomeViewState) {
      with(itemView) {
        pb_loading.visibility = if (state is Page) View.VISIBLE else View.GONE
      }
    }
  }
}