import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.DoubleSummaryStatistics;

public class Reader {
    private BufferedReader reader;
    private ArrayList<String> lines;
    public Reader(String filename) throws IOException {
        lines = new ArrayList<String>();
        this.readFile(filename);
    }

    private void readFile(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();

        while (line != null){
            lines.add(line);
            line = reader.readLine();
        }
    }

    public int getSize(){
        return lines.size();
    }

    public String getElement(int i){
        return lines.get(i);
    }
}
