package generics;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Generics = 	enable types (classes and interfaces) to be parameters when defining:
		//			  	classes, interfaces and methods
		//				a benefit is to eliminate the need to create multiple versions
		//				of methods or classes for various data types.
		//				Use 1 version for all reference data types.
		
		Integer[] intArray = {1,2,3,4,5}; 
		Double[] doubleArray = {1.1,2.2,3.3,4.4,5.5}; 
		Character[] charArray = {'H','E','L','L','O'}; 
		String[] stringArray = {"BB","YY","EE"}; 
		
		GenericClass<Integer, Double> myInt = new GenericClass<>(1,2.2);
		GenericClass<String, Long> myStr = new GenericClass<>("Hello",1L);
		GenericClass<Character, Float> myChar = new GenericClass<>('C', 1.1F);

		System.out.println(displayArray(intArray));
		System.out.println(displayArray(doubleArray));
		System.out.println(displayArray(charArray));
		System.out.println(displayArray(stringArray));
		System.out.println(myChar.getValue());
		System.out.println(myInt.getValue());
		
	}
	
	public static <T> ArrayList<T> displayArray(T[] array) {
		ArrayList<T> arrayResult = new ArrayList<>();
		for(T x:array) {
			arrayResult.add(x);
		}
		return arrayResult;
	}

}
