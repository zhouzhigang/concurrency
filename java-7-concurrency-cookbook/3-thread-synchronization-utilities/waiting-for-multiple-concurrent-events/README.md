# Waiting for multiple concurrent events

`CountDownLatch` 

* `CountDownLatch(int num)` intialized with an integer, which is the number of operations/events the threads are going to wait for.
* `await()` when a thread want to wait for the execution of these operations, it puts the thread to sleep until the operations are complete.
* `countDown()` when one of these operation finishes, it use `countDown()` method to decrement the internal counter of the `CountDownLatch`.

When the counter arrives to `0`, the class wakes up all the threads that were sleeping in the `await()` method.


