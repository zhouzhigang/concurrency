# Waiting for finalization of a thread

* `join()`  it suspends the execution of the calling thread until the object called finishes its execution.
* `join(long milliseconds)`
* `join(long milliseconds, long nanos)`

e.g. [DataSourcesLoader.java](waiting-for-finalization-of-thread/DataSourcesLoader.java) [NetworkConnectionsLoader.java](waiting-for-finalization-of-thread/NetworkConnectionsLoader.java) [WaitingFinalization.java](waiting-for-finalization-of-thread/WaitingFinalization.java)
