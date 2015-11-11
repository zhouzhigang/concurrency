# Creatinga Fork/Join pool

* Creating a `ForkJoinPool` object to execute the tasks
* Creating a subclass of `ForkjoinTask` to be executed in the pool

Steps
* Create `ForkJoinPool` using the default constructor
* Inside the task, using the following structure recommended by Java API

    if (problem size > default size) {
        task = divide(task);
        execute(task);
    } else {
        resolve problem using another algorithm;
    }

* Execute the tasks in a synchronized way
* Take the `RecursiveAction` class as the base class to collect the results.
