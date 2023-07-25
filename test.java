public class test {
    public static void main(String[] args) {

        int n = 100000;
        String resultUsingString = getResultUsingString(n);
        System.out.println("Result using String: " + resultUsingString);

//        String resultUsingStringBuilder = getResultUsingStringBuilder(n);
//        System.out.println("Result using StringBuilder: " + resultUsingStringBuilder);

    }

    // Sử dụng String để nối chuỗi
    public static String getResultUsingString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " " + i;
        }
        return result;
    }

    // Sử dụng StringBuilder để nối chuỗi
    public static String getResultUsingStringBuilder(int n) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(" ").append(i);
        }
        return resultBuilder.toString();
    }
}
