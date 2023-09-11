package br.com.danielverdi;

import br.com.danielverdi.dao.ClienteMapDAO;
import br.com.danielverdi.dao.ClienteSetDAO;
import br.com.danielverdi.dao.IClienteDAO;
import br.com.danielverdi.domain.Cliente;

import javax.swing.*;

public class Programa {

    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteSetDAO();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 - Consultar, " +
                "3 - Alteração, 4 - Exclusão, 5 - Sair", "Programa", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)){
            if ("".equals(opcao)){
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida digite 1 para Cadastro, 2 para Consultar, 3 para Alteração, 4 para Exclusão ou 5 para Sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
        while (isOpcaoValida(opcao)){

            if (isOpcaoSair(opcao)){
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados do cliente separados por vígula, conforme exemplo:" +
                                                           " Nome, CPF, Telefone, Endereço, Número, Cidade e Estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);

            } else if (isConsulta(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite o CPF para consulta",
                        "Consulta cadastro", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);

            } else if (isAlteracao(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Por favor, altere os dados",
                        "Alteração", JOptionPane.INFORMATION_MESSAGE);

                alterar(dados);
            } else  {
                String dados = JOptionPane.showInputDialog(null, "Por favor, digite o CPF de cadastro para exclusão",
                        "Exclusão",JOptionPane.INFORMATION_MESSAGE);
                excluir(dados);
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para Cadastro, 2 para Consultar, 3 para Alteração, 4 para Exclusão ou 5 para Sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }




    private static void cadastrar(String dados) {
        String[] dadosSep = dados.split(",");
        Cliente cliente = new Cliente(dadosSep[0], dadosSep[1], dadosSep[2], dadosSep[3], dadosSep[4], dadosSep[5], dadosSep[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if(isCadastrado){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        }else{
            JOptionPane.showMessageDialog(null, "Cliente já está cadastrado", "Erro", JOptionPane.INFORMATION_MESSAGE );
        }
    }

    private static void consultar (String dados){
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if(cliente != null){
            JOptionPane.showMessageDialog(null, "Resultado: "+cliente.toString(), "Consultar", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Cliente não encontrado", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterar (String dados){
        String[] dadosSep2 = dados.split(",");
        Cliente cliente = new Cliente(dadosSep2[0],dadosSep2[1], dadosSep2[2], dadosSep2[3], dadosSep2[4], dadosSep2[5], dadosSep2[6]);
        iClienteDAO.alterar(cliente);
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void excluir (String dados){
        iClienteDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
    }


    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isConsulta(String opcao) {
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isAlteracao (String opcao){
        if ("3".equals(opcao)){
            return true;
        }
        return false;
    }


    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até a próxima","Saindo",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }
}



