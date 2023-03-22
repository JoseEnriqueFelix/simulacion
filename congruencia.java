import java.util.*;
public class congruencia {
	static Scanner sc = new Scanner(System.in);
	static Random r = new Random();


	public static void main(String[] args) {
		while (true) {
			System.out.println("METODO DE LAS CONGRUENCIAS");
			System.out.println("Proporciona el valor de A: ____ (debe ser un numero entero impar, que no debera ser divisible por 3 o 5): ");
			int a = sc.nextInt();
			if (esParYDivisible3o4(a)) {
				System.out.println("El valor es un numero par. Ingresa uno valido");
				System.out.println("\n\n\n");
				continue;
			}
			System.out.println();
			System.out.println("Proporciona el valor de X: ");
			int x;
			if (esPorMetodoRandom()) {
				x = r.nextInt(1, 1000);
			} else {
				x = sc.nextInt();
			}
			System.out.println("SE HA GENERADO EL NUMERO: " + x);
			System.out.println();

			System.out.println("Proporciona el valor de C: ___: ");
			int c = sc.nextInt();
			if(numLong(c)){
				System.out.println("El valor de C no puede ser");
				System.out.println("\n\n\n");
				continue;
			}
			System.out.println("Proporciona el valor de M");
			int m;
			if (esPorMetodoRandom()) {
				m = r.nextInt(1, 10^63);
			} else {
				m = sc.nextInt();
			}
			System.out.println("SE HA GENERADO EL NUMERO: " + m);

			System.out.println();
			metodo(a, x, c, m);
			System.out.println();
		}
	}

	private static boolean numLong(int num) {
        boolean longi = num%200!=21;
        return longi;
    }

    public static void metodo(int a, int x, int c, int m){
		if(m == 1) {
			System.out.println("El valor de M no puede ser 1");
			System.exit(0);
		}
		ArrayList <Integer> mC = new ArrayList<>();
		mC.add(x);
		boolean flag = true;
		while(flag) {
			x = (a * x + c) % m;
			if(mC.contains(x)){
				mC.add(x);
				x = (a * x + c) % m;
				mC.add(x);
				flag = false;
			} else {
				mC.add(x);
			}
		}
        System.out.printf("%3s| %15s| %15s| %15s| %15s", "n", "Xn", "Xn+c", "xnC/m", "next"+"\n");
		for (int i = 0; i < mC.size() - 1; i++) {
			int current = mC.get(i);
			int next = mC.get(i + 1);
			int xnC = (current * a) + c;
			System.out.printf("%3s| %15s| %15s| %15s| %15s", i, current, xnC, xnC+"/"+ m, next+"\n");
		}
	}

	public static boolean esPorMetodoRandom() {
		System.out.println("INGRESE METODO DE GENERACION  \n1)TECLADO \n2)RANDOM");
		int operacion = sc.nextInt();
		if(operacion == 1) {
			return false;
		} else if(operacion == 2){
			return true;
		}
		System.out.println("OPCION NO VALIDA");
		return esPorMetodoRandom();
	}

	public static boolean esParYDivisible3o4(int num){
		boolean par = num % 2 == 0; //true
		boolean divisible3o4 = num % 3 == 0 || num % 5 == 0;   //true
		return par || divisible3o4;
	}

}