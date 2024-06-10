package com.mycompany.clinica;
//import java.util.Scanner;

// A classe Medico herda os atributos e métodos da classe Pessoa
public class Medico extends Pessoa {

    // Atributos específicos da classe Medico
    private String especialidade;
    private int crm;

    // Construtor da classe Medico
    public Medico(String nome, long cpf, String endereco, long telefone, String especialidade, int crm) {
        
        super(nome, cpf, endereco, telefone); // Chamada o construtor da classe mãe (superclasse) Pessoa
        
        // Inicialização dos atributos específicos da classe Medico
        this.especialidade = especialidade;
        this.crm = crm;
    }

    // Método getter para obter a especialidade do médico
    public String getEspecialidade() {
        return especialidade;
    }

    // Método getter para obter o CRM do médico
    public int getCrm() {
        return crm;
    }

    // Sobrescrita do método toString para retornar os dados do Médico
    @Override
    public String toString() {
        // Utiliza o método toString da classe mãe (superclasse) Pessoa
        return super.toString() + "\nEspecialidade: " + especialidade + ", CRM: " + crm;
    }
}
