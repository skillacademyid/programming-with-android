package id.kotlin.belajar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

  val name: MutableLiveData<String> by lazy {
    MutableLiveData<String>()
  }
}