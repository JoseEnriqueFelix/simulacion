import java.util.*;
import java.math.BigInteger;

public class tarea2 {
    static Scanner sc = new Scanner(System.in);
    static Random r = new Random();

    public static void medioCuadrado(int num1){
        ArrayList <Integer> mC = new ArrayList<Integer>();
        mC.add(num1);
        boolean equal=false;
        while(!equal){
            num1=(int)Math.pow(num1,2);;
            String str1 = String.valueOf(num1);
            while(str1.length()<8){
                str1="0"+str1;
            }
            str1 = str1.substring(2,6);
            num1 = Integer.parseInt(str1);
            if(mC.contains(num1)){
                mC.add(num1);
                equal=true;
            }else{
                mC.add(num1);
            }
        }
        print(num1,mC);
    }

    public static void newman(BigInteger num1){
        ArrayList <BigInteger> mC = new ArrayList<BigInteger>();
        BigInteger a=new BigInteger (String.valueOf(num1));
        mC.add(a);
        a=num1.multiply(num1);
        String str1=String.valueOf(a);
        int m1=0;
        for (int  i=0; i<str1.length(); i++){
            m1++;
        }
        if(m1%2==0){
            str1="0"+str1;
            m1++;
        }
        str1=str1.substring(((m1/2)-2), ((m1/2)+3));
        BigInteger b=new BigInteger(str1);
        mC.add(b);
        boolean equal=false;
        while(!equal){
            b=b.multiply(b);
            String str2 = String.valueOf(b);
            int m2=0;
            for (int  i=0; i<str2.length(); i++){
                m2++;
            } 
            if(m2%2==0){
                str2="0"+str2;
                m2++;
            }
            if (str2.length()>6){
                str2=str2.substring(((m2/2)-2), ((m2/2)+3));
            }
            BigInteger c=new BigInteger(str2);
            b=c;
            if(mC.contains(b)){
                mC.add(b);
                equal=true;
            }else{
                mC.add(b);
            }
        }
        printNewman(b,mC);
    }

    public static void print(int num, ArrayList <Integer> mC){
        System.out.println("LOS NUMEROS GENERADOS SON: ");
        System.out.println("==================================");
        for(int i=0; i<mC.size(); i++){
            System.out.println("x"+(i)+ ") "+mC.get(i));
        }
        System.out.println("SE HAN GENERADO: " + mC.size() + " NUMEROS");
        if(num==0){
            System.out.println("SE HA LLEGADO A 0");
        }
        else{
            System.out.println("SE HA REPETIDO EL NUMERO: " + num);
        }
    }

    public static void printNewman(BigInteger num, ArrayList<BigInteger> mC){
        System.out.println("LOS NUMEROS GENERADOS SON: ");
        System.out.println("==================================");
        for(int i=0; i<mC.size(); i++){
            System.out.println("x"+(i)+ ") "+mC.get(i));
        }
        System.out.println("SE HAN GENERADO: " + mC.size() + " NUMEROS");
        if(num.compareTo(BigInteger.ZERO)==0){
            System.out.println("SE HA LLEGADO A 0");
        }
        else{
            System.out.println("SE HA REPETIDO EL NUMERO: " + num);
        }
    }
    


    public static void main(String[] args) {
        int op=0;
        while(op!=3){
        System.out.println("INGRESE METODO DE GENERACION  \n1)MEDIO CUADRADO \n2)NEWMAN  \n3)SALIR");
        op=sc.nextInt();
            if(op==1){
                System.out.println("HA SELECCIONADO METODO DE MEDIO CUADRADO");
                boolean ope=tecRan();
                if(ope){
                    Boolean o=false;
                    while(!o){
                        System.out.println("INGRESE NUMERO");
                        int num1=sc.nextInt();
                        String str1 = String.valueOf(num1);
                        if(str1.length()==4){
                            o=true;
                            System.out.println("SE HA GENERADO EL NUMERO: "+num1);
                            medioCuadrado(num1);
                        }
                    }
                            
                }else{
                    int a=r.nextInt(1000,9999);
                    System.out.println("SE HA GENERADO EL NUMERO: "+a);
                    medioCuadrado(a);
                }
            }
            else if(op==2){
                System.out.println("HA SELECCIONADO METODO DE NEWMAN");
                boolean ope=tecRan();
                if(ope){
                    Boolean o=false;
                    while(!o){
                        System.out.println("INGRESE NUMERO");
                        BigInteger num1=sc.nextBigInteger();
                        String str1 = String.valueOf(num1);
                        if(str1.length()==10){
                            o=true;
                            System.out.println("SE HA GENERADO EL NUMERO: "+num1);
                            newman(num1);
                        }
                    }
                }else{
                    Long a=r.nextLong(1000000000, 9999999999L);
                    String str2=String.valueOf(a);
                    BigInteger b=new BigInteger(str2);
                    System.out.println("SE HA GENERADO EL NUMERO: "+(Long)a);
                    newman(b);
                }
            }
            else if(op==3){
                System.out.println("SALIENDO");
                System.exit(0);
            }
        }
        
    }

    public static boolean tecRan(){
        boolean ope=true;
        System.out.println("INGRESE METODO DE GENERACION  \n1)TECLADO \n2)RANDOM");
        int op=sc.nextInt();
        if(op==1){
            ope=true;
        }else if(op==2){
            ope=false;
        }else{
            tecRan();
        }
        return ope;
    }
}
