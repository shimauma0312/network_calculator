package network_calculator;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class memo_qa145403_2 {
	public static void main(String[] args) throws UnknownHostException {

		String sb = "255.255.240.0";

		System.out.println(maxHostCount(sb));

	}

	/**
	 * ホスト数を求める
	 */
	public static int maxHostCount(String sb) throws UnknownHostException {
		int result = 0;

		byte[] bSB = InetAddress.getByName(sb).getAddress();

		for (int i = 0; i < bSB.length; i++) {
			System.out.printf("%02X  ", (0x0ff & bSB[i]));
		}
		System.out.println();

		//16進数表記
		for (int i = 0; i < bSB.length; i++) {
			System.out.print(bSB[i]);
		}
		System.out.println();

		//2進数表記
		String binNum = "";
		for (byte b : bSB) {
			for (int i = 0; i < 8; i++) {
				binNum += String.format("%d", (b & 0x80) / 0x80);
				b <<= 1;
			}
		}
		System.out.println("binNum: "+binNum);

		//元の文字列長から"0"を""で置換(消去)した文字列長を計算して
		//0の個数を数える
		int x = binNum.length() - binNum.replace("0", "").length();

		//ホスト数を求める公式2^x-2
		result = (int) (Math.pow(2, x) - 2);

		//答え
		return result;
	}
}