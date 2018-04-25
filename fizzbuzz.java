package program_challenge;

public class fizzbuzz {

	public static void main(String[] args) {
		for (int i=0;i<100;i++) {
			String output="";
			if (i%3==0)
				output+="fizz";
			if (i%5==0)
				output+="buzz";
			if (output.trim().length()==0)
				output+=i;
			System.out.println(output);
			
		}

	}

}
