# Synchronizing a block of code with a Lock

`Lock` interface and classes that implement is(as `ReentrantLock`) is more powerful and flexible mechanism than the `synchronized` keyword.

* allows the structuring of synchronized blocks in a more flexible way
* provide additional functionalities over the `synchronized` keyword, such as `tryLock()` method
* allow a separation of read and writeoperations haveing mutiple readers and only one modifier
* offer better performance than `synchronized` keyword

`Lock` interface(and the `ReentrantLock` class)

* `lock()` get the control of lock, if it already occupied by other thread, the `lock()` method will put current thread to sleep until the other thread is finished.
* `unlock()` free the control of the lock and allow other threads to run this critical section. If don't unlock, the other threads will be waiting forever.
* `tryLock()` if the thread that uses it can't get the control of the `Lock` interface, returns immediately and doesn't put the thread to sleep. It returns a `boolean` value.

The `ReentrantLock` class also allows the use of recursive calls.

__Note:__ We have to be careful with the use of `Locks` to avoid __deadlocks__. This situation occurs when two or more threads are blocked waiting for locks that newver will be locked.

    Thread A ---> Lock X
       |            |
    Lock Y  <---- Thread B

Example: [PrintQueue.java](synchronizing-block-code-using-lock/PrintQueue.java) [Job.java](synchronizing-block-code-using-lock/Job.java)
