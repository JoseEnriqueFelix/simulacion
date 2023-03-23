import random

import matplotlib.pyplot as plt
import math

eventos_dado = []
eventos_moneda = []
probabilidad_dado = []
probabilidad_moneda = []


def imprimir_resultados(es_moneda):
    print("N\t#P\tEvento")
    if es_moneda:
        for i, probabilidad in enumerate(probabilidad_moneda):
            print('{}\t{}\t{}'.format(i, eventos_moneda[i], probabilidad))
    else:
        for i, probabilidad in enumerate(probabilidad_dado):
            print('{}\t{}\t{}'.format(i, eventos_dado[i], probabilidad))

    graficar_resultado(es_moneda)
    num = int(input("¿Quiere conserver estos valores para posteriores ejecuciones?\n1.Si\n2.No"))
    if num == 2:
        eventos_dado.clear()
        eventos_moneda.clear()
        probabilidad_dado.clear()
        probabilidad_moneda.clear()
    main()


def generar_num_aleatorio_redondeado():
    num_aleatorio = random.uniform(0, 1)
    return round(num_aleatorio, 4)


def lanzar_moneda():
    total = int(input("Cuantas veces deseas lanzar la moneda: "))
    print("Lanzando moneda(s)...")
    for i in range(total):
        resultado = generar_num_aleatorio_redondeado()
        if resultado <= 0.5:
            probabilidad_moneda.append("Cara")
        else:
            probabilidad_moneda.append("Sello")
        eventos_moneda.append(resultado)

    imprimir_resultados(es_moneda=True)


def lanzar_dado():
    total = int(input("¿Cuantás veces deseas lanzar el dado? "))
    print("Lanzando dado(s)...")
    for i in range(total):
        resultado = generar_num_aleatorio_redondeado()
        probabilidad = math.ceil(resultado / 0.16666666)
        probabilidad_dado.append(probabilidad._str_())
        eventos_dado.append(resultado)

    imprimir_resultados(es_moneda=False)


def graficar_resultado(es_moneda):
    if es_moneda:
        fig, ax = plt.subplots()
        ax.pie([probabilidad_moneda.count('Cara'), probabilidad_moneda.count('Sello')], labels=['Cara', 'Sello'],
               autopct='%1.1f%%')
        ax.set_title('Resultados de lanzar la moneda')
        plt.show()
    else:
        fig, ax = plt.subplots()
        ax.pie([probabilidad_dado.count('1'), probabilidad_dado.count('2'), probabilidad_dado.count('3'),
                probabilidad_dado.count('4'), probabilidad_dado.count('5'), probabilidad_dado.count('6')],
               labels=['1', '2', '3', '4', '5', '6'], autopct='%1.1f%%')
        ax.set_title('Resultados de lanzar el dado')
        plt.show()


def main():
    opcion = int(input("¿Que deseas lanzar\n1. Moneda\n2. Dado\n3. Salir: "))
    while opcion != 3:
        if opcion == 1:
            lanzar_moneda()
        elif opcion == 2:
            lanzar_dado()
        elif opcion == 3:
            print("Adios")
            SystemExit()
        else:
            print("Opción invalida")
            main()


if _name_ == "_main_":
    main()