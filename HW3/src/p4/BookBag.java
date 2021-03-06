package p4;

import java.util.Arrays;

public class BookBag {

	private Book[] books;
	private int nElems;

	public BookBag(int max) {
		books = new Book[max];
		nElems = 0;
	}

	public int getNElems() {
		return nElems;
	}

	public void insert(Book book) {
		books[nElems++] = book;
	}

//	public Book sequentialSearchByISBN(Book book) {
//		for (int i = 0; i < nElems; i++) {
//			if (books[i].getIsbn().contentEquals(book.getIsbn())) {
//				return books[i];
//			}
//		}
//		return null;
//	}

	public Book[] getBooksArray() {
		return books;
	}

	public Book[] sequintialSearchByIsbn() {
		Book[] books2 = new Book[nElems];
		int countBooks = 0;
		int n = 0;
		while(n < 1000) {
			int rand = (int)(Math.random() * 1000);
			
		for (int i = 0; i < 1000; i++) {
			if (books[i].getIsbn().contentEquals(books[rand].getIsbn())) {
				books2[countBooks++] = books[i];
			}
		}
		n++;
		}
		Book[] books3 = Arrays.copyOf(books2, countBooks);
		return books3;
	}

	public Book binarySearchByISbn(Book book) {
		int low = 0;
		int high = nElems - 1;
//		int mid = 0;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (books[mid].getIsbn().compareTo(book.getIsbn()) > 0) {
				high = mid - 1;
			} else if (book.getIsbn().compareTo(books[mid].getIsbn()) == 0) {
				return books[mid];
			} else {
				low = mid + 1;
			}
		}
		return null;
	}

	public Book[] binarySearchByIsbn(String lastName) {// logn
		Book[] books2 = new Book[nElems];
		int high = nElems - 1;
		int low = 0;
		int countBooks = 0;
		while (high >= low) {
			int mid = (low + high) / 2;
			if ((books[mid].getAuthor().getLastName()).compareTo(lastName) == 0) {
				books2[countBooks++] = books[mid];
			}
			if ((books[mid].getAuthor().getLastName()).compareTo(lastName) > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		Book[] foundBooks = Arrays.copyOf(books2, countBooks);
		return foundBooks;
	}

	public void bubbleSortByISBN() {
		int out;
		int in;
		for (out = nElems - 1; out >= 1; out--) {
			for (in = 0; in < out; in++) {
				if (books[in].getIsbn().compareTo(books[in + 1].getIsbn()) > 0) {
					Book temp = books[in + 1];
					books[in + 1] = books[in];
					books[in] = temp;
//					swap(books[in], books[in+1]);
				}
			}
		}
	}

	public void bubbleSortByLastName() {// effort to sort one number : n, all is n^2, n*n
		int out;
		int in;

		for (out = nElems - 1; out >= 1; out--) {
			for (in = 0; in < out; in++) {
				if (books[in].getAuthor().getLastName().compareTo(books[in + 1].getAuthor().getLastName()) > 0) {
//					swap(books[in], books[in+1]);
					Book temp = books[in];
					books[in] = books[in + 1];
					books[in + 1] = temp;
				}
			}
		}
	}

	private void swap(Book book, Book book2) {
		Book temp = book;
		book = book2;
		book2 = temp;
	}

//	public Book deleteByIsbn(String isbn) {
//		int i;
//		int count;
//		for (i = 0; i < nElems; i++) {
//			if (books[i].getIsbn().contentEquals(isbn)) {
//				break;
//			}
//		}
//		Book temp = books[i];
//		if (i == nElems) {
//			return null;
//		} else {
//			for (int j = i; j < nElems - 1; j++) {
//				books[j] = books[j + 1];
//			}
//		}
//		nElems--;
//		return temp;
//
//	}

	public Book[] deleteByIsbn() {
		int i = 0;
		int n = 0;
		int[] indices = new int[nElems];
		int count = 0;
		while(n < 1000) {
			int rand = (int)(Math.random() * 1000);
		for (i = 0; i < 1000; i++) {
			if (books[i].getIsbn().contentEquals(books[rand].getIsbn())) {
				indices[count++] = i;
			}
		}
		n++;
		}
		Book[] temp = new Book[count];
		for (int j = 0; j < count; j++) {
			temp[j] = books[indices[j]];
			System.out.println("indices" + indices[j]);
		}
		if (indices.length == 0) {
			System.out.println("indices length" + indices.length);
			return null;
		} else {
			for (int j = 0; j < 1000; j++) {
				for (int k = indices[j]; k < n - 1; k++) {
					books[k] = books[k + 1];
				}
//				nElems--;
				n--;
			}
			return temp;
		}

	}

	public void selectionSort() {
		// n^2 n*(n-1)
		// for almost sorted n
		int out;
		int in;
		int min;
		for (out = 0; out < nElems - 1; out++) {
			min = out;
			for (in = out + 1; in < nElems; in++) {
				if (books[in].getIsbn().compareTo(books[min].getIsbn()) < 0) {
					min = in;
				}
			}
//					swap(out, min);
			Book temp = books[min];
			books[min] = books[out];
			books[out] = temp;
		}
	}

	public void insertionSort() {// (n*n/2) big o is n^2, if sorted or almost big o is n; n+2n
									// most efficient because it does not swap like other sorts. it makes 2 copies
									// instead.
		int in;
		int out;
		for (out = 1; out < nElems; out++) {
			Book temp = books[out];
			in = out;
			while (in > 0 && books[in - 1].getIsbn().compareTo(temp.getIsbn()) >= 0) {
				books[in] = books[in - 1];
				in--;
			}
			books[in] = temp;
		}
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(i + " " + books[i]);
		}
	}

}
