package poo.model;

import javax.persistence.Entity;

@Entity
public class Carro extends Veiculo {

    private int portas;

    public Carro() {
    }

    public Carro(Long id, String marca, String modelo, int ano, int portas) {
        super(id, marca, modelo, ano);
        this.portas = portas;
    }

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    @Override
    public void cadastrar() {
        // Implementar lógica de cadastro
    }

    @Override
    public void consultar() {
        // Implementar lógica de consulta
    }

    @Override
    public void atualizar() {
        // Implementar lógica de atualização
    }

    @Override
    public void excluir() {
        // Implementar lógica de exclusão
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + getId() +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", portas=" + portas +
                '}';
    }
}
