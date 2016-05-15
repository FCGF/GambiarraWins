package br.org.catolicasc.estrutura.proxy.modelo;

import br.org.catolicasc.estrutura.*;



public class Proxy extends RealSubject implements Arquivo {
      
	private RealSubject arquivoReal;

	private String nomeDoArquivo;

	private RealSubject realSubject;

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
