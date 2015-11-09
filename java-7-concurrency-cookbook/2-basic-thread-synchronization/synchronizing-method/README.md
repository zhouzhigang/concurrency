# Synchronizing a method

Every method declared with the `synchronized` keyword is a critical section and Java only allows the execution of one of the critical sections of an object.

Static methods have a different behavior.
Only one execution thread will access one of the static methods declared with the `synchronized` keyword, but another thread can access other nonstatic methods of an object of that class. Two threads can access two different synchronized methods if one is static and the other is not.

The `synchronized` keyword penalizes the performance of the application, so we must only use it on methods that modify shared data in a concurrent environment.

We can use the `synchronize` keyword to protect the access to a block of code instead of an entire method.

    synchronized(this) {
        // java code
    }

e.g. [Account.java](sychronizing-method/Account.java) [Bank.java](sychronizing-method/Bank.java) [Company.java](sychronizing-method/Company.java) [AccountTest.java](sychronizing-method/AccountTest.java)
