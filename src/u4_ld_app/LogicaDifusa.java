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
 *: Fecha         : 01 / Mayo / 2024
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

public class LogicaDifusa {
    
    // -------------------------------------------------------------------------
    
    // Variables para los valores de Salida
    
    static double tiempoLavado = 0, temperatura = 0 , tiempoSecado = 0, RPM = 0, calidadLavado = 0;
    
    // -------------------------------------------------------------------------

    // Métodos get and set para los valores de salida

    public static double getTiempoLavado() {
        return tiempoLavado;
    }

    public static double getTemperatura() {
        return temperatura;
    }

    public static double getTiempoSecado() {
        return tiempoSecado;
    }

    public static double getRPM() {
        return RPM;
    }

    public static double getCalidadLavado() {
        return calidadLavado;
    }
    
    // -------------------------------------------------------------------------
    
    // Método de la función triangular
    public static double trimf(double x, double a, double b, double c) {
        if (x < a || x > c) {
            return 0.0; // fuera del rango
        } else if (x <= b) {
            return (x - a) / (b - a);
        } else {
            return (c - x) / (c - b);
        }
    }
    
    // -------------------------------------------------------------------------
    
    // Método para la función trapezoidal
    public static double trapmf (double x, double a, double b, double c, double d) {
        if (x < a || x > d) {
            return 0.0; // fuera del rango
        } else if (x >= b && x <= c) {
            return 1.0; // valor constante entre b y c
        } else if (x < b) {
            return (x - a) / (b - a); // pendiente ascendente
        } else {
            return (d - x) / (d - c); // pendiente descendente
        }
    }
     
    // -------------------------------------------------------------------------

    // Método del centroide para obtener los valores finales
    public static double centroide ( double [] membresias, double [] valores )
    {
        // Variables para la implementación
        double numerador = 0;
        double denominador = 0;
        double centroide = 0;
        
        // Se almacena la información del númerador y del denominador
        for ( int i = 0; i < membresias.length; i++ ) 
        {
            numerador   += membresias [ i ] * valores [ i ];
            denominador += membresias [ i ];
        }
        
        // Se valida el denominador y se obtiene el centroide
        if ( denominador > 0 )
            centroide = numerador / denominador;
        else
            centroide = 0;
        
        return centroide;
    }
    
    // -------------------------------------------------------------------------
    
    // Método para evaluar sistema de control de lógica difusa
    public static void evaluar ( double tipoTela, double suciedadRopa, 
            double pesoRopa ) {
        
        // Entradas
        
        // tipo de tela
        double delicada_T = trimf ( tipoTela, 0, 0, 50 );
        double media_T = trimf ( tipoTela, 10, 50, 90 );
        double resistente_T = trimf ( tipoTela, 50, 100, 100 );
        
        // suciedad de la ropa
        double poca_S = trimf ( suciedadRopa, 0, 0, 50 );
        double media_S = trimf ( suciedadRopa, 10, 50, 90 );
        double mucha_S = trimf ( suciedadRopa, 50, 100, 100 );
        
        // peso de la ropa
        double ligera_P = trimf ( pesoRopa, 0, 0, 50 );
        double media_P = trimf ( pesoRopa, 10, 50, 90 );
        double pesada_P = trimf ( pesoRopa, 50, 100, 100 );
        
        
        // Salidas
        
        // tiempo de lavado
        double muyCorta_TL = trapmf ( 1, 0, 0, 5, 10 );
        double corta_TL = trimf ( 1, 5, 15, 25 );
        double media_TL = trimf ( 1, 20, 30, 40 );
        double larga_TL = trimf ( 1, 35, 45, 55 );
        double muyLarga_TL = trapmf ( 1, 50, 55, 60, 60 );
        
        // temperatura
        double fria_Temp = trimf ( 1, 15, 15, 30 );
        double tibia_Temp = trimf ( 1, 25, 37.5, 50 );
        double caliente_Temp = trimf ( 1, 45, 60, 60 );
        
        // tiempo de secado
        double muyCorta_TS = trapmf ( 1, 0, 0, 5, 10 );
        double corta_TS = trimf ( 1, 5, 15, 25 );
        double media_TS = trimf ( 1, 20, 30, 40 );
        double larga_TS = trimf ( 1, 35, 45, 55 );
        double muyLarga_TS = trapmf ( 1, 50, 55, 60, 60 );
        
        // RPM
        double baja_RPM = trimf ( 1, 0, 300, 600 );
        double media_RPM = trimf ( 1, 400, 800, 1200 );
        double alta_RPM = trimf ( 1, 1000, 1300, 1600 );
        
        // calidad de lavado
        double baja_CL = trimf ( 1, 0, 0, 50 );
        double media_CL = trimf ( 1, 10, 50, 90 );
        double alta_CL = trimf ( 1, 50, 100, 100 );
        
        // REGLAS DIFUSAS MÉTODO AND (USANDO EL MINIMO) AndMehod='min' (Causas de las reglas)
        
        // Regla de entrada 1 : Si el tipo de tela es delicada, la suciedad es poca y el peso es ligero
        double r1_aux = Math.min ( delicada_T, poca_S );
        double r1 = Math.min ( r1_aux, ligera_P );
        
        // Regla de entrada 2 : Si el tipo de tela es delicada, la suciedad es poca y el peso es media
        double r2_aux = Math.min ( delicada_T, poca_S );
        double r2 = Math.min ( r2_aux, media_P );
        
        // Regla de entrada 3 : Si el tipo de tela es delicada, la suciedad es poca y el peso es pesado
        double r3_aux = Math.min ( delicada_T, poca_S );
        double r3 = Math.min ( r3_aux, pesada_P );
        
        // Regla de entrada 4 : Si el tipo de tela es delicada, la suciedad es media y el peso es ligero
        double r4_aux = Math.min ( delicada_T, media_S );
        double r4 = Math.min ( r4_aux, ligera_P );
        
        // Regla de entrada 5 : Si el tipo de tela es delicada, la suciedad es media y el peso es medio
        double r5_aux = Math.min ( delicada_T, media_S );
        double r5 = Math.min ( r5_aux, media_P );
        
        // Regla de entrada 6 : Si el tipo de tela es delicada, la suciedad es media y el peso es pesado
        double r6_aux = Math.min ( delicada_T, media_S );
        double r6 = Math.min ( r6_aux, pesada_P );
        
        // Regla de entrada 7 : Si el tipo de tela es delicada, la suciedad es mucha y el peso es ligera
        double r7_aux = Math.min ( delicada_T, mucha_S );
        double r7 = Math.min ( r7_aux, ligera_P );
        
        // Regla de entrada 8 : Si el tipo de tela es delicada, la suciedad es mucha y el peso es medio
        double r8_aux = Math.min ( delicada_T, mucha_S );
        double r8 = Math.min(r8_aux, media_P );
        
        // Regla de entrada 9 : Si el tipo de tela es delicada, la suciedad es mucha y el peso es pesada
        double r9_aux = Math.min ( delicada_T, mucha_S );
        double r9 = Math.min(r9_aux, pesada_P );
        
        // Regla de entrada 10 : Si el tipo de tela es media, la suciedad es poca y el peso es ligero
        double r10_aux = Math.min ( media_T, poca_S );
        double r10 = Math.min(r10_aux, ligera_P );
        
        // Regla de entrada 11 : Si el tipo de tela es media, la suciedad es poca y el peso es medio
        double r11_aux = Math.min ( media_T, poca_S );
        double r11 = Math.min ( r11_aux, media_P );
        
        // Regla de entrada 12 : Si el tipo de tela es media, la suciedad es poca y el peso es pesado
        double r12_aux = Math.min ( media_T, poca_S );
        double r12 = Math.min ( r12_aux, pesada_P );
        
        // Regla de entrada 13 : Si el tipo de tela es media, la suciedad es media y el peso es ligero
        double r13_aux = Math.min ( media_T, media_S );
        double r13 = Math.min ( r13_aux, ligera_P );
        
        // Regla de entrada 14 : Si el tipo de tela es media, la suciedad es media y el peso es medio
        double r14_aux = Math.min ( media_T, media_S );
        double r14 = Math.min ( r14_aux, media_P );
                
        // Regla de entrada 15 : Si el tipo de tela es media, la suciedad es media y el peso es pesado
        double r15_aux = Math.min ( media_T, media_S );
        double r15 = Math.min ( r15_aux, pesada_P );
        
        // Regla de entrada 16 : Si el tipo de tela es media, la suciedad es mucha y el peso es ligero
        double r16_aux = Math.min ( media_T, mucha_S );
        double r16 = Math.min ( r16_aux, ligera_P );
        
        // Regla de entrada 17 : Si el tipo de tela es media, la suciedad es mucha y el peso es media
        double r17_aux = Math.min ( media_T, mucha_S );
        double r17 = Math.min ( r17_aux, media_P );
        
        // Regla de entrada 18 : Si el tipo de tela es media, la suciedad es mucha y el peso es pesado
        double r18_aux = Math.min ( media_T, mucha_S );
        double r18 = Math.min ( r18_aux, pesada_P );
        
        // Regla de entrada 19 : Si el tipo de tela es resistente, la suciedad es poca y el peso es ligero
        double r19_aux = Math.min ( resistente_T, poca_S );
        double r19 = Math.min ( r19_aux, ligera_P );
        
        // Regla de entrada 20 : Si el tipo de tela es resistente, la suciedad es poca y el peso es medio
        double r20_aux = Math.min ( resistente_T, poca_S );
        double r20 = Math.min ( r20_aux, media_P );
        
        // Regla de entrada 21 : Si el tipo de tela es resistente, la suciedad es poca y el peso es pesado
        double r21_aux = Math.min ( resistente_T, poca_S );
        double r21 = Math.min ( r21_aux, pesada_P );
        
        // Regla de entrada 22 : Si el tipo de tela es resistente, la suciedad es media y el peso es ligero
        double r22_aux = Math.min ( resistente_T, media_S );
        double r22 = Math.min ( r22_aux, ligera_P );
        
        // Regla de entrada 23 : Si el tipo de tela es resistente, la suciedad es media y el peso es medio
        double r23_aux = Math.min ( resistente_T, media_S );
        double r23 = Math.min ( r23_aux, media_P );
        
        // Regla de entrada 24 : Si el tipo de tela es resistente, la suciedad es media y el peso es pesado
        double r24_aux = Math.min ( resistente_T, media_S );
        double r24 = Math.min ( r24_aux, pesada_P );
        
        // Regla de entrada 25 : Si el tipo de tela es resistente, la suciedad es mucha y el peso es ligero
        double r25_aux = Math.min ( resistente_T, mucha_S );
        double r25 = Math.min ( r25_aux, ligera_P );
        
        // Regla de entrada 26 : Si el tipo de tela es resistente, la suciedad es mucha y el peso es medio
        double r26_aux = Math.min ( resistente_T, mucha_S );
        double r26 = Math.min ( r26_aux, media_P );
        
        // Regla de entrada 27 : Si el tipo de tela es resistente, la suciedad es mucha y el peso es pesado
        double r27_aux = Math.min ( resistente_T, mucha_S );
        double r27 = Math.min ( r27_aux, pesada_P );
        
        
        
        // IMPLICACIÓN USANDO LOS MÍNIMOS ImpMethod='min' (Consecuencias de las reglas)
        
        
        // Regla de salida 1 : Entonces tiempo de lavado es muy Corta, temperatura es fría, tiempo de Secado es muy Corta,
        // RPM es baja, y calidad de lavado es alta.
        
        double s1_1 = Math.min ( r1 , muyCorta_TL ) ;
        double s1_2 = Math.min ( r1, fria_Temp ) ;
        double s1_3 = Math.min ( r1, muyCorta_TS ) ;
        double s1_4 = Math.min ( r1, baja_RPM ) ;
        double s1_5 = Math.min ( r1, alta_CL ) ;
        
        // Regla de salida 2 : Entonces tiempo de lavado es Corta, temperatura es fría, tiempo de Secado es Corta,
        // RPM es baja, y calidad de lavado es alta.
        
        double s2_1 = Math.min ( r2 , corta_TL ) ;
        double s2_2 = Math.min ( r2, fria_Temp ) ;
        double s2_3 = Math.min ( r2, corta_TS ) ;
        double s2_4 = Math.min ( r2, baja_RPM ) ;
        double s2_5 = Math.min ( r2, alta_CL ) ;
        
        // Regla de salida 3 : Entonces tiempo de lavado es media, temperatura es fría, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s3_1 = Math.min ( r3 , media_TL ) ;
        double s3_2 = Math.min ( r3, fria_Temp ) ;
        double s3_3 = Math.min ( r3, media_TS ) ;
        double s3_4 = Math.min ( r3, media_RPM ) ;
        double s3_5 = Math.min ( r3, media_CL ) ;
        
        // Regla de salida 4 : Entonces tiempo de lavado es media, temperatura es fría, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s4_1 = Math.min ( r4 , media_TL ) ;
        double s4_2 = Math.min ( r4, fria_Temp ) ;
        double s4_3 = Math.min ( r4, media_TS ) ;
        double s4_4 = Math.min ( r4, media_RPM ) ;
        double s4_5 = Math.min ( r4, media_CL ) ;
        
        // Regla de salida 5 : Entonces tiempo de lavado es media, temperatura es fría, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s5_1 = Math.min ( r5 , media_TL ) ;
        double s5_2 = Math.min ( r5, fria_Temp ) ;
        double s5_3 = Math.min ( r5, media_TS ) ;
        double s5_4 = Math.min ( r5, media_RPM ) ;
        double s5_5 = Math.min ( r5, media_CL ) ;
        
        // Regla de salida 6 : Entonces tiempo de lavado es larga, temperatura es fría, tiempo de Secado es larga,
        // RPM es media, y calidad de lavado es baja.
        
        double s6_1 = Math.min ( r6 , larga_TL ) ;
        double s6_2 = Math.min ( r6, fria_Temp ) ;
        double s6_3 = Math.min ( r6, larga_TS ) ;
        double s6_4 = Math.min ( r6, media_RPM ) ;
        double s6_5 = Math.min ( r6, baja_CL ) ;
        
        // Regla de salida 7 : Entonces tiempo de lavado es media, temperatura es tibia, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s7_1 = Math.min ( r7 , media_TL ) ;
        double s7_2 = Math.min ( r7, tibia_Temp ) ;
        double s7_3 = Math.min ( r7, media_TS ) ;
        double s7_4 = Math.min ( r7, media_RPM ) ;
        double s7_5 = Math.min ( r7, media_CL ) ;
        
        // Regla de salida 8 : Entonces tiempo de lavado es media, temperatura es tibia, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s8_1 = Math.min ( r8 , media_TL ) ;
        double s8_2 = Math.min ( r8, tibia_Temp ) ;
        double s8_3 = Math.min ( r8, media_TS ) ;
        double s8_4 = Math.min ( r8, media_RPM ) ;
        double s8_5 = Math.min ( r8, media_CL ) ;
        
        // Regla de salida 9 : Entonces tiempo de lavado es larga, temperatura es tibia, tiempo de Secado es larga,
        // RPM es media, y calidad de lavado es baja.
        
        double s9_1 = Math.min ( r9 , larga_TL ) ;
        double s9_2 = Math.min ( r9, tibia_Temp ) ;
        double s9_3 = Math.min ( r9, larga_TS ) ;
        double s9_4 = Math.min ( r9, media_RPM ) ;
        double s9_5 = Math.min ( r9, baja_CL ) ;
        
        // Regla de salida 10 : Entonces tiempo de lavado es corta, temperatura es fria, tiempo de Secado es corta,
        // RPM es baja, y calidad de lavado es alta.
        
        double s10_1 = Math.min ( r10 , corta_TL ) ;
        double s10_2 = Math.min ( r10, fria_Temp ) ;
        double s10_3 = Math.min ( r10, corta_TS ) ;
        double s10_4 = Math.min ( r10, baja_RPM ) ;
        double s10_5 = Math.min ( r10, alta_CL ) ;
        
        // Regla de salida 11 : Entonces tiempo de lavado es media, temperatura es fria, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s11_1 = Math.min ( r11 , media_TL ) ;
        double s11_2 = Math.min ( r11, fria_Temp ) ;
        double s11_3 = Math.min ( r11, media_TS ) ;
        double s11_4 = Math.min ( r11, media_RPM ) ;
        double s11_5 = Math.min ( r11, media_CL ) ;
        
        // Regla de salida 12 : Entonces tiempo de lavado es larga, temperatura es fria, tiempo de Secado es larga,
        // RPM es media, y calidad de lavado es baja.
        
        double s12_1 = Math.min ( r12 , larga_TL ) ;
        double s12_2 = Math.min ( r12, fria_Temp ) ;
        double s12_3 = Math.min ( r12, larga_TS ) ;
        double s12_4 = Math.min ( r12, media_RPM ) ;
        double s12_5 = Math.min ( r12, baja_CL ) ;
        
        // Regla de salida 13 : Entonces tiempo de lavado es media, temperatura es tibia, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s13_1 = Math.min ( r13 , media_TL ) ;
        double s13_2 = Math.min ( r13, tibia_Temp ) ;
        double s13_3 = Math.min ( r13, media_TS ) ;
        double s13_4 = Math.min ( r13, media_RPM ) ;
        double s13_5 = Math.min ( r13, media_CL ) ;
        
        // Regla de salida 14 : Entonces tiempo de lavado es larga, temperatura es tibia, tiempo de Secado es larga,
        // RPM es media, y calidad de lavado es media.
        
        double s14_1 = Math.min ( r14 , larga_TL ) ;
        double s14_2 = Math.min ( r14, tibia_Temp ) ;
        double s14_3 = Math.min ( r14, larga_TS ) ;
        double s14_4 = Math.min ( r14, media_RPM ) ;
        double s14_5 = Math.min ( r14, media_CL ) ;
        
        // Regla de salida 15 : Entonces tiempo de lavado es larga, temperatura es tibia, tiempo de Secado es larga,
        // RPM es alta, y calidad de lavado es alta.
        
        double s15_1 = Math.min ( r15 , larga_TL ) ;
        double s15_2 = Math.min ( r15, tibia_Temp ) ;
        double s15_3 = Math.min ( r15, larga_TS ) ;
        double s15_4 = Math.min ( r15, alta_RPM ) ;
        double s15_5 = Math.min ( r15, alta_CL ) ;
        
        // Regla de salida 16 : Entonces tiempo de lavado es corta, temperatura es tibia, tiempo de Secado es corta,
        // RPM es media, y calidad de lavado es media.
        
        double s16_1 = Math.min ( r16 , corta_TL ) ;
        double s16_2 = Math.min ( r16, tibia_Temp ) ;
        double s16_3 = Math.min ( r16, corta_TS ) ;
        double s16_4 = Math.min ( r16, media_RPM ) ;
        double s16_5 = Math.min ( r16, media_CL ) ;
        
        // Regla de salida 17 : Entonces tiempo de lavado es larga, temperatura es tibia, tiempo de Secado es larga,
        // RPM es alta, y calidad de lavado es alta.
        
        double s17_1 = Math.min ( r17 , larga_TL ) ;
        double s17_2 = Math.min ( r17, tibia_Temp ) ;
        double s17_3 = Math.min ( r17, larga_TS ) ;
        double s17_4 = Math.min ( r17, alta_RPM ) ;
        double s17_5 = Math.min ( r17, alta_CL ) ;
        
        // Regla de salida 18 : Entonces tiempo de lavado es larga, temperatura es tibia, tiempo de Secado es larga,
        // RPM es alta, y calidad de lavado es alta.
        
        double s18_1 = Math.min ( r18 , larga_TL ) ;
        double s18_2 = Math.min ( r18, tibia_Temp ) ;
        double s18_3 = Math.min ( r18, larga_TS ) ;
        double s18_4 = Math.min ( r18, alta_RPM ) ;
        double s18_5 = Math.min ( r18, alta_CL ) ;
        
        // Regla de salida 19 : Entonces tiempo de lavado es corta, temperatura es fria, tiempo de Secado es corta,
        // RPM es baja, y calidad de lavado es alta.
        
        double s19_1 = Math.min ( r19 , corta_TL ) ;
        double s19_2 = Math.min ( r19, fria_Temp ) ;
        double s19_3 = Math.min ( r19, corta_TS ) ;
        double s19_4 = Math.min ( r19, baja_RPM ) ;
        double s19_5 = Math.min ( r19, alta_CL ) ;
        
        // Regla de salida 20 : Entonces tiempo de lavado es media, temperatura es fria, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s20_1 = Math.min ( r20 , media_TL ) ;
        double s20_2 = Math.min ( r20, fria_Temp ) ;
        double s20_3 = Math.min ( r20, media_TS ) ;
        double s20_4 = Math.min ( r20, media_RPM ) ;
        double s20_5 = Math.min ( r20, media_CL ) ;
        
        // Regla de salida 21 : Entonces tiempo de lavado es larga, temperatura es fria, tiempo de Secado es larga,
        // RPM es media, y calidad de lavado es baja.
        
        double s21_1 = Math.min ( r21 , larga_TL ) ;
        double s21_2 = Math.min ( r21, fria_Temp ) ;
        double s21_3 = Math.min ( r21, larga_TS ) ;
        double s21_4 = Math.min ( r21, media_RPM ) ;
        double s21_5 = Math.min ( r21, baja_CL ) ;
        
        // Regla de salida 22 : Entonces tiempo de lavado es media, temperatura es tibia, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es media.
        
        double s22_1 = Math.min ( r22 , media_TL ) ;
        double s22_2 = Math.min ( r22, tibia_Temp ) ;
        double s22_3 = Math.min ( r22, media_TS ) ;
        double s22_4 = Math.min ( r22, media_RPM ) ;
        double s22_5 = Math.min ( r22, media_CL ) ;
        
        // Regla de salida 23 : Entonces tiempo de lavado es larga, temperatura es tibia, tiempo de Secado es larga,
        // RPM es media, y calidad de lavado es baja.
        
        double s23_1 = Math.min ( r23 , larga_TL ) ;
        double s23_2 = Math.min ( r23, tibia_Temp ) ;
        double s23_3 = Math.min ( r23, larga_TS ) ;
        double s23_4 = Math.min ( r23, media_RPM ) ;
        double s23_5 = Math.min ( r23, baja_CL ) ;
        
        // Regla de salida 24 : Entonces tiempo de lavado es muy larga, temperatura es tibia, tiempo de Secado es muy larga,
        // RPM es alta, y calidad de lavado es alta.
        
        double s24_1 = Math.min ( r24 , muyLarga_TL ) ;
        double s24_2 = Math.min ( r24, tibia_Temp ) ;
        double s24_3 = Math.min ( r24, muyLarga_TS ) ;
        double s24_4 = Math.min ( r24, alta_RPM ) ;
        double s24_5 = Math.min ( r24, alta_CL ) ;
        
        // Regla de salida 25 : Entonces tiempo de lavado es media, temperatura es caliente, tiempo de Secado es media,
        // RPM es media, y calidad de lavado es baja.
        
        double s25_1 = Math.min ( r25 , media_TL ) ;
        double s25_2 = Math.min ( r25, caliente_Temp ) ;
        double s25_3 = Math.min ( r25, media_TS ) ;
        double s25_4 = Math.min ( r25, media_RPM ) ;
        double s25_5 = Math.min ( r25, baja_CL ) ;
        
        // Regla de salida 26 : Entonces tiempo de lavado es larga, temperatura es caliente, tiempo de Secado es larga,
        // RPM es alta, y calidad de lavado es alta.
        
        double s26_1 = Math.min ( r26 , larga_TL ) ;
        double s26_2 = Math.min ( r26, caliente_Temp ) ;
        double s26_3 = Math.min ( r26, larga_TS ) ;
        double s26_4 = Math.min ( r26, alta_RPM ) ;
        double s26_5 = Math.min ( r26, alta_CL ) ;
        
        // Regla de salida 27 : Entonces tiempo de lavado es muy larga, temperatura es caliente, tiempo de Secado es muy larga,
        // RPM es alta, y calidad de lavado es alta.
        
        double s27_1 = Math.min ( r27 , muyLarga_TL ) ;
        double s27_2 = Math.min ( r27, caliente_Temp ) ;
        double s27_3 = Math.min ( r27, muyLarga_TS ) ;
        double s27_4 = Math.min ( r27, alta_RPM ) ;
        double s27_5 = Math.min ( r27, alta_CL ) ;
        
        // AGREGACIÓN POR MEDIO DE MÁXIMOS AggMethod='max'
        
        // Agregación por medio de máximos para cada variable de salida
        
        // Tiempo de lavado
        

        // Para tiempo de lavado
        /*double max_TL = Math.max(s1_1, Math.max(s2_1, Math.max(s3_1, Math.max(s4_1, Math.max(s5_1, 
                Math.max(s6_1, Math.max(s7_1, Math.max(s8_1, Math.max(s9_1, Math.max(s10_1, Math.max(s11_1,
                        Math.max(s12_1, Math.max(s13_1, Math.max(s14_1, Math.max(s15_1, Math.max(s16_1, Math.max(s17_1, 
                                Math.max(s18_1, Math.max(s19_1, Math.max(s20_1, Math.max(s21_1, Math.max(s22_1, Math.max(s23_1, 
                                        Math.max(s24_1, Math.max(s25_1, Math.max(s26_1, s27_1))))))))))))))))))))))))));
        */
        
        double max_TL = Math.max(s1_1, s2_1);
        max_TL = Math.max(max_TL, s3_1);
        max_TL = Math.max(max_TL, s4_1);
        max_TL = Math.max(max_TL, s5_1);
        max_TL = Math.max(max_TL, s6_1);
        max_TL = Math.max(max_TL, s7_1);
        max_TL = Math.max(max_TL, s8_1);
        max_TL = Math.max(max_TL, s9_1);
        max_TL = Math.max(max_TL, s10_1);
        max_TL = Math.max(max_TL, s11_1);
        max_TL = Math.max(max_TL, s12_1);
        max_TL = Math.max(max_TL, s13_1);
        max_TL = Math.max(max_TL, s14_1);
        max_TL = Math.max(max_TL, s15_1);
        max_TL = Math.max(max_TL, s16_1);
        max_TL = Math.max(max_TL, s17_1);
        max_TL = Math.max(max_TL, s18_1);
        max_TL = Math.max(max_TL, s19_1);
        max_TL = Math.max(max_TL, s20_1);
        max_TL = Math.max(max_TL, s21_1);
        max_TL = Math.max(max_TL, s22_1);
        max_TL = Math.max(max_TL, s23_1);
        max_TL = Math.max(max_TL, s24_1);
        max_TL = Math.max(max_TL, s25_1);
        max_TL = Math.max(max_TL, s26_1);
        max_TL = Math.max(max_TL, s27_1);
        
        System.out.println(" " + max_TL);
        
        // Para temperatura
        double max_Temp = Math.max(s1_2, Math.max(s2_2, Math.max(s3_2, Math.max(s4_2, Math.max(s5_2, 
                Math.max(s6_2, Math.max(s7_2, Math.max(s8_2, Math.max(s9_2, Math.max(s10_2, Math.max(s11_2, 
                        Math.max(s12_2, Math.max(s13_2, Math.max(s14_2, Math.max(s15_2, Math.max(s16_2, Math.max(s17_2, 
                                Math.max(s18_2, Math.max(s19_2, Math.max(s20_2, Math.max(s21_2, Math.max(s22_2, Math.max(s23_2, 
                                        Math.max(s24_2, Math.max(s25_2, Math.max(s26_2, s27_2))))))))))))))))))))))))));

        // Para tiempo de secado
        double max_TS = Math.max(s1_3, Math.max(s2_3, Math.max(s3_3, Math.max(s4_3, Math.max(s5_3, 
                Math.max(s6_3, Math.max(s7_3, Math.max(s8_3, Math.max(s9_3, Math.max(s10_3, Math.max(s11_3, 
                        Math.max(s12_3, Math.max(s13_3, Math.max(s14_3, Math.max(s15_3, Math.max(s16_3, Math.max(s17_3, 
                                Math.max(s18_3, Math.max(s19_3, Math.max(s20_3, Math.max(s21_3, Math.max(s22_3, Math.max(s23_3, 
                                        Math.max(s24_3, Math.max(s25_3, Math.max(s26_3, s27_3))))))))))))))))))))))))));

        // Para RPM
        double max_RPM = Math.max(s1_4, Math.max(s2_4, Math.max(s3_4, Math.max(s4_4, Math.max(s5_4, 
                Math.max(s6_4, Math.max(s7_4, Math.max(s8_4, Math.max(s9_4, Math.max(s10_4, Math.max(s11_4, 
                        Math.max(s12_4, Math.max(s13_4, Math.max(s14_4, Math.max(s15_4, Math.max(s16_4, Math.max(s17_4, 
                                Math.max(s18_4, Math.max(s19_4, Math.max(s20_4, Math.max(s21_4, Math.max(s22_4, Math.max(s23_4, 
                                        Math.max(s24_4, Math.max(s25_4, Math.max(s26_4, s27_4))))))))))))))))))))))))));

        // Para calidad de lavado
        double max_CL = Math.max(s1_5, Math.max(s2_5, Math.max(s3_5, Math.max(s4_5, Math.max(s5_5, 
                Math.max(s6_5, Math.max(s7_5, Math.max(s8_5, Math.max(s9_5, Math.max(s10_5, Math.max(s11_5, 
                        Math.max(s12_5, Math.max(s13_5, Math.max(s14_5, Math.max(s15_5, Math.max(s16_5, Math.max(s17_5, 
                                Math.max(s18_5, Math.max(s19_5, Math.max(s20_5, Math.max(s21_5, Math.max(s22_5, Math.max(s23_5, 
                                        Math.max(s24_5, Math.max(s25_5, Math.max(s26_5, s27_5))))))))))))))))))))))))));
        

        
        // DEFUZZIFICACIÓN POR MEDIO DEL CENTROIDE
        
        double [] membresiasTL = {max_TL, max_TL, max_TL, max_TL, max_TL, /**/max_TL, max_TL, max_TL, max_TL, max_TL, max_TL/**/, max_TL, max_TL, max_TL, max_TL, max_TL, 0};
        double [] valoresTL =    {0, 0, 5, 10,5,15,25,20,30,40,35,45,55,50,55,60,60};
        
        double [] membresiasTemp = {0, 0, 0, max_Temp, max_Temp, max_Temp, 0, 0, 0}; 
        double [] valoresTemp = {15,15,30,25,37.5,50,45,60,60};
        
        double [] membresiasTS = {0, 0, 0, 0, 0, 0, 0, max_TS,max_TS,max_TS, 0, 0, 0, 0, 0, 0, 0};
        double [] valoresTS = {0,0,5,10,5,15,25,20,30,40,35,45,55,50,55,60,60};
        
        double [] membresiasRPM = {0, 0, 0, max_RPM, max_RPM, max_RPM, 0, 0, 0};
        double [] valoresRPM = {0,300,600,400,800,1200,1000,1300,1600};
        
        double [] membresiasCL = {0, 0, 0, max_CL, max_CL, max_CL, 0, 0, 0};
        double [] valoresCL = {0,0,50,10,50,90,50,100,100};
        
        

        // Se obtiene el centroide del tiempo
        
        tiempoLavado = centroide ( membresiasTL , valoresTL ) ;
        temperatura = LogicaDifusa.centroide ( membresiasTemp, valoresTemp ) ;
        tiempoSecado = LogicaDifusa.centroide ( membresiasTS, valoresTS ) ;
        RPM = LogicaDifusa.centroide ( membresiasRPM, valoresRPM ) ;
        calidadLavado = LogicaDifusa.centroide ( membresiasCL, valoresCL );
        
    }
    
    public static void main(String[] args) {
        // Valores de entrada
        double tipoTela = 30; // Ejemplo
        double suciedadRopa = 30; // Ejemplo
        double pesoRopa = 30; // Ejemplo

       // LogicaDifusa
       LogicaDifusa.evaluar(tipoTela, suciedadRopa, pesoRopa);

        // Imprimir resultados
        
        System.out.println("Tiempo de lavado: " + LogicaDifusa.getTiempoLavado());
        System.out.println("Temperatura: " + LogicaDifusa.getTemperatura());
        System.out.println("Tiempo de secado: " + LogicaDifusa.getTiempoSecado());
        System.out.println("RPM: " + LogicaDifusa.getRPM());
        System.out.println("Calidad del lavado: " + LogicaDifusa.getCalidadLavado());
        
        // Los valores de salida según Matlabd deberían de ser
        // Tiempo de lavado: 45
        // temperatura : 47.5
        // tiempo de secado: 45
        // RPM : 800
        // calidad de lavado : 50
        
    }
    
    // -------------------------------------------------------------------------
}
