class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int minLength = Math.min(prefix.length(), strs[i].length());
            int index = 0;
            while (index < minLength) {
                if (prefix.charAt(index) == strs[i].charAt(index)) {
                    index++;
                } else {
                    break;
                }
            }
            prefix = prefix.substring(0, index);
        }
        return prefix;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean flag = true;
        while (flag) {
            char key = ' ';
            for (String s : strs) {
                if (index >= s.length()) {
                    flag = false;
                    break;
                } else {
                    if (key == ' ') {
                        key = s.charAt(index);
                    } else if (key != s.charAt(index)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                sb.append(key);
            }
            index++;
        }
        return sb.toString();
    }
}