package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Clientes;
import util.JPAUtil;

public class DAOCliente {
    EntityManager manager;
    
    
    /**
     * Busca um objeto cliente com o login fornecido. 
     * @param id
     * @return
     * @throws ExcecaoObjetoNaoEncontrado 
     */
    public Clientes buscaPorId(Integer id) throws ExcecaoObjetoNaoEncontrado{
        Clientes temp = null;
        manager = JPAUtil.getEntityManager();
        String sql;
        sql = "SELECT a FROM Clientes a WHERE a.id = :id";
        TypedQuery<Clientes> query = manager.createQuery(sql, Clientes.class);
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