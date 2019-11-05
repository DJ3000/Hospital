package controle;

import dao.DAO;
import dao.DAOCliente;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Clientes;

@ManagedBean
@ViewScoped
public class ClientesControle implements Serializable {

    private Clientes cliente;
    private DAO<Clientes> dao;
    private List<Clientes> lista;
    private boolean popupNovo;
    private boolean popupAltera;
    

    public ClientesControle() {
        cliente = new Clientes();
        dao = new DAO(Clientes.class);
        lista = dao.listarTodos();
        popupNovo = false;    // fica oculto
        popupAltera = false;  // fica oculto
    }

    public void abrePopupNovo() {
        this.popupNovo = true;
    }

    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }

     
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        // só pode inserir se não existir o login
        boolean jaExiste = true;
        try {
            Clientes temp = new DAOCliente().buscaPorId(cliente.getId());
        } catch (ExcecaoObjetoNaoEncontrado e) {
            jaExiste = false;
        }
        if (!jaExiste) {
            dao.inserir(cliente);
            lista = dao.listarTodos();
            cliente = new Clientes();  // apenas para limpar os campos
            fecharPopupNovo();
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este ID", null));
        }

    }

    
    public void alterarClientes() {
        dao.alterar(cliente);
        lista = dao.listarTodos(); // atualiza a lista
        cliente = new Clientes(); 
        fecharPopupAltera();
    }
    
    public void excluir(Clientes cliente){
        dao.excluir(cliente.getId());
        lista.remove(cliente);
    }
       
    public Clientes getCliente() {
       
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public DAO<Clientes> getDao() {
        return dao;
    }

    public void setDao(DAO<Clientes> dao) {
        this.dao = dao;
    }

    public List<Clientes> getLista() {
        return lista;
    }

    public void setLista(List<Clientes> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }

}