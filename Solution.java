class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] r = ransomNote.toCharArray();
        char[] m = magazine.toCharArray();
        int count = 0;

        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < m.length ; j++) {
                if (r[i] == m[j]) {
                    r[i] = 1;
                    m[j] = 0;
                    count++;
                }
            }
        }
        return count == r.length;
    }
}