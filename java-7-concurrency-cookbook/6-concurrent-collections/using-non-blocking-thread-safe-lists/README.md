# Using non-blocking thread-safe lists

The most basic collection is the __list__. A list has an undertermined number of elements and we can add, read, or remove the element of any position.

`ConcurrentLinkedDeque`
* `getFirst()`, `getLast()` return the first or last element. They don't remove the returned element. If the list is empty, it will throw `NoSuchElementException`.
* `peek()`, `peekFirst()` and `peekLast()` return the first and last element. They don't remove the returned element. If the list is empty, it will return a `null` value.
* `remove()`, `removeFirst()` and `removeLast()` return the first or last elelemnt, will remove the element. If empty, it will throw `NoSuchElementEception`.

