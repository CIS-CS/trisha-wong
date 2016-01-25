package circuitsimulator;

/**
 *
 * @author tklw06
 */
public class CircuitBucket {
    // getState invoked by persistor
    private Circuit[] bucket = new Circuit[4];
    
    public void add(Series s){
        bucket[UI.SERIES] = s; // store???
    }
    
    public void add(Parallel p){
        bucket[UI.PARALLEL] = p;
    }
    
    public void add(ParallelInSeries ps){
        bucket[UI.PARALLEL_IN_SERIES] = ps;
    }
    
    public void add(MultiLoop ml){
        bucket[UI.MULTI_LOOP] = ml;
    }
    
    // make getBucket, to send the whole array to the persistor to unravel?
    public Circuit[] getBucket(){
        return bucket;
    }
    // loose coupling
}
