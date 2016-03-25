package cutreos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ismael on 2/14/16.
 */

public class CutreOS {
    Scheduling sched;
    private LinkedList<Interrupt> interruptList;

    public CutreOS() {
        this.interruptList = new LinkedList<>();
        interruptList.add(new SigKillInterrupt());
        interruptList.add(new SigTermSVCInterrupt());
        this.sched = new Scheduling();
    }

    public LinkedList<String> getInterrupts(){
        LinkedList<String> list = new LinkedList<>();
        for(Interrupt i: interruptList){
            list.add(i.getName());
        }
        return list;
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
    
    public int newProcess(String name, int expectedRuntime, int pages_count) throws OSisFullException{
        int status = 3;
        LinkedList<LinkedList> pages = new LinkedList<>();
        for (int i = 0; i < pages_count; i++){
            LinkedList<Integer> page = new LinkedList<Integer>();
            for (int n = 0; n < 6; i++) page.addLast(0);
            pages.addLast(page);
        }
        return this.newProcess(name, this.getTime(), expectedRuntime, status, pages);
    }
    

    public Process getRunning() {
        return sched.getRunning();
    }


}
