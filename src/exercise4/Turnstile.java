package exercise4;

public class Turnstile implements Runnable
{
    private final TurnstileCounter counter;
    private int count;
    
    final int COUNT_MAX = 1000;
    
    Turnstile(TurnstileCounter c)
    {
        counter = c;
    }
    
    public int getCount()
    {
        return count;
    }
    
    @Override
    public void run()
    {
        // Original
        count = 0;
        for (int i = 0; i < COUNT_MAX; i++) {
            counter.incr();
            count++;
        }
        
        // Synchronized
        count = 0;
        for (int i = 0; i < COUNT_MAX; i++) {
            counter.incrSync();
            count++;
        }
        
        // AtomicInteger
        count = 0;
        for (int i = 0; i < COUNT_MAX; i++) {
            counter.incrAtom();
            count++;
        }
        
        // ReentrantLock
        count = 0;
        for (int i = 0; i < COUNT_MAX; i++) {
            counter.incrLock();
            count++;
        }
    }
}
