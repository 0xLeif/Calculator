package mwhs.apcs.zeriksen.postfix;

import java.util.ArrayList;
import java.util.List;

import mwhs.apcs.zeriksen.mathtoken.MathToken;

public class MyStack<E> implements Stack<E>{
	private List<E> list;

	public MyStack() {
		list = new ArrayList<E>();
	}

	@Override
	public void push(E object) {
		list.add(object);
	}

	@Override
	public E pop() {
		return list.remove(list.size() - 1);
	}

	@Override
	public E peek() {
		return list.get(list.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	public String toString() {
		boolean start = true;
		int max = 0;
		String sum = "";
		String tacks = "";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).toString().length() > max) {
				max = list.get(i).toString().length();
			}
		}
		for (int i = 0; i < max+2; i++) {
			tacks += "-";

		}
		for (int i = list.size() - 1; i >= 0; i--) {
			if (start == true) {
				sum += tacks + "\n";
				start = false;
			}
			sum += "|" + list.get(i) + spaceCount(list.get(i).toString(), max) +"|" + "\n";
			sum += tacks + "\n";
		}
		return sum;
	}
	
	public String spaceCount(String name, int max){
		String spaces = "";
		int nameSpaces = name.length();
		int numSpaces = max - nameSpaces;
		for (int i = 0; i < numSpaces; i++) {
			spaces += " ";
		}
		return spaces;
	}
}
