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
        //initalize logging to console
        //logger.addHandler(new ConsoleHandler());
        //list of interrupts
        this.interruptList = new LinkedList<>();
        interruptList.add(new SigKillInterrupt());
        interruptList.add(new SigTermSVCInterrupt());
        
        //paging algorithms list
        this.pagingList = new LinkedList<>();
        pagingList.add(new PagingFIFO());
        pagingList.add(new PagingLFU());
        pagingList.add(new PagingLRU());
        pagingList.add(new PagingNRU());
        
        //scheduling algorithm list
        this.schedList = new LinkedList<>();
        schedList.add(new SchedFCFS());
        
        this.sched = new Scheduling();
        logger.log(Level.INFO, "Scheduling instance loaded");
        
        setPagingAlgorithm(pagingList.get(0).getName());
        logger.log(Level.INFO, "Loaded paging algorithm: ".concat(pagingList.get(0).getName()));
        logger.info("CutreOS kernel initiliazed");

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
            try{
                if(s.getName() == algo){
                    Constructor constructor =
                            s.getClass().getConstructor(new Class[]{this.sched.getClass()});
                PagingAlgorithm newAlgo =
                        (PagingAlgorithm)constructor.newInstance(this.sched);
                
                this.sched.setPagingAlgorithm(newAlgo);

                }
            }catch(Exception e){
                logger.log(Level.SEVERE, "Vergas! algo falló y ni puta idea");
            }
        }
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


}
