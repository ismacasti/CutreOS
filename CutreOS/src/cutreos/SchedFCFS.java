package cutreos;

import cutreos.Process.Status;
import java.util.LinkedList;

/**
 * Created by ismael on 2/15/16.
 */
public class SchedFCFS extends SchedAlgorithm {

    LinkedList<Process> ready;
    LinkedList<Process> blocked;
    Process running;

    public SchedFCFS(LinkedList<Process> allProcess, int time) {
        super(allProcess, time);
    }
    
    public SchedFCFS(){
    }

    @Override
    public int getQuantum() {
        return 0;
    }

    @Override
    public void setQuantum(int quantum) {
        //nothing, no quantum in FCFS
    }

    @Override
    public LinkedList<Process> getReady() {
        return this.ready;
    }

    @Override
    public LinkedList<Process> getBlocked() {
        return this.blocked;
    }

    @Override
    public Process getRunning() {
        return this.running;
    }

    @Override
    public void tick(int time) {
        if (this.running != null){
            if (this.running.getExpected_runtime() < this.running.getRunning_time()) {
                this.running.finishProcess();
                this.chooseNewProcess();
            }
        }else{
            this.chooseNewProcess();
        }
        
    }

    private void chooseNewProcess(){
        Process earliest = null;
        for(Process p: allProcess){
            if (p.getCurrent() == Status.READY){
                if (earliest == null){
                    earliest = p;
                }else{
                    if (p.getArriveTime() < earliest.getArriveTime()){
                        earliest = p;
                    }
                }
            }
        }
        if (earliest != null) earliest.setCurrent(Status.RUNNING);
        this.running = earliest;
    }

    static final public String getName(){
        return "FCFS";
    }

    @Override
    public int newProcess(Process P) {
        this.ready.addLast(P);
        return (P.getPid());
    }


}
