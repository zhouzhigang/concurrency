# Using non-blocking thread-safe lists

The most basic collection is the __list__. A list has an undertermined number of elements and we can add, read, or remove the element of any position.

`ConcurrentLinkedDeque`
* `getFirst()`, `getLast()` return the first or last element. They don't remove the returned element. If the list is empty, it will throw `NoSuchElementException`.
* `peek()`, `peekFirst()` and `peekLast()` return the first and last element. They don't remove the returned element. If the list is empty, it will return a `null` value.
* `remove()`, `removeFirst()` and `removeLast()` return the first or last elelemnt, will remove the element. If empty, it will throw `NoSuchElementEception`.
* `poll()`, `pollFirst()`, `pollLast()` return first or last element, and remove. If empty, return `null`.
* `add()`, `addFirst()`, `addLast()` add in first or last position. If full, throw `IllegalStateException`.

Summary of Deque Methods
|      |First throws Exp.|First return val|Last Throws Exp.|Last return val|
+------+----------------+-----------------+----------------+---------------+
|Insert|addFirst(e)|offerFirst(e)|addLast(e)|offerLast(e)|
|Remove|removeFirst()|pollFirst()|removeLast()|pollLast()|
|Examine|getFirst()|peekFirst()|getLast()|peekLast()|

`add`, `remove`, `get` will throw exception.
`offer`, `poll`, `peek` will return a special value.
