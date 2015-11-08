# 1. Thread Management

## Introduction

Concurrency
Parallelism

## [Creating and running a thread](creating-running-thread)

* extends `Thread`
* implements `Runnable`

## [Getting and Setting thread information](getting-setting-thread-information)

Thread attributes

* __Id__ 
* __Name__
* __Priority__
* __Status__ six status in java: `new`, `runnable`, `blocked`, `waiting`, `timewaiting`, `terminated`

## [Interrupting a thread](interrupting-thread)

* `interrupt()`
* `isInterrupted()`
* `Thread.interrupted()`

## [Controlling the interruption of a thread](controlling-interruption-of-thread)

* detect by `isInterrupted`
* throw `InterruptedException` and catch in `run()`

## [Sleeping and resuming a thread](sleeping-resume-thread)

* `Thread.sleep(integer)`
* `TimeUnit.SECONDS.sleep(integer)`
* `yield()`

## [Waiting for finalization of a thread](waiting-for-finalization-of-thread)

* `join()`
* `join(long milliseconds)`
* `join(long milliseconds, long nanos)`

## [Creating and running a daemon thread](creating-running-daemon-thread)

* `setDaemon(true)`
* `isDaemon()`

## [Processing uncontrolled exceptions in a thread](processing-uncontrolled-exception-in-thread)

* `UncaughtExceptionHandler` interface, `uncaughtException()` method
* `ThreadGroup` handler
* `Thread.setDefaultUncaughtException()`

## [Using local thread variables](using-local-thread-variables)

* `initialValue()`
* `get()`
* `set()`
* `remove()`

## [Grouping threads into a group](grouping-threads-into-group)

* `list()`
* `activeCount()`
* `enumerate()`

## [Processing uncontrolled exceptions in a group of threads](processing-uncontrolled-exception-in-group-threads)

Capture all the uncaught exceptions throwns by any `Thread` of the `ThreadGroup` class.

## [Creating threads through a factory](creating-threads-through-factory)

__ThreadFactory__ interface to implement a Thread object factory. It has only one method called `newThread`.

