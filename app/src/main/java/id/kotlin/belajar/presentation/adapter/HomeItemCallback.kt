package id.kotlin.belajar.presentation.adapter

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import id.kotlin.belajar.data.HomeResponse.Result

object HomeItemCallback : ItemCallback<Result>() {

  override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
    return oldItem.id == newItem.id
  }

  override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
    return oldItem == newItem
  }
}