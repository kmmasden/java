package solutions;

import java.util.Arrays;

public class P14_Lcf {
    
    // 14. longest common prefix
    public String longestCommonPrefix (String[] strs) {
            String answer = "";
            //Sort strings using Arrays.sort; if there is an empty string "", aka. strs[i].length == 0, then it will be in front 
            Arrays.sort(strs);

            if (strs[0].length() == 0) {
                return answer; 
            }

            //strs should contain strings with length > 0 now 
            //loop through and ensure that all strings start with same letter, and find shortest length 
            int shortestLength = 200;
            char c = strs[0].charAt(0); 
            String check = ""; 

            for (String s : strs) {
                //if doesn't start with first letter, then return 
                if (s.charAt(0) != c) {
                    return answer; 
                }
                
                if (s.length() < shortestLength) {
                    shortestLength = s.length(); 
                    check = s; 
                }
            }

            answer += check.substring(0, 1); 

            for (int i = 1; i < shortestLength; i++) {
                char checkChar = check.charAt(i); 
                boolean match = true; 

                for (String s : strs) {
                    char sChar = s.charAt(i);

                    if (checkChar != sChar) {
                        match = false;
                        break; 
                    }
                }
                if (!match) {
                    break;
                }
                answer+= String.valueOf(checkChar); 
            }
        return answer;
    }

}
