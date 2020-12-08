import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShoppingList {

	public static void main(String[] args) {
		
		LinkedHashSet<String> shoppingSet = new LinkedHashSet<String>();
		TreeMap<String, Double> priceList = new TreeMap<String, Double>();
		Scanner s = new Scanner(System.in);
		String item,brought = null;
		double price = 0,total = 0;
		while(true) {
			System.out.println("add item to your list: (when done type '0')");
			item = s.nextLine();
			if (item.equals("0")) {
				break;
			}
			else {
				shoppingSet.add(item);
			}
		}
		List<String> shoppingList = new LinkedList<String>(shoppingSet);
		System.out.println(shoppingList);
		
		for(int i = 0; i<shoppingList.size();) {
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			System.out.println("what did you brought: ");
			try {
				brought = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("price of "+brought+": ");
			try {
				price = Double.parseDouble(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			shoppingList.remove(brought);
			priceList.put(brought, price);
			System.out.println("remaining item in your list is: "+shoppingList);
		}
		
		valueComparator vc = new valueComparator(priceList);
		TreeMap<String, Double> sortedPriceList = new TreeMap<String, Double>(vc);
		sortedPriceList.putAll(priceList);
		System.out.println(sortedPriceList);
		
		List<Double> itarablePriceList = new ArrayList<Double>(priceList.values());
		
		//System.out.println(itarablePriceList);
		
		Iterator<Double> it = itarablePriceList.iterator();
		while(it.hasNext()) {
			total+=it.next();
		}
		System.out.println("total money spent is "+ total);
		
	
	}
}
