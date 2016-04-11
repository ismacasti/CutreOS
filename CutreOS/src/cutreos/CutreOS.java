package cutreos;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Constructor;

/**
 * Created by ismael on 2/14/16.
 */

public class CutreOS {
    private final static Logger logger = Logger.getLogger("kernel"); 

    Scheduling sched;
    private LinkedList<Interrupt> interruptList;
    private LinkedList<PagingAlgorithm> pagingList;
    private LinkedList<SchedAlgorithm> schedList;
    public int Quantum;

    public LinkedList<String> getPagingList() {
        LinkedList<String> list = new LinkedList<>();
        for(PagingAlgorithm p: this.pagingList){
            list.addLast(p.getName());
        }
        return list;
    }
    public String getCurrentPagingAlgo(){
        PagingAlgorithm algo = this.sched.getCurrentPagingAlgo();
        return algo.getName();
    }

    public CutreOS() {
        //initialize sched
        this.sched = new Scheduling();

        //list of interrupts
        this.interruptList = new LinkedList<>();
        interruptList.add(new SigKillInterrupt());
        interruptList.add(new SigTermSVCInterrupt());
        interruptList.add(new IOSVCInterrupt());
        
        //paging algorithms list
        this.pagingList = new LinkedList<>();
        pagingList.add(new PagingFIFO(this.sched));
        pagingList.add(new PagingLFU(this.sched));
        pagingList.add(new PagingLRU(this.sched));
        pagingList.add(new PagingNRU(this.sched));
        
        //scheduling algorithm list
        this.schedList = new LinkedList<>();
        schedList.add(new SchedFCFS(this.getProcesses(), this.sched));
        schedList.add(new SchedSRT(this.getProcesses(), this.sched));
        schedList.add(new SchedSJF(this.getProcesses(), this.sched));
        schedList.add(new SchedRoundRobin(this.getProcesses(), this.sched));
        schedList.add(new SchedHRRN(this.getProcesses(), this.sched));
        
        sched.createIdleProcess();
        logger.log(Level.INFO, "Scheduling instance loaded");
        PagingAlgorithm pagingAlgo = pagingList.getFirst();
        setPagingAlgorithm(pagingAlgo.getName());
        logger.log(Level.INFO, "Loaded paging algorithm: ".concat(pagingList.get(0).getName()));
        logger.info("CutreOS kernel initiliazed");
        sched.tick();

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

    public void setPagingAlgorithm(String algo){
        for(PagingAlgorithm s: this.pagingList){
            if(s.getName() == algo){
                this.sched.setPagingAlgorithm(s);
                break;
            }
        }
        logger.log(Level.INFO, "Paging algorithm set to ".concat(getCurrentPagingAlgo()));
    }
    
    public void setSchedAlgorithm(String algo){
        for(SchedAlgorithm s: this.schedList){
            if(s.getName() == algo){
                this.sched.setSchedAlgorithm(s);
                break;
            }
        }
        logger.log(Level.INFO, "Scheduling algorithm set to ".concat(getCurrentSchedAlgo()));
    }
    public int newProcess(String name, int arriveTime, int expectedRuntime, int status, LinkedList<LinkedList> pages) throws OSisFullException {
        logger.entering(getClass().getName(), "newProcess");
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
        logger.exiting(getClass().getName(), "newProcess");
        return p.getPid();

    }
    
    public int newProcess(String name, int expectedRuntime, int pages_count) throws OSisFullException{
        int status = 3;
        LinkedList<LinkedList> pages = new LinkedList<>();
        for (int i = 0; i < pages_count; i++){
            LinkedList<Integer> page = new LinkedList<Integer>();
            for (int n = 0; n < 6; n++) page.addLast(0);
            pages.addLast(page);
        }
        return this.newProcess(name, this.getTime(), expectedRuntime, status, pages);
    }
    

    public Process getRunning() {
        return sched.getRunning();
    }

    public void runPage(int pageNumber) {
        this.sched.runPage(pageNumber);
        this.tick();
        
    }

    private String getCurrentSchedAlgo() {
        return this.sched.getCurrentSched();
    }

    public LinkedList<String> getSchedList() {
        LinkedList<String> list = new LinkedList<>();
        for(SchedAlgorithm p: this.schedList){
            list.addLast(p.getName());
        }
        return list;
    }

    public boolean interrupt(String interrupt) {
        for(Interrupt i: interruptList){
            if(interrupt == i.getName()){
                Process running = sched.getRunning();
                if(!running.isIdle()){
                    i.interrupt(sched, sched.getRunning());
                    this.tick();
                    return true;
                }else return false;
            }
        }
        return false;
    }

    public void resetNUR() {
        Process running = sched.getRunning();
        if(!running.isIdle()) running.resetNUR();
    }

    public void setMaxLoadedPages(int maxLoadedPages) {
        for(PagingAlgorithm algo: pagingList){
            algo.setPage_limit(maxLoadedPages);
        }
    }
    
    

}
