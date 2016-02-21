/**
 * Created by ismael on 2/14/16.
 */
public class Process {
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
    Status current;
    Status next;

    public Process(String name, int expected_runtime, int pid) {
        this.name = name;
        this.expected_runtime = expected_runtime;
        this.pid = pid;
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

    public enum Status {
        RUNNING, BLOCKED, READY, FINISHED, NEW
    }
}
