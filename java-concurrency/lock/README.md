# Lock

## Lock and ReadWriteLock interface

    public interface Lock {
        void lock();
        void lockInterruptibly() throws InterruptedException;
        boolean tryLock();
        boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
        void unlock();
        Condition newCondition();
    }

    public interface ReadWriteLock {
        Lock readLock();
        Lock writeLock();
    }

## AbstractOwnableSynchronizer


## AbstractQueuedSynchronizer

## AbstractQueuedLongSynchronizer

## ReentrantLock
