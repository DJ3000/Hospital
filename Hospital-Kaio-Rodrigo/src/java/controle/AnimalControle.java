package controle;

import dao.DAO;
import dao.DAOAnimal;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;

@ManagedBean
@ViewScoped
public class AnimalControle implements Serializable {

    private Animal animal;
    private DAO<Animal> dao;
    private List<Animal> lista;
    private boolean popupNovo;
    private boolean popupAltera;
    

    public AnimalControle() {
        animal = new Animal();
        dao = new DAO(Animal.class);
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
            Animal temp = new DAOAnimal().buscaPorId(animal.getId());
        } catch (ExcecaoObjetoNaoEncontrado e) {
            jaExiste = false;
        }
        if (!jaExiste) {
            dao.inserir(animal);
            lista = dao.listarTodos();
            animal = new Animal();  // apenas para limpar os campos
            fecharPopupNovo();
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este ID", null));
        }

    }

    
    public void alterarAnimal() {
        dao.alterar(animal);
        lista = dao.listarTodos(); // atualiza a lista
        animal = new Animal(); 
        fecharPopupAltera();
    }
    
    public void excluir(Animal animal){
        dao.excluir(animal.getId());
        lista.remove(animal);
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    public List<Animal> getLista() {
        return lista;
    }

    public void setLista(List<Animal> lista) {
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