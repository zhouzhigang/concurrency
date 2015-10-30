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


## Creating and running a daemon thread

Daemon thread has very low priority and normally only executes when no other thread of the same program is running.
When daemon threads are the only threads running in a program, the JVM ends the program finishing these threads.
The daemon threads are normally used as service providers for normal(also called user) threads running in the same program. They usually have infiniate loop that wait for the service request or performs the tasks of the thread.
A typical example of these kind of threads is the Java garbage collector.

* `setDaemon(true)` mark the thread as a daemon thread, we only can call this method before call the `start()` method. Once the thread is running, we can't modify its daemon status.
* `isDaemon()` check if a thread is a daemon thread or user thread.

e.g. [Event.java](Event.java) [WriterTask.java](WriterTask.java) [CleanerTask.java](CleanerTask.java) [Daemon.java](Daemon.java)


## Processing uncontrolled exceptions in a thread

* __Checked exceptions__ must be specified in the throws clause of a method or caught inside them. e.g. `IOException`, `ClassNotFoundException`
* __Unchecked exceptions__ don't have to be specified or caught. e.g. `NumberFormatException`

When an unchecked exception is thrown inside the `run()` method of a Thread object, the default behaviour is to write the stack trace in the console and exit the program.
Fortunately, Java provide a mechanism to catch and treat unchecked exceptions thrown in a Thread object to avoid program ending.

* `UncaughtExceptionHandler` interface, `uncaughtException()` method
* `ThreadGroup` handler for a group of threads
* `Thread.setDefaultUncaughtException()` the default handler for all the thread objects

e.g. [ExceptinHandler.java](ExceptionHandler.java) [ExceptionTask.java](ExceptionTask.java)

## Using local thread variables



## Grouping threads into a group



## Processing uncontrolled exceptions in a group of threads



## Creating threads through a factory


