package program_challenge;
//program to give cheapest travel option based on condition:
//if 7 days pass cost 7 rs
//1 day pass cost 2 rs
//30 day pass cost 25 rs
//input array of +ve number between 1-30
public class CheapestTravelOption {

	public static void main(String[] args) {
		//int[] A= {1,2,4,5,7,29,30};//--11
		//int A[]={1,2,3,4,5,6,7,8,9,10,11,12,14,15,17,19,20,22,24,25,26,27,28,29};//--25
		//int A[]= {1,2,3,4};//--7
		//int A[]= {1,6,12,18,24};//--10
		//int A[]= {1,6,15,26,27,28};//12
		int A[]= {1,2,3,7,10,20,22,23,24,26,27,28,29,30};
		//int A[]=new int[] {1,2,3,7,10,20,23,25,26,27,28,29,30};//--20
		//int A[]={5,7,8,9,15};//--9
		//int A[]= {1,5,7,15,20,21};//12
		//int A[]= {15,22,29,30};//8
		//int A[]= {1,2,3,4,5,6,7};
		//int A[]= {1,17,30};
		//int A[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		System.out.println(solution(A));


	}
	public static int solution(int[] A) {
		if(A.length>24) {
			return 25;
		}else if (A.length<=3) {
			return A.length*2;
		}else {
			boolean found=false;
			int sum=0;
			int lastIndex=0;
			for (int i=0;i<A.length;) {
				found=false;
				int week=A[i]+6;
				if (A.length-i<=3) {
					sum=sum+((A.length-i)*2);
					return returnValue(sum);
				}
			
				for (int k=i;k<A.length;k++){
					   if (A[k]<week ) {
						   if (k==A.length-1) {
								sum=sum+7;
								return returnValue(sum);
							}
							continue;
						}else {
							int compare=k-i;
							if (A[k]==week) {
								compare=(k+1)-i;
							}
							//int maxdays=A[k]==week?7:6;
							if(compare>3&&(compare==7||(!checkIfsomeMaxDAysexist(i+1,A,compare)))) {
								found=true;
								lastIndex=k;
								if (A[k]==week) {
									lastIndex=k+1;
								}
								sum=sum+7;
								break;

							}else {
								found=false;
								break;
							}
						}
					
				}
				if (!found) {
					sum=sum+2;
					i++;
				}else {
					i=lastIndex;
				}

			}
			return returnValue(sum);
		}

	}
	private static boolean checkIfsomeMaxDAysexist(int j, int[] A, int p) {
		int len=j-1+p;
		for (int i=j;i<len;) {//6,7,8
			int week=A[i]+6;
			for (int k=i;k<A.length;k++){
				if (A[k]<week ) {
					if (k==A.length-1) {
						int compare=k-i;
						if (compare>p) {
							return true;
						}
						else
						 return false;
					}
					continue;  
				} else {
					int compare=k-i;
					if (A[k]==week) {
						compare=(k+1)-i;
					}
					if (compare>p) {
						return true;
					}
					break;
				}//end else
			}
			i++;
		}
		return false;
	}
	private static int returnValue(int sum) {
		if (sum>25) {
			System.out.println("sum originally"+sum);
			return 25;
		}else {
		 return sum;
		}
	}
}
