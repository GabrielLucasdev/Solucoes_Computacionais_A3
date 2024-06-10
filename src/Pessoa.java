package com.mycompany.clinica;

public class Pessoa {
    
    // Atributos da classe Pessoa
    private String nome;
    private long cpf;
    private String endereco;
    private long telefone;

    // Construtor da classe Pessoa
    public Pessoa(String nome, long cpf, String endereco, long telefone) {
        // Inicialização dos atributos da classe Pessoa
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Métodos getter para obter os valores dos atributos da classe Pessoa
    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public long getTelefone() {
        return telefone;
    }

    // Sobrescrita do método toString para retornar os dados da Pessoa
    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nEndereço: " + endereco + "\nTelefone: " + telefone;
    }
}
