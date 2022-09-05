package network_calculator;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ver03 {

	public static void main(String[] args) throws UnknownHostException {

		String ip = "192.168.130.130";
		String sb = "255.255.240.0";
		String nt = getNetworkAddress(ip,sb);

		System.out.println(nt);

		System.out.println();
		System.out.println(nt.substring(1));

	}

	public static String getNetworkAddress (String ip, String sb) throws UnknownHostException {

		byte[] bIP = InetAddress.getByName(ip).getAddress();
		byte[] bSB = InetAddress.getByName(sb).getAddress();
		byte[] bNT = new byte[4];

		for(int i = 0;i<bIP.length;i++) {
			System.out.printf("%02X  ", (0x0ff & bIP[i]));
		}
		System.out.println();

		for(int i = 0;i<bSB.length;i++) {
			System.out.printf("%02X  ", (0x0ff & bSB[i]));
		}
		System.out.println();

		for(int i = 0;i<bIP.length;i++) {

			bNT[i] = (byte) (bIP[i] & bSB[i]);
			System.out.printf("%02X  ", (0x0ff & bNT[i]));
		}
		System.out.println();

		return InetAddress.getByAddress(bNT).toString();

    }

//	IPアドレスが「192.168.125.130」
//	ネットマスクが「255.255.255.192｣のIPアドレスがあるとする。
//	192.168.125.130は2進数になおすと「11000000 10101000 01111101 10000010」となる。
//	255.255.255.192は2進数になおすと「11111111 11111111 11111111 11000000」となる。
//	これらを桁ごとに論理積を算出すると「11000000 10101000 01111101 10000000」となり、これがネットワークアドレスである。
//	10進数になおすと「192.168.125.128」となる。
}