# Using blocking thread-safe lists ordered by priority

All the elements to add to `PriorityBlockingQueue` have to implement the `Comparable` interface and override the `compateTo()` method.
The greater element will be the tail of the queue.
Another important characteristic of `PriorityBlockingQueue` is that it's a __blocking data structure__.

`PriorityBlockingQueue`
* `clear()` reomoves all the elements of the queue
* `take()` return and remove the first element of the queue
* `put(E e)` insert the element to the queuq
* `peek()` return the first element of the queue, doesn't remove it


