package cutreos;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ismael on 2/15/16.
 */
public abstract class SchedAlgorithm {
    LinkedList<Process> allProcess;
    int time;

    public SchedAlgorithm(LinkedList<Process> allProcess, int time) {
        this.allProcess = allProcess;
    }

    abstract String getName();

    abstract void tick(int time); //here all the scheduling happens

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
                        p.setCurrent(Process.Status.READY);
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
