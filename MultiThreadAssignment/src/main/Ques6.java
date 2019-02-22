package main;

import java.util.concurrent.*;

public class Ques6 {
    /*
    Return a Future from ExecutorService by using callable and use
    get(), isDone(), isCancelled() with the Future object to know the status of task submitted.
*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //executing only one thread at a time

        Future<Integer> integerFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 98;
            }
        });

        executorService.shutdown();

        if (integerFuture.isDone()) {       //using isDone()
            System.out.println(integerFuture.get());        //using get()
        }

        if (integerFuture.isCancelled()) {      //using isCancelled()
            System.out.println("Your task has been cancelled");
        }
    }
}
