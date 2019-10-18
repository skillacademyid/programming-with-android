package id.kotlin.belajar.presentation

import id.kotlin.belajar.data.HomeDatasource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class HomePresenter(
    private val view: HomeView,
    private val datasource: HomeDatasource
) {

  private val disposables: CompositeDisposable = CompositeDisposable()

  fun discoverMovie() {
    view.onShowLoading()

    datasource.discoverMovie()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ response ->
          view.onHideLoading()
          view.onResponse(response.results)
        }, { error ->
          view.onHideLoading()
          view.onFailure(error)
        }).addTo(disposables)
  }

  fun onDetach() {
    disposables.clear()
  }
}