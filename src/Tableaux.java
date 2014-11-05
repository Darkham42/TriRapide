import java.util.*;

class Tableaux {

	private int tab[];
	private int NbElem;

	public Tableaux(int n) {
		tab = new int[n];
		NbElem = n;
		for (int i = 0; i < NbElem; i++)
			tab[i] = NbElem - i * 2;
	}

	public Tableaux(int n, int seed) {
		Random a = new Random(seed);
		tab = new int[n];
		NbElem = n;
		for (int i = 0; i < NbElem; i++)
			tab[i] = a.nextInt(14);
	}

	public int getNbElem() {
		return NbElem;
	}

	public void affiche(int ia, int ib) {
		for (int i = ia; i <= ib; i++)
			System.out.print(tab[i] + "   ");
		System.out.println();
	}

	private void placer(int binf, int bsup) {
		int temp = tab[binf];
		tab[binf] = tab[bsup];
		tab[bsup] = temp;
	}

	public void quicksort(int binf, int bsup) {
		int i = binf, j = bsup, pivot = tab[binf + (bsup - binf) / 2];

		while (i <= j) {
			while (tab[i] < pivot) {
				i++;
			}

			while (tab[j] > pivot) {
				j--;
			}

			if (i <= j) {
				placer(i, j);
				i++;
				j--;
			}
		}

		if (binf < j)
			quicksort(binf, j);
		if (i < bsup)
			quicksort(i, bsup);
	}

	public static void main(String argv[]) {
		Tableaux t = new Tableaux(6, 12345);
		t.affiche(0, t.getNbElem() - 1);
		t.quicksort(0, t.getNbElem() - 1);
		t.affiche(0, t.getNbElem() - 1);
	}
}