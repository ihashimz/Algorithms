import java.io.*;

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

    public void write(int[][] array, boolean overwrite) {
        if (array.length != 0) {
            try (DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(outputFile, !overwrite)))) {

                dos.write(array.length); // basic length
                dos.write(array[0].length); //second length

                for (int[] arr : array) {
                    for (int element : arr) {
                        dos.write(element);
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int[][] read() {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(inputFile)))) {
            int x = dis.read();
            int y = dis.read();
            int[][] output = new int[x][y];
            for (int i = 0; i < x; i++) {
                for(int j = 0; j < y; j++){
                    output[i][j] = dis.read();
                }
            }
            return output;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
