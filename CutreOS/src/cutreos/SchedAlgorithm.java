import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ismael on 2/15/16.
 */
public abstract class SchedAlgorithm {
    LinkedList<Process> allProcess;

    public SchedAlgorithm(LinkedList<Process> allProcess) {
        this.allProcess = allProcess;
    }

    abstract String getName();

    abstract void tick(); //here all the scheduling happens

    abstract public int newProcess(Process P);

    ;

    abstract public int getQuantum();

    abstract public void setQuantum(int quantum);

    abstract public LinkedList<Process> getReady();

    abstract public LinkedList<Process> getBlocked();

    abstract public Process getRunning();

    private void updateTimes() {
        for (Iterator<Process> i = this.allProcess.iterator(); i.hasNext(); ) {
            Process p = i.next();
            switch (p.getCurrent()) {
                case FINISHED:
                    break;//nada
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
