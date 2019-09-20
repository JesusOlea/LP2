package at3.parte2;


import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Main 
{
    public static void main(String[] args) throws SQLException
    {
       int op1 = -1;
        Exibir e = new Exibir();
        DAO d = new DAO();
        
        while(op1 !=0)
        {
            String opcao = JOptionPane.showInputDialog("1 - Salvar \n 2 - Buscar \n 3 - Remover \n 4 - Alterar \n 0 - Sair");
            switch (opcao)
            {
                case "1":
                {
                    d.gravarPessoa(op1);
                }
                break;
                case "2":
                {
                    String op = JOptionPane.showInputDialog(" 1 - Professor \n 2 - Aluno \n 3 - Buscar Todos\n 0 - Voltar ");
                    switch (op)
                    {
                        case "1":
                        {
                            d.buscarP();
                        }
                        break;
                        case "2":
                        {
                            d.buscarA();
                        }
                        break;
                        case "3":
                        {
                            d.buscarT();
                        }
                        break;
                        case "0":
                        {
                            JOptionPane.showMessageDialog(null, "Voltar");
                        }
                        break;
                        default:
                        JOptionPane.showMessageDialog(null, "opção incorreta");
                    }
                }
                break;
                case "3":
                {
                    d.excluirCpf(e.op());
                }
                break;
                case "4":
                {
                    d.alterar(e.op());
                }
                break;
                case "0":
                {
                    JOptionPane.showMessageDialog(null, "Saindo");
                   op1 = 0;
                }
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "opção incorreta");
            }
        }
    }
}