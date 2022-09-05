package network_calculator;

import java.util.BitSet;

public class Main {

	public static void main(String[] args) {
		/*
		System.out.println("繝阪ャ繝医Ρ繝ｼ繧ｯ繧｢繝峨Ξ繧ｹ繧定ｨ育ｮ励＠縲�騾壻ｿ｡蜿ｯ閭ｽ縺句愛螳壹＠縺ｾ縺吶��");

		System.out.println("繧ｵ繝ｼ繝舌�ｼ蛛ｴ縺ｮ諠ｳ螳�");
		String server_str = Processing.inputStr();

		System.out.println("繧ｯ繝ｩ繧､繧｢繝ｳ繝亥�ｴ縺ｮ諠ｳ螳�");
		String client_str = Processing.inputStr();

		System.out.println(server_str);
		System.out.println(client_str);
		*/
		/*
		int client_ipstr = 19216801;
		long client_snstr = 2552552550L;
		System.out.println("クライアント側");
		System.out.println(client_ipstr);
		System.out.println(client_snstr);
		
		int server_ipstr = 19216802;
		long server_snstr = 255255255140L;
		System.out.println("鯖側");
		System.out.println(server_ipstr);
		System.out.println(server_snstr);
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");


*/

		  // サブネットマスク[255 0 0 0]をセット
		  BitSet subnet = new BitSet(32);
		  subnet.set(24, 32);
		  
		  System.out.print("サブネットマスク===>");
		  IPCreator.getIP(subnet);
		  
		  // IPアドレス[7 128 0 0]をセット
		  BitSet ip = new BitSet(32);
		  ip.set(23,27);
		  
		  System.out.print("IPアドレス===>");
		  IPCreator.getIP(ip);
		  
		  // ネットワークアドレスを計算
		  ip.and(subnet);
		  
		  // ネットワークアドレスを表示
		  System.out.print("ネットワークアドレス===>");
		  IPCreator.getIP(ip);
		  
		 }
		


	}




