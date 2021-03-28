public class Recursion {

    /**
     * @param args the command line arguments
     */
    public static boolean isPalindrome(char[] s, int index) {
        if (index < s.length) {
            if (s[index] == s[s.length - 1 - index]) {
                return isPalindrome(s, index + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int index) {
        if (index < s.length()) {
            if (s.charAt(index) == s.charAt((s.length() - 1) - index)) {
                return isPalindrome(s, index + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1,s.length()-1));
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        char[] chr = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        String str = "jom";
        boolean palindrome = isPalindrome(str);
        System.out.println(palindrome);
    }

}