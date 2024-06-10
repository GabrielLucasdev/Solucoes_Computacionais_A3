package com.mycompany.clinica;

// A classe Paciente herda os atributos e métodos da classe Pessoa
public class Paciente extends Pessoa {

    // Atributo específico da classe Paciente
   
    private String historicoMedico;

    // Construtor da classe Paciente
    public Paciente(String nome, long cpf, String endereco, long telefone, String historicoMedico) {
        
        super(nome, cpf, endereco, telefone); // Chamada ao construtor da classe mãe (superclasse) Pessoa
        
        // Inicialização do atributo específico da classe Paciente
        this.historicoMedico = historicoMedico;
    }

    // Método getter para obter o histórico médico do paciente
    public String getHistoricoMedico() {
        return historicoMedico;
    }

    // Sobrescrita do método toString para retornar os dados do Paciente
    @Override
    public String toString() {
        // Utiliza o método toString da classe mãe (superclasse) Pessoa
        return super.toString() + "\nHistórico Médico: " + historicoMedico;
    }
}
