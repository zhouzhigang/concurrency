# Creatinga Fork/Join pool

* Creating a `ForkJoinPool` object to execute the tasks
* Creating a subclass of `ForkjoinTask` to be executed in the pool

Steps
* Create `ForkJoinPool` using the default constructor
* Inside the task, using the following structure recommended by Java API

    if (problem size > default size) {
        task = divide(task);
        execute(task);
    } else {
        resolve problem using another algorithm;
    }

* Execute the tasks in a synchronized way
* Take the `RecursiveAction` class as the base class to collect the results.

`ForkJoinPool`
* `execute(Runnable task)` another version of the `execute()` method, but doesn't use the work-stealing algorithm with `Runnable` object.
* `invoke(ForkJoinTask<T> task)` while `execute()` makes an asynchronous call to the `ForkJoinPool` class, `invoke()` method makes a synchronous call.
* `invokeAll()`, `invokeAny()` 

`ForkJoinTask`
* `invokeAll(ForkJoinTask<?>... tasks)`
* `invokeAll(Collection<T> tasks)` the generic type `T` must be the `ForkJoinTask` class or a subclass of it.
* `adapt(Runnable|Callable task)` Although `ForkJoinPool` is designed to execute an object of `ForkJoinTask`, we can also execute `Runnable` and `Callable` objects directly.

