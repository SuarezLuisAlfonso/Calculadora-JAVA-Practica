import java.util.Scanner;

public class Main {

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Hola, bienvenido a la calculadora");

    System.out.print("Por favor Ingrese el primer número: ");
    double num1 = scanner.nextDouble();

    System.out.print("Por favor Ingrese el segundo número:");
    double num2 = scanner.nextDouble();

        Op op = new Op();

    System.out.println("Selecciona la operación que deseas realizar:");
    System.out.println("1. Sumar");
    System.out.println("2. Restar");
    System.out.println("3. Multiplicar");
    System.out.println("4. Dividir");
    System.out.println("5. Potencia");
    System.out.println("6. Salir");

    double resultado = 0;
    switch (scanner.nextInt()) {
        case 1:
            resultado = op.sumar(num1, num2);
            System.out.println("El resultado es: " + resultado);
            break;

        case 2:
            resultado = op.restar(num1, num2);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 3:
            resultado = op.multiplicar(num1, num2);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 4:
            resultado = op.dividir(num1, num2);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 5:
            if (num2 % 1 != 0) {
                System.out.println("El exponente debe ser un número entero");
                System.exit(0);
            }
            resultado = op.potencia(num1, (int) num2);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 6:
            System.out.println("Gracias por usar la calculadora");
            System.exit(0);
            break;
    }
    
    while (true) {
        System.out.println("Elige la siguiente operación");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Potencia");
        System.out.println("6. Salir");

        int option = scanner.nextInt();

    System.out.print("Ingrese el siguiente número: ");
    double num3 = scanner.nextDouble();


    switch (option) {
        case 1:
            resultado = op.sumar(resultado, num3);
            System.out.println("El resultado es: " + resultado);
            break;

        case 2:
            resultado = op.restar(resultado, num3);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 3:
            resultado = op.multiplicar(resultado, num3);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 4:
            resultado = op.dividir(resultado, num3);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 5:
            if (num3 % 1 != 0) {
                System.out.println("El exponente debe ser un número entero");
                System.exit(0);
            }
            resultado = op.potencia(resultado, (int) num3);
            System.out.println("El resultado es: " + resultado);
            break;
        
        case 6:
            System.out.println("Gracias por usar la calculadora");
            System.exit(0);
            break;
    }
}
}
}