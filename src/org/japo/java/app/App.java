/* 
 * Copyright 2016  - Raul Granel - raul.granel@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

/**
 * La clase App contiene la lógica del proyecto.
 *
 * @author - Raul Granel - raul.granel@gmail.com
 */
public class App {

    public static final int DIA = 10;
    public static final int MES = 6;
    public static final int ANY = 2002;

    /**
     * El método lanzarAplicación es el método de entrada de la clase App.
     */
    public void lanzarAplicacion() {

        if (comprobarFecha(DIA, MES)) {
            System.out.printf("Fecha......: %02d-%02d-%04d\n", DIA, MES, ANY);
        } else {
            System.out.println("Datos incorrectos, eso no es una fecha.");
        }
    }

    //Comprueba que es un día.
    private boolean comprobarDia(int d) {

        return d >= 1 && d <= obtenerDiasMes(MES, ANY);
    }

    //Comprueba que es un mes.
    private boolean comprobarMes(int m) {

        return m >= 1 && m <= 12;
    }

    private boolean comprobarFecha(int d, int m) {

        return comprobarDia(d) && comprobarMes(m);
    }

    //Comprueba si es un mes de 31 días.
    private boolean comprobarMes31(int mes) {

        return mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12;
    }

    //Comprueba si es un mes de 30 días.
    private boolean comprobarMes30(int mes) {

        return mes == 4 || mes == 6 || mes == 7 || mes == 9 || mes == 11;
    }

    //Comprueba si estamos en un año bisiesto.
    private boolean comprobarBisiesto(int any) {

        return any % 400 == 0 || any % 100 != 0 || any % 4 == 0;
    }

    //Obtiene los días que tiene el mes de febrero ese año.
    private int obtenerDiasFebrero(int any) {

        int dias;

        if (comprobarBisiesto(any)) {
            dias = 29;
        } else {
            dias = 28;
        }
        return dias;
    }

    //Obtiene los días del mes.
    private int obtenerDiasMes(int mes, int any) {

        int dias;

        if (comprobarMes31(mes)) {
            dias = 31;
        } else if (comprobarMes30(mes)) {
            dias = 30;
        } else {
            dias = obtenerDiasFebrero(any);
        }
        return dias;
    }

}
