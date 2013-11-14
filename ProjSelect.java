import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ProjSelect {   
    private static Project[] projs;
    private static BufferedReader read;
    private static Random randomGenerator;
    private static int size;
    private static int posProfits; // total positive profits
  
    public static void main(String[] args) {
        
        read = new BufferedReader(new InputStreamReader(System.in));
        
        randomGenerator = new Random();
        
        try
        {
            System.out.print("Please enter number of projects : ");
            size = Integer.parseInt(read.readLine());
     
            // create array
            projs = new Project[size];
            posProfits = 0;
            
            // Creating projects 
            for(int i=0; i<size; i++) {
            	int x = randomGenerator.nextInt(50*size);
            	x -= 50*(size-i-1);
            	if (x > 0) posProfits += x;
            	Project p = new Project(i+1, x);
            	if (i > 0) {
            		int n = randomGenerator.nextInt(Math.min(i, 3))+1;
            		// System.out.println("n = "+n);
            		for (int j = 0; j < n; j++) {
            			x = randomGenerator.nextInt(i);
            			if (p.predecessor.contains(projs[x]) == false) p.predecessor.add(projs[x]);
            		}
                }
                projs[i] = p;
                if (size <= 30) p.display();
            }
            System.out.println("The sum of all positive profits = " + posProfits);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        // How to select a subset of projects such that the total profits of all selected
        // projects is maximal ? 
        // Note that if a project is selected, then all its predecessors will be selected.
    }
}
    
