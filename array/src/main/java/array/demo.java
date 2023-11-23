package array;

public class demo {
    public static void main(String[] args) {
        try {
            StringBuilder s = new StringBuilder();
            s.append("123");
            System.out.println(s);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(1123);
        }
    }
}
