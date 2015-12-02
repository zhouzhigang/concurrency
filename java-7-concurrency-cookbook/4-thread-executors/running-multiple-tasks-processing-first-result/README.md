# Running multipletasks and processing the first result

A common problem in concurrent programing is when we have various concurrent tasks that solve a problem, and we only interested in the first result of those tasks.

`ThreadPoolExecutor`
* `invokeAny(Collection<? extends Callable<T>> tasks)` receives a list of tasks, launches them, and returns the result of the first task that finishes without throwing an exception. And the return data type is same with call method of this task.
* `invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)`

