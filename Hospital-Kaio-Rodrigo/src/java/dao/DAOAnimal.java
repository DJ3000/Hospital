package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Animal;
import util.JPAUtil;

public class DAOAnimal {
    EntityManager manager;
    
    
    /**
     * Busca um objeto animal com o login fornecido. 
     * @param id
     * @return
     * @throws ExcecaoObjetoNaoEncontrado 
     */
    public Animal buscaPorId(Integer id) throws ExcecaoObjetoNaoEncontrado{
        Animal temp = null;
        manager = JPAUtil.getEntityManager();
        String sql;
        sql = "SELECT a FROM Animal a WHERE a.id = :id";
        TypedQuery<Animal> query = manager.createQuery(sql, Animal.class);
        query.setParameter("id", id);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  
            throw new ExcecaoObjetoNaoEncontrado("Nenhum objeto com este id");
        } finally {
            manager.close();
        }
        return temp;
    }
}