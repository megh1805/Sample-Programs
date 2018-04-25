package program_challenge;
//simulate chmod command in java
public class ChmodCommand {

	public static int symbolicToOctal(String permString) {
		String ret="";
		String one= permString.substring(0, 3);
		int sum = doCal(one);
		ret+=sum;
		String two= permString.substring(3,6);
		sum = doCal(two);
		ret+=sum;
		String three= permString.substring(6,9);
		sum = doCal(three);
		ret+=sum;

		return Integer.parseInt(ret);
	}

	private static int doCal(String permString) {
		int sum=0;
		for (int i=0;i<3;i++) {
			char x= permString.charAt(i);
			if (x == 'r') {
				sum+= 4;
			} else if (x == 'w') {
				sum+= 2;
			} else if (x == 'x') {
				sum+= 1;
			} else if (x == '-') {
				sum+= 0;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// Should write 752
		System.out.println(ChmodCommand.symbolicToOctal("rwxr-x-w-"));
	}

}
