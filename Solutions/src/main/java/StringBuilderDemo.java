package main.java;

import java.util.function.Function;
import java.util.function.Predicate;

import java.util.*;

class IkmTest {

	public static void main(String[] args) {
		SortedSet<Element> s = new TreeSet<Element>();
		s.add(new Element(15));
		s.add(new Element(10));
		s.add(new Element(25));
		s.add(new Element(10));
		System.out.println(s.first() + " " + s.size());
	}
}

class Element implements Comparable {
	int id;

	Element(int id) {
		this.id = id;
	}

	public int compareTo(Object obj) {
		Element e = (Element) obj;
		return this.id - e.id;
	}

	public String toString() {
		return "" + this.id;
	}
}

public class StringBuilderDemo {
	public static void main(String[] argList) {

	}
}