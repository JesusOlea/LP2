package Atividade2;

import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Main 
{
    public static void main(String[] args)
    {
        boolean op1 = true;
        Exibir e = new Exibir();
        DAO d = new DAO();
        d.ler();
        while(op1)
        {
            String opcao = JOptionPane.showInputDialog("1 - Salvar \n 2 - Buscar Todos \n 3 - Remover \n 0 - Sair");
            switch (opcao)
            {
                case "1":
                {
                    String op = JOptionPane.showInputDialog(" 1 - Aluno \n 2 - Professor \n 0 - Sair ");
                    switch (op)
                    {
                        
                        case "1":
                        {
                           e.aluno(d);
                        }
                        break;
                        case "2":
                        {
                            e.professor(d);
                        }
                        break;
                        case "0":
                        {
                            JOptionPane.showMessageDialog(null, "Saindo");

                        } break;  
                    default:
                    JOptionPane.showMessageDialog(null, "opção incorreta");
                    }
                }
                break;
                case "2":
                {
                    String op = JOptionPane.showInputDialog(" 1 - Aluno \n 2 - Professor \n 0 - Sair ");
                    switch (op)
                    {
                        case "1":
                        {
                            d.buscarA();
                        }
                        break;
                        case "2":
                        {
                            d.buscarP();
                        }
                        break;
                        case "0":
                        {
                            JOptionPane.showMessageDialog(null, "Saindo");
                        }
                        break;
                        default:
                        JOptionPane.showMessageDialog(null, "opção incorreta");
                    }
                }
                break;
                case "3":
                    String cpf = JOptionPane.showInputDialog("Digite o CPF da pessoa");
                    d.excluirA(cpf);
                    
                    break;
                case "0":
                {
                    op1 = false;
                    JOptionPane.showMessageDialog(null, "Saindo");
                    d.gravar();
                }
                    break;
                    default:
                    JOptionPane.showMessageDialog(null, "opção incorreta");
            }
            
        }
        
    }
}
