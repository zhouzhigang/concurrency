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

e.g. Simulate a bank account and two threads.

## [Arranging independent attributes in synchronized classes](arranging-independent-attributes-in-synchronized-class)

If we have two independent attributes in a class shared by mutiple threads, we must synchronize the access to each variable, but there is no problem if there is one thread accesssing one of the attributes and another thread accessing the other at the same time.

e.g. Simulate a cinema with two screens and two ticket offices.

## [Using conditions in synchronized code](using-conditions-in-sychronized-code)

    // get/set method in shared object
    synchronized set/get() {
        while (full/empty) {
            try {
                wait();
            } catch (InterruptedException) {}
        }
        // do set/get
        notifyAll();
    }

e.g. __Producer Consumer__ problem using `synchronized` and `wait`, `notify`.

## [Synchronizing a block of code with a Lock](synchronizing-block-code-using-lock

    private final Lock lock = new ReentrantLock();

    try {
        lock.lock();
        // do something else
    } catch (InterruptedException e) {
    } finally {
        lock.unlock();
    }

e.g. Simulate a print queue.

## [Synchronizing data access with read/write locks](synchronizing-data-access-with-read-write-lock)

    lock.readLock().lock();
    // read value
    lock.readLock().unlock();

    lock.writeLock().lock();
    // write value
    lock.writeLock().unlock();

e.g. Simulate a program that use `ReadWriteLock` to control the access of an object that stores the prices of two products.

## [Modifying Lock fairness](modifying-lock-fairness)

Constructor `ReentrantLock(boolean fair)` or `ReentrantReadWriteLock(boolean fair)`

e.g. Check the difference between fair and non-fair modes.

## Using multiple conditions in a Lock

    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    // constructor
    lock = new ReentrantLock;
    lines = lock.newCondition(); // line condtion wait for readable line
    space = lock.newCondition(); // space condition wait for free space 


    lock.lock();
    try {
        while (full/empty) {
            space/lines.await();
        }
        // write/read
        lines/space.singalAll();
    } catch (IntterruptedException e) {
    } finally {
        lock.unlock();
    }

e.g. __Producer-Consumer__ problem using `Lock` and `Condition`

