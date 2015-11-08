# Creating and running a daemon thread

Daemon thread has very low priority and normally only executes when no other thread of the same program is running.
When daemon threads are the only threads running in a program, the JVM ends the program finishing these threads.
The daemon threads are normally used as service providers for normal(also called user) threads running in the same program. They usually have infiniate loop that wait for the service request or performs the tasks of the thread.
A typical example of these kind of threads is the Java garbage collector.

* `setDaemon(true)` mark the thread as a daemon thread, we only can call this method before call the `start()` method. Once the thread is running, we can't modify its daemon status.
* `isDaemon()` check if a thread is a daemon thread or user thread.

e.g. [Event.java](creating-running-daemon-thread/Event.java) [WriterTask.java](creating-running-daemon-thread/WriterTask.java) [CleanerTask.java](creating-running-daemon-thread/CleanerTask.java) [Daemon.java](creating-running-daemon-thread/Daemon.java)

