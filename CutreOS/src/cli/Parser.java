import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by ismael on 2/16/16.
 */
public class Parser {
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    private final Path filePath;

    public Parser (String filePath){
        this.filePath = Paths.get(filePath);
    }

    private String nextLine(Scanner sc){
        String line = sc.nextLine();

        int offset = line.indexOf("/");
        if (offset != -1){
            line = line.substring(0, offset);
        }

        line = line.replaceAll("[^\\d.,]", "");

        return line;
    }

    public LinkedList<ProcessParsed> parse() throws IOException{
        LinkedList<ProcessParsed> list = new LinkedList<ProcessParsed>();
        Scanner sc = new Scanner(this.filePath);
        this.nextLine(sc); //we jump the first line
        int ProcCount = Integer.parseInt(this.nextLine(sc)); //processes count
        for(int i = 0; i < ProcCount; i++){
            ProcessParsed p = new ProcessParsed();
            //parse the process info (7, 25, 1)

            String[] procInfo = this.nextLine(sc).split(",");
            p.setArriveTime(Integer.parseInt(procInfo[0]));
            p.setEstimatedTime(Integer.parseInt(procInfo[1]));
            p.setNextState(Integer.parseInt(procInfo[2]));

            //parse pages
            int pageCount = Integer.parseInt(this.nextLine(sc));
            for(int x = 0; x < pageCount; x++){
                LinkedList<Integer> page = new LinkedList<Integer>();
                String pageLine[] = this.nextLine(sc).split(",");
                for(int n = 0; n <= 5; n++){
                    page.addLast(Integer.parseInt(pageLine[n]));
                }
                p.addPage(page);
            }
            list.addLast(p);
        }
        return list;
    }

}
