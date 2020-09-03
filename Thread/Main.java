

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(final String args[]) {

        System.out.println(Thread.currentThread().getName());
        List<Thread> threadsList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {

                try {
                    Thread.sleep(400);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " interrupted");
                    // throw new InterruptedException(e);
                }

            });
            threadsList.add(thread);
            thread.start();

        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException sleep " + e);
        }
        System.out.println("Main post sleep");

        threadsList.get(0).interrupt();
        threadsList.forEach((t) -> {
            try {
                t.join(); // wait on the parent thread for the child to finish
            } catch (InterruptedException e) {
                System.out.println("InterruptedException join " + e);
            }
        });

        System.out.println("----------------------");
        // ExecutorService
        // newFixedThreadPool

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("coreCount: " + coreCount);

        ExecutorService service = Executors.newFixedThreadPool(coreCount); // create pool of threads upfront
        for (int i = 0; i < 20; i++) {
            final int index = i;
            // submit tasks to execution
            // each threads will fetch the next task from the queue and execute it
            // queue uses locks internally(blocking queue), if multiple threads attempt to
            // take the same task at the same time
            service.execute(() -> {
                System.out.println("i: " + index + ", name " + Thread.currentThread().getName());

                System.out.println("A: " + TLocal.threadLocal2.get()); // each thread will get its own copy
                System.out.println("B: " + TLocal.threadLocal2.get()); // therefore no synchronization, locks, etc
                                                                       // required
            });
        }

        // LifeCycle methods
        System.out.println("pre shutdown");
        // after last submit, you shutdown the pool, submitted jobs will continue to run
        // (jobs that are in the blocking queue)
        // does not block
        // initiate shutdown
        service.shutdown();
        System.out.println("post shutdown");

        // service.isShutdown(); // if shutdown has started
        // service.isTerminated(); // if all tasks have completed following shut down

        // complete the tasks that are currently running, not initiate tasks that are
        // queued (jobs that are in the blocking queue)
        // returns the tasks that are queued, but the execution was not initiated
        // List<Runnable> runnables = service.shutdownNow();

        try {
            // Blocks until all tasks have completed execution after a shutdown request, or
            // the timeout occurs,
            // or the current thread is interrupted, whichever happens first.
            // similar to thread.join()
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException awaitTermination " + e);
        }
        System.out.println("post awaitTermination");

        // newCachedThreadPool

        ExecutorService service2 = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int index = i;
            // submit tasks to execution
            // no fixed number of threads
            // no queue to hold the number of tasks, replaced by a synchronous queue of a
            // single task
            // each time a task is submitted, if no available threads, a new one is created
            // if a thread is idle for 60 seconds (no tasks to execute), then kill the
            // thread

            service2.execute(() -> {
                System.out.println("cached i: " + index + ", name " + Thread.currentThread().getName());

            });
        }
        service2.shutdown();

        // newScheduledThreadPool

        /*
         * ScheduledExecutorService service3 =
         * Executors.newScheduledThreadPool(coreCount); // schedule // ex: run after x
         * seconds // scheduleAtFixedRate // ex: run every x seconds //
         * scheduleWithFixedDelay // ex: run x seconds after the previous instance has
         * run
         * 
         * // task, delay, timeUnit service3.schedule(() ->
         * System.out.println("schedule " + Thread.currentThread().getName()), 15,
         * TimeUnit.SECONDS);
         * 
         * // task, initialDelay, period, timeUnit service3.scheduleAtFixedRate(() ->
         * System.out.println("scheduleAtFixedRate " +
         * Thread.currentThread().getName()), 10, 15, TimeUnit.SECONDS);
         * 
         * // task, initialDelay, delay, timeUnit service3.scheduleWithFixedDelay(() ->
         * System.out.println("scheduleWithFixedDelay " +
         * Thread.currentThread().getName()), 10, 15, TimeUnit.SECONDS);
         */

        // newSingleThreadExecutor
        // same as newFixedThreadPool
        // used to ensure task run order

        ExecutorService service4 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            final int index = i;

            service4.execute(() -> {
                System.out
                        .println("newSingleThreadExecutor i: " + index + ", name " + Thread.currentThread().getName());
            });
        }
        service4.shutdown();

        // callable

        ExecutorService cService = Executors.newFixedThreadPool(10);

        Future<Integer> future = cService.submit(new CallableExample());

        // future.cancel(mayInterruptIfRunning)
        // future.isCancelled()
        // future.isDone()
        try {
            // blocking operation
            // Integer futureResult = future.get();
            Integer futureResult = future.get(1, TimeUnit.SECONDS);
            System.out.println("futureResult " + futureResult);

        } catch (InterruptedException | ExecutionException | TimeoutException e) {
 
            e.printStackTrace();
        }

    }
}



// https://www.youtube.com/watch?v=sjMe9aecW_A      // done

// spring - each request its a thread

// https://www.youtube.com/playlist?list=PLhfHPmPYPPRk6yMrcbfafFGSbE2EPK_A6
// Java Concurrency // 11
// ch: 7


// ---
// ch: completablefuture 


// https://www.youtube.com/playlist?list=PLBB24CFB073F1048E