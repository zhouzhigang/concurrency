# Running a task in an executor after a delay

The Executor framework provides the `ThreadPoolExecutor` class to execute `Callable` and `Runnable` tasks with a pool of threads, which avoid all the thread creation operation. When we send a task to the executor, it's executed as soon as possible, according to the configuration of the executor.

`ScheduledThreadPoolExecutor` allow us execute a task after a period of time or to execute a task periodically.
* `schedule()`

e.g. Using `ScheduledThreadPoolExecutor` to shedule execution of a task after a given period of time.

