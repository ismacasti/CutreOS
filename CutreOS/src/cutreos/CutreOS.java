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

    public ArrayList<String> getProcesses() {
        LinkedList<Process> allProcesses = this.sched.getAllProcesses();

        ArrayList<String> list = new ArrayList<String>();

        for (Iterator<Process> i = allProcesses.iterator(); i.hasNext(); ) {
            Process p = i.next();
            list.add(p.getPid() + " -> " + p.getName());
        }

        return list;
    }

    public int newProcess(String name, int arriveTime, int expectedRuntime, int status) {
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
        return p.getPid();

    }
}
