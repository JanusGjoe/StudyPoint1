/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author Janus
 */
public class Exercise2
{
    Even evenClass = new Even();
    
    public void startExercise()
    {
        Task1 t1 = new Task1(evenClass);
        Task2 t2 = new Task2(evenClass);
        
        t1.start();
        t2.start();
    }
    
    public class Task1 extends Thread
    {
        Even ec;

        public Task1(Even ec) {
            this.ec = ec;
        }
        
        @Override
        public void run()
        {
            for (int i = 0; i < 100000; i++)
            {
                int j = ec.next();
                int oddEven = (j%2);
                if(oddEven == 1)
                {
                    System.out.println(j);
                }
            }
        }
    }
    
    public class Task2 extends Thread
    {
        Even ec;

        public Task2(Even ec) {
            this.ec = ec;
        }
        
        @Override
        public void run()
        {
            for (int i = 0; i < 100000; i++)
            {
                int j = ec.next();
                int oddEven = (j%2);
                if(oddEven == 1)
                {
                    System.out.println("     " + j);
                }
            }
        }
    }
    
    public class Even
    {
        private int n = 0;

        public synchronized int next()
        {
            n++;
            n++;
            return n;
        }
    }
}
