package id.kotlin.belajar.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import id.kotlin.belajar.data.Result

class HomeAdapterViewModel(result: Result) : BaseObservable() {

  val title: String = result.title
    @Bindable get

  val overview: String = result.overview
    @Bindable get
}