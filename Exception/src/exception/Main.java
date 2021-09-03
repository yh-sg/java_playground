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
	
/*************Catch different exceptions(From top(Most specific one shld be on top) to bottom(More generic ones on bottom))****************/
	
	//Checked exceptions - Compiler raises an error if not handled (IOException)
	//Unchecked exceptions - Compiler does not enforce handling (RunTimeException)
	
	private void arithemetic() throws InvalidStatementException {
		int i = 5;
		int j = 3;
		try {
			if(j==2) {
				throw new InvalidStatementException("Cannot be divided by 0");
			}
			int result = i / (j/2);
		}catch(InvalidStatementException e) {
			//to re-catch and throw again. So that it will not catch by other exception
			e.getMessage();
			e.getCause();
			throw e;
		}
		catch(ArithmeticException e){
		//do something about ArithmeticExpcetion
		}catch(Exception e){
		//	do something on exception e
		}
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

