/*
 * SPDX-FileCopyrightText: 2024 Abdesselam Boutchich <zeyd.boutchich@gmail.com>
 *
 * SPDX-License-Identifier: GPL-3.0-or-later
 */
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
