/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.clinica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ana Clara
 */
public class Clinica {

    public static void main(String[] args) {

        // Inicialização das listas e do Scanner
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Criando e adicionando um objeto Médico e Paciente ao iniciar o programa dentro do ArrayList
        Medico medicoInicial1 = new Medico("Carlos Azevedo", 3L, "Rua Euclides, 25, Laguna", 31988887777L, "Cardiologia", 1234);
        medicos.add(medicoInicial1);
        Medico medicoInicial2 = new Medico("Ana Moreira", 4L, "Rua Fabricio, 101, Esmeralda", 31988887777L, "Oncologia", 4567);
        medicos.add(medicoInicial2);
        
        Paciente pacienteInicial1 = new Paciente("Maria Joaquina", 1L, "Rua Fagundes, 11, Ribeirão", 31988887777L, "Paciente teve câncer em 2021");
        pacientes.add(pacienteInicial1);
        Paciente pacienteInicial2 = new Paciente("José da Silva", 2L, "Rua Gino, 98, Pontal", 31988887777L, "Paciente fez cirurgia de coração em 2019");
        pacientes.add(pacienteInicial2);

        System.out.println("---------------------------------------------------");
        System.out.print("Seja bem vindo ao sistema de agendamento de consultas!");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner, pacientes); // Chama o método cadastrar paciente
                    break;
                case 2:
                    cadastrarMedico(scanner, medicos); // Chama o método cadastrar médico
                    break;
                case 3:
                    consultarPaciente(scanner, pacientes); // Chama o método consultar paciente
                    break;
                case 4:
                    consultarMedico(scanner, medicos); // Chama o método consultar médico
                    break;
                case 5:
                    agendarConsulta(scanner, pacientes, medicos, consultas); // Chama o método agendar consulta
                    break;
                case 6:
                    consultarConsultas(consultas); // Chama o método consultar consulta
                    break;
                case 0:
                    System.out.println("\nSaindo...");
                    System.out.println("Sistema encerrado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Método para exibir o menu principal
    private static void exibirMenu() {
        System.out.println("\n------- Menu -------");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Cadastrar Médico");
        System.out.println("3. Consultar Paciente");
        System.out.println("4. Consultar Médico");
        System.out.println("5. Agendar Consulta");
        System.out.println("6. Consultar Consultas");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Método para cadastrar um novo paciente
    private static void cadastrarPaciente(Scanner scanner, ArrayList<Paciente> pacientes) {
        System.out.println("\nPor favor, insira os dados do paciente:");
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do paciente: ");
        long cpf = scanner.nextLong();
        System.out.print("Endereço do paciente: ");
        scanner.nextLine();  // Consumir a nova linha 
        String endereco = scanner.nextLine();
        System.out.print("Telefone do paciente: ");
        int telefone = scanner.nextInt();
        System.out.print("Histórico médico do paciente: ");
        scanner.nextLine();  // Consumir a nova linha
        String historicoMedico = scanner.nextLine();

        // Criação do objeto Paciente
        Paciente paciente = new Paciente(nome, cpf, endereco, telefone, historicoMedico);
        pacientes.add(paciente); // Adiciona o paciente à lista de pacientes
        System.out.println("Paciente cadastrado com sucesso!");
    }

    // Método para cadastrar um novo médico
    private static void cadastrarMedico(Scanner scanner, ArrayList<Medico> medicos) {
        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do médico: ");
        long cpf = scanner.nextLong();
        System.out.print("Endereço do médico: ");
        scanner.nextLine();  // Consumir a nova linha
        String endereco = scanner.nextLine();
        System.out.print("Telefone do médico: ");
        int telefone = scanner.nextInt();
        System.out.print("Especialidade do médico: ");
        scanner.nextLine();  // Consumir a nova linha
        String especialidade = scanner.nextLine();
        System.out.print("CRM do médico: ");
        int crm = scanner.nextInt();

        // Criação do objeto Medico
        Medico medico = new Medico(nome, cpf, endereco, telefone, especialidade, crm);
        medicos.add(medico); // Adiciona o medico à lista de medicos
        System.out.println("Médico cadastrado com sucesso!");
    }

    // Método para consultar um paciente por CPF
    private static void consultarPaciente(Scanner scanner, ArrayList<Paciente> pacientes) { // recebe o valor que o usuário digitou e a lista de pacientes
        System.out.print("Digite o CPF do paciente: ");
        long cpf = scanner.nextLong();
        System.out.println("\n----- Paciente cadastrado -----");
        for (Paciente paciente : pacientes) { // percorre a lista de pacientes 
            if (paciente.getCpf() == cpf) { // verificar se o cpf que o usuário informou existe na lista de pacientes cadastrados
                System.out.println(paciente); // exibe o paciente pesquisado
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }

    // Método para consultar médicos cadastrados
    private static void consultarMedico(Scanner scanner, ArrayList<Medico> medicos) { // recebe o valor que o usuário digitou e a lista de medicos
        // Verifica se há médicos cadastrados
        if (medicos.isEmpty()) { 
            System.out.println("Nenhum médico cadastrado.");
            return;
        }
        System.out.println("\n----- Médicos cadastrados ----- ");
        for (int i = 0; i < medicos.size(); i++) { // percorre toda a lista de médicos cadastrados e exibe no console
            System.out.println((i + 1) + ". " + medicos.get(i).getNome() + ", CPF: " + medicos.get(i).getCpf() + ", CRM: " + medicos.get(i).getCrm() + ", Especialidade: " + medicos.get(i).getEspecialidade());
        }
    }
     
    // Método para agendar uma nova consulta
    private static void agendarConsulta(Scanner scanner, ArrayList<Paciente> pacientes, ArrayList<Medico> medicos, ArrayList<Consulta> consultas) { 
        
        System.out.println("\n---- Cadastro de consultas ----");
        // solicita o CPF do paciente e faz a leitura do valor
        System.out.print("Digite o CPF do paciente: ");
        long cpfPaciente = scanner.nextLong();
        scanner.nextLine();  // Consumir a nova linha
        
        // Busca pelo paciente na lista de pacientes
        Paciente paciente = null;
        for (Paciente p : pacientes) {
            if (p.getCpf() == cpfPaciente) { // verificar se o cpf que o usuário informou existe na lista de pacientes cadastrados
                paciente = p;
                break;
            }
        }
        // Verifica se o paciente foi encontrado
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        // Solicita o CPF do médico e faz a leitura do valor
        System.out.print("Digite o CPF do médico: ");
        long cpfMedico = scanner.nextLong();
        scanner.nextLine();  // Consumir a nova linha
        
        // Busca pelo médico na lista de médicos
        Medico medico = null;
        for (Medico m : medicos) {
            if (m.getCpf() == cpfMedico) {
                medico = m;
                break;
            }
        }
        // Verificação se o médico foi encontrado
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        // Solicita que o usuário informe a data e hora da consulta e realize a leitura do valor
        System.out.print("Digite a data da consulta (formato: dd/MM/AAAA): ");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // conversão

        System.out.print("Digite a hora da consulta (formato: HH:mm): ");
        String horaString = scanner.nextLine();
        LocalTime hora = LocalTime.parse(horaString, DateTimeFormatter.ofPattern("HH:mm")); // conversão

        // Criação do objeto LocalDateTime para representar a data e hora da consulta
        LocalDateTime dataHora = LocalDateTime.of(data, hora);

        // Criação do objeto Consulta
        Consulta consulta = new Consulta(paciente, medico, dataHora);
        consultas.add(consulta); // adiciona a lista de consultas cadastradas
        System.out.println("Consulta agendada com sucesso!");
    }

    // Método para consultar as consultas agendadas 
    private static void consultarConsultas(ArrayList<Consulta> consultas) { // recebe um arraylist de consultas ja existentes
        System.out.println("\n----- Detalhes das consultas agendadas -----");
        
        
        // Verifica se possui consultas cadastradas
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        
        // Exibe as consultas cadastradas
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }
}
