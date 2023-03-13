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
    cout << "Ingrese la cantidad de numeros pseudoaleatorios a generar: " << endl;
    int n;
    cin >> n;
    int arr[n];
    int seed=time(0);
    bool menu;
    cout << "========================================" << endl;
    cout << "Ingrese 1 si desea generarlos usted mismo" << endl;
    cout << "Ingrese 0 si desea generarlos por computadora" << endl;
    cin >> menu;
    if(menu){
        for(int i=0; i<n; i++){
            cout << "Ingrese el numero " << (i+1) << endl;
            cin >> arr[i];
        }
    }
    else{
        for(int i=0; i<n; i++){
            arr[i]=pseudoaleat((i+13*54) * seed);
            cout << arr[i] << endl;
        }
    }
    cout << "========================================" << endl;
    cout << "La media es: " << calcmedia(arr, n) << endl;
    cout << "La varianza es: " << calcvarianza(arr, n, calcmedia(arr, n)) << endl;
    return 0;
}