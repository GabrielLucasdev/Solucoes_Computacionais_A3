public class Pessoa {

    private String crm;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private int id;

    public Pessoa(int id, String nome, String cpf, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Pessoa(int id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        endereco = "ENDEREÇO NÃO INFORMADO.";
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public int setId() {
        return id;
    }

    public String setNome() {
        return nome;
    }

    public String setCpf() {
        return cpf;
    }

    public String setTelefone() {
        return telefone;
    }

    public String setEndereco() {
        return endereco;

    }

}

