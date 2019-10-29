package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicamento implements Serializable {
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
    @Column (length = 30)
    private String nome;
    
    public Medicamento() {
        id = 0;
        tipo = "";
        marca = "";
        custo = 0.0;
        qtd = 0;
        nome = "";
    }

    public Medicamento(Integer id, String tipo, String marca, Double custo, Integer qtd, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.custo = custo;
        this.qtd = qtd;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + Objects.hashCode(this.marca);
        hash = 61 * hash + Objects.hashCode(this.custo);
        hash = 61 * hash + Objects.hashCode(this.qtd);
        hash = 61 * hash + Objects.hashCode(this.nome);
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
        final Medicamento other = (Medicamento) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
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
        return "Medicamento{" + "id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", custo=" + custo + ", qtd=" + qtd + ", nome=" + nome + '}';
    }
}
