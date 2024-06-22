package poo;

import java.util.List;
import java.util.Scanner;
import poo.dao.VeiculoDAO;
import poo.model.Veiculo;
import poo.model.Carro;
import poo.model.Moto;
import poo.model.Aviao;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VeiculoDAO veiculoDAO = new VeiculoDAO();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Veiculo");
            System.out.println("2. Consultar Veiculo");
            System.out.println("3. Atualizar Veiculo");
            System.out.println("4. Excluir Veiculo");
            System.out.println("5. Listar Todos os Veiculos");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarVeiculo(scanner, veiculoDAO);
                    break;
                case 2:
                    consultarVeiculo(scanner, veiculoDAO);
                    break;
                case 3:
                    atualizarVeiculo(scanner, veiculoDAO);
                    break;
                case 4:
                    excluirVeiculo(scanner, veiculoDAO);
                    break;
                case 5:
                    listarTodosVeiculos(veiculoDAO);
                    break;
                case 6:
                    veiculoDAO.close();
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarVeiculo(Scanner scanner, VeiculoDAO veiculoDAO) {
        System.out.println("Escolha o tipo de veiculo:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.println("3. Aviao");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o ID:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Digite a marca:");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo:");
        String modelo = scanner.nextLine();
        System.out.println("Digite o ano:");
        int ano = scanner.nextInt();
        scanner.nextLine(); 

        Veiculo novoVeiculo = null;
        switch (tipo) {
            case 1:
                System.out.println("Digite o número de portas:");
                int portas = scanner.nextInt();
                scanner.nextLine();
                novoVeiculo = new Carro(id, marca, modelo, ano, portas);
                break;
            case 2:
                System.out.println("Digite as cilindradas:");
                int cilindradas = scanner.nextInt();
                scanner.nextLine();
                novoVeiculo = new Moto(id, marca, modelo, ano, cilindradas);
                break;
            case 3:
                System.out.println("Digite o número de turbinas:");
                int turbinas = scanner.nextInt();
                scanner.nextLine();
                novoVeiculo = new Aviao(id, marca, modelo, ano, turbinas);
                break;
            default:
                System.out.println("Tipo de veiculo inválido.");
                return;
        }

        veiculoDAO.cadastrarVeiculo(novoVeiculo);
        System.out.println("Veiculo cadastrado com sucesso!");
        listarTodosVeiculos(veiculoDAO);
    }

    private static void consultarVeiculo(Scanner scanner, VeiculoDAO veiculoDAO) {
        System.out.println("Digite o ID do veiculo:");
        Long idConsulta = scanner.nextLong();
        scanner.nextLine();
        Veiculo veiculoConsulta = veiculoDAO.getVeiculoById(idConsulta);
        if (veiculoConsulta != null) {
            System.out.println(veiculoConsulta);
        } else {
            System.out.println("Veiculo não encontrado.");
        }
    }

    private static void atualizarVeiculo(Scanner scanner, VeiculoDAO veiculoDAO) {
        System.out.println("Digite o ID do veiculo:");
        Long idAtualiza = scanner.nextLong();
        scanner.nextLine(); 
        Veiculo veiculoAtualiza = veiculoDAO.getVeiculoById(idAtualiza);
        if (veiculoAtualiza != null) {
            System.out.println("Digite a nova marca:");
            veiculoAtualiza.setMarca(scanner.nextLine());
            System.out.println("Digite o novo modelo:");
            veiculoAtualiza.setModelo(scanner.nextLine());
            System.out.println("Digite o novo ano:");
            veiculoAtualiza.setAno(scanner.nextInt());
            scanner.nextLine();
            veiculoDAO.atualizarVeiculo(veiculoAtualiza);
            System.out.println("Veiculo atualizado com sucesso!");
            listarTodosVeiculos(veiculoDAO);
        } else {
            System.out.println("Veiculo não encontrado.");
        }
    }

    private static void excluirVeiculo(Scanner scanner, VeiculoDAO veiculoDAO) {
        System.out.println("Digite o ID do veiculo:");
        Long idExclui = scanner.nextLong();
        scanner.nextLine();
        Veiculo veiculoExclui = veiculoDAO.getVeiculoById(idExclui);
        if (veiculoExclui != null) {
            veiculoDAO.deletarVeiculo(veiculoExclui);
            System.out.println("Veiculo excluído com sucesso!");
            listarTodosVeiculos(veiculoDAO);
        } else {
            System.out.println("Veiculo não encontrado.");
        }
    }

    private static void listarTodosVeiculos(VeiculoDAO veiculoDAO) {
        List<Veiculo> veiculos = veiculoDAO.listarVeiculos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo encontrado.");
        } else {
            System.out.println("Lista de Veiculos:");
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo);
            }
        }
    }
}
