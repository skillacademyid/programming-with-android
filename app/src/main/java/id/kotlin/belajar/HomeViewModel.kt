package id.kotlin.belajar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

  val hello: LiveData<String> = MutableLiveData<String>()
      .also { it.value = "Halo" }
}