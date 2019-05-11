/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import redsocial.entity.Usuario;

/**
 *
 * @author rafa
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario findByEmail(String email){
        Query q = getEntityManager().createNativeQuery("SELECT * FROM Usuario WHERE email='" + email + "'", Usuario.class);
        return (Usuario) q.getResultList().get(0);
    }
    
    public List<Integer> findAmigosByID(Integer id) {
        
        Query q = this.getEntityManager().createNativeQuery("SELECT Usuario2 FROM amigos_confirmados WHERE Usuario1 =" + id);
        return (List<Integer>) q.getResultList();
    }
    
    public List<String> findUsuario(String nombre){

        Query q;
        //al ser el nick primary key, tomaremos que solo puede devolver un unico usuario o ninguno si no existe
        q = this.getEntityManager().createNativeQuery("select email from Usuario where nick = '" + nombre + "'" );
        
        return q.getResultList();
    }
    
    
    
}
