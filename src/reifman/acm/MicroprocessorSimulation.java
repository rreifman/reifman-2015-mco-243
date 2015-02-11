package reifman.acm;

import java.util.Scanner;

public class MicroprocessorSimulation {

	public static void main(String args[]) {

		Scanner kybd = new Scanner(System.in);
		String input = kybd.next();
		char[] array = input.toCharArray();
		int counter = 0;
		char accA;
		char accB;

		while (counter < 256) {
			char code = array[counter];
			switch (code) {
			case '0': {
				String addressHex = String.valueOf(array[counter + 1]
						+ array[counter + 2]);
				int addressDec = Integer.parseInt(addressHex, 16);
				accA = array[addressDec];
				counter = counter + 3;
				System.out.println(addressHex + " " + addressDec + " " + accA);
				break;
			}
			case '1': {
				counter++;
				break;
			}
			case '2': {
				counter++;
				break;
			}
			case '3': {
				counter++;
				break;
			}
			case '4': {
				counter++;
				break;
			}
			case '5': {
				counter++;
				break;
			}

			case '6': {
				counter++;
				break;
			}
			case '7': {
				counter++;
				break;
			}
			case '8': {
				counter = 256;
				break;
			}
			}

		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " " + array[i]);
		}

		/*
		 * while (counter < 256) {
		 * 
		 * switch (letter) { case 0: { break; } case 1: { break; } case 2: {
		 * break; } case 3: { break; } case 4: { break; } case 5: { break; }
		 * case 6: { break; } case 7: { break; } case 8: { break; } } counter++;
		 * }
		 */

	}

}
