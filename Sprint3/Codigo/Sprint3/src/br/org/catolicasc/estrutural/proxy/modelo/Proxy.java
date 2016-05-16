package br.org.catolicasc.estrutural.proxy.modelo;

public class Proxy extends RealSubject implements Arquivo {

    private RealSubject arquivoReal;

    private String nomeDoArquivo;

    public Proxy(String nomeDoArquivo) {
        super(nomeDoArquivo);
    }

    public void RequestProxy(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
        getArquivos();
    }

    @Override
    public void getArquivos() {
        arquivoReal = new RealSubject(this.nomeDoArquivo);

        arquivoReal.getArquivos();
    }

}
