import java.util.LinkedList;

/**
 * Created by ismael on 2/16/16.
 */
public class ProcessParsed {
    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getNextState() {
        return nextState;
    }

    public void setNextState(int nextState) {
        this.nextState = nextState;
    }


    public void addPage(LinkedList<Integer> page){
        this.pages.addLast(page);
    }

    private int arriveTime;
    private int estimatedTime;
    private int nextState;

    public LinkedList<LinkedList> getPages() {
        return pages;
    }

    private LinkedList<LinkedList> pages;

    public ProcessParsed(){
        this.pages = new LinkedList<LinkedList>();
    }
}
