package program_challenge;

public class BuyTicketHelper {
	
	static int[] daysTravel = new int[] {1,2,3,7,28,29};//11
	static int[] daysTravel1 = new int[] {1,2,3,7,10,14,16,17,18,20,28,29};//20
	static int[] daysTravel2 = new int[] {1,2,3,7,10,20,23,25,26,27,28,29,30};//20
	static int[] daysTravel3 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,14,15,17,19,20,22,24,25,26,27,28,29}; //coming 30 //should be 25
	static int[] daysTravel4 =new int[]{1,2,3,4};//coming as 8 , should be 7
	static int[] daysTravel5 =new int[]{1,6,12,18,24};//10
	static int[] daysTravel6 =new int[]{1,6,15,26,27,28};
	static int[] daysTravel7 =new int[]{5,7,8,9,15};
	static int[] daysTravel8 =new int[]{1,5,7,15,20,21};
	static int[] daysTravel9 =new int[]{15,22,29,30};
	static int[] daysTravel10 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,14,15,17,18,19,20,22,24,25,26,27,28,29};
	public BuyTicketHelper() {
		
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(getPrice(daysTravel));
		System.out.println(getPrice(daysTravel1));
		System.out.println(getPrice(daysTravel10));
	}
	
	public static int getPrice(int[] days)
	{
		// 30 days
				if(days.length > 27)
					return 30;
				else if(days.length <=3)
					return days.length*2;
				return calculatePrice(days);
	}
	
	public static int calculatePrice(int[] days)
	{
		int[] data = calculateWeeks(days);
		int weekPrice = data[0]*7;
		int dayPrice = (days.length - data[1]) * 2;
		
		int[] reverseArray = reverseArray(days);
		int[] data1 = calculateWeeks(reverseArray);
		int weekPrice1 = data[0]*7;
		int dayPrice1 = (days.length - data1[1]) * 2;
		
		int total =weekPrice+dayPrice;
		int total1 = weekPrice1+dayPrice1;
		return total1 < total ? total1:total;
	}
	
	private static int[] reverseArray(int[] validData)
	{
		for(int i = 0; i < validData.length / 2; i++)
		{
		    int temp = validData[i];
		    validData[i] = validData[validData.length - i - 1];
		    validData[validData.length - i - 1] = temp;
		}
		return validData;
	}
	
	public static int[] calculateWeeks(int[] days)
	{
		int week = 0;
		int day = 0;
		for(int ctr=0; ctr<days.length;ctr++)
		{
			if(ctr + 6 < days.length)
			{
				if(isItWeek(days[ctr],days[ctr+6]))
				{
					week+=1;
					day+=7;
					ctr+=7;
				}
			}
			 if(ctr + 5 < days.length)
			{
				if(isItWeek(days[ctr],days[ctr+5]))
				{
					week+=1;
					day+=6;
					ctr+=6;
				}
			}
			 if(ctr + 4 < days.length)
			{
				if(isItWeek(days[ctr],days[ctr+4]))
				{
					week+=1;
					day+=5;
					ctr+=5;
				}
			}
			 if(ctr + 3 < days.length)
			{
				if(isItWeek(days[ctr],days[ctr+3]))
				{
					week+=1;
					day+=4;
					ctr+=4;
				}
			}			
		}
		return new int[]{week,day};
	}
	
	private static boolean isItWeek(int startDay, int endDay)
	{
		if(startDay < endDay)
		return ((endDay-startDay) >3 && (endDay-startDay<7)) ? true :false;
		else
			return ((startDay-endDay) >3 && (startDay-endDay<7)) ? true :false;
	}
	
	

}

