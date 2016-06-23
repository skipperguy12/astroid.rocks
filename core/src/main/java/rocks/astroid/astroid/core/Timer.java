package rocks.astroid.astroid.core;

/**
 * keeps time
 */
public class Timer {
    private long tStart;
    private long tLast;
    private long tNow;
    private long threshold;

    /**
     * @param threshold milliseconds that
     */
    public Timer(long threshold)
    {
        tStart = System.nanoTime();
        tLast=-1;
        tNow=0;
        this.threshold=threshold;
    }

    /**
     * @return true if threshold time has passed since last true OR true if first call
     */
    public boolean thresholdPassed()
    {
        tNow = System.nanoTime();
        long temp = (tNow-tLast)/1000000;
        if(temp>threshold)
        {
            tLast = System.nanoTime();
            return true;
        }
        return false;
    }
}
