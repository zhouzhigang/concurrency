# Creating a fixed-size thread executor

When we use basic `ThreadPoolExecutor` created with the `newCachedThreadPool()` method of the `Executors` class, we have a problem with the number of threads the executor is running at a time. The executor creates a new thread for each task that receives, (if there is no pooled thread free) so, if we send a large number of tasks and they have long duration, we can overload the system and provoke a poor performance of our application.

`Executor` class provides a method to create a fixed-size thread executor to avoid the problem. The executor has a maximum number of threads.
If we send more tasks than the number of threads, the executor won't create additional threads and the remaining tasks will be blocked until the executor has a free thread.

* `getpoolSize()` returns actual number of threads in the pool of the executor
* `getActiveCount()` returns the number of threads that are executing tasks in the executor
* `getTaskCount()` return how many we have send to the executor

The `Executors` class also provides the `newSingleThreadExecutor()` method. This is an extreme case of a fixed-size thread executor.

