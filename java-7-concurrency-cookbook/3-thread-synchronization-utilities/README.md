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

`Semaphore`

    private final Semaphore;
    semaphore = new Semaphore(1); // constructor

    try {
        semaphore.acquire();
        // do something
    } catch (InterruptedException e) {
    } finally {
        semaphore.release();
    }

e.g. Using __binary semaphore__ to simulate a print queue.

## Controlling concurrent access to multiple copies of a resource

    private final Semaphore;
    semaphore = new Semaphore(count); // constructor
    
    try {
        semaphore.acquire();
    } catch (InterruptedException e) {
    } finally {
        semaphore.release();
    }

e.g Using semaphore to simulate a print queue that can print documents in three different printers.

## Waiting for multiple concurrent events

`CountDownLatch` 

    private final CountDownLatch latch;
    latch = new CountDownLatch(number); // constructor

    // count down when arrive or sthm condition happen
    latch.countDown();

    // wait all things done, run() method
    try {
        latch.await();
        // do something after every thing is done
    }  catch (InterruptedException e) {}

e.g. Simulate a video conference system which will wait for all participants.

## Synchronizing tasks in a common point

`CyclicBarrier`

    private final CyclicBarrier barrier;
    this.barrier = barrier; // constructor
    
    try {
        barrier.await();
        // auto start runnable thread after internal count arrive 0
    } catch (InterruptedException e) {
    } catch (BrokenBarrierException e) {
    }

    CyclicBarrier barrier = new CyclicBarrier(count, runnable);

e.g. Look for a number in a matrix of numbers.

## [Running concurrent phased tasks](running-concurrent-phased-tasks)

`Phaser`

    private Phaser phaser;
    this.phaser = phaser; // constructor

    
    if (finished) {
        phaser.arriveAndDeregister();
    } else {
        phaser.arriveAndAwaitAdvance();
    }

e.g. Look for files in three different folders(divided into three steps).

## [Controlling phase change in concurrent phased tasks]()

## [Changing data between concurrent tasks]()

`Exchanger`
