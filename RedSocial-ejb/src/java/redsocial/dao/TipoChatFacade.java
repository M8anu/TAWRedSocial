/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redsocial.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import redsocial.entity.TipoChat;

/**
 *
 * @author rafa
 */
@Stateless
public class TipoChatFacade extends AbstractFacade<TipoChat> {

    @PersistenceContext(unitName = "RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoChatFacade() {
        super(TipoChat.class);
    }
    
}
