package testetarget;

import java.util.Scanner;

public class Teste1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, a = 0, b = 1, c = 0;
        boolean pertence = false;

        System.out.print("Digite um número: ");
        num = input.nextInt();

        while (c < num) {
            c = a + b;
            a = b;
            b = c;

            if (c == num) {
                pertence = true;
                break;
            }
        }

        if (pertence) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }
    }
}