package cutreos;

import cutreos.Process.Status;
import static cutreos.Process.Status.BLOCKED;
import static cutreos.Process.Status.NEW;
import static cutreos.Process.Status.READY;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Created by ismael on 2/15/16.
 */
public abstract class SchedAlgorithm {
    private final static Logger logger = Logger.getLogger("kernel.scheduling.algo"); 

    LinkedList<Process> allProcesses;
    Scheduling sched;

    public SchedAlgorithm(){
        //nothing, just for the name
    }
    public SchedAlgorithm(LinkedList<Process> allProcess, Scheduling sched) {
        this.allProcesses = allProcess;
        this.sched = sched;
    }

    static public String getName(){
        return "Sched";
    }
     //here all the scheduling happens
    abstract void tick();

    abstract public int newProcess(Process P);


    abstract public int getQuantum();

    abstract public void setQuantum(int quantum);

    public LinkedList<Process> getReady(){
        LinkedList<Process> list = new LinkedList<>();
        for(Process p: allProcesses){
            if(p.getCurrent() == Status.READY)
                list.addLast(p);
        }
        return list;
        
    }

    public LinkedList<Process> getBlocked(){
        LinkedList<Process> list = new LinkedList<>();
        for(Process p: allProcesses){
            if(p.getCurrent() == Status.BLOCKED)
                list.addLast(p);
        }
        return list;
    }

    public Process getRunning(){
        return this.sched.getRunning();
    }

    void updateTimes() {
        //put the IDLE process to ready
        //we put from BLOCKED to READY process that 
        //have finished its time in BLOCKED
        for(Process proc: this.allProcesses){
            if(proc.isIdle()) proc.setCurrent(Status.BLOCKED);
            if(proc.current == BLOCKED && proc.getBlocked_until() <= this.sched.getTime()){
                proc.current = READY;
            }
        }

        for (Process p: this.allProcesses) {
            //update history values
            switch (p.getCurrent()) {
                case FINISHED:
                    break;//nada
                case NEW:
                    if(this.sched.getTime() >= p.getArriveTime()){
                        p.setCurrent(p.getNext());
                    }
                    break;
                case READY:
                    p.setReady_time(p.getReady_time() + 1);
                    break;
                case BLOCKED:
                    p.setBlocked_time(p.getBlocked_time() + 1);
                    break;
                case RUNNING:
                    p.setRunning_time(p.getRunning_time() + 1);
                    break;
            }
        }
    }


}
