# Joining the results of the tasks

The Fork/Join framework provides the ability of executing tasks that return a result. These kinds of tasks are implemented by the `RecursiveTask` class. This class extends the `ForkJoinTask` class and implements the `Future` interface provided by the Executor framework.

    if (problem size > size) {
        tasks = Divide(task);
        execute(tasks);
        groupResults();
        return result;
    } else {
        resolve problem;
        return result;
    }


