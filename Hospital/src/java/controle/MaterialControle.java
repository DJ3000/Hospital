package controle;

import dao.DAO;
import dao.ExcecaoObjetoMenorEstoque;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Material;

@ManagedBean (name = "MaterialControle")
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

//abertura dos popups de novo e de alteracoes
    public void abrePopupNovo() {
        setMat(new Material());
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
        getMat().setTipo(getMat().getTipo().toUpperCase());
    }
    
    public void alterar(){
        abrePopupAltera();
    }
    
    public void inserir() {
        converter();
        boolean jaExiste = true;
        try {
            Material temp = (Material) new DAO(Material.class).buscarPorNome(getMat().getTipo());
        } catch (ExcecaoObjetoNaoEncontrado e) {
            jaExiste = false;
        }
        if (!jaExiste) {
            getDao().inserir(getMat());
            setLista(getDao().listarTodos());
            setMat(new Material());  // apenas para limpar os campos
            fecharPopupNovo();
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este LOGIN", null));
        }
    }
    
    public void alterarMaterial() {
        getDao().alterar(getMat());
        setLista(getDao().listarTodos()); // atualiza a lista
        setMat(new Material()); 
        fecharPopupAltera();
    }
    
    public void excluir(Material mat){
        getDao().excluir(mat.getId());
        getLista().remove(mat);
    }
    
    public void adicionarUm(Material mat){
        mat.adicionarUm();
        getDao().alterar(mat);
    }
    
    public void removerUm(Material mat){   
        if (mat.getQtd() != 0)
        {
            mat.removerUm();
            getDao().alterar(mat);
        }
        else
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este LOGIN", null));
        }       
    }
    
    public void adicionar(Material mat){
        mat.adicionar();
        getDao().alterar(mat);
    }
    
    public void remover(Material mat){   
        if (mat.getQtd() != 0)
        {
            mat.remover();
            getDao().alterar(mat);
        }
        else
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este LOGIN", null));
        }       
    }
    
       
//getters and setters
    public Material getMat() {
        return mat;
    }

    public void setMat(Material mat) {
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

