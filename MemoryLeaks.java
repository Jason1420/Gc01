import java.util.ArrayList;
import java.util.List;

public class MemoryLeaks {
    private static List<int[]> listOfArrays = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            int[] newArray = new int[10000000]; // Tạo một mảng mới có 1 triệu phần tử
            listOfArrays.add(newArray); // Thêm mảng mới vào danh sách, nhưng không giải phóng danh sách này sau khi không cần nữa
            Thread.sleep(50);
            System.out.println(i++);
        }
    }
}
