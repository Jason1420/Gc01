import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        // Dữ liệu nhị phân cần mã hóa thành base64
        byte[] binaryData = "Hello, World!".getBytes();

        // Mã hóa dữ liệu thành chuỗi base64
        String base64String = Base64.getEncoder().encodeToString(binaryData);
        System.out.println("Base64 encoded: " + base64String);

        // Giải mã chuỗi base64 để nhận lại dữ liệu nhị phân ban đầu
        byte[] decodedData = Base64.getDecoder().decode(base64String);
        System.out.println("Decoded data: " + new String(decodedData));
    }
}

