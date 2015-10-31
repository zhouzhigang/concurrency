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

e.g. [Account.java](Account.java) [Bank.java](Bank.java) [Company.java](Company.java) [AccountTest.java](AccountTest.java)


## Arranging independent attributes in synchronizied classes

When we use the `synchronized` keyword to protect a block of code, we must pass an object reference as a parameter.

If we have two independent attributes in a class shared by mutiple threads, we must synchronize the access to each variable, but there is no problem if there is one thread accesssing one of the attributes and another thread accessing the other at the same time.

e.g. [Cinema.jva](Cinema.jva) [TicketOffice1.java](TicketOffice1.jva) [TicketOffice2.java](TicketOffice2.java) [CinemaTest.java](CinemaTest.java)


## Using conditions in synchronized code

__Producer-Consumer__ proble: we have a data buffer, one or more producers of data that save it in the buffer and one or more consumers of data that take it from the buffer.

As the buffer is a shared data structure, we have to control the access to it using a synchronization mechanism such as `synchronized` keyword, but we have more limitations.
A producer can't save data in the buffer if it's full and the consumer can't take data from the buffer if it's empty.

* `wait()` inside a `synchronized` block of code. If outside, the JVM will throw `IllegalMonitorStateException`. When the thread call `wait()` method, the JVM puts the thread to sleep and releases the object that controls the `sysnchronized` block of code that it's executing and allows the other threads to execute other blocks of `synchronized` code protected by that object.
* `notify()` or `notifyAll()` to wake up the thread

We have to keep checking the conditions and calling the `wait()` method in a while loop(can't continue until the condition is true).

Example: [EventStorage.java](EventStorage.java) [Producer.java](Producer.java) [Consumer.java](Consumer.java) [ProducerConsumerTest.java](ProducerConsumer.java)


## Synchronizaing a block of code with a Lock

`Lock` interface and classes that implement is(as `ReentrantLock`) is more powerful and flexible mechanism than the `synchronized` keyword.

* allows the structuring of synchronized blocks in a more flexible way
* provide additional functionalities over the `synchronized` keyword, such as `tryLock()` method
* allow a separation of read and writeoperations haveing mutiple readers and only one modifier
* offer better performance than `synchronized` keyword

`__Lock__` interface(and the `__ReentrantLock__` class)

* `lock()` get the control of lock, if it already occupied by other thread, the `lock()` method will put current thread to sleep until the other thread is finished.
* `unlock()` free the control of the lock and allow other threads to run this critical section. If don't unlock, the other threads will be waiting forever.
* `tryLock()` if the thread that uses it can't get the control of the `Lock` interface, returns immediately and doesn't put the thread to sleep. It returns a `boolean` value.

The `ReentrantLock` class also allows the use of recursive calls.

__Note:__ We have to be careful with the use of `Locks` to avoid __deadlocks__. This situation occurs when two or more threads are blocked waiting for locks that newver will be locked.

    Thread A ---> Lock X
       |            |
    Lock Y  <---- Thread B

Example: [PrintQueue.java](PrintQueue.java) [Job.java](Job.java)


