/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atividade2;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class DAO 
{
    LinkedList<Pessoa> listaDePessoa = new LinkedList<>();
    
    public void salvar (Aluno aluno)
    {
        listaDePessoa.add(aluno);
    }
    public void salvar (Professor professor)
    { 
        listaDePessoa.add(professor);
    }
    public void buscarA()
    {
       String info, total = "", b = "############################\n";
       int vazio = 0;
       for(int i=0; i < listaDePessoa.size(); i++)
       {
            if(listaDePessoa.get(i) instanceof Aluno)
            {
                Aluno aluno = (Aluno) listaDePessoa.get(i);
                info = "\tAluno\n" +
                "Nome: " + aluno.getNome() + "\n" +
                "Idade: " + aluno.getIdade() + "\n" +
                "CPF: " + aluno.getCpf() + "\n" +
                "RA: " + aluno.getRa() + "\n" +
                "Sexo: " + aluno.getSexo() + "\n";
           
                total = total + b + info;
                vazio++;
            }   
       }
       if(vazio == 0)
       {
            JOptionPane.showMessageDialog(null, "A lista esta vazia");
       }
       else
       {
            JOptionPane.showMessageDialog(null, total);
       }
    }
    public void buscarP ()
    {
       String info, total = "", b = "############################\n";
       int vazio = 0;
       for(int i=0; i < listaDePessoa.size(); i++)
       {
           if(listaDePessoa.get(i) instanceof Professor)
           {
           Professor professor = (Professor) listaDePessoa.get(i);
           info = "\tProfesor\n" +
           "Nome: " + professor.getNome() + "\n" +
           "Idade: " + professor.getIdade() + "\n" +
           "CPF: " + professor.getCpf() + "\n" +
           "SIAPE: " + professor.getSiape() + "\n" +
           "Sexo: " + professor.getSexo() + "\n";
           
           total = total + b + info;
           vazio++;
           }
       }
       if(vazio == 0 )
       {
            JOptionPane.showMessageDialog(null, "A lista esta vazia");
       }
       else
       {
            JOptionPane.showMessageDialog(null, total);
       }
    }

    public void excluirA (String cpf)
    {
        boolean c = false;
        for (int i = 0; i < listaDePessoa.size(); i ++)
        {
            if (listaDePessoa.get(i).getCpf().compareTo(cpf) == 0)
            {
                listaDePessoa.remove(i);
                c = true; 
            }
        }
        if (c==true)
        {
            JOptionPane.showMessageDialog(null, "Pessoa exluida com suesso!!");
        }
            else
                JOptionPane.showMessageDialog(null, "Essa Pessoa não está na lista!!");
                
    }
    public void gravar()
    {
        try 
        {
            FileWriter fw = new FileWriter("Pessoas.txt");
            PrintWriter pw = new PrintWriter (fw);
            for(int i = 0; i < listaDePessoa.size(); i++)
            {
                if(listaDePessoa.get(i) instanceof Professor)
                {
                    Professor p = (Professor) listaDePessoa.get(i);
                    pw.println("Professor" + "-" + p.getNome() + "-" + p.getIdade() + "-" +
                                p.getCpf() + "-" + p.getSexo() + "-" + p.getSiape());
                }
                else if(listaDePessoa.get(i) instanceof Aluno)
                {
                    Aluno a = (Aluno) listaDePessoa.get(i);
                    pw.println("Aluno" + "-" + a.getNome() + "-" + a.getIdade() + "-" +
                                a.getCpf() + "-" + a.getSexo() + "-" + a.getRa());
                }
            }
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Pessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ler()
    {
        try 
        {
            FileReader arquivo = new FileReader("Pessoas.txt");
            BufferedReader ler = new BufferedReader(arquivo);

            String linha = ler.readLine();
            while(linha != null) 
            { 
                String pessoa[] = linha.split("-");
                if(pessoa[0].compareTo("Professor") == 0)
                {
                    Professor pro = new Professor();
                    pro.setNome(pessoa[1]);
                    pro.setIdade(pessoa[2]);
                    pro.setCpf(pessoa[3]);
                    pro.setSexo(pessoa[4]);
                    pro.setSiape(pessoa[5]);
                    listaDePessoa.add(pro);
                }
                else if(pessoa[0].compareTo("Aluno") == 0)
                {
                    Aluno a = new Aluno();
                    a.setNome(pessoa[1]);
                    a.setIdade(pessoa[2]);
                    a.setCpf(pessoa[3]);
                    a.setSexo(pessoa[4]);
                    a.setRa(pessoa[5]);
                    listaDePessoa.add(a);
                }
                linha = ler.readLine();
            }
            ler.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void salvarNoBD( )
    {
        try {
            DriverManager.getConnection("jdbc:mysql://localhost/mysql", "", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
                    
        }
    }
}

