# Running a task in an executor periodically

`ScheduledThreadPoolExecutor`
* `scheduledAtFixedRate(Runnable task, long delay, long period, TimeUnit timeUnit)` returns a `ScheduledFuture` object, which extends `Future` interface, with methods to work with scheduled tasks.

`ScheduleFuture`
* `getDelay()` returns the time until the next ececution of the task

e.g. Using ScheduledThreadPoolExecutor to schedule a periodic task.

