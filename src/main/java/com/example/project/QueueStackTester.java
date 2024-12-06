package com.example.project;

public class QueueStackTester {

	public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
		recsplit(q, oq, eq, q.length(), 1);	}
	public static <T> void recsplit(Queue<T> q, Queue<T> oq, Queue<T> eq, int count, int pos) {
		if (pos > count)
			return;
		T x = q.serve();
		q.enqueue(x);
		if (pos % 2 == 1) {
			if (!oq.full()) {
				oq.enqueue(x);	}
		} else {
			if (!eq.full()) 
				eq.enqueue(x);
		}
		recsplit(q, oq, eq, count, pos + 1);

	}

	public static <T> void remove(LinkedPQ<T> pq, int p) {
		LinkedPQ<T> tempPQ = new LinkedPQ<T>();
		int count = pq.length();
		for (int i = 0; i < count; i++) {
			PQElement<T> element = pq.serve();
			if (element.p >= p)
				tempPQ.enqueue(element.data, element.p);
		}
		count = tempPQ.length();
		for (int i = 0; i < count; i++) {
			PQElement<T> element = tempPQ.serve();
			pq.enqueue(element.data, element.p);	}
	}
	public static <T> boolean search(Stack<T> st, T e) {
		if (st.empty())
			return false;
		T top = st.pop();
		boolean found;

		if (top.equals(e))
		found = true;
		else		found = search(st, e);
		st.push(top);
		return found;
	}}
