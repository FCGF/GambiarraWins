package br.org.catolicasc.estrutural.proxy.modelo;

public class RealSubject implements Arquivo {

    private  String nomeDoArquivo;

   public  RealSubject(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public void Request() {
        System.out.println("Carregando Arquivo");
    }

    public String arquivoReal(String real) {

        if (real.equals(nomeDoArquivo)) {
            return nomeDoArquivo;
        } else {
            return null;
        }

    }

    @Override
    public void getArquivos() {
        System.out.println(this.nomeDoArquivo);
    }

}
