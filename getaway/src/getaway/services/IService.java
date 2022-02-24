/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getaway.services;
import java.util.List;

/**
 *
 * @author Malek
 */
public interface IService<T> {
     void ajouter(T entity) throws Exception;
    void supprimer(int id);
    void modifier1(T entity,int id) ;
    List<T> afficher();
    
}
