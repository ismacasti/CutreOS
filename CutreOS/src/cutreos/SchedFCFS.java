import java.util.LinkedList;

/**
 * Created by ismael on 2/15/16.
 */
public class SchedFCFS extends SchedAlgorithm {

    LinkedList<Process> ready;
    LinkedList<Process> blocked;
    LinkedList<Process> allProcess;
    Process running;

    public SchedFCFS(LinkedList<Process> allProcess) {
        super(allProcess);
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
    public void tick() {
        if (this.running.getExpected_runtime() < this.running.getRunning_time()) {
            this.running.finishProcess();
        }


    }


    @Override
    public String getName() {
        return "FCFS (FIFO)";
    }


    @Override
    public int newProcess(Process P) {
        this.ready.addLast(P);
        return (P.getPid());
    }


}
