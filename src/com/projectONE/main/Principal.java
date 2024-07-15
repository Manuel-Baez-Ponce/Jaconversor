package com.projectONE.main;

import com.projectONE.modules.TasaDeCambio;
import com.projectONE.services.APIConnect;
import com.projectONE.services.ConversionDivisa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static final String urlBase = "https://v6.exchangerate-api.com/v6/";
    private static final String apiKEY = "Api_Key";
    private static final String mensajeBienvenida = "Bienvenido a la herramienta de conversion de divisas Jaconvercion";
    private static final String menu = "Lista de divisas disponibles para conversion:\n" +
            "\t1) Peso Mexicano MXN\n" +
            "\t2) Dolar Estadounidense USD\n" +
            "\t3) Dolar Canadiense CAD\n" +
            "\t4) Euro Union Europea EUR\n" +
            "\t5) Franco Suiso CHF\n" +
            "\t6) Yen Japones JPY\n" +
            "\t7) Yuan Chino CHY\n" +
            "\n\t0) Salir\n";
    private static final List<String> codigoDivisa = new ArrayList<>(Arrays.asList(
            "MXN",
            "USD",
            "CAD",
            "EUR",
            "CHF",
            "JPY",
            "CHY"
    ));
    private static final List<String> nombreDivisa = new ArrayList<>(Arrays.asList(
            "pesos",
            "dolares",
            "dolares",
            "euros",
            "francos",
            "yenes",
            "yuanes"
    ));
    private static int seleccion1;
    private static int seleccion2;
    private static double monto;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(mensajeBienvenida);
        String urlconsulta = urlBase + apiKEY + "/pair/";
        while (true){
            System.out.println(menu);
            System.out.println("Porfavor seleccione la divisa que desea convertir.");
            seleccion1 = teclado.nextInt();
            if (seleccion1 == 0){
                System.out.println("Gracias por confiar en Jaconversor");
                break;
            }
            System.out.println("Porfavor seleccione la divisa a la que desea convertir.");
            seleccion2 = teclado.nextInt();
            System.out.println("Porfavor introdusca el monto que desea convertir.");
            monto = teclado.nextDouble();
            try {
                urlconsulta += codigoDivisa.get(seleccion1 - 1) + '/' + codigoDivisa.get(seleccion2 - 1) + '/';
                TasaDeCambio tasaDeCambio = APIConnect.obtenerTasaDeCambio(urlconsulta);
                monto = ConversionDivisa.Conversion(monto, tasaDeCambio);
                System.out.println("\nEl resultado de la conversion es de " +
                        monto + " " + nombreDivisa.get (seleccion2 - 1) + '\n'
                );
            } catch(Exception e) {
                throw new RuntimeException("Seleccion de divisas no valida para conversion");
            }
        }

    }
}
