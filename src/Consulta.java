package com.mycompany.clinica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Consulta {
    
    // Atributos da classe Consulta
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;

    // Construtor da classe Consulta
    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        // Inicialização dos atributos da classe Consulta
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    // Métodos getter para obter os valores dos atributos da classe Consulta
    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    // Sobrescrita do método toString para retornar os dados da Consulta
    @Override
    public String toString() {
        // Formatação da data e hora usando DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Retorna uma string com os dados da consulta formatados
        return "Paciente: " + paciente.getNome() + ", CPF: " + paciente.getCpf() + " - Médico: " + medico.getNome()
                + ", Especialidade: " + medico.getEspecialidade() + " - Data e Hora: " + dataHora.format(formatter);
    }
}
