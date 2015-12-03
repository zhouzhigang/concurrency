# Running multiple tasks and processing all the results

`Future` class allow us control the status and get the results of any task executed in an executor.
* `isDone()` returns `true` if the task has finished its execution.

`ThreadPoolExecutor`
* `awaitTermination()` puts the thread to sleep until all the tasks have finished their execution after a call to the `shutdown()` method.

These two methods have same drawbacks. With the first one, we can only control the completion of a task, and with the second one, we have to shutdown the executor to wait for a thread, otherwise the method's call returns immediately.

The `ThreadPoolExecutor` class provides a method that allows us to send to the executor a list of tasks and wait for the finalization of all the tasks in the list.
* `invokeAll()`
* `invokeAll(Collection<? extends Callable<T> tasks, long timeout, TimeUnit unit)`




