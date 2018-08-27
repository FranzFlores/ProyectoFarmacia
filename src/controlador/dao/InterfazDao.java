/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import java.util.List;

/**
 * Esta Interfaz Generica define los metodos que se deben implementar dentro del
 * 'AdaptadorDao'
 *
 * @author Alberto Ortega
 */
public interface InterfazDao<T> {

    /**
     * Metodo para guardar los objetos y lanzar una excepcion
     */
    public void guardar(T obj) throws Exception;

    /**
     * Metodo para modificar los objetos y lanzar una excepcion
     */
    public void modificar(T obj) throws Exception;

    /**
     * Metodo para listar los objetos y me devuelve una lista
     */
    public List<T> listar();

    /**
     * Metodo para obtener el id
     */
    public T obtener(Long id);

}//Cierre de la Interfaz Generica
