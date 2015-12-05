# Controlling a task finisheing in an executor

The `FutureTask` class provides a method called `done()` that allows us to execute some code after the finalization of a task executed in an executor.
It can be used to make some post-process operations, generating a report, sending results by e-mail, or releasing some resources.

