package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "TB_Cliente")
public class Cliente implements Persistente{
   
    @Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
	@SequenceGenerator(name="cliente_seq", sequenceName="sq_cliente", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "Nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11)
    private long cpf;

    @Column(name = "Endereço", nullable = false, length = 50)
    private String endereco;

    @Column(name = "Numero", nullable = false, length = 5)
    private Long numero;

    @Column(name = "Telefone", nullable = false, length = 9)
    private Long telefone;

    @Column(name = "DDD", nullable = false, length = 2)
    private int ddd;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long tel) {
        this.telefone = tel;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    
    
}
