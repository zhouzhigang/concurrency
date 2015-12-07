# Separating the launching of tasks and the processing of their results in an executor

`CompletionService`
When we need to send the tasks to the executor in one object and process the results in another one.
The `CompletionService` class has a method to send the tasks to an executor and a method to get the `Future` object for the next task that has finished its execution. Interrnally, it uses an `Exector` object to execute the task.
This behavior has the advantage to share a `CompletionService` object, and send tasks to the executor so the others can process the results.
The limitation is that the second object can only get the `Future` objects for those tasks that have finished its execution, so these `Future` objects can only be used to get the results of the tasks.

The `CompletionService` can execute `Callable` or `Runnable` tasks.
Methods to obtain the `Future` objects of the finished tasks.
* `poll()`
* `take()`

e.g. Using the `CompletionSrvice` class to separate launching tasks in an executor from processing their results.
