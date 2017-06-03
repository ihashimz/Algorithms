import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayIO {

    private File outputFile;
    private File inputFile;

    public ArrayIO(String inputPath, String outputPath) {
        if (inputPath != null) {
            this.inputFile = new File(inputPath);
        }
        if (outputPath != null) {
            this.outputFile = new File(outputPath);
        }
    }




    public void write(List<Integer> input, boolean overwrite) {
        if (input.size() != 0) {
            try (DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(outputFile, !overwrite)))) {

                dos.write(input.size());

                input.forEach(integer -> {
                    try {
                        dos.write(integer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> read() {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(inputFile)))) {

            List<Integer> output = new ArrayList<>();

            int size = dis.read();

            for(int i = 0; i < size; i++){
                output.add(dis.read());
            }

            return output;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
