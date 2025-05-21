package com.aluracursos.screnmach.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
