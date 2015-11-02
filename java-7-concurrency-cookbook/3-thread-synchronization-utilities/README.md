# 3. Thread Synchronization Utilities

## Introduction

Basically, we talk about synchronization when more than one concurrent task shares a resource(critical section).

Basic synchronization mechanism

* `synchronized` keyword
* `Lock` interface and its implementation classes: `ReentrantLock`, `ReentrantReadWriteLock.ReadLock`, `ReentrantReadWriteLock.WriteLock`

Some high-level mechanisms

* __Semaphores__ A semaphore is a counter that controls the access to one or more shared resources. It's one of the basic tools of concurrent programming and is provided by most of programming language.
* __CountDownLatch__ is a machanism provided by Java that allows a thread to wait for the finalization of multiple operations.
* __CyclicBarrier__ is another mechanism provided by Java that allows the synchronization of multiple threads in a common point.
* __Phaser__ is another mechanism provided by Java that controls the execution of current tasks divided in phases. All the threads must finish one phase before they can continue with the next one.(Java 7)
* __Exchanger__ is another mechanism provided by Java that provideds a point of data interchange between two threads.

Semaphores are a generic synchronization mechanism that we can use to protect any critical section in any problem.
The other mechanisms are tought to be used in applications with specific features.

## Controlling concurrent access to a resource

`Semaphore` was introduced by Dijkstra in 1995 and was used for the first time in the THEOS operating system.

When a thread wants to access one of these shared resources, first, it must acquire the semaphore. 
If the internal counter of the semaphore is greater than `0`(means there are free resources that can be used), the semaphore decrements the counter and allows access to the shared resource.
Otherwise, if the counter of the semaphore is `0`(means all the shared resources are used by other threads), the semaphore puts the thread to sleep until the counter is greater than `0`.

When the thread has finished the use of the shared resource, it must release the semaphore so that other thread can access the shared resource. That operatin increases the counter of the semaphore.

* `acquire()` acquire the semaphore
* `acquireUninterruptibly()` when the internal counter of the semaphore is `0`, `acquire()` method will blcok the thread until the semaphore is released. During the block time, the thread might be interrupted and the method throws an `InterruptedException`. This version of acquire will ignores the interruption.
* `tryAcquire()` if acquire the semaphore failed, it will return the `false` value instead of being blocked and waits for the release of thesemaphore.
* `release()` free the semaphore

e.g. [PrintQueue.jva](PrintQueue) [Job.java](Job.java)

