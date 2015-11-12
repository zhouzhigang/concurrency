# Using blocking thread-safe lists

The main difference between blocking lists and non-blocking lists is that blocking lists has methods to insert and delete elements on it that, if they can't do the operation immediately, because the list is full or empty, they block the thread that make the call until the operation can be made.

`LinkedBlockingDeque`
* `take()`, `takeFirst()` and `takeLast()` return first or last element, and remove. If empty, block the thread until there are elements in the list.
* `getFirst()`, `getLast()` return first or last element, don't remove. If empty, throw `NoSuchElementException`.
* `peek()`, `peekFirst`, `peekLast()` return first or last element, don't remove. If empty, return `null`.
* `poll()`, `pollFirst()`, `pollLast()` return first or last element, and remove. If empty, return `null`.
* `add()`, `addFirst()`, `addLast()` add in first or last position. If full, throw `IllegalStateException`.


