import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// Require to be functional interface...
		// Similar to JS, 3 steps: 1. () , 2. -> 3. Return value
		
		//What is a functional interface?
		// An interface with only one abstract method!
		// Default,static and object methods does not count!
		
		// Supplier
		Supplier<String> supplier = () -> {
			System.out.println("Before hiya");
			return "Hiya!";
		};
		String string = supplier.get();
		System.out.println("String = " + string);
		
		// Consumer
		Consumer<Integer> consumer = (Integer t) -> System.out.println(t);
		consumer.accept(1);
		
		// Predicate
		Predicate<String> isEmpty = s -> s.isEmpty();
		System.out.println(isEmpty.test(""));
		
		// Function
		Function<Main, String> getName = main -> main.getName("Rena");
		Main mainClass = new Main();
		getName.apply(mainClass);
		
		// Runnable
		Runnable alert = () -> System.out.println("Hey!");
		alert.run();
		
		// Filter
		List<String> strings = new ArrayList<>(List.of("one","two","three","four","five"));
		List<String> filteredStrings = strings.stream().filter(e -> e.startsWith("f")).collect(Collectors.toList());;
		System.out.println(filteredStrings);
		
		//! This is equivalent to:
		Predicate<String> filter = s -> !s.startsWith("t");
		strings.removeIf(filter);
		Consumer<String> action = s -> System.out.println(s);
		strings.forEach(action);
		
		//Map
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> numsList = nums.stream().map(e -> e*2).collect(Collectors.toList());
		System.out.println(numsList);
		
		//Chaining Lambda
		Consumer<String> c1 = s -> System.out.println("first " + s);
		Consumer<String> c2 = s -> System.out.println("second " +s);

		Consumer<String> c3 = c1.andThen(c2);
		
		c3.accept("string");
		
		//Comparator
		List<String> stringsLength = new ArrayList<>(List.of("owlKitty","ow","owlkit","owlk","owlki"));
		Comparator<String> cmp = (s1,s2) -> Integer.compare(s1.length(), s2.length());
		stringsLength.sort(cmp);
		System.out.println(stringsLength);
	}
	
	private String getName(String name) {
		return name;
	}

}
