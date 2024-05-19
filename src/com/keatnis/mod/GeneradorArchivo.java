package com.keatnis.mod;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivo {
 public void saveDataMovie (Pelicula pelicula) throws IOException {
     Gson gson = new GsonBuilder()
             .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
             .setPrettyPrinting()
             .create();
     FileWriter file = new FileWriter(pelicula.title()+".json");
     file.write(gson.toJson(pelicula));
     file.close();
 }
}
