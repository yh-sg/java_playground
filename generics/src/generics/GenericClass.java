package generics;

//Bounded class on U
public class GenericClass <T, U extends Number> {
	
	T x;
	U y;
	
	GenericClass(T x, U y){
		this.x = x;
		this.y = y;
	}
	
	public T getValue() {
		return x;
	}
	
	public U getValue2() {
		return y;
	}
}
