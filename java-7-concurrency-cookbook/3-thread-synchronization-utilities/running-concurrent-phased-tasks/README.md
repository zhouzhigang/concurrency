# [Running concurrent phased tasks](running-concurrent-phased-tasks)

`Phaser` when we have some concurrent tasks divided into steps, `Phaser` provides us with the mechanism to synchronize the threads at the end of each step, so no thread start its second step until all the threads ahve finished the first one.

We have to initialize the `Phaser` class with the number of tasks that participate in the synchronization operation, but we can dynamically modify this number by increasing or decreasing it.

