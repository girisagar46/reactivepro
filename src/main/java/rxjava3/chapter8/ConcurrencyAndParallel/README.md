1. Computation Scheduler
  - Where lot of calculation is happening
  - Num of threads >= Num of available cores
  - Prefer computation scheduler by default

2. IO Scheduler
  - For IO bound job (DB operations, HTTP operation, File operations)
  - Num of threads > Num of available cores

3. NewThread scheduler
  - Create 1 thread per Observer and then destroy thread when done
  - Threads are not reused
  - Create and destroy thread

4. Single Scheduler
  - Helps in performing non-thread safe operation in a thread
  - One thread responsible to do all the task by all the observers sequentially

5. Trampoline Scheduler
  - Prevents recursive schedule task
  - Generally this is not used in practice however, it's used internally by RxJava

6. Scheduler.from()
  - Factory scheduler
