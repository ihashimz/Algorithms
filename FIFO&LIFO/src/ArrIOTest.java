public class ArrIOTest {

    public static void main(String[] args) {

        ArrayIO arrayIO = new ArrayIO("/home/mateusz/Downloads/array.txt","/home/mateusz/Downloads/array.txt");
        int[][] array = {
                {0,1,2,3,4},
                {1,4,3,2,1},
                {4,4,3,2,1},
                {8,4,3,2,1},
                {0,4,3,2,1},
                {2,4,3,2,1},
        };
        arrayIO.write(array,true);

        int[][] output = arrayIO.read();

        for(int[] arr : output){
            for(int ele : arr){
                System.out.print(ele);
            }
            System.out.println();
        }
    }
}
