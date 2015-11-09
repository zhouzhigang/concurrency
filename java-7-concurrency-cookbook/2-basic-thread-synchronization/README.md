# 2 Basic Thread Synchronization

## Introduction

__Critical Section__ is a block of code that accesses a shared resource and can't be executed by more than one thread at the same time.

Two basic synchronization mechannisms offered by Java language:

* The keyword `synchronized`
* The `Lock` interface and its implementations

## [Synchronizing a method](sychronizing-method)_


    synchronized(this) {
        // java code
    }


## [Arranging independent attributes in synchronized classes](arranging-independent-attributes-in-synchronized-class)

If we have two independent attributes in a class shared by mutiple threads, we must synchronize the access to each variable, but there is no problem if there is one thread accesssing one of the attributes and another thread accessing the other at the same time.

## [Using conditions in synchronized code](using-conditions-in-sychronized-code)

* `wait()`
* `notify()` or `notifyAll()`


## [Synchronizing a block of code with a Lock](synchronizing-block-code-using-lock

`Lock` interface(and the `ReentrantLock` class)

* `lock()`
* `unlock()`
* `tryLock()`

## [Synchronizing data access with read/write locks](synchronizing-data-access-with-read-write-lock)

One of the most significant improvements offered by locks is the `ReadWriteLock` interface and `ReentrantReadWriteLock` class.
The class has two locks, one for read and one for write. There can be more than one thread using read operatons simultanously, but only one thread can be using write operations. When a thread is doing a write operation, there can't be any thread doing read operations.


## [Modifying Lock fairness](modifying-lock-fairness)

Constructor `ReentrantLock(boolean fair)` or `ReentrantReadWriteLock(boolean fair)`


## Using multiple conditions in a Lock


`Condition` created by `lock.newCondition()`, must inside `lock()` and `unblock()` block of code.

* `await()`
* `signal()` or `signalAll()`
* `await(long time, TimeUnit unit)`
* `awaitUninterruptibly()`
* `awaitUntil(Date date)` 

