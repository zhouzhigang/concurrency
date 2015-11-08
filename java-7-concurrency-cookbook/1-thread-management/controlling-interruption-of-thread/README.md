# Controlling the interruption of a thread

* detect by `isInterrupted` - simple algorithm
* throw `InterruptedException` and catch in `run()` method - a better mechanism to control the interruption of thread

e.g. [FileSearch.java](controlling-interruption-of-thread/FileSearch.java)

Note: The `InterruptedException` is thrown by some java methods related with the concurrency API such as `sleep()`.
