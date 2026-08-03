public class Op {

    public Op() {

    }

    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        if (num2 == 0) {
        throw new IllegalArgumentException("No se puede dividir entre cero");
        }
        else {
        return num1 / num2;
    }
}

    public double potencia(double base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }
        if (exponente == 0){
            return 1;
        }
        
        double resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }
}

