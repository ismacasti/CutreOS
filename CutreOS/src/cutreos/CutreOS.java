package cutreos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ismael on 2/14/16.
 */

public class CutreOS {
    Scheduling sched;

    public CutreOS() {
        this.sched = new Scheduling();
    }

    public LinkedList<Process> getProcesses(){
        return sched.getAllProcesses();
    }
    
    public int getTime(){
        return sched.getTime();
    }
    
    public int tick(){
        sched.tick();
        return sched.getTime();
    }
    
    public String getCurrentSched(){
        return sched.getCurrentSched();
    }

    public int newProcess(String name, int arriveTime, int expectedRuntime, int status, LinkedList<LinkedList> pages) throws OSisFullException {
        Process.Status s = Process.Status.NEW;
        switch (status) {
            case 1:
                s = Process.Status.RUNNING;
                break;
            case 2:
                s = Process.Status.BLOCKED;
                break;
            case 3:
                s = Process.Status.READY;
                break;

        }
        Process p = this.sched.newProcess(name, arriveTime, expectedRuntime, s);
        for(LinkedList<Integer> i: pages){
            Page new_page = new Page(i);
            p.addPage(new_page);
        }
        return p.getPid();
    }

    public Process getRunning() {
        return sched.getRunning();
    }

}
