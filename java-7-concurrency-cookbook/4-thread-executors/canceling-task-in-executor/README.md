# Canceling atask in an executor

`cancel()` method of `Future` class
* if the task has finished or has been canceled earlier or it can't be canceled for other reasons, it will return `false` and the task won't be canceled;
* if the task is waiting in the executor to get a `Thread` object that will execute it, the task is canceled and never begins its execution;
* if the task is already running, it depends on the parameter of the method. if the parameter is `true`, it will be canceld; otherwise it won't be canceled.

`get()` method will throw a `CancellationException`.

e.g. Use `cancel()` method of `Future` to cancel the task that already sent to an executor.
