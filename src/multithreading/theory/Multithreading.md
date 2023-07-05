# Multithreading Best Practice


Multithreading is the ability of an operating system to have numerous threads in memory at the same point in time with the illusion that all these threads are executing concurrently

1. **Avoid race conditions and deadlocks**: Race conditions occur when two or more threads access a shared resource at the same time and try to modify it. Deadlocks occur when two or more threads are blocked waiting for each other to release a lock.
2. Use `synchronization` when **accessing shared resources**: Synchronization ensures that only one thread can access a shared resource at a time. Do not access shared resources without first obtaining a `lock` on them.
3. **_Avoid using `wait()` and `notify()`_**: These methods can cause deadlocks if not used correctly.
4. **Use thread pools**:  Thread pools can help you manage the number of threads in your application and avoid creating too many threads.
5. **Prioritize lock ordering**: If you `need to acquire multiple locks`, always acquire them in the same order to avoid deadlocks.
6. Use **`volatile fields`**: Volatile fields ensure that changes made by one thread are visible to other threads.
7. **Avoid** using `thread-local` variables: Thread-local variables **can cause memory leaks** if not used correctly as difficult to manage and maintain in complex applications involving many threads and objects
8. **Keep synchronization blocks fast**: Synchronization blocks should be as short as possible to minimize the amount of time that other threads are blocked.
9. Use `Executre`: Creating a new thread is costly, thus executor leverage thread-pool. 