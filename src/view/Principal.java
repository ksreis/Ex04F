package view;

import javax.swing.JOptionPane;

import Kreis.fila.FilaStrings;
import controller.ImpressoraController;

public class Principal {

    public static void main(String[] args) {
        FilaStrings fila = new FilaStrings();
        ImpressoraController controller = new ImpressoraController();

        int opcao = 0;

        while (opcao != 3) {
            String input = JOptionPane.showInputDialog(null, "Selecione uma opção:\n1. Inserir documento na fila de impressão\n2. Imprimir documento\n3. Sair");

            if (input == null || input.isEmpty()) {
                continue;
            }

            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    String documento = JOptionPane.showInputDialog(null, "Digite o documento no formato ID_PC;Nome_Arquivo:");

                    if (documento == null || documento.isEmpty()) {
                        continue;
                    }

                    String[] partes = documento.split(";");

                    if (partes.length != 2) {
                        JOptionPane.showMessageDialog(null, "Documento inválido! Formato esperado: ID_PC;Nome_Arquivo");
                        continue;
                    }

                    String id_pc = partes[0];
                    String nome_arquivo = partes[1];

                    JOptionPane.showMessageDialog(null, "Documento inserido na fila de impressão!");
                    controller.insereDocumento(fila, documento);
                    break;
                case 2:
                    try {
                        controller.imprime(fila);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo do programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
}