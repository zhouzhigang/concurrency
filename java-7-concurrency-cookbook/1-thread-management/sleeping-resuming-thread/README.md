# Sleeping and resuming a thread

* `Thread.sleep(integer)` Thread leaves the CPU and stops its execution for a period of time. During this time, it's not consuming CPU time, so the CPU time can be executing other tasks.
* `TimeUnit.SECONDS.sleep(integer)`
* `yield()` Thread object can leave the CPU for other tasks. The JVM doesn't guarantee that it will comply with this request. Normally, it's only used for debug purposes.

Note: When `Thread` is sleeping and is interrupted, the method throws an `InterruptedException` exception immediately and doesn't wait until the sleeping time finishes.

e.g. [FileClock.java](sleeping-resuming-thread/FileClock.java)
