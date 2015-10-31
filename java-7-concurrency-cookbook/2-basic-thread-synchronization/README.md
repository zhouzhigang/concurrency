# 2 Basic Thread Synchronization

## Introduction

__Critical Section__ is a block of code that accesses a shared resource and can't be executed by more than one thread at the same time.

Two basic synchronization mechannisms offered by Java language:

* The keyword `synchronized`
* The `Lock` interface and its implementations

## Synchronizing a method

Every method declared with the `synchronized` keyword is a critical section and Java only allows the execution of one of the critical sections of an object.

Static methods have a different behavior.
Only one execution thread will access one of the static methods declared with the `synchronized` keyword, but another thread can access other nonstatic methods of an object of that class. Two threads can access two different synchronized methods if one is static and the other is not.

The `synchronized` keyword penalizes the performance of the application, so we must only use it on methods that modify shared data in a concurrent environment.

We can use the `synchronize` keyword to protect the access to a block of code instead of an entire method.

    synchronized(this) {
        // java code
    }

e.g. [Account.java](Account.java) [Bank.java](Bank.java) [Company.java](Company.java) [AccountTest.java](AccountTest.java)


## Arranging independent attributes in synchronizied classes

When we use the `synchronized` keyword to protect a block of code, we must pass an object reference as a parameter.

If we have two independent attributes in a class shared by mutiple threads, we must synchronize the access to each variable, but there is no problem if there is one thread accesssing one of the attributes and another thread accessing the other at the same time.

e.g. [Cinema.jva](Cinema.jva) [TicketOffice1.java](TicketOffice1.jva) [TicketOffice2.java](TicketOffice2.java) [CinemaTest.java](CinemaTest.java)


