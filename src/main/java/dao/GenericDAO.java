package dao;

import javax.persistence.EntityManager;

public abstract class GenericDAO {
    protected EntityManager em;

    public EntityManager getEntityMangaer() {
        return em;
    }

    public GenericDAO(EntityManager em) {
        this.em = em;
    }

//    public Object add(Object value) {
//        em.persist(value);
//        return null;
//    }
//
//    public Object update(Object value) {
//        return em.merge(value);
//    }
}
