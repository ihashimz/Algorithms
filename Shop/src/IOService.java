import java.io.*;

public class IOService implements Serializable {

    private File writeFile;

    public IOService(String writePath) {
        writeFile = new File(writePath);
    }

    public void saveStoreToFile(Store store) {

        try (ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(writeFile)))) {
            ous.writeObject(store);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Store readStoreFromFile(String path) throws IOException, ClassNotFoundException {

        Store store = null;
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
        store = (Store) ois.readObject();
        ois.close();
        return store;
    }
}
