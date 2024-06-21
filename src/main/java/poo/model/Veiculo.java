package poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorColumn;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Veiculo {

    @Id
    private Long id;

    private String marca;
    private String modelo;
    private int ano;

    public Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, int ano) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public abstract void cadastrar();
    public abstract void consultar();
    public abstract void atualizar();
    public abstract void excluir();
}
