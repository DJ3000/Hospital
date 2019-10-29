package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (length = 30)
    private String tipo;
    @Column (length = 30)
    private String marca;
    @Column (length = 10)
    private Double custo;
    @Column (length = 10)
    private Integer qtd;

    public Material() {
        id = 0;
        tipo = "";
        marca = "";
        custo = 0.0;
        qtd = 0;
    }
    
    public Material(Integer id, String tipo, String marca, Double custo, Integer qtd) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.custo = custo;
        this.qtd = qtd;
    }
    
//gets and seters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.getId());
        hash = 41 * hash + Objects.hashCode(this.getTipo());
        hash = 41 * hash + Objects.hashCode(this.getMarca());
        hash = 41 * hash + Objects.hashCode(this.getCusto());
        hash = 41 * hash + Objects.hashCode(this.getQtd());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Material other = (Material) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.custo, other.custo)) {
            return false;
        }
        if (!Objects.equals(this.qtd, other.qtd)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + getId() + ", tipo=" + getTipo() + ", marca=" + getMarca() + ", custo=" + getCusto() + ", qtd=" + getQtd() + '}';
    }
}
