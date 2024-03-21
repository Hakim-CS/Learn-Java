public class StringMatching {

    public static int stringMatching(String text, String pattern) {

        int n = text.length(); // the entire expression
        int m = pattern.length();

        for (int i = 0; i < n - m + 1; i++) {
            boolean found = true;
            for (int j = 0; j < m && found == true; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    found = false;
            }
            if (found == true)
                return i + 1; // Increment by 1 to reflect correct position
        }
        return -1; // Return -1 if pattern is not found
    }

    public static void main(String[] args) {

        String text = "Hello World";
        String pattern = "World";

        int num = stringMatching(text, pattern);

        if (num != -1) {
            System.out.println("The pattern is found at index: " + num + " in the text.");
        } else {
            System.out.println("The pattern is not found in the text.");
        }
    }
}
