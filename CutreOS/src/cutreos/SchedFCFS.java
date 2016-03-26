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

    public SchedFCFS(LinkedList<Process> allProcess, Scheduling sched) {
        super(allProcess, sched);
    }
    
    public SchedFCFS(){
    }

    public void tick() {
        this.updateTimes();
        if (this.getRunning() != null && !this.getRunning().isIdle()){
            if (this.getRunning().getExpected_runtime() < this.getRunning().getRunning_time()) {
                this.getRunning().finishProcess();
                this.chooseNewProcess();
            }
        }else{
            this.chooseNewProcess();
        }
        
    }

    private void chooseNewProcess(){
        Process earliest = null;
        for(Process p: allProcesses){
            if (p.getCurrent() == Status.READY && !p.isIdle()){
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

    public String getName(){
        return "FCFS";
    }


    @Override
    public int getQuantum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setQuantum(int quantum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
