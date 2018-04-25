package program_challenge;
/*Write a function that provides change directory (cd) function for an abstract file system.
Notes:
•	Root path is '/'.
•	Path separator is '/'.
•	Parent directory is addressable as "..".
•	Directory names consist only of English alphabet letters (A-Z and a-z).
•	The function should support both relative and absolute paths.
•	The function will not be passed any invalid paths.
•	Do not use built-in path-related functions.*/

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Path {
    //private String path;
    ArrayDeque<String> aq;

    public Path(String path) {
    	String s[]=path.split("/");
    	List<String> list = Arrays.asList(s);
    	 aq = new ArrayDeque<>(list);
        
    }

    public String getPath() {
    	
    	String path="";
    	if (aq.getFirst().trim().length()!=0) {
    		path+="/";
    	}
    	for (String st:aq) {
    		path+=st+"/";
    	}
        return path.substring(0,path.length()-1);
    }

    public void cd(String newPath) {
    	
    	String s[]=newPath.split("/");
    	for (String st:s) {
    		if (st.equals("."))
    			continue;
    		if (st.equals(".."))
    			aq.removeLast();
    		else if(st.isEmpty()) {
    			aq.clear();
    		    			
    		}
    		else 
    			aq.addLast(st);
    	}

    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        //path.cd("../x");
        path.cd("/a/x/c/1");
        System.out.println(path.getPath());
    }
}