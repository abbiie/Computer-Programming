package complementa;

public class ComplementA {

    public static void main(String[] args) /*throws java.io.IOException*/ {
        java.util.Scanner in = new java.util.Scanner (System.in);
            //  java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.print("Enter Minuend: ");
            //int min = Integer.parseInt(br.readLine());
            int min = in.nextInt();
            System.out.print("Enter Subtrahend: ");
            //String sub = br.readLine();
            int sub = in.nextInt();
            String z = String.format("%09d", sub);
            String temp = z; 
            
            int max = Integer.toString(min).length();
            //set array length to the number of integer inputed in Min
            for (int i = 0; i < temp.length(); i++) {
                sub = 0 + sub;
            }

            String[] subArr = z.split("");;
            //split the array 
            int[] num = new int[subArr.length];
            //get array length
            for (int i = 0; i < subArr.length; i++) {
                num[i] = Integer.parseInt(subArr[i]);
            }

            int[] n = new int[num.length];
            for (int i = 0; i < num.length; i++) {
                for (int ii = 0; num[i] < 9; ii++) {
                    num[i]++;
                    n[i]++;
                }
            }

            String str = "";
            for (int i = 0; i < num.length; i++) {
                str += Integer.parseInt(Integer.toString(n[i]));
            }

            int add = Integer.parseInt(str);
            String ans = Integer.toString(min + add);

            if (ans.length() > max) {
                String temp1 = ans.substring(0,1);
                String temp2 = ans.substring(1, ans.length());
                int fin = Integer.parseInt(temp2) + Integer.parseInt(temp1);
                System.out.println("Answer: " + fin);
            } else if (ans.startsWith("9") && ans.endsWith("9")) {
                System.out.println("Answer: 0");
            }

        }
}