package exception;

public class Main {

	public static void main(String[] args) {
		String reverseString = reverse(null);
		System.out.println(reverseString);
	}
	
	private static String reverse(String s) {
		//Throw - Create exception and transfer control
		//Catch - where execution is transferred and stated exception handled
		
		//2 categories of exceptions, checked and unchecked.
		
//		if(s==null) {
//			throw new NullPointerException("The parameter can't be null");
//		}
		
//		StringBuilder sb = new StringBuilder(s);
//		return sb.reverse().toString();
		
		String reversedString;
		
		try {
			if(s==null) {
				throw new Exception("The parameter can't be null");
			}
			StringBuilder sb = new StringBuilder(s);
			reversedString = sb.reverse().toString();
		}catch(Exception e) {
			reversedString = null;
			e.printStackTrace();
		}
		return reversedString;
	}

}
/******Typical TryCatch Block******/

//Scanner scanner = null;
//try {
//    scanner = new Scanner(new File("test.txt"));
//    while (scanner.hasNext()) {
//        System.out.println(scanner.nextLine());
//    }
//} catch (FileNotFoundException e) {
//    e.printStackTrace();
//} finally {
//    if (scanner != null) {
//        scanner.close();
//    }
//}

/******try-with-resources:*****/

//try (Scanner scanner = new Scanner(new File("test.txt"))) {
//    while (scanner.hasNext()) {
//        System.out.println(scanner.nextLine());
//    }
//} catch (FileNotFoundException fnfe) {
//    fnfe.printStackTrace();
//}