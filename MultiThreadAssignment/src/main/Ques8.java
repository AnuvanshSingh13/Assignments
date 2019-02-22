package main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ques8 {
    /*
       Schedule task using schedule(), scheduleAtFixedRate() and scheduleAtFixedDelay()
   */
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        normalSchedule(executorService);
        atFixedDelay(executorService);
        atFixedRate(executorService);
    }

    static void atFixedDelay(ScheduledExecutorService executorService) {
        //scheduled at fixed delay of 1 second
        executorService.scheduleWithFixedDelay(
                () -> {
                    try {
                        Thread.sleep(2000L);
                        System.out.println("ScheduleWithFixedDelay Scheduled Task to executed after fixed interval");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                0,
                1,
                TimeUnit.SECONDS);
    }

    static void atFixedRate(ScheduledExecutorService executorService) {
        //scheduled at fixed rate of 1 second
        executorService.scheduleAtFixedRate(
                () -> {
                    try {
                        Thread.sleep(2000L);
                        System.out.println("ScheduleAtFixedRate Scheduled Task to executed after fixed interval");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }, 0, 1, TimeUnit.SECONDS);
    }

    static void normalSchedule(ScheduledExecutorService executorService) {
        //scheduled to execute after a delay of 1 second
        executorService.schedule(
                () -> System.out.println("Task executed after 1 second"), 1, TimeUnit.SECONDS);

    }
}
