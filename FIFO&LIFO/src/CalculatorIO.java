import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorIO {

    // Reads instructions from csv file
    // Saves results to csv file

    private File inputFile;
    private List<String> instructionsList = new ArrayList<>();
    private File outputFile;

    public CalculatorIO(String inputPath, String outputPath) {
        if (inputPath != null) {
            this.inputFile = new File(inputPath);
        }
        if (outputPath != null) {
            this.outputFile = new File(outputPath);
        }
    }

    public void write(List<String> list, boolean overwrite) {
        try (BufferedWriter output = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(outputFile, !overwrite)))) {

            for (int i = 0; i < list.size(); i++) {
                output.write(list.get(i));
                if ((i + 1) % 4 == 0) {
                    output.write("\n");
                } else {
                    output.write(";");
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//        try (BufferedWriter output = new BufferedWriter(new FileWriter(outputFile,!overwrite))){
//            for (int i = 0; i < list.size(); i++) {
//                output.write(list.get(i));
//                if((i + 1) % 4 == 0){
//                    output.write("\n");
//                }else {
//                    output.write(";");
//                }
//            }
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
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
