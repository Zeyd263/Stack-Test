public class MyMaths {
	
	public int gcd(int m, int n) {
		
		int r;
		if (n>m) {
			
			r = m;
			m = n;
			n = r;
		}
		
		r = m % n;
		while (r != 0) {
			
			m = n;
			n = r;
			r = m % n;
		}		
		return n;
	}
	
}
