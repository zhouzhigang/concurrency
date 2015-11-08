# Creating and running a thread

* extends `Thread` class and overriding the `run()` method
* implements `Runnable` interface and Creating an object of `Thread` passing `Runnable` object as a parameter

e.g. [Calculator.java](creating-running-thread/Calculator.java)

Note: only call `start()` method creates a new execution thread.
The `start()` method will call `run()` method.
