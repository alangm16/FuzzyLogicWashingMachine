/*:-----------------------------------------------------------------------------
 *:                       INSTITUTO TECNOLOGICO DE LA LAGUNA
 *:                     INGENIERIA EN SISTEMAS COMPUTACIONALES
 *:                            INTELIGENCIA ARTIFICIAL           
 *: 
 *:                  SEMESTRE: ENE-JUN/2024     HORA: 11:00 - 12:00 HRS
 *:                                   
 *:               
 *:    Clase que contiene los métodos para la aplicación de la lógica difusa.
 *                 
 *:                           
 *: Archivo       : LogicaDifusa.java
 *:
 *: Autor         : Alan Yahir J. Gómez Mireles       
 *:
 *: Fecha         : 10 / Mayo / 2024
 *:
 *: Compilador    : Java JDK 8.2
 *:
 *: Descripción   : Clase que contiene la implementación de los metodos trimf,   
 *:                 trapmf, centroide y evaluar para la aplicación de la lógica
 *:                 difusa en el sistema de control de la lavadora.
 *: 
 *:-----------------------------------------------------------------------------
 */

package u4_ld_app;

import java.util.Arrays;

public class LavadoraFuzzyController {

    // Variables de entrada
    private double[] tipoTela;
    private double[] suciedadRopa;
    private double[] pesoRopa;

    // Variables de salida
    private double[] tiempoLavado;
    private double[] temperatura;
    private double[] tiempoSecado;
    private double[] rpm;
    private double[] calidadLavado;

    // Conjuntos difusos
    private final String[] conjuntosDifusos = {"delicada", "media", "resistente"};

    // Funciones de membresía para las variables de entrada
    private double[][] tipoTelaMembresia = {{0, 0, 50}, {10, 50, 90}, {50, 100, 100}};
    private double[][] suciedadRopaMembresia = {{0, 0, 50}, {10, 50, 90}, {50, 100, 100}};
    private double[][] pesoRopaMembresia = {{0, 0, 50}, {10, 50, 90}, {50, 100, 100}};

    // Funciones de membresía para las variables de salida
    private double[][] tiempoLavadoMembresia = {{0, 0, 5, 10}, {5, 15, 25}, {20, 30, 40}, {35, 45, 55}, {50, 55, 60, 60}};
    private double[][] temperaturaMembresia = {{15, 15, 30}, {25, 27.5, 50}, {45, 60, 60}};
    private double[][] tiempoSecadoMembresia = {{0, 0, 5, 10}, {5, 15, 25}, {20, 30, 40}, {35, 45, 55}, {50, 55, 60, 60}};
    private double[][] rpmMembresia = {{0, 300, 600}, {400, 800, 1200}, {1000, 1300, 1600}};
    private double[][] calidadLavadoMembresia = {{0, 0, 50}, {10, 50, 90}, {50, 100, 100}};

    // Reglas difusas
    private double[][] reglas = {
        // tipoTela: delicada, suciedadRopa: poca, pesoRopa: ligero
        {0, 0, 0, 0, 0},
        // tipoTela: delicada, suciedadRopa: poca, pesoRopa: mediana
        {0, 0, 1, 0, 0},
        // tipoTela: delicada, suciedadRopa: poca, pesoRopa: pesada
        {0, 0, 2, 1, 1},
        // tipoTela: delicada, suciedadRopa: media, pesoRopa: ligero
        {0, 1, 0, 1, 1},
        // tipoTela: delicada, suciedadRopa: media, pesoRopa: mediana
        {0, 1, 1, 1, 1},
        // tipoTela: delicada, suciedadRopa: media, pesoRopa: pesada
        {0, 1, 2, 2, 2},
        // tipoTela: delicada, suciedadRopa: mucha, pesoRopa: ligero
        {0, 2, 0, 1, 1},
        // tipoTela: delicada, suciedadRopa: mucha, pesoRopa: mediana
        {0, 2, 1, 1, 1},
        // tipoTela: delicada, suciedadRopa: mucha, pesoRopa: pesada
        {0, 2, 2, 2, 2},
        // tipoTela: media, suciedadRopa: poca, pesoRopa: ligero
        {1, 0, 0, 0, 0},
        // tipoTela: media, suciedadRopa: poca, pesoRopa: mediana
        {1, 0, 1, 1, 1},
        // tipoTela: media, suciedadRopa: poca, pesoRopa: pesada
        {1, 0, 2, 2, 2},
        // tipoTela: media, suciedadRopa: media, pesoRopa: ligero
        {1, 1, 0, 1, 1},
        // tipoTela: media, suciedadRopa: media, pesoRopa: mediana
        {1, 1, 1, 1, 1},
        // tipoTela: media, suciedadRopa: media, pesoRopa: pesada
        {1, 1, 2, 2, 2},
        // tipoTela: media, suciedadRopa: mucha, pesoRopa: ligero
        {1, 2, 1, 2, 2},
        // tipoTela: media, suciedadRopa: mucha, pesoRopa: mediana
        {1, 2, 2, 2, 2},
        // tipoTela: media, suciedadRopa: mucha, pesoRopa: pesada
        {1, 2, 2, 2, 2},
        // tipoTela: resistente, suciedadRopa: poca, pesoRopa: ligero
        {2, 0, 0, 0, 0},
        // tipoTela: resistente, suciedadRopa: poca, pesoRopa: mediana
        {2, 0, 1, 1, 1},
        // tipoTela: resistente, suciedadRopa: poca, pesoRopa: pesada
        {2, 0, 2, 2, 2},
        // tipoTela: resistente, suciedadRopa: media, pesoRopa: ligero
        {2, 1, 1, 1, 1},
        // tipoTela: resistente, suciedadRopa: media, pesoRopa: mediana
        {2, 1, 2, 2, 2},
        // tipoTela: resistente, suciedadRopa: media, pesoRopa: pesada
        {2, 1, 2, 2, 2},
        // tipoTela: resistente, suciedadRopa: mucha, pesoRopa: ligero
        {2, 2, 1, 2, 2},
        // tipoTela: resistente, suciedadRopa: mucha, pesoRopa: mediana
        {2, 2, 2, 2, 2},
        // tipoTela: resistente, suciedadRopa: mucha, pesoRopa: pesada
        {2, 2, 2, 2, 2},};

    public LavadoraFuzzyController() {
        // Inicializar las matrices de salida
        tiempoLavado = new double[5];
        temperatura = new double[3];
        tiempoSecado = new double[5];
        rpm = new double[3];
        calidadLavado = new double[3];
    }

    // Función de pertenencia triangular
    private double triangularMembership(double x, double[] params) {
        double a = params[0];
        double b = params[1];
        double c = params[2];

        if (x <= a || x >= c) {
            return 0;
        } else if (x > a && x <= b) {
            return (x - a) / (b - a);
        } else if (x > b && x < c) {
            return (c - x) / (c - b);
        }
        return 0;
    }

    // Función de pertenencia trapezoidal
    private double trapezoidalMembership(double x, double[] params) {
        double a = params[0];
        double b = params[1];
        double c = params[2];
        double d = params[3];

        if (x <= a || x >= d) {
            return 0;
        } else if (x >= b && x <= c) {
            return 1;
        } else if (x > a && x < b) {
            return (x - a) / (b - a);
        } else if (x > c && x < d) {
            return (d - x) / (d - c);
        }
        return 0;
    }

    // Método de inferencia difusa - Mamdani
    private void fuzzyInference() {
    for (int i = 0; i < conjuntosDifusos.length; i++) {
        for (int j = 0; j < conjuntosDifusos.length; j++) {
            for (int k = 0; k < conjuntosDifusos.length; k++) {
                int index = i * conjuntosDifusos.length * conjuntosDifusos.length + j * conjuntosDifusos.length + k;
                double minDegree = Math.min(tipoTela[i], Math.min(suciedadRopa[j], pesoRopa[k]));
                tiempoLavado[(int)reglas[index][0]] = Math.max(tiempoLavado[(int)reglas[index][0]], minDegree);
                temperatura[(int)reglas[index][1]] = Math.max(temperatura[(int)reglas[index][1]], minDegree);
                tiempoSecado[(int)reglas[index][2]] = Math.max(tiempoSecado[(int)reglas[index][2]], minDegree);
                rpm[(int)reglas[index][3]] = Math.max(rpm[(int)reglas[index][3]], minDegree);
                calidadLavado[(int)reglas[index][4]] = Math.max(calidadLavado[(int)reglas[index][4]], minDegree);
            }
        }
    }
}

    // Método de defuzzificación - Centroide
    private double defuzzifyCentroid(double[] outputSet, double[] membershipSet) {
        double numerator = 0;
        double denominator = 0;

        for (int i = 0; i < outputSet.length; i++) {
            numerator += outputSet[i] * membershipSet[i];
            denominator += membershipSet[i];
        }

        return numerator / denominator;
    }

    // Método para calcular la salida
    public double[] calculateOutput(double inputTipoTela, double inputSuciedadRopa, double inputPesoRopa) {
        tipoTela = new double[3];
        suciedadRopa = new double[3];
        pesoRopa = new double[3];

        // Calcular grados de membresía
        for (int i = 0; i < 3; i++) {
            tipoTela[i] = triangularMembership(inputTipoTela, tipoTelaMembresia[i]);
            suciedadRopa[i] = triangularMembership(inputSuciedadRopa, suciedadRopaMembresia[i]);
            pesoRopa[i] = triangularMembership(inputPesoRopa, pesoRopaMembresia[i]);
        }

        // Realizar inferencia difusa
        fuzzyInference();

        // Defuzzificación
        double tiempoLavadoResult = defuzzifyCentroid(new double[]{5, 45, 53, 60}, tiempoLavado);
        double temperaturaResult = defuzzifyCentroid(new double[]{25, 37.5, 50}, temperatura);
        double tiempoSecadoResult = defuzzifyCentroid(new double[]{5, 45,  53, 60}, tiempoSecado);
        double rpmResult = defuzzifyCentroid(new double[]{375, 800, 1300}, rpm);
        double calidadLavadoResult = defuzzifyCentroid(new double[]{45, 50, 65}, calidadLavado);

        return new double[]{tiempoLavadoResult, temperaturaResult, tiempoSecadoResult, rpmResult, calidadLavadoResult};
    }

    public static void main(String[] args) {
        LavadoraFuzzyController controller = new LavadoraFuzzyController();
        double[] output = controller.calculateOutput(50, 50, 50);
        System.out.println("Tiempo de lavado: " + output[0] + " minutos");
        System.out.println("Temperatura: " + output[1] + " grados Celsius");
        System.out.println("Tiempo de secado: " + output[2] + " minutos");
        System.out.println("RPM: " + output[3]);
        System.out.println("Calidad del lavado: " + output[4]);
    }
}
