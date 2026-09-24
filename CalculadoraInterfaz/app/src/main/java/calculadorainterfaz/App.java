package calculadorainterfaz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application { //CLASE PRINCIPAL

    private String numeroActual = "";
    private double primerNumero = 0;
    private String operadorActual = "";
    private Label pantalla;

    private Op op = new Op(0);

    @Override
    public void start(Stage stage) {

        pantalla = new Label("0"); //PANTALLA DE LA CALCULADORA

        pantalla.setMaxWidth(Double.MAX_VALUE);
        pantalla.setMinHeight(100);

        pantalla.setAlignment(Pos.CENTER_RIGHT);

        pantalla.setStyle("-fx-font-size: 42px;" + "-fx-padding: 15px;" + "-fx-background-color: #1e1e1e;" + "-fx-text-fill: white;");


        Button segundo = new Button("2nd"); //BOTONES DE LA CALCULADORA
        Button pi = new Button("π");
        Button e = new Button("e");
        Button limpiar = new Button("C");
        Button borrar = new Button("⌫");


        Button cuadrado = new Button("x²");
        Button inverso = new Button("1/x");
        Button absoluto = new Button("|x|");
        Button exp = new Button("exp");
        Button mod = new Button("mod");

        Button raiz = new Button("√x");
        Button parentesisIzq = new Button("(");
        Button parentesisDer = new Button(")");
        Button factorial = new Button("n!");
        Button dividir = new Button("÷");


        Button potencia = new Button("x^y");
        Button siete = new Button("7");
        Button ocho = new Button("8");
        Button nueve = new Button("9");
        Button multiplicar = new Button("×");

        Button diezPotencia = new Button("10^x");
        Button cuatro = new Button("4");
        Button cinco = new Button("5");
        Button seis = new Button("6");
        Button restar = new Button("-");

        Button logaritmo = new Button("log");
        Button uno = new Button("1");
        Button dos = new Button("2");
        Button tres = new Button("3");
        Button sumar = new Button("+");

        Button ln = new Button("ln");
        Button signo = new Button("+/-");
        Button cero = new Button("0");
        Button punto = new Button(".");
        Button igual = new Button("=");


        GridPane teclado = new GridPane(); //TECLADO DE LA CALCULADORA
        
        teclado.setHgap(5);
        teclado.setVgap(5);
        teclado.setPadding(new Insets(5));

        teclado.add(segundo, 0, 0);
        teclado.add(pi, 1, 0);
        teclado.add(e, 2, 0);
        teclado.add(limpiar, 3, 0);
        teclado.add(borrar, 4, 0);

        teclado.add(cuadrado, 0, 1);
        teclado.add(inverso, 1, 1);
        teclado.add(absoluto, 2, 1);
        teclado.add(exp, 3, 1);
        teclado.add(mod, 4, 1);

        teclado.add(raiz, 0, 2);
        teclado.add(parentesisIzq, 1, 2);
        teclado.add(parentesisDer, 2, 2);
        teclado.add(factorial, 3, 2);
        teclado.add(dividir, 4, 2);

        teclado.add(potencia, 0, 3);
        teclado.add(siete, 1, 3);
        teclado.add(ocho, 2, 3);
        teclado.add(nueve, 3, 3);
        teclado.add(multiplicar, 4, 3);

        teclado.add(diezPotencia, 0, 4);
        teclado.add(cuatro, 1, 4);
        teclado.add(cinco, 2, 4);
        teclado.add(seis, 3, 4);
        teclado.add(restar, 4, 4);

        teclado.add(logaritmo, 0, 5);
        teclado.add(uno, 1, 5);
        teclado.add(dos, 2, 5);
        teclado.add(tres, 3, 5);
        teclado.add(sumar, 4, 5);

        teclado.add(ln, 0 , 6);
        teclado.add(signo, 1, 6);
        teclado.add(cero, 2, 6);
        teclado.add(punto, 3, 6);
        teclado.add(igual, 4, 6);

        uno.setOnAction(e1 -> escribirNumero("1")); //EVENTOS DE LOS BOTONES
        dos.setOnAction(e1 -> escribirNumero("2"));
        tres.setOnAction(e1 -> escribirNumero("3"));
        cuatro.setOnAction(e1 -> escribirNumero("4"));
        cinco.setOnAction(e1 -> escribirNumero("5"));
        seis.setOnAction(e1 -> escribirNumero("6"));
        siete.setOnAction(e1 -> escribirNumero("7"));
        ocho.setOnAction(e1 -> escribirNumero("8"));
        nueve.setOnAction(e1 -> escribirNumero("9"));
        cero.setOnAction(e1 -> escribirNumero("0"));

        punto.setOnAction(e1 -> escribirPunto());

        sumar.setOnAction(e1 -> seleccionarOperacion("+"));
        restar.setOnAction(e1 -> seleccionarOperacion("-"));
        multiplicar.setOnAction(e1 -> seleccionarOperacion("*"));
        dividir.setOnAction(e1 -> seleccionarOperacion("/"));

        igual.setOnAction(e1 -> calcular());
        limpiar.setOnAction(e1 -> limpiar());
        borrar.setOnAction(e1 -> borrar());
        signo.setOnAction(e1 -> cambiarSigno());

        raiz.setOnAction(e1 -> {
            try {
                double numero = Double.parseDouble(numeroActual);
                double resultado = op.sqrt(numero);
                mostrarResultado(resultado);
            } catch (IllegalArgumentException ex) {
                pantalla.setText("Error");
            }
        });

        cuadrado.setOnAction(e1 -> {
            try {
                double numero = Double.parseDouble(numeroActual);
                double resultado = op.pow(numero, 2);
                mostrarResultado(resultado);
            } catch (IllegalArgumentException ex) {
                pantalla.setText("Error");
            }
        });

        potencia.setOnAction(e1 -> seleccionarOperacion("pow"));



        for(var nodo : teclado.getChildren()){ //TAMAÑO Y ESTILO DE LOS BOTONES
        Button boton = (Button) nodo;
        boton.setPrefSize(80,60);

        boton.setStyle("-fx-font-size: 18px;" + "-fx-background-color: #333333;" + "-fx-text-fill: white;");
    }
        
    VBox layout = new VBox(10); //LAYOUT DE LA CALCULADORA
    
    layout.setPadding(new Insets(10));
    layout.setStyle("-fx-background-color: #202020;");

    layout.getChildren().addAll(pantalla, teclado);


    Scene scene = new Scene(layout, 500, 650); // SCENA DE LA CALCULADORA

    stage.setTitle("Calculadora Cientifica");
    stage.setScene(scene);
    stage.show();

    }
    //METODOS DE LA CALCULADORA
    private void escribirNumero(String numero) {
        numeroActual += numero;
        pantalla.setText(numeroActual);
        
    }

    private void escribirPunto() {
        if (!numeroActual.contains(".")){

            if (numeroActual.isEmpty()){
                numeroActual = "0.";
            } else {
                numeroActual += ".";
            }
            pantalla.setText(numeroActual);
        }
    }

    private void seleccionarOperacion(String operador) {
        
        if (numeroActual.isEmpty()) {
            return;
        }
        
        primerNumero = Double.parseDouble(numeroActual);
        this.operadorActual = operador;
        numeroActual = "";
    }

    private void mostrarResultado(double resultado) {

        numeroActual = String.valueOf(resultado);
        pantalla.setText(numeroActual);
    }

    private void calcular() {

        if (numeroActual.isEmpty() || operadorActual.isEmpty()) {
            return;

        }

        double segundoNumero = Double.parseDouble(numeroActual);
        
        double resultado = 0;

        try {
            switch (operadorActual) {

                case "+":
                    resultado = op.sum(primerNumero, segundoNumero);
                    break;
                case "-":
                    resultado = op.sub(primerNumero, segundoNumero);
                    break;
                case "*":
                    resultado = op.mul(primerNumero, segundoNumero);
                    break;
                case "/":
                    resultado = op.div(primerNumero, segundoNumero);
                    break;
                case "pow":
                    resultado = op.pow(primerNumero, segundoNumero);
                    break;
            }
        

        mostrarResultado(resultado);

        operadorActual = "";
    }
    catch (ArithmeticException e){
        pantalla.setText("Error:");

    } catch (IllegalArgumentException ex){
        pantalla.setText("Error");
    }
    }

    private void limpiar(){

        numeroActual = "";
        primerNumero = 0;
        operadorActual = "";
        pantalla.setText("0");
    }

    private void borrar(){

        if (!numeroActual.isEmpty()){
            numeroActual = numeroActual.substring(0, numeroActual.length() - 1);
            
            if (numeroActual.isEmpty()){
            pantalla.setText("0");
        } else {
            pantalla.setText(numeroActual);
        }
        }
    }

    private void cambiarSigno(){

        if (!numeroActual.isEmpty()){
            double numero = Double.parseDouble(numeroActual);
            numero *= -1;
            numeroActual = String.valueOf(numero);
            pantalla.setText(numeroActual);
        }
    }

    public static void main(String[] args) {

        launch();
    }
}