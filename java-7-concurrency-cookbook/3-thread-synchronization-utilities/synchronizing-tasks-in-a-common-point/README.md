# Synchronizing tasks in a common point

`CyclicBarrier` allows the synchronization of two or more threads in a determined point.
Similar to the `CountDownLatch` class, but presents some differentces that make them a more powerful class.

* `CyclicBarrier(int parties, Runnable barrierAction)` initialized with an integer, which is the number of threads that will be synchronized in a determined point.
* `await()` when a thread arrives to the determined point, it calls the `await()` method to wait for the other threads, the `CyclicBarrier` class will block the thread that is sleeping until the other threads arrive. when the last thread calls the `await()` method, it wakes up all the threads that were waiting and continues with its job.
* `await(long time, TimeUnit unit)`
* `reset()` One of the most important differences between `CyclicBarrier` and `CountDownLatch` is that a `CyclicBarrier` object can be reset to its initial state, assigning to its internal counter the value with which it was initializd. With this occurs, all the threads that were waiting in the `await()` method receive a `BrokenBarrierException`.
* `isBroken()` check if the object is in broken state
