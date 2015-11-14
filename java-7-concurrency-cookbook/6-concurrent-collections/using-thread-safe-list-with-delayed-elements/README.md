# Using thread-safe lists with delayed elements

`DelayedQueue` can store elements with an activation date. The methods that return or extract elements of the queue will ignore those elements whose data is in the future.

The elements to store in `DelayedQueue` have to implement the `Delayed` interface. This interface forces to implement the floowing two methods:
* `compareTo(Delayed o)`: The `Delayed` interface extends the `Comparable` interface
* `getDelay(TimeUnit unit)`: return the time remaining until the activation date in the units is specified by the unit parameter.


