# Interrupting a thread

* `interrupt()` set interrupted flag as true.
* `isInterrupted()` check whether the thread has been interrupted or not, didn't change `interrupted` attribute - Recommented
* `Thread.interrupted()` check whether current executing thread has been interrupted or not, set the `interrupted` as false

e.g.[PrimeGenerator.java](interrupting-thread/PrimeGenerator.java)

Thread can ignore its interruption, but this is not the expected behavour.
