package calculadorainterfaz;

public class Op{
    double num;
    public Op(double num){
        this.num = num;
    }

    public double sum(double num, double num2){
        return num + num2;
    }

    public double sub(double num, double num2){
        return num - num2;
    }

    public double mul(double num, double num2){
        return num * num2;
    }

    public double div(double num, double num2){
        return num/num2;
    }

    public double pow(double base, double exponent){
        
        double result = 1;
        for(int i = 0; i < exponent; i++){
            result *= base;
        }
        return result;
    }

    public double sqrt(double num){
        if (num < 0){
            throw new IllegalArgumentException("Cannot calculate the square root of a negative numbe");
        }

        double i = 0;
        while(pow(i, 2) < num){
            i+= 0.0001;
        }
        return i;
    }

    public double root(double num, double indice){
        if (num < 0 && indice % 2 == 0){
            throw new IllegalArgumentException("Cannot calculate the root of a negative number with an even indice");
        }
        double i = 0;
        while(pow(i, indice) < num){
            i+= 0.0001;
        }
        return i;
    }
}
