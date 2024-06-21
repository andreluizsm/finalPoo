package poo.model;

import javax.persistence.Entity;

@Entity
public class Aviao extends Veiculo {

    private int turbinas;

    public Aviao() {
    }

    public Aviao(Long id, String marca, String modelo, int ano, int turbinas) {
        super(id, marca, modelo, ano);
        this.turbinas = turbinas;
    }

    public int getTurbinas() {
        return turbinas;
    }

    public void setTurbinas(int turbinas) {
        this.turbinas = turbinas;
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
        return "Aviao{" +
                "id=" + getId() +
                ", marca='" + getMarca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", ano=" + getAno() +
                ", turbinas=" + turbinas +
                '}';
    }
}
