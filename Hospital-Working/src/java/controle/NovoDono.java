package controle;

import dao.DAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Dono;

@ManagedBean (name = "novoDono")
@ViewScoped
public class NovoDono implements Serializable{
    private Dono dono;
    private DAO<Dono> dao; 
    
    public NovoDono(){
        dono = new Dono();
        dao = new DAO(Dono.class);
    }
    
    public void salvar(){
        dao.inserir(dono);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage
          (null, new FacesMessage(FacesMessage.SEVERITY_INFO,
          "Dono cadastrado", null));
    }
    

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
}