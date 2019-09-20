
package at3.parte2;

import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Jesus
 */
public class DAO 
{
    LinkedList<Pessoa> salvarNoBD = new LinkedList<>();
    Exibir leitura = new Exibir();
    
    public void gravarPessoa(int Gravar) throws SQLException
    {
        int gp = -1;
        while(gp != 0)
        {
            Gravar = Integer.parseInt(JOptionPane.showInputDialog("1- Professor: \n 2 - Aluno: \n 0 - Voltar"));
            switch (Gravar) 
            {
                case 1:  
                    Professor p = new Professor();
                    leitura.professor(p);
                    salvarNoBD(p);
                break;
                case 2:
                    Aluno a = new Aluno ();
                    leitura.aluno(a);
                    salvarNoBD(a);
                break;
                case 0:
                {
                    JOptionPane.showMessageDialog(null, "Voltando");
                }
                gp = 0;
                break;
                default:
                JOptionPane.showMessageDialog(null, "opção incorreta");
            }
        }           
    }
    public void salvarNoBD(Professor p) throws SQLException
    {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", "")) 
        {
            String sql ="insert into professor (nome, idade, sexo, cpf, Siape) values (?,?,?,?,?)";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, p.getNome());
            prepare.setString(2, p.getIdade());
            prepare.setString(3, p.getSexo());
            prepare.setString(4, p.getCpf());
            prepare.setString(5, p.getSiape());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Professor salvo com Sucesso! ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());   
        }
    }
    public void salvarNoBD(Aluno a) throws SQLException
    {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", "")) {
            String sql ="insert into aluno (nome, idade, sexo, cpf, ra) values (?,?,?,?,?)";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, a.getNome());
            prepare.setString(2, a.getIdade());
            prepare.setString(3, a.getSexo());
            prepare.setString(4, a.getCpf());
            prepare.setString(5, a.getRa());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null,"Aluno salvo com Sucesso! ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());               
        }
    }
    public void buscarP() throws SQLException
    {
       try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", "")) 
       {
            String sql ="select * from professor where nome = ?";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, leitura.nome());
            
            ResultSet resul = prepare.executeQuery();
            while(resul.next())
            {
                String nome = resul.getString("nome");
                String cpf = resul.getString("cpf");
                String siape = resul.getString("siape");
                JOptionPane.showMessageDialog(null, "Nome: " + nome + 
                "\nCPF: " + cpf + "\n" + "Siape: " + siape);
            }

        }
    }
    public void buscarA() throws SQLException
    {
       try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", "")) 
       {
        String sql ="select * from aluno where nome = ?";
            PreparedStatement prepare = conexao.prepareCall(sql);
            prepare.setString(1, leitura.nome());
            
            ResultSet resul = prepare.executeQuery();
            while(resul.next())
            {
                String nome = resul.getString("nome");
                String cpf = resul.getString("cpf");
                String ra = resul.getString("ra");
                JOptionPane.showMessageDialog(null, "Nome: " + nome + 
                "\nCPF: " + cpf + "\n" + "Ra: " + ra );
            }
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public void buscarT () throws SQLException
    {
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", "")) 
        {
            String info = "";
            String sql = "select * from professor";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            ResultSet resul = prepare.executeQuery();
            while(resul.next())
            {
                String nome = resul.getString("nome");
                String cpf = resul.getString("cpf");
                String siape = resul.getString("siape");
                String in =
                "#########################\n" +
                "Nome: " + nome + 
                "\nCPF: " + cpf +
                "\nSiape: "+ siape + "\n";
                info = info + in;
            }
            sql = "select * from aluno";
            prepare = conexao.prepareStatement(sql);
            resul = prepare.executeQuery();
            while(resul.next())
            {
                String nome = resul.getString("nome");
                String cpf = resul.getString("cpf");
                String ra = resul.getString("ra");
                String in =
                "#########################\n" +
                "Nome: " + nome + 
                "\nCPF: " + cpf +
                "\nRa: "+ ra + "\n";
                info = info + in;
            }
            JOptionPane.showMessageDialog(null, info + "#########################\n");
        }
    }
    public void excluirCpf (int op) throws SQLException
    {
        String cpf = leitura.Cpf();
        boolean c = checar(cpf);
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", ""))
        {
            if(op == 1 && c == false)
            {
                String sql = "delete from professor where cpf = ?";
                PreparedStatement prepare = conexao.prepareStatement(sql);
                prepare.setString(1,cpf);
                prepare.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pessoa exluida com sucesso!!");
            }
            else if(op==2 && c == false)
            {                
                String sql = "delete from aluno where cpf = ?";
                PreparedStatement prepare = conexao.prepareStatement(sql);
                prepare.setString(1, cpf);
                prepare.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pessoa exluida com sucesso!!");
                
            } 
        else
            JOptionPane.showMessageDialog(null, "Essa pessoa não está na lista!!");

        }catch(SQLException ex)
            {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    public void alterar (int op) throws SQLException
    {
        String cpf = leitura.Cpf();
        boolean c = checar(cpf);
        ResultSet resul = null;

        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", ""))
        {
            if(op == 1 && c == false)
            {
                Professor p = new Professor();
                leitura.professor(p);
                String sql = "update professor set nome = ?, idade = ?, cpf = ?, sexo = ?, siape = ? where cpf = ?";
                PreparedStatement prepare = conexao.prepareStatement(sql);
                prepare.setString(6,cpf);
                prepare.setString(1, p.getNome());
                prepare.setString(2, p.getIdade());
                prepare.setString(3, p.getCpf());
                prepare.setString(4, p.getSexo());
                prepare.setString(5, p.getSiape());
                prepare.executeUpdate();
                JOptionPane.showMessageDialog(null, "Informação editada com sucesso!!");
            }
            else if( op==2 && c == false)
            {                
                Aluno a = new Aluno();
                leitura.aluno(a);
                String sql = "update aluno set nome = ?, idade = ?, cpf = ?, sexo = ?, ra = ? where cpf = ?";
                PreparedStatement prepare = conexao.prepareStatement(sql);
                prepare.setString(6,cpf);
                prepare.setString(1, a.getNome());
                prepare.setString(2, a.getIdade());
                prepare.setString(3, a.getCpf());
                prepare.setString(4, a.getSexo());
                prepare.setString(5, a.getRa());
                prepare.executeUpdate();
                JOptionPane.showMessageDialog(null, "Informação editada com sucesso!!");
            }
            else
            JOptionPane.showMessageDialog(null, "Essa pessoa não está na lista!!");

        }catch(SQLException ex)
            {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    public boolean checar(String cpf) throws SQLException
    {
        boolean b = true;
        ResultSet resul = null;
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lp2-at3", "root", ""))
        {
            String sql = "select * from professor where cpf = ?";
            PreparedStatement prepare = conexao.prepareStatement(sql);
            prepare.setString(1, cpf);
            resul = prepare.executeQuery();
                    while(resul.next())
                    {
                        b = false;
                    }
            sql = "select * from aluno where cpf = ?";
            prepare = conexao.prepareStatement(sql);
            prepare.setString(1, cpf);
            resul = prepare.executeQuery();
                    while(resul.next())
                    {
                        b = false;
                    }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        return b;
    }
}