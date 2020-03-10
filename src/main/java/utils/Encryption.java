package utils;

public class Encryption {
	public static String convert(String str) {

		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (Character.toString(a[i]).equals("0")) {
				a[i] = a[i];
			} else {
				a[i] = (char) (a[i] ^ 'y');
			}
		}
		String s = new String(a);
		return s;
	}
}
