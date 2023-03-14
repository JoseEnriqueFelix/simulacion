import java.util.*;
import java.math.BigInteger;

public class MetodosPseudoAlgoritmos {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        int operacion;
        while (true) {
            System.out.println();
            System.out.println("INGRESE METODO DE GENERACION  \n1)MEDIO CUADRADO \n2)NEWMAN  \n3)SALIR");
            operacion = scanner.nextInt();
            switch (operacion) {
                case 1 -> menuMetodoCuadrado();
                case 2 -> menuMetodoNewman();
                case 3 -> {
                    System.out.println("SALIENDO");
                    System.exit(0);
                }
            }
        }
    }

    public static void menuMetodoCuadrado() {
        System.out.println("HA SELECCIONADO METODO DE MEDIO CUADRADO");
        boolean esPorTeclado = esPorTeclado();
        if (esPorTeclado) {
            boolean flag = true;
            while (flag) {
                System.out.println("INGRESE NUMERO (4 digitos)");
                int numero = scanner.nextInt();
                String strNumber = String.valueOf(numero);
                if (strNumber.length() == 4) {
                    flag = false;
                    System.out.printf("GENERAR CON EL NUMERO: %s %n%n", numero);
                    medioCuadrado(numero);
                }
            }
        } else {
            int numeroAleatorio = random.nextInt(1000, 9999);
            System.out.printf("GENERAR CON EL NUMERO: %s %n%n", numeroAleatorio);
            medioCuadrado(numeroAleatorio);
        }
    }

    public static void medioCuadrado(int numero) {
        ArrayList<Integer> numerosGenerados = new ArrayList<>();
        numerosGenerados.add(numero);
        boolean noSeRepite = true;
        while (noSeRepite) {
            numero = (int) Math.pow(numero, 2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(numero));
            while (stringBuilder.length() < 8) {
                stringBuilder.insert(0, "0");
            }
            String strNumber = stringBuilder.substring(2, 6);
            numero = Integer.parseInt(strNumber);
            if (numerosGenerados.contains(numero)) noSeRepite = false;
            numerosGenerados.add(numero);
        }
        imprimirInformacion(numero, numerosGenerados);
    }

    public static void imprimirInformacion(int numero, ArrayList<Integer> numerosGenerados) {
        System.out.println("LOS NUMEROS GENERADOS SON: ");
        System.out.println("============================");
        for (int i = 0; i < numerosGenerados.size(); i++) {
            System.out.printf("x%s) %s %n", i, numerosGenerados.get(i));
        }
        System.out.println();
        System.out.printf("SE HAN GENERADO: %s NUMEROS %n", numerosGenerados.size());
        String mensaje;
        if (numero == 0) {
            mensaje = "SE HA LLEGADO A 0";
        } else {
            mensaje = String.format("SE HA REPETIDO EL NUMERO: %s", numero);
        }
        System.out.println(mensaje);
    }

    public static void menuMetodoNewman() {
        System.out.println("HA SELECCIONADO METODO DE NEWMAN");
        boolean esPorTeclado = esPorTeclado();
        if (esPorTeclado) {
            boolean flag = true;
            while (flag) {
                System.out.println("INGRESE NUMERO (10 digitos)");
                BigInteger numero = scanner.nextBigInteger();
                String strNumber = String.valueOf(numero);
                if (strNumber.length() == 10) {
                    flag = false;
                    System.out.printf("GENERAR CON EL NUMERO: %s %n%n", numero);
                    metodoNewman(numero);
                }
            }
        } else {
            Long numeroAleatorio = random.nextLong(1000000000, 9999999999L);
            String strNumber = String.valueOf(numeroAleatorio);
            BigInteger bigInteger = new BigInteger(strNumber);
            System.out.printf("SE HA GENERADO EL NUMERO: %s %n", numeroAleatorio);
            metodoNewman(bigInteger);
        }
    }

    public static void metodoNewman(BigInteger numero) {
        ArrayList<BigInteger> numerosGenerados = new ArrayList<>();
        numerosGenerados.add(numero);
        BigInteger numeroAlCuadrado = numero.pow(2);
        String strNumber = String.valueOf(numeroAlCuadrado);
        int numeroDeCaracters = strNumber.length();
        if (numeroDeCaracters % 2 == 0) {
            strNumber = "0" + strNumber;
            numeroDeCaracters++;
        }
        int lowerLimit = (numeroDeCaracters / 2) - 2;
        int upperLimit = (numeroDeCaracters / 2) + 3;
        String newStrNumber = strNumber.substring(lowerLimit, upperLimit);
        BigInteger bigInteger = new BigInteger(newStrNumber);
        numerosGenerados.add(bigInteger);
        boolean flag = true;
        while (flag) {
            bigInteger = bigInteger.pow(2);
            String bigIntegerStr = String.valueOf(bigInteger);
            int numCaractersBigInt = bigIntegerStr.length();
            if (numCaractersBigInt % 2 == 0) {
                bigIntegerStr = "0" + bigIntegerStr;
                numCaractersBigInt++;
            }
            if (bigIntegerStr.length() > 6) {
                lowerLimit = (numCaractersBigInt / 2) - 2;
                upperLimit = (numCaractersBigInt / 2) + 3;
                bigIntegerStr = bigIntegerStr.substring(lowerLimit, upperLimit);
            }
            BigInteger newBigInteger = new BigInteger(bigIntegerStr);
            if (numerosGenerados.contains(newBigInteger)) {
                flag = false;
            }
            numerosGenerados.add(newBigInteger);
            bigInteger = newBigInteger;
        }
        printNewman(bigInteger, numerosGenerados);
    }

    public static void printNewman(BigInteger numero, ArrayList<BigInteger> numerosGenerados) {
        System.out.println("LOS NUMEROS GENERADOS SON: ");
        System.out.println("==============================");
        for (int i = 0; i < numerosGenerados.size(); i++) {
            System.out.printf("x%s) %s %n", i, numerosGenerados.get(i));
        }
        System.out.printf("SE HAN GENERADO: %s NUMEROS %n", numerosGenerados.size());
        String mensaje;
        if (numero.compareTo(BigInteger.ZERO) == 0) {
            mensaje = "SE HA LLEGADO A 0";
        } else {
            mensaje = String.format("SE HA REPETIDO EL NUMERO: %s", numero);
        }
        System.out.println(mensaje);
    }


    public static boolean esPorTeclado() {
        System.out.println();
        System.out.println("INGRESE METODO DE GENERACION  \n1)TECLADO \n2)RANDOM");
        int operacion = scanner.nextInt();
        if (operacion == 1) {
            return true;
        } else if (operacion == 2) {
            return false;
        }
        return esPorTeclado();
    }
}
