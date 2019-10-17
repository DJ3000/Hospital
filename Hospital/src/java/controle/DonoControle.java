package controle;

import dao.DAO;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Dono;

@ManagedBean (name = "DonoControle")
@ViewScoped
public class DonoControle implements Serializable{
    private Dono dono;
    private DAO<Dono> dao;
    private List<Dono> lista;
    private boolean popupNovo;
    private boolean popupAltera;
    
    public DonoControle(){
        dono = new Dono();
        dao = new DAO(Dono.class);
        lista = dao.listarTodos();
        popupNovo = false;
        popupAltera = false;
    }
    
    public void salvar(){
        getDao().inserir(getDono());
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage
          (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Dono cadastrado", null));
    }
//abertura dos popups de novo e de alteracoes
    public void abrePopupNovo() {
        setDono(new Dono());
        this.setPopupNovo(true);
    }

    public void fecharPopupNovo() {
        this.setPopupNovo(false);
    }
    
    public void abrePopupAltera(){        
        this.setPopupAltera(true);
    }
    
    public void fecharPopupAltera(){
        this.setPopupAltera(false);
    }
    
    public void converter() {
        dono.setNome(dono.getNome().toUpperCase());
    }
    
    public void alterar(){
        abrePopupAltera();
    }
    
    public void alterarDono() {
        getDao().alterar(getDono());
        setLista(getDao().listarTodos()); // atualiza a lista
        setDono(new Dono()); 
        fecharPopupAltera();
    }
    
    public void excluir(Dono dono){
        getDao().excluir(dono.getId());
        getLista().remove(dono);
    }
    
    public void inserir() {
        // só pode inserir se não existir o login
        converter();
        boolean jaExiste = true;
        try {
            Dono temp = (Dono) new  DAO(Dono.class).buscarPorNome(dono.getNome());
        } catch (ExcecaoObjetoNaoEncontrado e){
            jaExiste = false;
        }
        if (!jaExiste) {
            dao.inserir(dono);
            lista = dao.listarTodos();
            dono = new Dono();  // apenas para limpar os campos
            fecharPopupNovo();
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este NOME", null));
        }

    }
    
//gets and seters
    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public DAO<Dono> getDao() {
        return dao;
    }

    public void setDao(DAO<Dono> dao) {
        this.dao = dao;
    }

    public List<Dono> getLista() {
        return lista;
    }

    public void setLista(List<Dono> lista) {
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
