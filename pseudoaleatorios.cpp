#include <iostream>
#include <ctime>
#include <cmath>
#include <iomanip>
using namespace std;

int pseudoaleat(int seed){
    int resultado=((seed * 87 + 66) % 94362);
    if(resultado<0){
        resultado*=-1;
    }
    return resultado;
}

double calcmedia(int arr[], int n){
    double suma=0;
    for (int i=0;i<n; i++){
        suma=suma + arr[i];
    }
    double media=suma/n;
    return media;
}

double calcvarianza(int arr[], int n, double media){
    double suma=0;
    for (int i=0; i<n; i++){
        suma+= (arr[i] - media)*(arr[i] - media);
    }
    double varianza=suma/n;
    return varianza;
}

int main(){
    cout << setprecision(15);
    int n1;
    int seed=time(0);
    int n2=time(0)%10000;
    bool menu;
    cout << "========================================" << endl;
    cout << "Ingrese 1 si desea generarlos por teclado" << endl;
    cout << "Ingrese 0 si desea generarlos de manera aleatoria" << endl;
    cin >> menu;
    if(menu){
        cout << "Ingrese la cantidad de numeros aleatorios a generar" << endl;
        cin >> n1;
        int arr[n1];
        for(int i=0; i<n1; i++){
            arr[i]=pseudoaleat((i+13*54) * seed);
            cout << arr[i] << endl;
        }
        cout << "========================================" << endl;
        double media=calcmedia(arr, n1);
        cout << "La media es: " << media << endl;
        cout << "La varianza es: " << calcvarianza(arr, n1, media) << endl;
    }
    else{
        int arr[n2];
        for(int i=0; i<n2; i++){
            arr[i]=pseudoaleat((i+13*54) * seed);
            cout << arr[i] << endl;
        }
        cout << "La cantidad de numeros aleatorios que fueron generados es de " << n2 << " numeros" << endl;
        double media=calcmedia(arr, n2);
        cout << "La media es: " << media << endl;
        cout << "La varianza es: " << calcvarianza(arr, n2, media) << endl;
    }
    return 0;
}