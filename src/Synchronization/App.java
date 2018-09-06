package Synchronization;

/*
 * Basic Thread Synchronization
 */

import java.util.Scanner;

class Processor extends Thread{

    // volatile keyword is used for data inconsistency
    // volatile keyword makes a variable's local copy for each thread separately.
    // when the thread terminates successfully then it update the variable's master copy from the local copy.


    private volatile boolean running = true;

    // overriding the existing run method
    public void run()
    {
        while(running)
        {
            System.out.println("Hello");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void shutdown()
    {
        running = false;
    }
}




public class App {

    public static void main(String args[])
    {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }
}
