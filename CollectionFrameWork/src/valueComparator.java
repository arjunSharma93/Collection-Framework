import java.util.*;

public class valueComparator implements Comparator<String>{
	
	TreeMap<String, Double> tm;
	
	public valueComparator(TreeMap<String, Double> tm) {
		this.tm = tm;
	}

	

	@Override
	public int compare(String o1, String o2) {
		
		return tm.get(o2).compareTo(tm.get(o1));
	}

}
