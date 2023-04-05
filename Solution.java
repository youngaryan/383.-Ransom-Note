import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> mapR = new HashMap<>();
        Map<Character, Integer> mapM = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!mapR.containsKey(ransomNote.charAt(i)))
                mapR.put(ransomNote.charAt(i), 1);
            else {
                Integer count = mapR.get(ransomNote.charAt(i));
                mapR.put(ransomNote.charAt(i), ++count);
            }
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (!mapM.containsKey(magazine.charAt(i)))
                mapM.put(magazine.charAt(i), 1);
            else {
                Integer count = mapM.get(magazine.charAt(i));
                mapM.put(magazine.charAt(i), ++count);
            }
        }

        for (char key : mapR.keySet()) {
            if (!mapM.containsKey(key)) {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : mapR.entrySet()) {
            char key = entry.getKey();
            Integer value1 = entry.getValue();
            Integer value2 = mapM.get(key);
            if (value1>value2) {
                return false;
            }
        }

        //throw new RuntimeException(String.valueOf(mapR)+ mapM);
        return true;
    }
}