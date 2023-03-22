import java.util.*;
public class dardos {
    static Random rnd=new Random();
    static Scanner sc=new Scanner(System.in);

    static Coordenadas [] lanzarDardos(int n){
        Coordenadas [] c=new Coordenadas[n];
        for (int i=0; i<n; i++){
            c[i]=new Coordenadas(); // crea un nuevo objeto Coordenadas antes de establecer sus valores
            c[i].setX(rnd.nextFloat()*2-1); // Genera un valor aleatorio del -2 al 2
            c[i].setY(rnd.nextFloat()*2-1); 
        }
        return c;
    }

    static int calcularExitos(Coordenadas [] c){
        int exitos=0;
        float hip_cuadrada=0;
        float hipotenusa=0;
        for (int i=0; i<c.length; i++){
            hip_cuadrada=(float) (Math.pow(c[i].getX(), 2) + Math.pow(c[i].getY(), 2));
            hipotenusa=(float) Math.sqrt(hip_cuadrada);
            if(hipotenusa<=1){
                exitos++;
            }
        }
        return exitos;
    }

    static float aproximacionPi(int exitos, int n){
        float ap_pi=(float)exitos*4/n;
        return ap_pi;
    }
    public static void main(String[] args) {
        int a=0;
        do{
            System.out.println("¿Cuantos dardos desea lanzar?");
            int n=sc.nextInt();
            Coordenadas [] arr=lanzarDardos(n);
            System.out.println(aproximacionPi(calcularExitos(arr), n));
            System.out.println("Ingrese el 1 si desea salir del programa");
            a=sc.nextInt();
        }while(a!=1);
    }
}
