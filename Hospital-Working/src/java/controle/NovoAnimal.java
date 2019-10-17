package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;
import modelo.Dono;

@ManagedBean (name = "novoAnimal")
@ViewScoped
public class NovoAnimal implements Serializable{
    private Animal animal;
    private DAO<Animal> dao;
    private List<Dono> donos;
    private Dono donoSelecionado;
    private DAO<Dono> daodono;
    
    public NovoAnimal(){
        animal = new Animal();
        dao = new DAO(Animal.class);
        daodono = new DAO(Dono.class);
        donos = daodono.listarTodos();
    }
    
    public void salvar(){
        animal.setDono(donoSelecionado);
        dao.inserir(animal);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage
          (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Animal cadastrado", null));
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

    public List<Dono> getDonos() {
        return donos;
    }

    public void setDonos(List<Dono> donos) {
        this.donos = donos;
    }

    public Dono getDonoSelecionado() {
        return donoSelecionado;
    }

    public void setDonoSelecionado(Dono donoSelecionado) {
        this.donoSelecionado = donoSelecionado;
    }

    public DAO<Dono> getDaodono() {
        return daodono;
    }

    public void setDaodono(DAO<Dono> daodono) {
        this.daodono = daodono;
    }
}
