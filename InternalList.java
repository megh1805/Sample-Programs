package program_challenge;
/*
 * Design a data structure with two methods:
 * 1) Implements an internal encapsulated sequential list of integers.The list can be appended to by calling
 * addLast(intt[])
 * 2)A second method containsSum3(int) returns true, if 3 consecutive elements in the list equal the given sum.
 * The implementation must be efficient.the second method must be better than o(n).
 * For example a new Sum3 begins with an empty list with no existing sum3s. AddLast{1,2,3} append elements {1,2,3}
 * resulting with elements {1,2,3} and with only one existing sum3(1+2+3=6).Addlst{4} appends element 4 resulting with element
 * {1,2,3,4} and two existing sum3s (1+2+3=6 and 2+3+4=9)
 * HINT:It is not an requirement to implement an internal list
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InternalList {

	private static List<Integer> intList = new ArrayList<Integer>();
	
	public List<Integer> getIntList() {
		return Collections.unmodifiableList(intList);
	}

	/**
	 * Adds/appends list of integers at the end of internal list.
	 */
	public void addLast(int[] list) {
		intList.addAll(Arrays.stream(list).boxed().collect(Collectors.toList()));
	}

	/**
	 * Returns boolean representing if any three consecutive integers in the
	 * internal list have given sum.
	 */
	public boolean containsSum3(int N) {
		List<Integer> intList1 = new ArrayList<Integer>(intList);
		Collections.sort(intList1);
		int sum = 0;
		for(int i = 0; i < intList1.size() - 1; ++i) { 
			for(int j = i+1;  j < intList1.size(); ++j) {
				for(int k=j+1;k<intList1.size();++k) {
					sum = intList1.get(i) + intList1.get(j)+intList1.get(k);
					if (sum==N)
						return true;
				}

			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		InternalList s = new InternalList();

		s.addLast(new int[] { 1, 2, 3 });

		System.out.println(s.containsSum3(6));
		System.out.println(s.containsSum3(9));

		s.addLast(new int[] { 4 });
		System.out.println(s.containsSum3(9));
	}
}

