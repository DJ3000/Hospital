package controle;

import dao.DAO;
import dao.ExcecaoObjetoNaoEncontrado;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Material;

@ManagedBean
@ViewScoped
public class MaterialControle implements Serializable {

    private Material mat;
    private DAO<Material> dao;
    private List<Material> lista;
    private boolean popupNovo;
    private boolean popupAltera;

    public MaterialControle() {
        mat = new Material();
        dao = new DAO(Material.class);
        lista = dao.listarTodos();
        popupNovo = false;    // fica oculto
        popupAltera = false;  // fica oculto
    }

    public void abrePopupNovo() {
        mat = new Material();
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

    public void converter() {
        mat.setTipo(mat.getTipo().toUpperCase());
    }
    
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        converter();
        boolean jaExiste = true;
        try {
            Material temp = new DAO(Material.class).buscaPorNome(mat.getTipo());
        } catch (ExcecaoObjetoNaoEncontrado e) {
            jaExiste = false;
        }
        if (!jaExiste) {
            dao.inserir(mat);
            lista = dao.listarTodos();
            mat = new Material();  // apenas para limpar os campos
            fecharPopupNovo();
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este LOGIN", null));
        }

    }

    
    public void alterarMaterial() {
        dao.alterar(mat);
        lista = dao.listarTodos(); // atualiza a lista
        mat = new Material(); 
        fecharPopupAltera();
    }
    
    public void excluir(Material mat){
        dao.excluir(mat.getId());
        lista.remove(mat);
    }
       
    public Material getAdm() {
        return mat;
    }

    public void setAdm(Material mat) {
        this.mat = mat;
    }

    public DAO<Material> getDao() {
        return dao;
    }

    public void setDao(DAO<Material> dao) {
        this.dao = dao;
    }

    public List<Material> getLista() {
        return lista;
    }

    public void setLista(List<Material> lista) {
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

