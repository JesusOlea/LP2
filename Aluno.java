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

public class Aluno extends Pessoa

{
    private String ra;

    public Aluno(String nome, String idade, String cpf, String sexo)
    {
        super(nome, idade, cpf, sexo);
    }
    public Aluno(String n, String i, String c, String s,String ra)
    {
        this.ra = ra;
    }
    public Aluno ()
    {
        
    }
    public String getRa() 
    {
        return ra;
    }
    public void setRa(String ra) 
    {
        this.ra = ra;
    }
    
}
