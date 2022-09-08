package bitShift;

public class Bitshift {
	  public long ipToLong(String ipAddress) {
		  int okutetto1 = 192;
		  int okutetto2 = 168;
		  int okutetto3 = 1;
		  int okutetto4 = 2;
		  int fullIp = 0;
		  int value = 1;
		  int a = okutetto1 * 256;
		  // (okutetto1 * (256)^3) = 256の3乗をしてから最後にokutetto1を掛けてください
		  for(int i = 0; i < 3; i++) {
			  value = a * 256;
				System.out.println(value);
		  }
			System.out.println(value);

		   fullIp = (okutetto1 * (256)^3) + (okutetto2 * (256)^2) + (okutetto3 * (256)^1) + (okutetto4 * (256)^0);

			System.out.println(okutetto1 * (256)^3);

		   return fullIp;
	  }
}
