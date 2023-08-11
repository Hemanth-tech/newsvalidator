package sampleTest;

public class SplitURL {
	
	public static void main(String[] args) {
		
		
		String url =" https://www.montereycountyweekly.com/";
		
		System.out.println("***************url.indent('/')**********************"+url.substring(9, url.indexOf('/', 9)));

		
		System.out.println("***************url.indent('/')**********************"+url.indexOf('h'));

		
		System.out.println("***************url.indent('/')**********************"+url.indexOf('/'));
		
		System.out.println("***************url.indent('/')**********************"+url.indexOf('/', 9));

		
//		url.substring(0, 0)
	}

}
