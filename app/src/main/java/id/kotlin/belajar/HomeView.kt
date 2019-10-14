package id.kotlin.belajar

interface HomeView {

  fun onShowLoading()
  fun onHideLoading()
  fun onResponse(results: List<Result>)
  fun onFailure(error: Throwable)
}