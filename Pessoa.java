/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade2;

/**
 *
 * @author Jesus
 */
public abstract class Pessoa
{
    private String nome;
    private String idade;
    private String cpf;
    private String sexo;

    public Pessoa()
    {
        
    }
    public Pessoa(String nome, String idade, String cpf, String sexo)
    {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.sexo = sexo;
    }
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getIdade()
    {
        return idade;
    }
    public void setIdade(String idade)
    {
        this.idade = idade;
    }
    public String getCpf()
    {
        return cpf;
    }
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }
    public String getSexo() 
    {
        return sexo;
    }
    public void setSexo(String sexo) 
    {
        this.sexo = sexo;
    }

}
