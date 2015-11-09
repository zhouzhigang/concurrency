# Synchronizing data access with read/write locks

One of the most significant improvements offered by locks is the `ReadWriteLock` interface and `ReentrantReadWriteLock` class.
The class has two locks, one for read and one for write. There can be more than one thread using read operatons simultanously, but only one thread can be using write operations. When a thread is doing a write operation, there can't be any thread doing read operations.

Example: [PricesInfo.java](synchronizing-data-access-with-read-write-lock/PricesInfo.java) [Reader.java](synchronizing-data-access-with-read-write-lock/Reader.java) [Writer.java](synchronizing-data-access-with-read-write-lock/Writer.java) [ReadWriteLockTest.java](synchronizing-data-access-with-read-write-lock/ReadWriteLockTest.java)


