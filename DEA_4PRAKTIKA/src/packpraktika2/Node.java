package packpraktika2;

	public class Node<T extends Comparable<T>> {
		public T data; 			// dato del nodo
		public Node<T> next; 	// puntero al siguiente nodo de la lista
		public Node<T> prev; 	// puntero al anterior nodo de la lista
		// -------------------------------------------------------------

		public Node(T pElem) 		// constructor
		{
			data = pElem;
			next = null;
			prev = null;
		}
	}


