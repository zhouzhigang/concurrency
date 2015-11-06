# 2 Basic Thread Synchronization

## Introduction

__Critical Section__ is a block of code that accesses a shared resource and can't be executed by more than one thread at the same time.

Two basic synchronization mechannisms offered by Java language:

* The keyword `synchronized`
* The `Lock` interface and its implementations

## Synchronizing a method

Every method declared with the `synchronized` keyword is a critical section and Java only allows the execution of one of the critical sections of an object.

Static methods have a different behavior.
Only one execution thread will access one of the static methods declared with the `synchronized` keyword, but another thread can access other nonstatic methods of an object of that class. Two threads can access two different synchronized methods if one is static and the other is not.

The `synchronized` keyword penalizes the performance of the application, so we must only use it on methods that modify shared data in a concurrent environment.

We can use the `synchronize` keyword to protect the access to a block of code instead of an entire method.

    synchronized(this) {
        // java code
    }

e.g. [Account.java](sychronizing-method/Account.java) [Bank.java](sychronizing-method/Bank.java) [Company.java](sychronizing-method/Company.java) [AccountTest.java](sychronizing-method/AccountTest.java)


## Arranging independent attributes in synchronized classes

When we use the `synchronized` keyword to protect a block of code, we must pass an object reference as a parameter.

If we have two independent attributes in a class shared by mutiple threads, we must synchronize the access to each variable, but there is no problem if there is one thread accesssing one of the attributes and another thread accessing the other at the same time.

e.g. [Cinema.java](arranging-independent-attributes-in-synchronized-class/Cinema.java) [TicketOffice1.java](arranging-independent-attributes-in-synchronized-class/TicketOffice1.java) [TicketOffice2.java](arranging-independent-attributes-in-synchronized-class/TicketOffice2.java) [CinemaTest.java](arranging-independent-attributes-in-synchronized-class/CinemaTest.java)


## Using conditions in synchronized code

__Producer-Consumer__ proble: we have a data buffer, one or more producers of data that save it in the buffer and one or more consumers of data that take it from the buffer.

As the buffer is a shared data structure, we have to control the access to it using a synchronization mechanism such as `synchronized` keyword, but we have more limitations.
A producer can't save data in the buffer if it's full and the consumer can't take data from the buffer if it's empty.

* `wait()` inside a `synchronized` block of code. If outside, the JVM will throw `IllegalMonitorStateException`. When the thread call `wait()` method, the JVM puts the thread to sleep and releases the object that controls the `sysnchronized` block of code that it's executing and allows the other threads to execute other blocks of `synchronized` code protected by that object.
* `notify()` or `notifyAll()` to wake up the thread

We have to keep checking the conditions and calling the `wait()` method in a while loop(can't continue until the condition is true).

Example: [EventStorage.java](using-conditions-in-sychronized-code/EventStorage.java) [Producer.java](using-conditions-in-sychronized-code/Producer.java) [Consumer.java](using-conditions-in-sychronized-code/Consumer.java) [ProducerConsumerTest.java](using-conditions-in-sychronized-code/ProducerConsumer.java)


## Synchronizing a block of code with a Lock

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


## Synchronizing data access with read/write locks

One of the most significant improvements offered by locks is the `ReadWriteLock` interface and `ReentrantReadWriteLock` class.
The class has two locks, one for read and one for write. There can be more than one thread using read operatons simultanously, but only one thread can be using write operations. When a thread is doing a write operation, there can't be any thread doing read operations.

Example: [PricesInfo.java](synchronizing-data-access-with-read-write-lock/PricesInfo.java) [Reader.java](synchronizing-data-access-with-read-write-lock/Reader.java) [Writer.java](synchronizing-data-access-with-read-write-lock/Writer.java) [ReadWriteLockTest.java](synchronizing-data-access-with-read-write-lock/ReadWriteLockTest.java)


## Modifying Lock fairness

Constructor `ReentrantLock(boolean fair)` or `ReentrantReadWriteLock(boolean fair)`

* `false` is the default value, __non-fair mode__: when there are some threads waiting for a lock and the lock has to select one of them to get the access of critical section, it select one without any criteria.
* ` true` __fair mode__: when there are some threads waiting for a lock and the lock has to select one of to get the access of critical section, it selects the thread that has been waiting for the most time.

Note: The fair attribute only affect `lock()` and `unlock()` methods. As `tryLock()` method doesn't put the thread to sleep if the `Lock` interface is used.

e.g. [FairPrintQueue.java](modifying-lock-fairness/FairPrintQueue.java) [FairJob.java](modifying-lock-fairness/FairJob.java)


## Using multiple conditions in a Lock

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
