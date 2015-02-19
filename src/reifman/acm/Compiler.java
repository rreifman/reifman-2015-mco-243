package reifman.acm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compiler {

	public static void main(String[] args) {

		try {
			Scanner input = new Scanner(new File("compilerCode.txt"));
			char[] output = new char[256];

			for (int i = 0; i < output.length; i++) {
				output[i] = '0';
			}

			int counter = 0;
			while (input.hasNextLine()) {

				String instruction = input.next();
				switch (instruction) {
				case "LD": {
					int address = input.nextInt();
					String hex = Integer.toHexString(address);
					hex.toUpperCase();
					output[counter] = '0';
					if (address > 16) {
						output[counter + 1] = hex.charAt(0);
						output[counter + 2] = hex.charAt(1);
					} else {
						output[counter + 1] = '0';
						output[counter + 2] = hex.charAt(0);
					}
					counter = counter + 3;
					break;
				}
				case "ST": {
					int address = input.nextInt();
					String hex = Integer.toHexString(address);
					hex.toUpperCase();
					output[counter] = '1';
					if (address > 16) {
						output[counter + 1] = hex.charAt(0);
						output[counter + 2] = hex.charAt(1);
					} else {
						output[counter + 1] = '0';
						output[counter + 2] = hex.charAt(0);
					}
					counter = counter + 3;
					break;
				}
				case "SWP": {
					output[counter] = '2';
					counter++;
					break;
				}
				case "ADD": {
					output[counter] = '3';
					counter++;
					break;
				}
				case "INC": {
					output[counter] = '4';
					counter++;
					break;
				}
				case "DEC": {
					output[counter] = '5';
					counter++;
					break;
				}
				case "BZ": {
					int address = input.nextInt();
					String hex = Integer.toHexString(address);
					hex.toUpperCase();
					output[counter] = '6';
					if (address > 16) {
						output[counter + 1] = hex.charAt(0);
						output[counter + 2] = hex.charAt(1);
					} else {
						output[counter + 1] = '0';
						output[counter + 2] = hex.charAt(0);
					}
					counter = counter + 3;
					break;
				}
				case "BR": {
					int address = input.nextInt();
					String hex = Integer.toHexString(address);
					hex.toUpperCase();
					output[counter] = '7';
					if (address > 16) {
						output[counter + 1] = hex.charAt(0);
						output[counter + 2] = hex.charAt(1);
					} else {
						output[counter + 1] = '0';
						output[counter + 2] = hex.charAt(0);
					}
					counter = counter + 3;
					break;
				}
				case "STP": {
					output[counter] = '8';
					counter++;
					;
					break;
				}
				case "DATA": {
					int address = input.nextInt();
					String hex = Integer.toHexString(address);
					hex.toUpperCase();
					output[counter] = '9';
					if (address > 16) {
						output[counter + 1] = hex.charAt(0);
						output[counter + 2] = hex.charAt(1);
					} else {
						output[counter + 1] = '0';
						output[counter + 2] = hex.charAt(0);
					}
					int data = input.nextInt();
					String hexTwo = Integer.toHexString(data);
					hexTwo.toUpperCase();
					if (address > 16) {
						output[counter + 3] = hex.charAt(0);
						output[counter + 4] = hex.charAt(1);
					} else {
						output[counter + 3] = '0';
						output[counter + 4] = hex.charAt(0);
					}
					counter = counter + 5;
					break;
				}
				case "//": {
					break;
				}

				}
				input.nextLine();
			}

			for (int i = 0; i < output.length; i++) {
				System.out.print(output[i]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
