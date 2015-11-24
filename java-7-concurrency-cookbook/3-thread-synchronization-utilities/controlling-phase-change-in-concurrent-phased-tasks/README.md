# Controlling phase change in concurrent phased tasks

`Phaser` provides a method that is executed each time the phaser changes the phase.

* `onAdvance()` method receives two parameters: the number of the current phase and the number of registered participants; it returns a `Boolean` value, `false` if the phaser continues its execution(the number of registered paticipants is zero).
* `arriveAndAwaitAdvance()` 
* `register()` register a paritcipant in the phaser

We can also extend the `Phaser` class and override the `onAdvance()` method when we have to execute some actions when we advance from one phase to the next one.

e.g. 
Control the phase change in a phaser that is implementing our own version of the `Phaser` class that overrides the `onAdcance()` method to execute some actions in every phase change.
Simulate an exam, all the students have to finish one exercise before they can proceed with the next one.
