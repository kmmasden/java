package solutions;

//problem not worded clearly, will return
public class P20_ValidParenthesis {

    public static void main (String args[]) {
        P20_ValidParenthesis prob = new P20_ValidParenthesis(); 

        String test = "(([)[[]])"; 

        System.out.println(prob.isValid(test));
    }

    public enum Brackets {
        ROUND('(',')'),
        SQUARE('[',']'),
        CURLY('{','}');
        
        private final char left;
        private final char right; 

        Brackets (char l, char r) {
            this.left = l;
            this.right = r; 
        }

        public char getLeft() {
            return left;
        }

        public char getRight() {
            return right; 
        }
    }

    public boolean isValid(String s) {
        //First check if lenght is valid 
        int sLength = s.length(); 
        if (sLength % 2 != 0) {
            //uneven amount of characters, means at least 1 pair incomplete
            return false; 
        }
        //Confirmed s is string of even length
        //First sort out each type of bracket into own array 
        boolean valid = true; 

        for (Brackets bracket : Brackets.values()) {
            if (!isValidByType(s, bracket)) {
                valid = false; 
                break; 
            }

            if (!valid) {
                break;
            }
        }

        return valid; 
    }

    private boolean isValidByType(String s, Brackets type) {

        String sBrackets = ""; 
        int nLeft = 0;
        int nRight = 0; 
    
        for (char c : s.toCharArray()) {
            if (c == type.getLeft()) {
                nLeft++; 
                sBrackets += String.valueOf(c); 
            } else if (c == type.getRight()) {
                nRight++; 
                sBrackets += String.valueOf(c); 
            }
            
            //if nRight is > nLeft at any time, then there is a bracket in wrong order than wont be able to be closed
            if (nRight > nLeft) {
                return false; 
            }
            
        }
        //now sBrackets should contain only characters from String s that are of the specified Brackets type 
    
        //it's convenient here to also check for things automatically disqualifying as invalid 
        //such as, uneven number of like brackets 
        //if nLeft != nRight
        
        if ((sBrackets.length() % 2 != 0) || (nLeft != nRight)) {
            return false; 
        } 
        return true; 
    }
}