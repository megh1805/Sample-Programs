package program_challenge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
// Using java 8 , in one line return state and cities with population greater than 5

class city {
	city(){
		
	}
	
	city (int x,String y,String z){
		population=x;
		state=y;
		name=z;
	}
	public int population;
	public String name;
	public String state;
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
  
}

public class MapOfCities {
	public static void main(String args[]) {
		List<city> l = Arrays.asList(
				new city(7,"haryana","gurgaon"),
				 new city(5,"gujrat","bhuj"),
				 new city(17,"rajasthan","jaipur"),
				 new city(27,"gujrat","baroda"),
				 new city(5,"haryana","rewari"),
				 new city(12,"UP","meerut"),
				 new city(10,"haryana","bhiwadi")
        );
		
		Map<String,List<city>> map=getMap(l,5);
		for (Map.Entry<String,List<city>> m:map.entrySet()) {
			System.out.println("***"+m.getKey()+"***");
			for (city c:m.getValue()) {
				System.out.println(c.name);
			}
		}
	}

	public static Map<String, List<city>> getMap(List<city> l,int population) {
		Map<String,List<city>> e=l.stream().filter(p->p.population>population).collect(Collectors.groupingBy(city::getState));
		return e;
	
	}

}
