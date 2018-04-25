package program_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryRepresentation {
//number of zeros between two 1, in binary representation of int
	public static void main(String[] args) {
		
		int x=529;//1000010001
		System.out.println(solution(x));
	}
	 static void met(int j, int[] xt, List<Integer> m) {
		 int count=0;
		 int val=0;
			if (j+1!=xt.length&&xt[j+1]==0) {
				for (int k=j+1;k<xt.length;k++) {
					
					if (xt[k]==0) {
						count++;
						val=k;
					}else {
						
						break;
					}
				}
				if (val<xt.length-1)
				 m.add(count);
				
			}
		}
	
	public static int solution(int x) {
		
		String y=Integer.toBinaryString(x);
		List<Integer> m=new ArrayList<>();
		int[] xt = new int[y.length()];
		for(int i = 0; i < y.length(); i++) {
		    xt[i] = Integer.parseInt(String.valueOf(y.charAt(i)));
		}
		
		for (int j=0;j<xt.length;j++) {
			if (xt[j]==1) {
				met(j,xt,m);
			}
			
		}
		 if (m.isEmpty())
			 return 0;
		 else
		return Collections.max(m); 
		
		
		
//		List<Double> l=DoubleStream.of(x).boxed().collect(Collectors.toList());
//		Set<Double> foo = new HashSet<Double>(l);
//		Double[] array = foo.stream().toArray(Double[]::new); 
//		Arrays.sort(array);
//		double[] unboxed = Stream.of(array).mapToDouble(Double::doubleValue).toArray();
//		 double[] positives=Arrays.stream(unboxed).filter(s -> s >= 0).toArray();
//		int count =1;
//		boolean notFound=true;
//		while(notFound) {
//			notFound=false;
//			for (int i=0;i<positives.length;i++) {
//				if (positives[i]==count) {
//					notFound=true;
//					break; 
//				}
//			}
//			if (notFound)
//			count++;
//		}
//		return count; 
	}

}
