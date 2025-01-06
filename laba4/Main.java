import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader("C:\\Users\\vlads\\Desktop\\OOP2\\OOP_2\\OOP_2\\file.txt");

        for (int i = 0; i < reader.getSize(); i++){
            String line = reader.getElement(i);
            System.out.println(line);
            String[] splitLine = line.split(":");
            try {
                System.out.println(Solver.findDecision(splitLine[1]));
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Хорошо:)");
            }
        }
    }
}
