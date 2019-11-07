package id.kotlin.belajar.domain.executor

import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

interface ThreadExecutor : Executor

class JobExecutor : ThreadExecutor {

  private val threadPoolExecutor = ThreadPoolExecutor(
      3,
      5,
      10,
      TimeUnit.SECONDS,
      LinkedBlockingQueue(),
      JobThreadFactory()
  )

  override fun execute(command: Runnable?) {
    command?.let { threadPoolExecutor.execute(it) }
  }
}

class JobThreadFactory(private var counter: Int = 0) : ThreadFactory {

  override fun newThread(runnable: Runnable?) =
      Thread(runnable, "android_${counter.inc()}")
}