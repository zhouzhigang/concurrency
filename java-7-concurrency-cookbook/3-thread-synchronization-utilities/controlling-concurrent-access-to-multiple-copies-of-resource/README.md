# Controlling concurrent access to multiple copies of a resource

Semaphore not only can protect the access to one shared resource/critical section, but also can be used when we need to protect various copies of a resource, or when a critical section that can be executed by more than one thread at the same time.

The `acquire()`, `acquireUninterruptibly()`, `tryAcquire()`, and `release()` methods have an additional version which has an `int` parameter.
This parameter represents the number of permits that the thread that use them wants to acquire or release, so as to say, the number of units that this thread wants to delete or to add to the internal counter of the semaphore.
If the value of this counter is less than this value, the thread will be blocked until the counter get this value or a greater one.

