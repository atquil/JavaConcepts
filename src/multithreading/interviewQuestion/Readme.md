# Multi-threading-interview-question
 
## Q) What is MultiTasking And Its types? 

 Performing  multiple tasks at one time . There are 2 types of multitasking :
1. Process based multitasking 
2. Thread based multitasking

## Q) What is Multi-threading & how is it diff from multitasking? [Multi-tasking,ProcessBaed] [Multi-threading,ThreadBased]

**Multithreading is a specialized form of multitasking.**

1. **Process-based multitasking** is executing several tasks simultaneously where each task is a separate independent process is Process-based multitasking .
For example, process based multitasking enables you to run the Java IDE at the same time that you are using a text editor or visiting a web site using chrome.

2. **Thread-based multitasking** is executing several tasks simultaneously where each task is a separate independent part of the same program (called Thread).
For instance,JUnit uses threads to run test cases in parallel. As an application, you can have computer games. You see objects in games like cars, motor bikes etc. They are just threads that run in the game application.

Thus, process-based multitasking deals with the “big picture,” and thread-based multitasking handles the details


### Q) Which is better process based multitasking or thread based multitasking and why ?

Thread based multitasking is better.

1. Multitasking threads require less overhead than multitasking processes. 
2. Processes are heavyweight tasks that require their own separate address spaces. Threads, on the other hand, are lighter weight. They share the same address space and cooperatively share the same heavyweight process.
3. Interprocess communication is expensive and limited. Context switching from one process to another is also costly. 
4. Inter Thread communication is inexpensive, and context switching from one thread to the next is lower in cost.

While Java programs make use of process-based multitasking environments, process-based multitasking is not under Java’s direct control. However, multithreaded multitasking is.

### Q) What is a Thread

Threads are light-weight processes within a process.
Java creates threads by using a **"Thread Class"**.

All Java programs have at least one thread, known as the **main thread**, which is created by the Java Virtual Machine (JVM) at the program’s start, when the main() method is invoked with the main thread.

### Q) Types of Thread in java -> Demon, Main

There are two types of thread – **user thread** and **daemon thread**.

### Q) What is demon thread?
Not a main thread, which is generally used for garbage collection. JVM can exit whithout finishing the demon thread.

We can setDemon(true) to a thread, and can check using currentThread().isDemon()
### Q) How to create a user thread in Java
Thread implementation in java can be achieved in two ways:

1. **Extending** the java.lang.Thread class
2. **Implementing** the java.lang.Runnable Interface


When the JVM starts, it creates a thread called “Main”. Your program will run on this thread, unless you create additional threads yourself. The first thing the “Main” thread does is to look for your static void main (String args[]) method and invoke it. That is the entry-point to your program. If you create additional threads in the main method those threads would be the child threads of main thread.

### Q) Which one is better extending or implementing?

When only one class to extend then extend Thread (not supported multiple inheritance), otherwise implment runnable

### Q) What is the task of Thread Scheduler?

If multiple Threads are waiting to execute, then thread scheduler which is a part of JVM decides. So, we can know about the output, but not the sequence. 


### Q) How to start a thread ?
thread.start() will call the run() method of the thread.

### Q) Difference between start() and run() method ?
when we  call start() it will create the chold thread, but if we directly call run() method , it will work as a normal method.

### Q) What are the task of Start()?
Register the task to TaskSchedular and call main

### Q) What if we don't override run() method: 
It will go the Thread.class and run it's run method() which will not do anything.

### Q) Can we overload the run(): run(int j)
Yes you can do, but then we will lose the thread, and it will run by main theread only as run in Thread.class has no parameter.

### Q) Can we restart the same thread using threadName.start()?
No , will through IlleagelThreadStateException

### Q) What is thread priority? 
Range from [1-10], main thread at 5, ThreadSchedular will give, we can also set using myThread.setPriority(7). if more then 10 then IllegalThreadArgumentException

## Advanced Questions: 

### Q) What is the different between FORK/JOIN and Executor Service

The Fork/Join framework is an extension to the Executor framework that is designed for recursive algorithms where tasks can be split into smaller sub-tasks until they reach a base case. It provides tools to help speed up parallel processing by attempting to use all available processor cores. It accomplishes this through a divide and conquer approach. 

The ExecutorService is better suited for tasks that can be parallelized but are not recursive. 

**Java API: parralSort()** it leverages concurrency via the form/join framework, thus make sorting faster in multi-core machine


| Features          | Fork/Join               | Executor                    |
|-------------------|-------------------------|-----------------------------|
| Task partitioning | Recursive Parallel Task | Non recursive Parallel task |        
|                   |                         |                             |

### Q) Is the executor task stop automatically? 

No, we need to explicitly shutdown the thread using `**executorName.shutdown()**` method.

### Q) Is there any way to wait for process to finish in executor?

Yes, we can use `executorThreadName.awaitTermination(Duration,TimeUnit)` to wait for the shutdown to occur. 

### Q) What is the difference between submit(Runnable) and submit(Callable) ?

submit(Runnable) will return null, as Runnable return type for run() is void. 

submit(Callable) will return the value similar to supplyAsync. 

### Q) What are the exception thrown by thread?

ExecutionException, InterruptedException

### Q) What is the use of invokeAny vs invokeAll?

invokeAny: When out of List<Callable<Object>> futureObject any one needs to be executed. Return object. 
invokeAll: When all needs to be invoked. Return List<Future<Object>>

### Q) Explain CompletableFuture? 

### Q) What is the difference between runAsync and supplyAsync?

runAsync: no return type
sypplyAsync: return CompletableFuture<Object>.

### Q) What is the synchronised() method in thread. 

As name suggest, it will put a Lock on thread till the work is completed . 

### Q) What do you mean by CountDownLatch ?

A CountDownLatch is a synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes. It is initialized with a count representing the number of threads that need to complete before the waiting thread can proceed

by using **latch.await()** it will wait till countdown reaches to 0 then only it moves ahead. 

### Q) What is ThreadLocal, and when it is used?

It enables you to create variables that can only be read and write by the same thread. If two threads are executing the same code and that code has a reference to a ThreadLocal variable then the two threads can’t see the local variable of each other
