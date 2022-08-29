package network_calculator;

import java.util.Scanner;

public class Processing {
	/*入力メソッド*/
	public static String inputStr() {

	    Scanner scanner = new Scanner(System.in);

        String str = null;

		System.out.println("IPドレスとサブネットマスクを入力してください");
		System.out.println("例： 192.168.0.0 255.255.255.0");

        System.out.print("入力:");
		str = scanner.next();

        return str;
	}
}
