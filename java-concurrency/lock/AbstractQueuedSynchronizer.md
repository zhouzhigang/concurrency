# AbstractQueuedSynchronizer

Provides a framework for implementing blocking locks and related synchronizers (semaphores, events, etc) that rely on first-in-first-out (FIFO) wait queues.

## Signature

    public abstract class AbstractQueuedSynchronizer
        extends AbstractOwnableSynchronizer
        implements java.io.Serializable 

    public abstract class AbstractOwnableSynchronizer
        implements java.io.Serializable

## Theory

"CLH" (Craig, Landin, and Hagersten) lock queue.
CLH locks are normally used for spinlocks.  We instead use them for blocking synchronizers, but use the same basic tactic of holding some of the control information about a thread in the predecessor of its node.

         +------+  prev +-----+       +-----+
    head |      | <---- |     | <---- |     |  tail
         +------+       +-----+       +-----+

## Fields

    private transient volatile Node head;
    private transient volatile Node tail;
    private volatile int state;

    static final class Node {
    }


## Reference
* [A Hierarchical CLH Queue Lock](http://www.cs.tau.ac.il/~shanir/nir-pubs-web/Papers/CLH.pdf)

