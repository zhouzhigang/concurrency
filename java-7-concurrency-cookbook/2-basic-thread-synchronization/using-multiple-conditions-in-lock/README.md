# Using multiple conditions in a Lock

A lock may be associated with one or more conditions. These conditions are declared in the `Condition` interface.
The purpose of these conditions is to allow threads to have control of a lock and check whether a condition is true or not and, if it's `false`, be suspended until another thread wakes them up.
The `Condition` interface provides the mechanisms to suspend a thread and to wake up a suspended thread.

Using locks and conditions to solve __Producer-Consumer__ problem.

`Condition` created by `lock.newCondition()`. Before we do any operation with a condition, we have to get the lock associated with the condition.
So it must inside `lock()` and `unblock()` block of code.

* `await()` automatically free the control of the lock, so that another thread can get it and begin the execution of the same, or another critical section protected by the lock
* `signal()` or `signalAll()` one or all of the threads  that were waiting for that condition are woken up, but this doesn't guarantee that the condition that made them sleep is now `ture`, so we must put `await()` inside a `while` loop. We can't leave the loop until the condition is `true`.
* `await(long time, TimeUnit unit)`
* `awaitUninterruptibly()`
* `awaitUntil(Date date)` 

e.g. [FileMock.java](using-multiple-conditions-in-lock/FileMock.java) [Buffer.java](using-multiple-conditions-in-lock/Buffer.java) [FileProducer.java](using-multiple-conditions-in-lock/FileProducer.java) [FileConsumer.java](using-multiple-conditions-in-lock/FileConsumer.java) [FileProducerConsumerTest.java](using-multiple-conditions-in-lock/FileProducerConsumerTest.java)
