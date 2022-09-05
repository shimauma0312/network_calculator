package network_calculator;


import java.util.BitSet;


public class IPCreator {
 public static void getIP(BitSet bs){
        int result = 0;
        for(int i=31; i >= 0; i--){         
         if(bs.get(i)){
          result += Math.pow(2, i%8);
         }
         
         if(i%8 == 0) {
          System.out.print(result + " ");
          result = 0;
         }

        }
        System.out.println();

 }
}