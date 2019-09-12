/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade2;

import javax.swing.JOptionPane;


/**
 *
 * @author Jesus
 */
public class Exibir 
{    
    public void aluno(DAO d)
    {
        Aluno aluno = new Aluno();
        aluno.setNome(JOptionPane.showInputDialog("Entre com o nome: "));
        aluno.setIdade(JOptionPane.showInputDialog("Entre com a idade: "));
        aluno.setCpf(JOptionPane.showInputDialog("Entre com o CPF: "));
        aluno.setRa("123");//(JOptionPane.showInputDialog("Entre com a RA: "));
        aluno.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
        JOptionPane.showMessageDialog(null,"Aluno salvo com Sucesso! ");
        
        d.salvarNoBD();
    }
    public void professor(DAO d)
    {
        Professor professor = new Professor();
        professor.setNome(JOptionPane.showInputDialog("Entre com o nome: "));
        professor.setIdade(JOptionPane.showInputDialog("Entre com a idade: "));
        professor.setCpf(JOptionPane.showInputDialog("Entre com o CPF: "));
        professor.setSiape("123");//(JOptionPane.showInputDialog("Entre com o SIAPE: "));
        professor.setSexo(JOptionPane.showInputDialog("Entre com o sexo: "));
        JOptionPane.showMessageDialog(null, "Professor salvo com Sucesso! "); 
        
        d.salvar(professor);
    }
   
}
