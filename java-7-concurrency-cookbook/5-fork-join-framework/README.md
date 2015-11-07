## 5. Fork/Join Framework

## Introduction

Java 7 goes a step further and includes an additional implementation of the `ExecutorService` interface oriented to a specific kind of problem. It's __Fork/Join framework__.

This framework is designed to solve problems that can be broken into smaller tasks using the divide and conquer technique.
Inside a task, we check the size of the problem we want to resolve and,
if it's bigger than an established size, we divide it in smaller tasks that are executed using the framework.
if smaller, we solve the problem directly and then, optionally, return a result.

There is no formula to determine the reference size of a problem that determines if a task is subdivided or not, depending on its characteristics.
We can use the number of the elements to process in the task and estimation of the execution time to determine the reference size.
Test different reference sizes to choose the best one to the problem.
We can consider `ForkJoinPool` is a special kind of `Executor`.

The framework is base on the following two operations:

* `fork`: when we divide a task into smaller tasks and execute them using the framework
* `join`: when a task waits for the finalization of the task it has created

The main difference between the Fork/Join and the Executor frameworks is the __work-stealing__ algorithm.
Unlike the Executor framework, when a task is waiting for the finalization of the subtasks it has created using the join operation, the thread that is executing the task(called __worker thread__) looks for other tasks that have not been executed yet and begins it execution.

To archieve this goal, the tasks executed by the Fork/Join framework have the following limitations:

* Tasks can only use the `fork()` and `join()` operations as synchronization mechanism.
* Tasks should not perform I/O operations, such as read or write data in a file.
* Tasks can't throw checked exceptions. It has to include the code necessary to process them.

The core of the Fork/Join framework is formed by the following two classes:

* `ForkJoinPool`: It implements the `ExecutorService` interface and the work-stealing algorithm. It manages the worker threads and offers information about the status of the tasks and their execution.
* `ForkJoinTask`: It's the base class of the tasks that will execute in `ForkJoinPool`. It provides the mechanisms to execute the `fork()` and `join()` operations inside a task and the methods to control the status of the task. Usually, to implement our Fork/Join tasks, we will implement a subclass of two subclasses of this class: `RecursiveAction` for tasks with no return result and `RecursiveTask` for tasks that return one.

## [Creating a Fork/Join pool](creating-fork-join-pool)

## [Joining the results of the tasks](join-results-of-tasks)

## [Running tasks asynchronously](running-tasks-asynchronously)

## [Throwing exceptions in the tasks](throwing-exceptions-in-task)

## [Canceling-a-task](canceling-task)
