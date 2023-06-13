package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class B_21276 {
	static class Person {
		String name;
		int cntChilds;
		ArrayList<Person> parents;
		ArrayList<String> childs;
		
		public Person(String name) {
			this.name = name;
			this.parents = new ArrayList<>();
			this.childs = new ArrayList<>();
		}
		
		public void appendParent(Person parent) {
			this.parents.add(parent);
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", parents=" + parents + "]";
		}
	}
	static int N, M;
	static HashMap<Integer, Person> persons;
	static HashMap<String, Integer> indexing;
	static ArrayList<Person> list;
	static int idx;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		persons = new HashMap<>();
		indexing = new HashMap<>();
		
		// 받아오기 + indexing
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			String name = st.nextToken();
			Person tmp = new Person(name);
			indexing.put(name, idx);
			persons.put(idx++, tmp);
		}
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String child = st.nextToken();
			String parent = st.nextToken();
			int index = indexing.get(child);
			
			persons.get(index).appendParent(persons.get(indexing.get(parent)));
		}
		
		persons.forEach((key, value) -> {
			System.out.println("index : " + key);
			System.out.println("name : " + value.name);
			System.out.println("parents : " + value.parents.toString());
			System.out.println();
		});
		
		list = new ArrayList<>();
		
		persons.forEach((key, value) -> {
			list.add(value);
		});
		
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		for (Person p : list) {
			if (p.parents.size() > 1) {
				Collections.sort(p.parents, new Comparator<Person>() {
					@Override
					public int compare(Person o1, Person o2) {
						return o2.parents.size() - o1.parents.size();
					}
				});
				p.parents.get(0).cntChilds++;
				p.parents.get(0).childs.add(p.name);
			}
			if (p.parents.size() == 1) {
				p.parents.get(0).cntChilds++;
				p.parents.get(0).childs.add(p.name);
			}
		}
		
		for (Person p : list) {
			if (p.parents.size() == 0)
				cnt++;
		}
		System.out.println(cnt);
		for (Person p : list) {
			if (p.parents.size() == 0)
				System.out.print(p.name + " ");
		}
		System.out.println();
		
		for (Person p : list) {
			System.out.print(p.name + " ");
			System.out.print(p.cntChilds + " ");
			for (int i = 0; i < p.childs.size(); i++) {
				System.out.print(p.childs.get(i) + " ");
			}
			System.out.println();
		}
		
	}

}
