# CurrentHashMap

The primary design goal of this hash table is to maintain concurrent readability (typically method `get()`, but also `iterators` and related methods) while minimizing update contention.
Secondary goals are to keep space consumption about the same or better than `java.util.HashMap`, and to support high initial insertion rates on an empty table by many threads.

## Signature

    public class ConcurrentHashMap<K,V> extends AbstractMap<K,V>
        implements ConcurrentMap<K,V>, Serializable

## Attributes

    // The array of bins. Lazily initialized upon first insertion.
    // Size is always a power of two. Accessed directly by iterators.
    transient volatile Node<K,V>[] table; // jdk 8
    final Segment<K,V>[] segments; // jdk 7

    // The next table to use; non-null only while resizing.
    private transient volatile Node<K,V>[] nextTable;
    // Base counter value, used mainly when there is no contention,
    // but also as a fallback during table initialization races. Updated via CAS.
    private transient volatile long baseCount;
    // Table initialization and resizing control.
    private transient volatile int sizeCtl;

### Constants

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final int DEFAULT_CAPACITY = 16;
    static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    private static final float LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8;
    static final int UNTREEIFY_THRESHOLD = 6;
    static final int MIN_TREEIFY_CAPACITY = 64;
    private static final int MIN_TRANSFER_STRIDE = 16;
    
    static final int NCPU = Runtime.getRuntime().availableProcessors();

### Nodes

__Jdk 8__

    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        volatile V val;
        volatile Node<K,V> next;
    }

__Jdk 7__

    static final class Segment<K,V> extends ReentrantLock implements Serializable {
        transient volatile HashEntry<K,V>[] table;
        transient int count;
        transient int modCount;
        transient int threshold;
        final float loadFactor;
    }

    static final class HashEntry<K,V> {
        final int hash;
        final K key;
        volatile V vlaue;
        volatile HashEntry<K,V> next;
    }

## Constructors

    public ConcurrentHashMap(int initialCapacity,
                                 float loadFactor, int concurrencyLevel) {
        if (!(loadFactor > 0.0f) || initialCapacity < 0 || concurrencyLevel <= 0)
            throw new IllegalArgumentException();
        if (initialCapacity < concurrencyLevel)   // Use at least as many bins
            initialCapacity = concurrencyLevel;   // as estimated threads
        long size = (long)(1.0 + (long)initialCapacity / loadFactor);
        int cap = (size >= (long)MAXIMUM_CAPACITY) ?
            MAXIMUM_CAPACITY : tableSizeFor((int)size);
        this.sizeCtl = cap;
    }

## Methods

### Static Utilities

    // Spreads (XORs) higher bits of hash to lower and also forces top bit to 0.
    static final int spread(int h) {
         return (h ^ (h >>> 16)) & HASH_BITS;
    }

    // Returns a power of two table size for the given desired capacity.
    // See Hackers Delight, sec 3.2
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

### get

### put

### size


