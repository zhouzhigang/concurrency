# Changing data between concurrent tasks

`Exchanger` allows the definition of a synchronization point between two threads, when the two threads arrive to this point, they interchange a data structure.
It's very useful in a situation similar to the producer-consumer problem. This is a classic concurrent problem where we have a common buffer of data, one or more producers of data, and one or more consumers of data. As the `Exchanger` class only synchronizes two threads, we can use it if we have a producer-consuer problem with one producer and one consumer.

* `exchange(V data) 
* `exchange(V data, long time, TimeUnit unit)` the thread will be sleeping until it's interrupted, the other thread arrives, or the specified time pass.

e.g. Use the `Exchanger` class to solve the __producer-consuer__ problem with one producer and one consumer.
