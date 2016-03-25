package cutreos;

import static cutreos.Process.Status;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ismael on 2/14/16.
 */
public class Scheduling {
    private final static Logger logger = Logger.getLogger("kernel.scheduling"); 

    private LinkedList<Process> allProcesses = new LinkedList<Process>();
    private Process running;
    private SchedAlgorithm currentSched;
    private int procCounter = 0;
    private PagingAlgorithm currentPaging;
    
    private int time = 0;

    public int getTime() {
        return time;
    }

    public int getProcCounter() {
        return procCounter;
    }

    public LinkedList<Process> getAllProcesses() {
        return allProcesses;
    }

    public String getCurrentSched() {
        return this.currentSched.getName();
    }
    //return the number of processes that are expected to be scheduled
    //(all except FINISHED)
    public int getConcurrentProcessesCount(){
        int n = 0;
        for(Process p: this.allProcesses){
            if(p.getCurrent() != Status.FINISHED) n++;
        }
        return n;
    }

    public Process newProcess(String name, int arriveTime, int expectedRuntime, Process.Status status) throws OSisFullException {
        if(this.getConcurrentProcessesCount() >= 10) throw new OSisFullException();
        Process p = new Process(name, expectedRuntime, allProcesses.size() + 1);
        p.setArriveTime(arriveTime);
        p.setCurrent(Process.Status.NEW);
        p.setNext(status);
        allProcesses.addLast(p);
        return p;
    }

    public Scheduling() {
        this.currentSched = new SchedFCFS(this.allProcesses, this.time);
        
    }

    void tick() {
        this.time++;
        logger.info("New tick! Time = ".concat(Integer.toString(this.time)));
        this.currentSched.tick(time);
        this.running = currentSched.getRunning();
        if(this.running != null)
            logger.info("The running process is: ".concat(this.running.getName()));
        else logger.info("No process is running at this moment");
    }

    public Process getRunning() {
        return this.running;
    }
    
    public void block(Process proc, int blocked_time){
        proc.setCurrent(Status.BLOCKED);
        proc.setBlocked_until(this.time + blocked_time);
        logger.log(Level.INFO, "Process {0} has been blocked for {1} ticks",
                new Object[] {proc.getName(), Integer.toString(blocked_time)});
    }
    
    public void kill(Process proc){
        logger.log(Level.INFO, "Process {0} has been killed!", proc.getName());
        proc.setCurrent(Status.FINISHED);
    }

    void setPagingAlgorithm(PagingAlgorithm newAlgo) {
        this.currentPaging = newAlgo;
    }

    PagingAlgorithm getCurrentPagingAlgo() {
        return this.currentPaging;
    }

}
