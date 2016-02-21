import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Created by ismael on 2/15/16.
 */
public class OS {
    CutreOS kernel;
    public static void main(String[] args) throws IOException{
        if (args.length == 1) {
            Parser p = new Parser(args[0]);
            LinkedList<ProcessParsed> procs = p.parse();
            new OS(procs);
        } else {
            System.out.println("Use only 1 parameter, the path for the input file");
            System.exit(-1);
        }
    }

    public OS(LinkedList<ProcessParsed> list){
        kernel = new CutreOS();
        int i = 0;
        for(ProcessParsed p: list){
            kernel.newProcess("Process " + Integer.toString(i), p.getArriveTime(), p.getEstimatedTime(), p.getNextState() );
        }

    }
}
