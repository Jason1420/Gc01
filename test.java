public class test {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int n = 100000;
        String resultUsingString = getResultUsingString(n);
        System.out.println("Result using String: " + resultUsingString);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        long startTimeSB = System.nanoTime();
        String resultUsingStringBuilder = getResultUsingStringBuilder(n);
        System.out.println("Result using StringBuilder: " + resultUsingStringBuilder);
        long endTimeSB = System.nanoTime();
        long durationSB = (endTimeSB - startTimeSB);  //divide by 1000000 to get milliseconds.

        System.out.println("executed time String: " + duration/1000000 +"ms");
        System.out.println("executed time StringBuilder: " + durationSB/1000000 +"ms");

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
