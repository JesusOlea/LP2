/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at3.parte2;

import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Jesus
 */
public class Exibir 
{    
    public void professor(Professor p )
    {
        p.setNome(JOptionPane.showInputDialog("Entre com o nome: \n"));
        p.setIdade(JOptionPane.showInputDialog("Entre com a idade: "));
        p.setCpf(JOptionPane.showInputDialog("Entre com o CPF: "));
        p.setSiape(JOptionPane.showInputDialog("Entre com o SIAPE: "));
        p.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
    }
    public void aluno(Aluno a) throws SQLException
    {
        a.setNome(JOptionPane.showInputDialog("Entre com o nome: "));
        a.setIdade(JOptionPane.showInputDialog("Entre com a idade: "));
        a.setCpf(JOptionPane.showInputDialog("Entre com o CPF: "));
        a.setRa(JOptionPane.showInputDialog("Entre com a RA: "));
        a.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
    }    
    public String nome()
    {
        String nome = JOptionPane.showInputDialog("Digite o nome: ");
        return nome;
    }
    public int op()
    {
        int op = Integer.parseInt(JOptionPane.showInputDialog("1 - Professor\n 2 - Aluno"));
        return op;
    }
    public String Cpf()
    {
        String excluir = JOptionPane.showInputDialog("Digite o CPF: ");
        return excluir;
    }
}