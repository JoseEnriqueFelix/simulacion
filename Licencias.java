import java.util.Random;
import java.util.Scanner;

class Licencias{
    static Random rnd=new Random();
    static Scanner sc=new Scanner(System.in);

    static int interpretarProbabilidades(float r){
        int licencias;
        if(r<=0.3){
            licencias=100;
        }
        else if(r>0.3 && r<=0.5){
            licencias=150;
        }
        else if(r>0.5 && r<=0.8){
            licencias=200;
        }
        else if(r>0.8 && r<=0.95){
            licencias=250;
        }
        else{
            licencias=300;
        }
        return licencias;
    }

    static double calcmedia(int arr[]){
        int suma=0;
        for (int i=0;i<arr.length; i++){
            suma=suma + arr[i];
        }
        double media=suma/arr.length;
        return media;
    }

    static double calcvarianza(int arr[], double media){
        double suma=0;
        for (int i=0; i<arr.length; i++){
            suma+= (arr[i] - media)*(arr[i] - media);
        }
        double varianza=suma/arr.length;
        double desvEstandar=Math.sqrt(varianza);
        return desvEstandar;
    }

    static void generarTabla(int n, int l){
        int costo=75*l;
        int ingvta;
        int ingdev;
        int utilidad;
        int [] arr=new int[n];
        float r;
        int lv;
        int ld;
        System.out.format("%17s %17s %17s %17s %17s %17s %17s %17s", "N", "#aleagen", 
        "Lic. vendidas", "Lic. devueltas","Costo", "Ing X Vta", "Ing X Dev", "Utilidad");
        System.out.println();
        for (int i=0; i< n; i++){
            r=rnd.nextFloat();
            lv=interpretarProbabilidades(r);
            if(l<=lv){
                lv=l;
            }
            ld=l-lv;
            ingvta=100*lv;
            ingdev=25*ld;
            utilidad=(ingvta+ingdev)-costo;
            arr[i]=utilidad;
            System.out.format("%17s %17s %17s %17s %17s %17s %17s %17s",
             i+1, r, lv, ld, costo, ingvta, ingdev, utilidad);
             System.out.println();
        }
        double media=calcmedia(arr);
        System.out.println("La media de las utilidades es: " + media);
        System.out.println("La desviacion estandar de las utilidades es: " + calcvarianza(arr, media));
    }



    public static void main(String[] args) {
        int n;
        int l;
        int a;
        do{
            System.out.println("Cuantas veces desea realizar la simulacion?");
            n=sc.nextInt();
            System.out.println("Cuantas licencias desea comprar?");
            l=sc.nextInt();
            generarTabla(n, l); 
            System.out.println("Ingrese un 0 para abortar el programa");
            a=sc.nextInt();
        }while(a!=0);
    }
}