# 1. Thread Management

## Introduction

Concurrency
Parallelism

## Creating and running a thread

* extends `Thread` class and overriding the `run()` method
* implements `Runnable` interface and Creating an object of `Thread` passing `Runnable` object as a parameter

e.g. [Calculator.java](Calculator.java)

Note: only call `start()` method creates a new execution thread.
The `start()` method will call `run()` method.


## Getting and Setting thread information

Thread attributes

* __Id__ 
* __Name__
* __Priority__
* __Status__ six status in java: `new`, `runnable`, `blocked`, `waiting`, `timewaiting`, `terminated`

e.g. [ThreadAttributes.java](ThreadAttributes.java)


## Interrupting a thread

* `interrupt()` set interrupted flag as true.
* `isInterrupted()` check whether the thread has been interrupted or not, didn't change `interrupted` attribute - Recommented
* `Thread.interrupted()` check whether current executing thread has been interrupted or not, set the `interrupted` as false

e.g.[PrimeGenerator.java](PrimeGenerator.java)

Thread can ignore its interruption, but this is not the expected behavour.


## Controlling the interruption of a thread

* detect by `isInterrupted` - simple algorithm
* throw `InterruptedException` and catch in `run()` method - a better mechanism to control the interruption of thread

e.g. [FileSearch.java](FileSearch.java)

Note: The `InterruptedException` is thrown by some java methods related with the concurrency API such as `sleep()`.


## Sleeping and resuming a thread

* `Thread.sleep(integer)` Thread leaves the CPU and stops its execution for a period of time. During this time, it's not consuming CPU time, so the CPU time can be executing other tasks.
* `TimeUnit.SECONDS.sleep(integer)`
* `yield()` Thread object can leave the CPU for other tasks. The JVM doesn't guarantee that it will comply with this request. Normally, it's only used for debug purposes.

Note: When `Thread` is sleeping and is interrupted, the method throws an `InterruptedException` exception immediately and doesn't wait until the sleeping time finishes.

e.g. [FileClock.java](FileClock.java)


## Waiting for finalization of a thread

* `join()`  it suspends the execution of the calling thread until the object called finishes its execution.
* `join(long milliseconds)`
* `join(long milliseconds, long nanos)`

e.g. [DataSourcesLoader.java](DataSourcesLoader.java) [NetworkConnectionsLoader.java](NetworkConnectionsLoader.java) [WaitingFinalization.java](WaitingFinalization.java)


## Creating and running a deamon thread



## Processing uncontrolled exceptions in a thread



## Using local thread variables



## Grouping threads into a group



## Processing uncontrolled exceptions in a group of threads



## Creating threads through a factory


