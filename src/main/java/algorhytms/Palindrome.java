package algorhytms;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        str  = str.toLowerCase();
        while (i <= j) {
            char left = str.charAt(i);
            char right = str.charAt(j);

            if (!(left >= 'a' && left <= 'z')) {
                i++;
            } else if (!(right >= 'a' && right <= 'z')) {
                j--;
            } else if (left == right){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
