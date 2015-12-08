# Controlling rejected tasks of an executor

If we send a task to an executor between the `shutdown()` method and the end of its execution, the task is rejected, because the executor no longer accepts new tasks. The `ThreadPoolExecutor` class provides a mechanism, which is called when a task is rejected.

`RejectedExecutionHandler` interface
* `rejectedExecution(Runnable r, ThreadPoolExecutor executor)`

e.g. Manage rejecting tasks in an executor that is implementing with `RejectedExecutionHandler`.
