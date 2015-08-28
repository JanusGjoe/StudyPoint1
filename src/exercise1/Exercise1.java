/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise1
{
    Thread t1 = new Task1();
    Thread t2 = new Task2();
    Thread t3 = new Task3();
    
    private boolean continueThread = true;
    
    public void stopThread()
    {
        System.out.println("***** Stopping thread in Task3");
        continueThread = false;
    }
    
    public void startExercise()
    {
        t1.start();
        t2.start();
        t3.start();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
        }
        stopThread();
    }
    
    public class Task1 extends Thread
    {
        @Override
        public void run()
        {
            long result = 0;
            for (int i = 1; i < 1000000000; i++)
            {
                result = result + i;
                System.out.println("Task1: " + result);
            }
        }
    }
    
    public class Task2 extends Thread
    {
        @Override
        public void run()
        {
            for (int i = 1; i < 6; i++)
            {
                System.out.println("   Task2: " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public class Task3 extends Thread
    {
        @Override
        public void run()
        {
            int result = 10;
            
            while (continueThread)
            {
                System.out.println("      Task3: " + result);
                result++;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

//     task1 : Compute and print the sum of all numbers from 1 to 1 billion
//     task2 : Print the numbers from 1 to 5. Pause for 2 seconds between each print.
//     task3 : Print all numbers from 10 and up. Pause for 3 seconds between each print.
