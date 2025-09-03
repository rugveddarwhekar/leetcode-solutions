class Solution {
    public String sortVowels(String s) {
        List<Character> sVowels = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || 
            c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sVowels.add(c);
            }
        } 

        Collections.sort(sVowels);
        char[] chars = s.toCharArray();
        int i = 0;
        int sz = sVowels.size();
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || 
            c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                chars[j] = sVowels.get(i);
                i++;
            }
            if (i == sz) return new String(chars);
        } 

        return new String(chars);
    }
}