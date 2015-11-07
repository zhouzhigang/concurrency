# 6. Concurrent Collections

## Introduction

Java provides wo kinds of collections to use in concurrent applications:

* __Blocking collection__: If the operation can't be made immediately, because the collection is full or emppty, the thread that makes the call will be blocked until the operation can be made.
* __Non-blocking collection__: If the operation can't be made immediately, the operation returns a `null` value or throws an exception, but the thread that makes the call won't be blocked.

Java concurrency collections

* Non-blocking lists, `ConcurrentLinkedDeque`
* Blocking lists, `LinkedBlockingDeque`
* Blocking list to be used with producers and consumers of data, `LinkedTransferQueue`
* Blocking lists that order their elements by priority, `PriorityBlockingQueue`
* Blocking lists with delayed elements, `DelayQueue`
* Non-blocking navigable maps, `ConcurrentSkipListMap`
* Random numbers, `ThreadLocalRandom`
* Atomic variables, `AtomicLong`, AtomicIntegerArray`

## [Using non-blocking thread-safe lists](using-non-blocking-thread-safe-lists)

## [Using blocking thread-safe lists](using-blocking-thread-safe-lists)

## [Using blocking thread-safe lists ordered by priority](using-blocking-thread-safe-lists-ordered-by-priority)

## [Using thread-safe lists with delayed elements](using-thread-safe-lists-with-delayed-elements)

## [Using thread-safe navigable maps](using-thread-safe-navigable-maps)

## [Generating concurrent random numbers](generating-concurrent-random-numbers)

## [Using atomic variables](using-atomic-variables)

## [Using atomic arrays](using-atomic-arrays)
