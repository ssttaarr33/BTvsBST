package algorhytms;

import java.util.List;

public class Palindrome {

    public static boolean isPalindromeSentence(String str) {
        int i = 0;
        int j = str.length() - 1;
        str = str.toLowerCase();
        while (i <= j) {
            char left = str.charAt(i);
            char right = str.charAt(j);

            if (!(left >= 'a' && left <= 'z')) {
                i++;
            } else if (!(right >= 'a' && right <= 'z')) {
                j--;
            } else if (left == right) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPalindromePairs(List<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            for(int j = i + 1; j < words.size(); j++){
                String check_str = "";
                check_str = check_str + words.get(i) + words.get(j);
                if(isPalindrome(check_str)){
                    return true;
                }
                check_str = words.get(j) + words.get(i);
                if(isPalindrome(check_str)){
                    return true;
                }
            }
        }
        return false;
    }

}
