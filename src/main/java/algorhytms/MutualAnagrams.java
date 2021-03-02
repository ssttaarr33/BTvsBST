package algorhytms;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
/*
An anagram is a word that can be written as a permutation of the characters of another word, like "dirty room" and "dormitory" (ignore spaces). However, "the" and "thee" are not anagrams, since "the" only has a single "e" whereas "thee" has two "e" characters (spaces can occur zero, or multiple times, however.)

Given a list of words as strings, you should return another list of strings, each containing words that are mutual anagrams.

Each string of the output should be a single group of anagarms joined with commas.

Within an output string, the expression should be sorted lexicographically. If a group contains only a single element, output that one-element group as a single string. And the string should be also output in lexicographical order. Given e.g.:

pear amleth dormitory tinsel dirtyroom hamlet listen silnet
... the output would be:

amleth,hamlet
dirty room,dormitory
listen,silnet,tinsel
pear
 */

public class MutualAnagrams {
    List<AnagramPair> pairs;

    public MutualAnagrams() {
        this.pairs = new ArrayList<>();
    }

    public List<AnagramPair> checkPairs(String inputData) {
        List<String> words = Arrays.asList(inputData.split(" "));

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (checkAnagram(words.get(i), words.get(j))) {
                    addToPairList(words.get(i), words.get(j));
                }
            }
        }
        for (int i = 0; i < words.size(); i++) {
            addMissedWords(words.get(i));
        }
        return pairs;
    }

    void addMissedWords(String wrd) {
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).wordPairs.contains(wrd)) {
                return;
            }
        }
        List<String> pair = new ArrayList<>();
        pair.add(wrd);
        pairs.add(new AnagramPair(pair));
    }

    void addToPairList(String a, String b) {
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).wordPairs.contains(a) && !pairs.get(i).wordPairs.contains(b)) {
                pairs.get(i).wordPairs.add(b);
                return;
            } else if (pairs.get(i).wordPairs.contains(b) && !pairs.get(i).wordPairs.contains(a)) {
                pairs.get(i).wordPairs.add(a);
                return;
            } else if (pairs.get(i).wordPairs.contains(a) && pairs.get(i).wordPairs.contains(b)) {
                return;
            }
        }
        List<String> pair = new ArrayList<>();
        pair.add(a);

        pair.add(b);
        pairs.add(new AnagramPair(pair));
    }

    boolean checkAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();

            Arrays.sort(aChars);
            Arrays.sort(bChars);
            for (int z = 0; z < aChars.length; z++) {
                if (aChars[z] != bChars[z]) {
                    return false;
                }
            }
            return true;
        }
    }

    @AllArgsConstructor
    public static class AnagramPair {
        List<String> wordPairs;
    }


}
