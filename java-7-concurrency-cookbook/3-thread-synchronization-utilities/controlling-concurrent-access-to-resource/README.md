# Controlling concurrent access to a resource

`Semaphore` was introduced by Dijkstra in 1995 and was used for the first time in the THEOS operating system.

When a thread wants to access one of these shared resources, first, it must acquire the semaphore. 
If the internal counter of the semaphore is greater than `0`(means there are free resources that can be used), the semaphore decrements the counter and allows access to the shared resource.
Otherwise, if the counter of the semaphore is `0`(means all the shared resources are used by other threads), the semaphore puts the thread to sleep until the counter is greater than `0`.

When the thread has finished the use of the shared resource, it must release the semaphore so that other thread can access the shared resource. That operatin increases the counter of the semaphore.

* `acquire()` acquire the semaphore
* `acquireUninterruptibly()` when the internal counter of the semaphore is `0`, `acquire()` method will blcok the thread until the semaphore is released. During the block time, the thread might be interrupted and the method throws an `InterruptedException`. This version of acquire will ignores the interruption.
* `tryAcquire()` if acquire the semaphore failed, it will return the `false` value instead of being blocked and waits for the release of thesemaphore.
* `release()` free the semaphore

