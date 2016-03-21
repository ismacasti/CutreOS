package cutreos;

import static cutreos.Process.Status;
import java.util.LinkedList;

/**
 * Created by ismael on 2/14/16.
 */
public class Scheduling {
    private LinkedList<Process> allProcesses = new LinkedList<Process>();
    private Process running;
    private SchedAlgorithm currentSched;
    private int procCounter = 0;
    
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
        this.currentSched.tick(time);
        this.running = currentSched.getRunning();
        
    }

    public Process getRunning() {
        return this.running;
    }
    
    public void block(Process proc, int blocked_time){
        proc.setCurrent(Status.BLOCKED);
        proc.setBlocked_until(this.time + blocked_time);
    }


}
