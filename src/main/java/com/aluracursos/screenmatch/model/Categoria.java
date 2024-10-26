package com.aluracursos.screenmatch.model;

public enum Categoria {
    ACCION("Action", "Acción"),
    ROMANCE("Romance","Romance"),
    COMEDIA("Comedy","Comedia"),
    DRAMA("Drama","Drama"),
    CRIMEN("Crime","Crimen"),
    SHORT("Short","Corto"),
    ADVENTURE("Adventure","Adventura"),
    UNKNOWN; // Categoria desconocida

    private String categoriaOmdb;
    private String categoriaEspanol;

    Categoria(String categoriaOmdb , String categoriaEspanol) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaEspanol = categoriaEspanol;
    }

    // Constructor para el valor UNKNOWN que no necesita una string
    Categoria() {

    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb != null && categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        System.out.println("La categoría '" + text + "' no existe. Asignando UNKNOWN.");
        return Categoria.UNKNOWN;
    }
    public static Categoria fromEspanol(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaEspanol != null && categoria.categoriaEspanol.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        System.out.println("La categoría '" + text + "' no existe. Asignando UNKNOWN.");
        return Categoria.UNKNOWN;
    }

}

