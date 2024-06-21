package poo.model;

import javax.persistence.Entity;

@Entity
public class Moto extends Veiculo {

    private int cilindradas;

    public Moto() {
    }

    public Moto(Long id, String marca, String modelo, int ano, int cilindradas) {
        super(id, marca, modelo, ano);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
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
        return "Moto{" +
                "id=" + getId() +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", cilindradas=" + cilindradas +
                '}';
    }
}
