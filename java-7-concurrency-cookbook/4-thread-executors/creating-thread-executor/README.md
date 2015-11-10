# Creating a thread executor

The first step to work with the Executor framework is to create an object of the `ThreadPoolExecutor` class.
We can use tht four constructors(complexity) provided by that class or use a factory class named `Executors`(__recommended__) that creates `ThreadPoolExecutor`.
Once we have an executor, we can send `Runnable` or `Callable` objects to be executed.


__Note__: Use the executor created by the `newCachedThreadPol()` method only when you have a reasonable number of threads or when they have a short duration.

* `getPoolSize()` returns the actual number of threads in the pool of the executor
* `getActiveCount()` returns the number of threads that are executing tasks in the executor
* `getCompletedTaskCount()` returns the number of tasks completed by the executor
* `shoutdown()` when the executor finishes the execution of all pending tasks, it finishes the execution. If we try to send a task to the executor after shutdown, it will be reject and throw a `RejectedExecutionException`.

One critical aspect of the `ThreadPoolExecutor` class, and of the executors in general, is that we have to end it explicitly. If we don't do this, it will continue the execution and won't end.

The `ThreadPoolExecutor` class provides a lot of methods to obtain information about its status.

* `getLargestPoolSize()` returns the maximum number of threads that has been in the pool at a time
* `shutdownNow()` shutdowm the executor immediately, it returns a list with all pending tasks(don't execute them).
* `isTerminated()` the method returns `true` if we have called the `shutdown()` or `shutdownNow()` and the executor finishes the process of shutting down.
* `isShutdown()` the method returns `true` if we have called the `shutdown()` method of the executor
* `awaitTermination(long timeout, TimeUnit unit)` blocks the calling thread until the tasks of the executor have ended or the timeout occurs

e.g. Use these two operations implement an example that will simulate a web server processing requests from various clients.


