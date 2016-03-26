package cutreos;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ismael on 2/14/16.
 */
public class Process {
    private final static Logger logger = Logger.getLogger("kernel.scheduling.proc"); 

    String name;
    int pid;
    int arriveTime;
    int expected_runtime;
    int running_time;
    int blocked_time;
    int ready_time;
    int last_running_time;
    int last_blocked_time;
    int last_ready_time;
    boolean idleProc = false;

    public boolean isIdle() {
        return idleProc;
    }

    public void setIdle(boolean idelProc) {
        this.idleProc = idelProc;
    }
    Status current;
    Status next;
    int blocked_until;
    LinkedList<Page> pages;
    

    public Status getNext() {
        return next;
    }

    public Process(String name, int expected_runtime, int pid) {
        this.name = name;
        this.expected_runtime = expected_runtime;
        this.pid = pid;
        pages = new LinkedList<>();
        logger.info("New process created: ".concat(name));
    }
    
    public int addPage(Page p){
        this.pages.addLast(p);
        //return the position in the page list
        int pos = this.pages.size() -1;
        logger.log(Level.INFO, "Added page {0} in process {1}",
                new Object[] {pos ,this.name});
        return pos;

        
    }
    public String getName() {
        return name;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getBlocked_time() {
        return blocked_time;
    }

    public void setBlocked_time(int blocked_time) {
        this.blocked_time = blocked_time;
    }

    public void setNext(Status next) {
        this.next = next;
    }

    public int getPid() {
        return this.pid;
    }

    public int getExpected_runtime() {
        return this.expected_runtime;
    }

    public int getRunning_time() {
        return this.running_time;
    }

    public void setRunning_time(int running_time) {
        this.running_time = running_time;
    }

    public void finishProcess() {
        logger.log(Level.INFO, "Process {0} set to FINISHED", this.name);
        this.current = Status.FINISHED;
    }

    public Status getCurrent() {
        return this.current;
    }

    public void setCurrent(Status current) {
        this.current = current;
    }

    public int getReady_time() {
        return this.ready_time;
    }

    public void setReady_time(int t) {
        this.ready_time = t;
    }

    public LinkedList<Page> getPages() {
        return pages;
    }


    

    public enum Status {
        RUNNING, BLOCKED, READY, FINISHED, NEW
    }

    public int getBlocked_until() {
        return blocked_until;
    }

    public void setBlocked_until(int blocked_until) {
        this.blocked_until = blocked_until;
    }

    public void setExpected_runtime(int expected_runtime) {
        this.expected_runtime = expected_runtime;
    }

    

    
}
