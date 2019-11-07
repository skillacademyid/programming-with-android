package id.kotlin.belajar.domain

import id.kotlin.belajar.domain.common.Usecase
import id.kotlin.belajar.domain.executor.JobExecutor
import id.kotlin.belajar.domain.executor.UIThread
import io.reactivex.Single

class HomeUsecase(
    private val repository: HomeRepository,
    executor: JobExecutor,
    thread: UIThread
) : Usecase<HomeEntity, HomeParam>(executor, thread) {

  override fun buildUsecaseObservable(params: HomeParam): Single<HomeEntity> =
      repository.discoverMovie(params)
}