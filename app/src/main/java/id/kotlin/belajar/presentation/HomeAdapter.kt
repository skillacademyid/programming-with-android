package id.kotlin.belajar.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import id.kotlin.belajar.R
import id.kotlin.belajar.data.Result
import id.kotlin.belajar.presentation.HomeAdapter.HomeViewHolder
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(private val results: List<Result>) : Adapter<HomeViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
    return HomeViewHolder(
        LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_home,
                parent,
                false
            )
    )
  }

  override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
    holder.bind(results[holder.adapterPosition])
  }

  override fun getItemCount(): Int {
    return results.count()
  }

  inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

    fun bind(result: Result) {
      with(itemView) {
        tv_title.text = result.title
        tv_overview.text = result.overview
      }
    }
  }
}