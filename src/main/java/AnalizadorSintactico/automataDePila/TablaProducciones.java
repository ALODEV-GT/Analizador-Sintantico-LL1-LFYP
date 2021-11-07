package AnalizadorSintactico.automataDePila;

import java.util.ArrayList;

public class TablaProducciones {
    private final Contenedor[][] tablaTransicion = new Contenedor[27][20];

    public TablaProducciones() {
    }
    
     /**FILAS
     *  I = 0
     * E = 1
     * R = 2
     * K = 3
     * Q = 4
     * C = 5
     * D = 6
     * P = 7
     * W = 8
     * A = 9
     * A' = 10
     * T = 11
     * T' = 12
     * B = 13
     * B' = 14
     * U = 15
     * G = 16
     * N = 17
     * Y = 18
     * M = 19
     * S = 20
     * O = 21
     * H = 22
     * Z = 23
     * X = 24
     * L = 25
     * F = 26
     */
    
    /**COLUMNAS
     * ESCRIBIR = 0
     * REPETIR = 1
     * SI = 2
     * id = 3
     * numero = 4
     * literal = 5
     * VERDADERO = 6
     * FALSO = 7
     * + = 8
     * - = 9
     * * = 10
     * / = 11
     * ^ = 12
     * ( = 13
     * ) = 14
     * ENTONCES = 15
     * INICIAR = 16
     * = = 17
     * FIN = 18
     * $ = 19
     */
    
    /** ID TERMINALES
     * ESCRIBIR = -1
     * REPETIR = -2
     * SI = -3
     * id = -4
     * numero = -5
     * literal = -6
     * VERDADERO = -7
     * FALSO = -8
     * + = -9
     * - = -10
     * * = -11
     * / = -12
     * ^ = -13
     * ( = -14
     * ) = -15
     * ENTONCES = -16
     * INICIAR = -17
     * = = -18
     * FIN = -19
     * $ (fin archivo) = -20
     * ε = -21
     */

    {  
        //FILA 0
        ArrayList<Integer> producciones0_0 = new ArrayList<>();
        producciones0_0.add(1);
        producciones0_0.add(0);
        tablaTransicion[0][0] = new Contenedor(producciones0_0);
        
        ArrayList<Integer> producciones0_1 = new ArrayList<>();
        producciones0_1.add(2);
        producciones0_1.add(0);
        tablaTransicion[0][1] = new Contenedor(producciones0_1);
        
        ArrayList<Integer> producciones0_2 = new ArrayList<>();
        producciones0_2.add(3);
        producciones0_2.add(0);
        tablaTransicion[0][2] = new Contenedor(producciones0_2);
        
        ArrayList<Integer> producciones0_3 = new ArrayList<>();
        producciones0_3.add(4);
        producciones0_3.add(0);
        tablaTransicion[0][3] = new Contenedor(producciones0_3);
        
        ArrayList<Integer> producciones0_19 = new ArrayList<>();
        producciones0_19.add(-21);
        tablaTransicion[0][19] = new Contenedor(producciones0_19);
        
        //FILA 1
        ArrayList<Integer> producciones1_0 = new ArrayList<>();
        producciones1_0.add(23);
        producciones1_0.add(5);
        producciones1_0.add(26);
        tablaTransicion[1][0] = new Contenedor(producciones1_0);
        
        ArrayList<Integer> producciones1_19 = new ArrayList<>();
        producciones1_19.add(-21);
        tablaTransicion[1][19] = new Contenedor(producciones1_19);
        
        //FILA 2
        ArrayList<Integer> producciones2_1 = new ArrayList<>();
        producciones2_1.add(24);
        producciones2_1.add(6);
        producciones2_1.add(22);
        producciones2_1.add(7);
        producciones2_1.add(26);
        tablaTransicion[2][1] = new Contenedor(producciones2_1);
        
        ArrayList<Integer> producciones2_19 = new ArrayList<>();
        producciones2_19.add(-21);
        tablaTransicion[2][19] = new Contenedor(producciones2_19);
        
        //FILA 3
        ArrayList<Integer> producciones3_2 = new ArrayList<>();
        producciones3_2.add(24);
        producciones3_2.add(6);
        producciones3_2.add(22);
        producciones3_2.add(7);
        producciones3_2.add(26);
        tablaTransicion[3][2] = new Contenedor(producciones3_2);
        
        ArrayList<Integer> producciones3_19 = new ArrayList<>();
        producciones3_19.add(-21);
        tablaTransicion[3][19] = new Contenedor(producciones3_19);
        
        //FILA 4
         ArrayList<Integer> producciones4_3 = new ArrayList<>();
        producciones4_3.add(18);
        producciones4_3.add(25);
        producciones4_3.add(9);
        producciones4_3.add(26);
        tablaTransicion[4][3] = new Contenedor(producciones4_3);
        
        //FILA 5
         ArrayList<Integer> producciones5_3 = new ArrayList<>();
        producciones5_3.add(18);
        tablaTransicion[5][3] = new Contenedor(producciones5_3);
        
         ArrayList<Integer> producciones5_4 = new ArrayList<>();
        producciones5_4.add(17);
        tablaTransicion[5][4] = new Contenedor(producciones5_4);
        
         ArrayList<Integer> producciones5_5 = new ArrayList<>();
        producciones5_5.add(19);
        tablaTransicion[5][5] = new Contenedor(producciones5_5);
        
        //FILA 6
          ArrayList<Integer> producciones6_3 = new ArrayList<>();
        producciones6_3.add(18);
        tablaTransicion[6][3] = new Contenedor(producciones6_3);
        
         ArrayList<Integer> producciones6_4 = new ArrayList<>();
        producciones6_4.add(17);
        tablaTransicion[6][4] = new Contenedor(producciones6_4);
        
        //FILA 7
        ArrayList<Integer> producciones7_0 = new ArrayList<>();
        producciones7_0.add(1);
        producciones7_0.add(7);
        tablaTransicion[7][0] = new Contenedor(producciones7_0);
        
        ArrayList<Integer> producciones7_18 = new ArrayList<>();
        producciones7_18.add(-21);
        tablaTransicion[7][18] = new Contenedor(producciones7_18);
        
        //FILA 8
        ArrayList<Integer> producciones8_6 = new ArrayList<>();
        producciones8_6.add(-7);
        tablaTransicion[8][6] = new Contenedor(producciones8_6);
        
        ArrayList<Integer> producciones8_7 = new ArrayList<>();
        producciones8_7.add(-8);
        tablaTransicion[8][7] = new Contenedor(producciones8_7);
        
        //FILA 9
        ArrayList<Integer> producciones9_3 = new ArrayList<>();
        producciones9_3.add(11);
        producciones9_3.add(10);
        tablaTransicion[9][3] = new Contenedor(producciones9_3);
        
        ArrayList<Integer> producciones9_4 = new ArrayList<>();
        producciones9_4.add(10);
        producciones9_4.add(11);
        tablaTransicion[9][4] = new Contenedor(producciones9_4);
        
        ArrayList<Integer> producciones9_9 = new ArrayList<>();
        producciones9_9.add(10);
        producciones9_9.add(11);
        tablaTransicion[9][9] = new Contenedor(producciones9_9);
        
        ArrayList<Integer> producciones9_13 = new ArrayList<>();
        producciones9_13.add(10);
        producciones9_13.add(11);
        tablaTransicion[9][13] = new Contenedor(producciones9_13);
        
        //FILA 10
        ArrayList<Integer> producciones10_8 = new ArrayList<>();
        producciones10_8.add(-9);
        producciones10_8.add(11);
        producciones10_8.add(10);
        tablaTransicion[10][8] = new Contenedor(producciones10_8);
        
        ArrayList<Integer> producciones10_9 = new ArrayList<>();
        producciones10_9.add(-10);
        producciones10_9.add(11);
        producciones10_9.add(10);
        tablaTransicion[10][9] = new Contenedor(producciones10_9);
        
        ArrayList<Integer> producciones10_14 = new ArrayList<>();
        producciones10_14.add(-21);
        tablaTransicion[10][14] = new Contenedor(producciones10_14);
        
        ArrayList<Integer> producciones10_18 = new ArrayList<>();
        producciones10_18.add(-21);
        tablaTransicion[10][18] = new Contenedor(producciones10_18);
        
        //FILA 11
        ArrayList<Integer> producciones11_3 = new ArrayList<>();
        producciones11_3.add(13);
        producciones11_3.add(12);
        tablaTransicion[11][3] = new Contenedor(producciones11_3);
        
        ArrayList<Integer> producciones11_4 = new ArrayList<>();
        producciones11_4.add(13);
        producciones11_4.add(12);
        tablaTransicion[11][4] = new Contenedor(producciones11_4);
        
        ArrayList<Integer> producciones11_9 = new ArrayList<>();
        producciones11_9.add(13);
        producciones11_9.add(12);
        tablaTransicion[11][9] = new Contenedor(producciones11_9);
        
        ArrayList<Integer> producciones11_13 = new ArrayList<>();
        producciones11_13.add(13);
        producciones11_13.add(12);
        tablaTransicion[11][13] = new Contenedor(producciones11_13);
        
        //FILA 12
        ArrayList<Integer> producciones12_8 = new ArrayList<>();
        producciones12_8.add(-21);
        tablaTransicion[12][8] = new Contenedor(producciones12_8);
        
        ArrayList<Integer> producciones12_9 = new ArrayList<>();
        producciones12_9.add(-21);
        tablaTransicion[12][9] = new Contenedor(producciones12_9);
        
        ArrayList<Integer> producciones12_10 = new ArrayList<>();
        producciones12_10.add(-11);
        producciones12_10.add(13);
        producciones12_10.add(12);
        tablaTransicion[12][10] = new Contenedor(producciones12_10);
        
        ArrayList<Integer> producciones12_11 = new ArrayList<>();
        producciones12_11.add(-12);
        producciones12_11.add(13);
        producciones12_11.add(12);
        tablaTransicion[12][11] = new Contenedor(producciones12_11);
        
        ArrayList<Integer> producciones12_14 = new ArrayList<>();
        producciones12_14.add(-21);
        tablaTransicion[12][14] = new Contenedor(producciones12_14);
        
        ArrayList<Integer> producciones12_18 = new ArrayList<>();
        producciones12_18.add(-21);
        tablaTransicion[12][18] = new Contenedor(producciones12_18);
        
        //FILA 13
        ArrayList<Integer> producciones13_3 = new ArrayList<>();
        producciones13_3.add(15);
        producciones13_3.add(14);
        tablaTransicion[13][3] = new Contenedor(producciones13_3);
        
        ArrayList<Integer> producciones13_4 = new ArrayList<>();
        producciones13_4.add(15);
        producciones13_4.add(14);
        tablaTransicion[13][4] = new Contenedor(producciones13_4);
        
        ArrayList<Integer> producciones13_9 = new ArrayList<>();
        producciones13_9.add(15);
        producciones13_9.add(14);
        tablaTransicion[13][9] = new Contenedor(producciones13_9);
        
        ArrayList<Integer> producciones13_13 = new ArrayList<>();
        producciones13_13.add(15);
        producciones13_13.add(14);
        tablaTransicion[13][13] = new Contenedor(producciones13_13);
        
        //FILA 14
        ArrayList<Integer> producciones14_8 = new ArrayList<>();
        producciones14_8.add(-21);
        tablaTransicion[14][8] = new Contenedor(producciones14_8);
        
        ArrayList<Integer> producciones14_9 = new ArrayList<>();
        producciones14_9.add(-21);
        tablaTransicion[14][9] = new Contenedor(producciones14_9);
        
        ArrayList<Integer> producciones14_10 = new ArrayList<>();
        producciones14_10.add(-21);
        tablaTransicion[14][10] = new Contenedor(producciones14_10);
        
        ArrayList<Integer> producciones14_11 = new ArrayList<>();
        producciones14_11.add(-21);
        tablaTransicion[14][11] = new Contenedor(producciones14_11);
        
        ArrayList<Integer> producciones14_12 = new ArrayList<>();
        producciones14_12.add(-13);
        producciones14_12.add(13);
        tablaTransicion[14][12] = new Contenedor(producciones14_12);
        
        ArrayList<Integer> producciones14_14 = new ArrayList<>();
        producciones14_14.add(-21);
        tablaTransicion[14][14] = new Contenedor(producciones14_14);
        
        ArrayList<Integer> producciones14_18 = new ArrayList<>();
        producciones14_18.add(-21);
        tablaTransicion[14][18] = new Contenedor(producciones14_18);
        
        //FILA 15
        ArrayList<Integer> producciones15_3 = new ArrayList<>();
        producciones15_3.add(16);
        tablaTransicion[15][3] = new Contenedor(producciones15_3);
        
        ArrayList<Integer> producciones15_4 = new ArrayList<>();
        producciones15_4.add(16);
        tablaTransicion[15][4] = new Contenedor(producciones15_4);
        
        ArrayList<Integer> producciones15_9 = new ArrayList<>();
        producciones15_9.add(-10);
        producciones15_9.add(16);
        tablaTransicion[15][9] = new Contenedor(producciones15_9);
        
        ArrayList<Integer> producciones15_13 = new ArrayList<>();
        producciones15_13.add(16);
        tablaTransicion[15][13] = new Contenedor(producciones15_13);
        
        //FILA 16
        ArrayList<Integer> producciones16_3 = new ArrayList<>();
        producciones16_3.add(18);
        tablaTransicion[16][3] = new Contenedor(producciones16_3);
        
        ArrayList<Integer> producciones16_4 = new ArrayList<>();
        producciones16_4.add(17);
        tablaTransicion[16][4] = new Contenedor(producciones16_4);
        
        ArrayList<Integer> producciones16_13 = new ArrayList<>();
        producciones16_13.add(-14);
        producciones16_13.add(9);
        producciones16_13.add(-15);
        tablaTransicion[16][13] = new Contenedor(producciones16_13);
        
        //FILA 17
        ArrayList<Integer> producciones17_4 = new ArrayList<>();
        producciones17_4.add(-5);
        tablaTransicion[17][4] = new Contenedor(producciones17_4);
        
        //FILA 18
        ArrayList<Integer> producciones18_3 = new ArrayList<>();
        producciones18_3.add(-4);
        tablaTransicion[18][3] = new Contenedor(producciones18_3);
        
        //FILA 19
        ArrayList<Integer> producciones19_5 = new ArrayList<>();
        producciones19_5.add(-6);
        tablaTransicion[19][5] = new Contenedor(producciones19_5);
        
        //FILA 20
        ArrayList<Integer> producciones20_2 = new ArrayList<>();
        producciones20_2.add(-3);
        tablaTransicion[20][2] = new Contenedor(producciones20_2);
        
        //FILA 21
         ArrayList<Integer> producciones21_15 = new ArrayList<>();
        producciones21_15.add(-16);
        tablaTransicion[21][15] = new Contenedor(producciones21_15);
        
        //FILA 22
         ArrayList<Integer> producciones22_16 = new ArrayList<>();
        producciones22_16.add(-17);
        tablaTransicion[22][16] = new Contenedor(producciones22_16);
        
        //FILA 23
         ArrayList<Integer> producciones23_0 = new ArrayList<>();
        producciones23_0.add(-1);
        tablaTransicion[23][0] = new Contenedor(producciones23_0);
        
        //FILA 24
         ArrayList<Integer> producciones24_1 = new ArrayList<>();
        producciones24_1.add(-2);
        tablaTransicion[24][1] = new Contenedor(producciones24_1);
        
        //FILA 25
         ArrayList<Integer> producciones25_17 = new ArrayList<>();
        producciones25_17.add(-18);
        tablaTransicion[25][17] = new Contenedor(producciones25_17);
        
        //FILA 26
         ArrayList<Integer> producciones26_18 = new ArrayList<>();
        producciones26_18.add(-19);
        tablaTransicion[26][18] = new Contenedor(producciones26_18);
    }

    public Contenedor[][] getTablaTransicion() {
        return tablaTransicion;
    }
    
}
