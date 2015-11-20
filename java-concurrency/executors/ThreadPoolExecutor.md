# ThreadPoolExecutor

An `ExecuteService` that executes each submitted task using one of possibly several pooled threads, normally configured using `Executors` factory methods.

Thread pools address two different problems: 
* improved performance when executing large numbers of asynchronous tasks.
* maintains some basic statistics, such as the number of completed tasks.

## Signature

    public class ThreadPoolExecutor extends AbstractExecutorService

## Fields

    // The queue used for holding tasks and handing off to worker threads.
    private final BlockingQueue<Runnable> workQueue;
    // Lock held on access to workers set and related bookkeeping.
    private final ReentrantLock mainLock = new ReentrantLock();
    // Set containing all worker threads in pool
    private final HashSet<Worker> workers = new HashSet<Worker>();
    // Wait condition to support awaitTermination
    private final Condition termination = mainLock.newCondition();

    private int largestPoolSize;
    private long completedTaskCount;

    private volatile ThreadFactory threadFactory;
    private volatile RejectedExecutionHandler handler;

    // Core pool size is the minimum number of workers to keep alive
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;


## Constructors

There are four constructors. Others will call the constructor with 7 parameters.

    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler)


