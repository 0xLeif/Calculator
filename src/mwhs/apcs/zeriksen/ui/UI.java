package mwhs.apcs.zeriksen.ui;

import java.util.Scanner;

import mwhs.apcs.zeriksen.postfix.InfixToPostfix;
import mwhs.apcs.zeriksen.postfix.PostfixExpression;

public class UI {
	public static void main(String[] args) {
		while (true) {
			Scanner in = new Scanner(System.in);
			System.out.print("1) Solve an Equation \n" + "2) Exit \n");
			System.out.print("Please enter your option: ");
			String o = in.nextLine();
			if (o.equals("1")) {
				System.out.print("\nPlease enter your Equation: ");
				String problem = in.nextLine();
				try{
				InfixToPostfix infix = new InfixToPostfix(problem);
				PostfixExpression postfix = new PostfixExpression(
						infix.toPost());
				System.out.println(postfix.evaluate() + "\n");
				}catch (Exception e) {
					System.out.println("\nInvalid input, please try again");
				}
				} else {
				break;
			}
		}
	}
}
