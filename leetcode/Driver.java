
public class Driver {
    public static void main(String[] args) {
        Solutions solutions = new Solutions(); 
        String[] strs = {"flower", "flow", "flight"}; 
        String soln = solutions.longestCommonPrefix(strs);
        
        System.out.println("Solution: " + soln); 
	}

}