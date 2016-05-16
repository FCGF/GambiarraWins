package br.org.catolicasc.estrutural.proxy.modelo;

public class RealSubject implements Arquivo {

    private String nomeDoArquivo;

    RealSubject(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

 
    public void Request() {
        System.out.println("Carregando Arquivo");
    }

    public String arquivoReal(String real) {
        return real = nomeDoArquivo;
    }

    @Override
    public void getArquivos() {
      System.out.println(this.nomeDoArquivo);
    }

}
