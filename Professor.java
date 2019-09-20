/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at3.parte2;

/**
 *
 * @author Jesus
 */
public class Professor extends Pessoa
{
    private String siape;
    public Professor(String nome, String idade, String cpf, String sexo)
    {
        super(nome, idade, cpf, sexo);
    }
    public Professor(String n, String i, String c, String s,String siape)
    {
        this.siape = siape;
    }
    public Professor()
    {
        
    }
    public String getSiape() 
    {
        return siape;
    }
    public void setSiape(String siape)
    {
        this.siape = siape;
    }

}