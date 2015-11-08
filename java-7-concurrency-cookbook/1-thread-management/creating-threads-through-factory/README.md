# Creating threads through a factory

Factory pattern

* easy to change the class of the objects created or the way we create these objects
* easy to limit the creation of objects for limited resources
* easy to generate statistical data about the creation objects

__ThreadFactory__ interface to implement a Thread object factory. It has only one method called `newThread`.

e.g. [MyThreadFactory.java](creaing-threads-through-factory/MyThreadFactory.java) [FactoryTask.java](creaing-threads-through-factory/FactoryTask.java)

