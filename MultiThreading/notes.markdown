Multi-Threading Programming in Java

The latest operationg system allows us to excecute several programs simaltenously. This ability is known as multi-tasking. In system terminology it is called multi threading. Multi-Threading is a concept programming where a program is divided into two or more sub-programs or process which can be implemented at the same time in parallel. For example, one sub program can display an animation on screen while another may build next animation to be displayed on the screen. This is similar to dividing the task into sub tasks and assigning them to different people for execution independently and simultaneously.

We have only a simgle processor and therefore in reality the processor is doing one thing at a time. However, the processor switches between the process so fast that it appears that all of them are being done simultaneously.

Java programs that we have discussed so far contain only a single sequential flow of control, the programs begins, runs through various sequences of execution and finally ends at givent point of time but there is only one statement under execution. A thread is similar program that has a single flow of control, it has a beginning, body and an end and executed commands sequentially. In fact, all main programs in earlier examples can be called single threaded programs.

A unique property of java is its support for Multi-Threading. Java enables us to use multiple flows of control in a developing program. Each flow of control may be thought of a separate tiny program know as a thread that runs in parallel to the other. A program that contains multiple flows of control is known as multi-threaded program. A java program with four threads, one main and three others, the main thread is actual the main method module, which is designed to create and start the other three threads. Once initiated by the main method, the threads run concurrently and share the resources jointly.

The ability of a language to support various languages is referred to as concurrency. Since threads in java are sub programs of a main program and share main memory space, they are know as light weight threads or light weight processes.

It is important to remember that threads running in parallel does not really mean that they actually run in same time. Since all the threads are running on a single processor, the flow of exceution is shared between the threads. The java interpreter handles the switching of the control between the threads in such a way that it appears they are running concurrently.

Mulit-Threading is useful in many ways. It enables porgrammers to do multiple things at one time. They can divide a long program into threads and execute them in parallel. For example, we can send tasks such as printing in the background and continue to perform some other task in foreground. This approach would considerably improve the speed of our program.

Any application that we are working on will require two or more things to me done at the same time is probably a best one for use of our threads.

Difference between Multi-Threading and Multi-Tasking

Multi-Threading :- It is a programming concept in which a program or a process is divided into two or more sub programs or threads that are executed at the same time in parallel. It supports execution of multiple parts of a single program simultaneously. The processor has to switch between different parts or threads of a program. It is highly efficient. A thread is a smallest unit in multi-threading. It helps in developing efficient programs. It is cost effective in terms of context switching.

Multi_Tasking :- It is an operating system concept in which multiple tasks are performed simultaneously. It supports execution of multiple programs simultaneously. The processor has to switch between different programs or processes. It is less efficient in comparsion to multi-threading. The program or a process is a smallest unit in multi-tasking enviornment. It helps in developing efficient operating system. It is expensive in case on context switching.

Thread creation

Threads creation in java is simple. They are implemented in the form of objects that contain a method called run. The run method is the heart and soul of any thread. It makes the entire body of the thread and is the only method in which threads behaviour can be implemented following is the syntax for the run method :-

        public void run(){}

The run method should be invoked by the object of the concerned thread. This can be achieved by creating a thread and initiating it with a thread of another method called the start. A new thread can be created into two ways

1. by creating a thread class
2. by converting a class to thread

The approach to be used depend upon the use of the class. If it requires to extend another class then we have no choice but to implement the runnable interface, since java classes cannot have two super classes.

//

1. Starting a Thread

To create and run an instance of a thread class we must follow a. create a object of thread based class The thread is in new born state, b. call the start method causing the thread to move into the runnable state then the java runtime will scehulde the thread to run for invoking its run method. Now the thread is said to be in running state.

2. Can be call the run method directly

Whenever a run method is invoked by the start method the thread starts in separate call stack. However invoking the run method directly from the main method causes the corresponding state to go into current call stack that are main thread. Since the direct call to the run method from the main does not create a separate call stack, its instructions are executed sequencly and non parallely, thus calling the run method directly causes the program to behave like normal single threaded program.

3. Stopping a thread

Whenever we want to stop a thread from running further we may do so by calling its stop method. This causes the thread to move the dead state. A thread will also move to the dead state automatically when it reaches the end of its method. The stop method may be used when the premature death of a thread is required. A thread can be blocked or stopped temporarly by running state by using either of a following thread methods. First, sleep:- blocked for specific time. Second, Suspend:- blocked until further orders. Third, wait:- Blocked until further conditions occur. This methods cause the thread to go into the blocked state, the thread will return to the runnable state when the specified time is elapsed in the case of sleep method, The resume() is invoked in terms of suspend method and notify() is the terms of wait method.

4. LifeCycle of a thread

During a life cycle of a thread, it may enter many states which include:- new born state, runnable state, running state, blocked state, dead state.

New born state:- When we create a thread object, a thread is born and is said to be in new born state. The thread is not yet scehuled for running. At this state we can do only one of the following things with it, first, sechulde it to start at run method, second, kill it using stop method.

Runnable state:- The runnable state means that Thread is ready for execution and is waiting for the availablity of the processor, that is, the thread has joined the queue of threads that is waiting for the execution. If all threads have equal priority then they are given time slots for execution in round robin fashion, that is, first come first serve manner. The thread that relinquishes control joins the queue at a end and again waits for it run. This process of assigning time to threads is known as time slicing. However, if we want a thread to relinquish the control to another thread to its equal priority before its turn comes, we can do so by using the yield() method.

Running state:- It means that the processor has given its time to the thread, for its execution. The thread runs until it relinquishes control on its own, or it is preempted by a higher priority thread. A running thread may relinquish its control in one of the following situations. It has been suspended using suspend() method. A suspended thread can be revived by using the resume method. This approach is useful when we want to suspend a thread for sometime due to certain reasons but do not want to kill it. second, it has been made to sleep, we can put a thread to sleep for specified time period using the method sleep where time is in millisecond. This means that the thread is out of the queue during this time period. The thread reenters the runnable state as soon as this time period is elapsed. It has been told to wait until some even occurs, this is done using the wait(). The thread can be scheduled to run again using notify().

Blocked state:- A thread is said to be blocked when it is prevented from entering into the runnable state and subsequently in the running state. This happens when the thread is suspended, sleeping or waiting in order to satisfy certain requirements. A blocked thread is considered not runnable but not dead and therefore its is fully qualified to run again.

Dead state:- Ever thread has a life cycle, a running thread ends its life when it has completed the run method. Its is a natural death. However we can kill it by sending the stop() to it at any state thus causing a premature death to it. A thread can be killed as soon as it is born or while it is running or even when it is in not runnable state.

//
Thread Synchronization

When two or more threads need access to a shared resource, they need some way to ensure that the resource will be used by only one thread at a time. The process by which this is achieved is called thread synchronization. Key to synchronization is the concept of the monitor. A monitor is an object that is used as a mutually exclusive lock or mutaex. Only one thread can own a monitor at a given time. When a thread acquires a lock it is said to have entered the monitor. All other threads attempting to enter the locked monitor will be suspended until the first thread exists on the monitor, this other threads are said to be waiting for the monitor. A thread that owns a monitor can reenter the same monitor if it so desires.

IF you have worked with synchronization when using other languages such as C or CPP, we know that it can be a bit tricky to use, this is because these languages do not, themselves support synchronization instead to synchronize thread your program needs to use os primitive. Forunately, java implements synchronization through language element, most of the complexity associated with synchronization has been eliminated.

We can synchronize our code by either of two ways both envolve the use of synchronize keyword.

1. Using synchronized method :- Synchronization is easy in java because all objects have there implicit monitor with them, to enter a objects monitor, just call a method that has been modified with synchronized keyword. While a thread is inside a synchronized method, all other thread that try to call it on the same instance have to wait. To exit the monitor and relinquish the control of the object to the next waiting thread, the owner of the monitor simply returns from the synchronized method.

2. The synchronized statement :- While creating synchronized method within classes that we created is an easy and effect means of achieving the synchronization, it will not work in all cases. To understand why consider the following situation, Imagine that we want to synchronize access to the objects of a class that was not designed for multi threading access. That is the class does not use synchronized method. Further this class was not created by us, but by a third party and we do not have the access to the source code. Does we cannot add synchronized to the appropriate method within the class. Now how can a access to an object of this class be synchronize. The solution to this object is simple, just put a call to the method defined by the class inside the synchronized block. This is a general form of the synchronized sequence

synchronized(object){
// code
}

2. here the object is the reference to the object being synchronized. A synchronized block ensures that a call to the method that is it is a member of objefct occures after the current thread has successfully entered the objects monitor.

//
Producer and Consumer

The programs developed using synchronized keyword unconditionally block other threads from asynchronized access to certain methods. This use of the implicit monitor in java objects is powerful but we can achieve more subtle(very clever/ use of clever and indirected method to achieving something). level of control through Inter-process communication. This is especially easy in java.

Multi-Threading replaces event Loop Programming by dividing our task into discrete logical units. Threads also provide secondary benefit, they do way with polling. Polling is usually implemented by a loop that is used to check some condition repeatedly. ONce the condition is true appropriate action is taken, this wastes CPU time for example, consider the queueing problem, very one thread is producing some data and another is consuming it, to make the problem more interesting suppose the porducer has to wait until the consumer has to wait until it generates some more data. In a polling system, the consumer would waste many CPU cycles. while it waited for the producer to produce. Once the producer was finished it would start polling, wasting more CPU cycles waiting for the consumer to finish and so on.

To avoid polling, Java includes an elegant interprocess communication mechanism via the methods wait(), notify() and notifyAll(). This methods are implemented as final method for class object. So all the classes have them, all the three methods can be called from within a synchronzied context. Although conceptually advanced from the CS preseptive the rules for using this methods are actually quiet simple.

The rules are :-

1. wait() tells the calling the thread to give up the monitor and go to sleep until some other thread enters the same monitor and calls notify.
2. notify() method wakes up a thread that calls wait on the same objects.
3. notifyAll() wakeups all the thread that call wait on the same objects. One of the thread will be granted access.

This methods are decalred inside the class object because before working through a example that illustrates inter thread communication and important point needs to be made although wait() normally waits until notify() or notifyAll() method is called, there is a possiblity at in various cases the waiting thread maybe wakedend by a furios, In this case a waiting thread wakeups without any method being called. Sun recommends that call to wait() should take place within the loop that checks the condition on which the thread is waiting.
