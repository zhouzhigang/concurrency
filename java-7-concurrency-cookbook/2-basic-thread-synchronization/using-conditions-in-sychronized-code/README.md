# Using conditions in synchronized code

__Producer-Consumer__ proble: we have a data buffer, one or more producers of data that save it in the buffer and one or more consumers of data that take it from the buffer.

As the buffer is a shared data structure, we have to control the access to it using a synchronization mechanism such as `synchronized` keyword, but we have more limitations.
A producer can't save data in the buffer if it's full and the consumer can't take data from the buffer if it's empty.

* `wait()` inside a `synchronized` block of code. If outside, the JVM will throw `IllegalMonitorStateException`. When the thread call `wait()` method, the JVM puts the thread to sleep and releases the object that controls the `sysnchronized` block of code that it's executing and allows the other threads to execute other blocks of `synchronized` code protected by that object.
* `notify()` or `notifyAll()` to wake up the thread

We have to keep checking the conditions and calling the `wait()` method in a while loop(can't continue until the condition is true).

Example: [EventStorage.java](using-conditions-in-sychronized-code/EventStorage.java) [Producer.java](using-conditions-in-sychronized-code/Producer.java) [Consumer.java](using-conditions-in-sychronized-code/Consumer.java) [ProducerConsumerTest.java](using-conditions-in-sychronized-code/ProducerConsumer.java)
