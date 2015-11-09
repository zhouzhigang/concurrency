# Modifying Lock fairness

Constructor `ReentrantLock(boolean fair)` or `ReentrantReadWriteLock(boolean fair)`

* `false` is the default value, __non-fair mode__: when there are some threads waiting for a lock and the lock has to select one of them to get the access of critical section, it select one without any criteria.
* ` true` __fair mode__: when there are some threads waiting for a lock and the lock has to select one of to get the access of critical section, it selects the thread that has been waiting for the most time.

Note: The fair attribute only affect `lock()` and `unlock()` methods. As `tryLock()` method doesn't put the thread to sleep if the `Lock` interface is used.

e.g. [FairPrintQueue.java](modifying-lock-fairness/FairPrintQueue.java) [FairJob.java](modifying-lock-fairness/FairJob.java)
