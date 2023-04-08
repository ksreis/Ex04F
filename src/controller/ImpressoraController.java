package controller;
import Kreis.fila.*;


public class ImpressoraController {

    public void insereDocumento(FilaStrings f, String documento) {
        f.enfileirar(documento);
    }

    public void imprime(FilaStrings f) throws InterruptedException {
        if (f.vazia()) {
            throw new InterruptedException("Não há documentos na fila de impressão!");
        }

        String documento = f.desenfileirar();
        String[] partes = documento.split(";");

        String id_pc = partes[0];
        String nome_arquivo = partes[1];

        int tempo = (int) (Math.random() * 1000) + 1000; 

        Thread.sleep(tempo);

        System.out.println("[#PC: " + id_pc + " - Arquivo: " + nome_arquivo + "]");
    }
}