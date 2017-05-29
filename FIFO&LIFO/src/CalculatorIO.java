import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorIO {

    // Reads csv from file

    private File inputFile;
    List<String> instructionsList = new ArrayList<>();

    public CalculatorIO(String path) {
        if (path != null) {
            this.inputFile = new File(path);

        }
    }

    public void read() {
        try (Scanner sc = new Scanner(new BufferedInputStream(new FileInputStream(inputFile)))) {
            sc.useDelimiter(";");
            while (sc.hasNext()) {
                String next = sc.next();
                if (next.contains("\n")) {
                    int index = next.indexOf("\n");
                    instructionsList.add(next.substring(0, index));
                    instructionsList.add(next.substring(index + 1, next.length()));

                } else {
                    instructionsList.add(next);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> getInstructionsList() {
        return new ArrayList<>(instructionsList);
    }
}
