package cutreos;

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

    LinkedList<Process> allProcess;
    int time;

    public SchedAlgorithm(){
        //nothing, just for the name
    }
    public SchedAlgorithm(LinkedList<Process> allProcess, int time) {
        this.allProcess = allProcess;
    }

    abstract String getName();

     //here all the scheduling happens
    void tick(int time){
        this.time++;
        this.updateTimes();
        
        //we put from BLOCKED to READY process that 
        //have finished its time in BLOCKED
        for(Process proc: this.allProcess){
            if(proc.current == BLOCKED && proc.getBlocked_until() == time){
                proc.current = READY;
            }
        }
    }

    abstract public int newProcess(Process P);

    ;

    abstract public int getQuantum();

    abstract public void setQuantum(int quantum);

    abstract public LinkedList<Process> getReady();

    abstract public LinkedList<Process> getBlocked();

    abstract public Process getRunning();

    void updateTimes() {
        for (Process p: this.allProcess) {
            //update history values
            switch (p.getCurrent()) {
                case FINISHED:
                    break;//nada
                case NEW:
                    if(time == p.getArriveTime()){
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
