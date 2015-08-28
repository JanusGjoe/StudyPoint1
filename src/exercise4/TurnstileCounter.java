package exercise4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TurnstileCounter
{
    // ORIGINAL solution
    private long count = 0;
    public long getValue()
    {
        return count;
    }
    public void incr()
    {
        count++;
    }
    
    // SYNHRONIZED solution
    //
    private long countSync = 0;
    public long getSynchronizedValue()
    {
        return countSync;
    }
    synchronized public void incrSync()
    {
        countSync++;
    }
    
    // ATOMIC-INTEGER solution
    //
    private AtomicInteger atom = new AtomicInteger(0);
    public int getAtomicValue()
    {
        int returnValue = atom.get();
        return returnValue;
    }
    public void incrAtom()
    {
        atom.incrementAndGet();
    }
    
    // java.util.concurrent.locks.ReentrantLock solution
    //
    private final ReentrantLock lock = new ReentrantLock();
    private long countLock = 0;
    public long getReentrantLockValue()
    {
        return countLock;
    }
    public void incrLock()
    {
        lock.lock();
        try
        {
            countLock++;
        } finally
        {
            lock.unlock();
        }
    }
}