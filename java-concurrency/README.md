# Java Concurrency

## Java Concurrency History

Java 1.0 - Preemptive(OS), Collaborative(Java); `Thread`, `ThreadUsage`, `AtomicityXXX`,`synchronized`

JDK 1.2 - `stop/resume/suspend` -> `wait/notify/sleep`, `ThreadLocal`

JDK 1.4 - NIO(Selector, Channel)

JDK 5.0 - JSR 133, JSR 166(`java.util.concurrent`)

JDK 6.0 - `CyclicBarrier`, `CountDownLatch`

JDK 7.0 - `Phaser`, `fork-join`

## Java Concurrency Overview

* Concurrency Containers
    + blocked queue
    + non-blocked queue
    + tranfer queue
    + other containers
* Sync: `CountDownLatch`, `CyclicBarrier`, `Semaphore`, `Exchanger`, `Phaser`
* Atomic Object: `AtomicBoolean`, `AtomicInteger`, `AtomicIntegerArray`, `AtomicIntegerFieldUpdater`, `AtomicLong`, `AtomicLongArray`, `AtomicLongFieldUpdater`, `AtomicMarkableReference`, `AtomicReference`, `AtomicReferenceArray`, `AtomicReferenceFieldUpdater`, `AtomicStampedReference`
* Lock: `AbstractOwnableSynchronizer`, `AbstractQueuedLongSynchronizer`, `AbstractQueuedSynchronizer`, `Lock`, `ReadWriteLock`, `ReentrantLock`, `ReentrantReadWriteLock`, `Condition`
* Fork-join: `ForkJoinPool`, `ForkJoinTask`, `ForkJoinWorkerThread`, `RecursiveTask`, `RecursiveAction`
* ExecuteService, Thread pool
    + `ExecutorService`
    + `ScheduledExecutor`
    + `CompletionService`
    + Other

## Java Concurrency Model(JCM)

## Java Concurrency in Action

## Java Concurrency Best Practice

## References
* [JSR 166: Concurrency Utilities](https://www.jcp.org/en/jsr/detail?id=166)
* [Overview of package util.concurrent Release 1.3.4](http://gee.cs.oswego.edu/dl/classes/EDU/oswego/cs/dl/util/concurrent/intro.html)
* [Java Concurrency API](http://gee.cs.oswego.edu/dl/jsr166/dist/docs/)
* [Java Concurrency History](http://www.raychase.net/698)
* [Overview of java.util.concurrent](http://www.raychase.net/1912)
