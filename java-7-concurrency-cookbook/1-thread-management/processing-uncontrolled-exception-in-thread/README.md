# Processing uncontrolled exceptions in a thread

* __Checked exceptions__ must be specified in the throws clause of a method or caught inside them. e.g. `IOException`, `ClassNotFoundException`
* __Unchecked exceptions__ don't have to be specified or caught. e.g. `NumberFormatException`

When an unchecked exception is thrown inside the `run()` method of a Thread object, the default behaviour is to write the stack trace in the console and exit the program.
Fortunately, Java provide a mechanism to catch and treat unchecked exceptions thrown in a Thread object to avoid program ending.

* `UncaughtExceptionHandler` interface, `uncaughtException()` method
* `ThreadGroup` handler for a group of threads
* `Thread.setDefaultUncaughtException()` the default handler for all the thread objects

e.g. [ExceptinHandler.java](processing-uncontrolled-exception-in-thread/ExceptionHandler.java) [ExceptionTask.java](processing-uncontrolled-exception-in-thread/ExceptionTask.java)
