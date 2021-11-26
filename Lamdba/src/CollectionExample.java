import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionExample {
	
	private String name;
	private int weight;
	
	public static void main(String[] args) {
		CollectionExample doll1 = new CollectionExample("Vodka", 12);
		CollectionExample doll2 = new CollectionExample("Teio", 23);
		CollectionExample doll3 = new CollectionExample("Spe-Chan", 35);
		CollectionExample doll4 = new CollectionExample("Teio", 22);
		
		Collection<CollectionExample> umaCollections = new ArrayList<>();
		umaCollections.add(doll1);
		umaCollections.add(doll2);
		umaCollections.add(doll3);
		umaCollections.add(doll4);
		
		//forEach - this cannot modify like remove/add
//		for(CollectionExample umaDoll:umaCollections) {
//			System.out.println(umaDoll);
//		}
		
		//Solution, use iterator, it acts like a cursor goes through one by one of the collection
//		Iterator<CollectionExample> iterator = umaCollections.iterator();
//		while(iterator.hasNext()) {
//			CollectionExample umaCollection = iterator.next();
//			
//			if(umaCollection.getWeight()>25) {
//				iterator.remove();
//			}
//		}
//		System.out.println(umaCollections);
		
		//using stream
		umaCollections
			.stream()
			.filter(e->e.getWeight()<25)
			.sorted(Comparator.comparingInt(CollectionExample::getWeight))
			.map(CollectionExample::getName)
			.forEach(System.out::println);
		
		List<CollectionExample> lightCollection = umaCollections
				.stream()
				.filter(e->e.getWeight()<25)
				.sorted(Comparator.comparingInt(CollectionExample::getWeight))
				.collect(Collectors.toList());
		
		Map<String, List<CollectionExample>> lightUma = umaCollections
				.stream()
				.filter(e->e.getWeight()<25)
				.sorted(Comparator.comparingInt(CollectionExample::getWeight))
				.collect(Collectors.groupingBy(CollectionExample::getName));
		
		boolean answer = umaCollections.stream().anyMatch(e->e.getName()=="Teio");
		System.out.println(lightUma);
			
	}
	
	public CollectionExample(String name, int weight) {
		this.name=name;
		this.weight=weight;
	}
	
	private int getWeight() {
		return this.weight;
	}
	
	private String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "CollectionExample [name=" + name + ", weight=" + weight + "]";
	}

}
