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
    private SchedAlgorithm currentSched;
    private int procCounter = 0;
    private PagingAlgorithm currentPaging;
    
    private int time = 0;

    public void setTime(int time) {
        this.time = time;
    }

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
        this.currentSched = new SchedFCFS(this.allProcesses, this);
        
    }

    void tick() {
        this.time++;
        logger.info("New tick! Time = ".concat(Integer.toString(this.time)));
        this.currentSched.tick();
        if(this.getRunning() != null)
            logger.info("The running process is: ".concat(this.getRunning().getName()));
        else setRunningAsIdle();
    }

    public Process getRunning() {
        Process running = null;
        for(Process proc: this.allProcesses){
            if(proc.getCurrent() == Status.RUNNING) running = proc;
        }
        return running;
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

    private void setRunningAsIdle() {
        for(Process proc: allProcesses){
            if(proc.getCurrent() == Status.RUNNING && proc.isIdle() == false)
                proc.setCurrent(Status.READY);
            else if(proc.isIdle()) proc.current = Status.RUNNING;
            
        }
    }

    void createIdleProcess() {
        try{
            Process idle = newProcess("[IDLE]", 0, 9999, Status.RUNNING);
            idle.setIdle(true);
            Page p = new Page();
            p.setArrive_time(0);
            p.setAccess_count(0);
            p.setLast_access_time(0);
            p.setModified(false);
            p.setReferenced(false);
            p.setResident(true);
            idle.addPage(p);
        }catch(OSisFullException e){
            //this never happens
        }
        logger.log(Level.INFO, "Process IDLE created");
    }

    public void runPage(int pageNumber) {
        Process running = getRunning();
        currentPaging.runPage(running, pageNumber);
    }

}
