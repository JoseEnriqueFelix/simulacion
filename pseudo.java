import java.text.DecimalFormat;
import java.text.*;
import java.util.*;

class pseudo{
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static DecimalFormat df = new DecimalFormat("0.00");

    public static double calcVarianza(int[] numeros){
        double varianza=0;
        double media=calcMedia(numeros);
        for(int i=0; i<numeros.length; i++){
            varianza+=Math.pow(numeros[i]-media,2);
        }
        varianza=varianza/numeros.length;
        return varianza;
    }

    public static double calcMedia(int[] numeros){
        double media=0;
        for(int i=0; i<numeros.length; i++){
            media+=numeros[i];
        }
        media=media/numeros.length;
        return media;
    }

    public static void main(String[] args) {
        System.out.println("INGRESE METODO DE GENERACION  \n0)TECLADO \n1)RANDOM");
        int op=sc.nextInt();
        int n=0;

        if(op==0){
            System.out.println("INGRESE CANTIDAD");
            n= sc.nextInt();
        }
        else if (op==1){
            n= random.nextInt(0,1000);
        }
        int [] numeros= new int[n];

        for(int i=0; i<numeros.length; i++){
            numeros[i]=random.nextInt(0, 100000);
            System.out.println((i+1)+ ") "+numeros[i]);
        }

        System.out.println("SE HAN GENERADO: " + n + " NUMEROS");

        System.out.println("LA MEDIA ES: " + df.format(calcMedia(numeros)));
        System.out.println("LA VARIANZA ES: " + df.format(calcVarianza(numeros)));



    }
}