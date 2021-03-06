# 4. Thread Executors

## Introduction

Disadvandages of creating many threads using `Runnable`

* have to implement all the code-related information to the management of the `Thread` objects(creation, ending, obtaining result)
* affect the throughtput of application if execute a big number of tasks

Java(since 5) provide __Executor framework__ and is aroud the `Executor` interface, its subinterface `ExecutorService` and the `ThreadPoolExecutor` class that implement both interface.

This mechanism separates the task creation and its execution.
With an executor, we only have to implement the `Runnable` objects and send them to the executor. 
It tries to use a pooled thread for the execution of this task, to avoid continuous spawning of threads.

Another important advantage of the Executor framework is the `Callable` interface. It's similar to the `Runnable` interface, but offers two improvement.

* The main method of this interface, named `call()`, may return a result
* When we send a `Callable` object to an executor, we get an object that implements the `Future` interface. We can use this object to control the status and the result of the `Callable` object.

## [Creating a thread executor](creating-thread-executor)

    ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();// it returns ExecutorService object
    executor.execute(runnable/callable);
    executor.getPoolSize();
    executor.getActiveCount();
    executor.getCompletedTaskCount();
    executor.shutdown(); // need end it explicitly

## [Creating a fixed-size thread executor](creating-fixed-size-thread-executor)

    ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(count); // newSingleThreadExecutor()
    execurot.getTaskCount();

## [Executing tasks in an executor that returns a result](executing-tasks-in-executor-returns-result)

    Public class Task implements Callable<T> {
        @Override
        public T call() throws Exception {
            return t;
        }
    }

    Future<T> result = executor.submit(task);
    
    result.isDone(); // loop to check the status
    
    result.get(); // block until task finish

## [Running multiple tasks and processing the first result](running-multiple-tasks-processing-first-result)

    public class Task implements Callable<T> {
        @Override
        public T call() throws Exception {
            return t;
        }
    }

    ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
    T result = executor.invokeAny(tasks); // need try-catch or throw

    executor.shutdown();

## [Running multiple tasks and processing all the results](running-multiple-tasks-processing-all-results)

    public class Task implements Callable<T> {
        @Override
        public T call() throws Exception {
            return t;
        }
    }

    ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
    // use Future<T> to get the result
    List<Future<T>> resultList = executor.invokeAll(tasks); // need try-catch or throw

    executor.shutdown();

    for (int i = 0; i < resultList.size(); i++) {
        Future<T> future = resultList.get(i);
        try {
            T result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

## [Running a task in an executor after a delay](running-task-in-executor-after-delay)

    ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(1);

    executor.schedule(task, time, timeUnit);
    
    executor.shutdown();

    executor.awaitTermination(time, timeUnit); // need try-catch or throw InterruptedException


## [Running a task in an executor periodically](running-task-in-executor-periodically)

    public class Task implements Runnable {}

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    ScheduledFuture<?> result = executor.scheduleAtFixedTate(task, delay, period, timeUnit);

    executor.shutdown();

## [Canceling a task in an executor](canceling-task-in-executor)

    Future<T> result = executor.submit(task);

    result.cancle(true);

    result.isCancelled();
    result.isDone();

## [Controlling a task finishing in an executor](controlling-task-finishing-in-executor)


## [Separating the launching of tasks and the processing of their results in an executor](separating-launching-tasks-processing-results-in-executor)

    ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
    CompletionService<T> service = new ExecutorCompletionService<T>(executor);

    // send the task to the service
    service.submit(task);

    // process the results in another thread
    Future<T> result = service.poll();
    if (result != null) {
        result.get();
    }

## [Controlling the rejected tasks of an executor](controlling-rejected-tasks-of-executor)

    public class RejectedTaskController implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        }
    }

    executor.setRejectedExecutionHandler(controller);

    executor.shutdown();
    executor.submit(task);
