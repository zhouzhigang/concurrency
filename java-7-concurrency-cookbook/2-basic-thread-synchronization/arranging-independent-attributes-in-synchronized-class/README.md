# Arranging independent attributes in synchronized classes

When we use the `synchronized` keyword to protect a block of code, we must pass an object reference as a parameter.

If we have two independent attributes in a class shared by mutiple threads, we must synchronize the access to each variable, but there is no problem if there is one thread accesssing one of the attributes and another thread accessing the other at the same time.

e.g. [Cinema.java](arranging-independent-attributes-in-synchronized-class/Cinema.java) [TicketOffice1.java](arranging-independent-attributes-in-synchronized-class/TicketOffice1.java) [TicketOffice2.java](arranging-independent-attributes-in-synchronized-class/TicketOffice2.java) [CinemaTest.java](arranging-independent-attributes-in-synchronized-class/CinemaTest.java)
