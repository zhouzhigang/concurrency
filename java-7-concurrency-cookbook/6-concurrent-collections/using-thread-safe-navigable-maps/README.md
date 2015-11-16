# Using thread-safe navigable maps

The classes that implement the `ConcurrentNavigableMap` interface stores elements within two parts:

* A __key__ taht uniquely identifies an element
* The rest of the data that define the element

Each part has to be implemented in different classes.

`ConcurrentSkipListMap` interface that implements a non-blocking list with the behavior of the`ConcurrentNavigableMap` interface.
Internally, it uses a __Skip List__ to store the data. A Skip List is a data structure based on parallel lists that allows us to get efficiency similar to binary tree. With it, we can get a sorted data structure with a better access time to insert, search, or dlete elements than a sorted list.

When we insert an element in the map, it uses the key to order them, so all the elements will be ordered.The class also provides methods to obtain a submap of the map, in addition to the ones that return a concrete element.

* `put()`
* `firtEntry()`, `LastEntry()`
* `pollFirst()`, `pollLastEntry()`
* `subMap()`
* `headMap(K toKey)`, tailMap(K fromKey)`
* `putIfAbsent(K key, V value)`
* `replace(K key, V value)`
