package ep.research.falsesharing;

import ep.research.time.MilliTimer;
import ep.research.time.Timer;

import java.io.IOException;

public class FalseSharingApp {

    private static final long ITERATIONS = 900_000_000;
    private static final int  THREADS = 2;
    private static final FalseSharingState[] STATES = new FalseSharingState[THREADS];
    static {
        for(int i=0;i<STATES.length;i++) {
            STATES[i]=new FalseSharingState();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = buildTestThread(i, ITERATIONS, STATES[i]);
        }

        Timer timer = new MilliTimer();

        try (Timer t=timer.start()){
            runTest(threads);
        }

        System.out.println("total time: " + timer.elapsedTime());
    }


    static void runTest(final Thread[] threads) throws InterruptedException {

        for(int i=0;i<threads.length;i++) {
            threads[i].start();
        }

        for(int i=0;i<threads.length;i++) {
            threads[i].join();
        }
    }

    static Thread buildTestThread(final long threadNumber,final long iterations,final FalseSharingState state) {
        return new Thread(() -> {
            for (long i=0;i<iterations;i++) {
                state.value++;
            }
        });
    }
}
