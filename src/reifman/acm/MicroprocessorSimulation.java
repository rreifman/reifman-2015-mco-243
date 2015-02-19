package reifman.acm;

import java.util.Scanner;

public class MicroprocessorSimulation {

	public static void main(String args[]) {

		Scanner kybd = new Scanner(System.in);
		String input = kybd.next();
		char[] array = input.toCharArray();
		int counter = 0;
		char accA = '0';
		char accB = '0';

		while (counter < 256) {
			char code = array[counter];
			switch (code) {
			case '0': {
				String one = Character.toString(array[counter + 1]);
				String two = Character.toString(array[counter + 2]);
				String hex = one + two;
				hex = hex.toUpperCase();
				int addressDec = Integer.parseInt(hex, 16);
				accA = array[addressDec];
				counter = counter + 3;
				break;
			}
			case '1': {
				String one = Character.toString(array[counter + 1]);
				String two = Character.toString(array[counter + 2]);
				String hex = one + two;
				hex = hex.toUpperCase();
				int addressDec = Integer.parseInt(hex, 16);
				array[addressDec] = accA;
				counter = counter + 3;
				break;
			}
			case '2': {
				char temp = accA;
				accA = accB;
				accB = temp;
				counter++;
				break;
			}
			case '3': {
				String registerA = Character.toString(accA);
				int a = Integer.parseInt(registerA, 16);
				String registerB = Character.toString(accB);
				int b = Integer.parseInt(registerB, 16);
				int sumDec = a + b;
				String hex = Integer.toHexString(sumDec);
				hex = hex.toUpperCase();
				if (sumDec > 16) {
					accA = hex.charAt(1);
					accB = hex.charAt(0);
				} else {
					accA = hex.charAt(0);
					accB = '0';
				}
				counter++;
				break;
			}
			case '4': {
				String registerA = Character.toString(accA);
				int a = Integer.parseInt(registerA, 16);
				if(a == 15){
					a=0;
				}
				else{
					a = a + 1;
				}
				String hex = Integer.toHexString(a);
				hex = hex.toUpperCase();
				accA = hex.charAt(0);
				counter++;
				break;
			}
			case '5': {
				String registerA = Character.toString(accA);
				int a = Integer.parseInt(registerA, 16);
				if(a ==0){
					a = 15;
				}
				else{
					a = a - 1;
				}
				String hex = Integer.toHexString(a);
				hex = hex.toUpperCase();
				accA = hex.charAt(0);
				counter++;
				break;
			}

			case '6': {
				if (accA == '0') {
					String one = Character.toString(array[counter + 1]);
					String two = Character.toString(array[counter + 2]);
					String hex = one + two;
					int addressDec = Integer.parseInt(hex, 16);
					counter = addressDec;
				} else {
					counter = counter+3;
				}
				break;
			}
			case '7': {
				String one = Character.toString(array[counter + 1]);
				String two = Character.toString(array[counter + 2]);
				String hex = one + two;
				int addressDec = Integer.parseInt(hex, 16);
				counter = addressDec;
				break;
			}
			case '8': {
				counter = 256;
				break;
			}
			default: {
				counter++;
				break;
			}
			}

		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

	}
}
