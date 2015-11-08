# Using local thread variables

__`ThreadLocal`__ create an attribute that won't be shared between all the threads that using the same Runnable object

* `initialValue()` assign a value for that thread and return the initial value
* `get()` read the value of a thread-local variable
* `set()` change the value of a thread-local variable
* `remove()` delete the value stored in the thread-local variable

__`InheritableThreadLocal`__ provides inheritance of values for threads created from a thread.
We can override the `childValue()` method that is called to initialize the value of the child thread in the thread-local varible.

e.g. [UnsafeTask.java](using-local-thread-variables/UnSafeTask.java) [SafeTask.java](using-local-thread-variables/SafeTask.java)
