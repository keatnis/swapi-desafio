package com.keatnis;

import com.keatnis.mod.ConsultaAPI;
import com.keatnis.mod.GeneradorArchivo;
import com.keatnis.mod.Pelicula;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

       ConsultaAPI consulta = new ConsultaAPI();
        System.out.println("Escriba el numero de pelicula de Star Wars que desea consultar");

       try{
           var numeroPelicula = Integer.valueOf(teclado.nextLine());
           Pelicula pelicula = consulta.buscaPelicula(numeroPelicula);
           System.out.println(pelicula);
           GeneradorArchivo generador = new GeneradorArchivo();
           generador.saveDataMovie(pelicula);
       }catch (NumberFormatException e){
           System.out.println("Numero no encontrado"+e.getMessage());

       }
       catch (RuntimeException | IOException e ) {
           System.out.println(e.getMessage());
           System.out.println("Finalizando la aplicacion");
       }

    }

}