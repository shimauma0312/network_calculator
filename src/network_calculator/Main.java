package network_calculator;

public class Main {

	public static void main(String[] args) {
		System.out.println("ネットワークアドレスを計算し、通信可能か判定します。");

		System.out.println("サーバー側の想定");
		String server_str = Processing.inputStr();

		System.out.println("クライアント側の想定");
		String client_str = Processing.inputStr();

		System.out.println(server_str);
		System.out.println(client_str);

	}



}
