package br.org.catolicasc.criacao.builder.poc;

public class VolksBuilder extends CarroBuilder {

    @Override
    public void buildPreco() {
        carro.setPreco(1000.00);
    }

    @Override
    public void buildDscMotor() {
        carro.setDscMotor("1.0 Flex");
    }

    @Override
    public void buildAnoDeFabricacao() {
        carro.setAnoDeFabricacao(2010);
    }

    @Override
    public void buildModelo() {
        carro.setModelo("Gol");
    }

    @Override
    public void buildMontadora() {
        carro.setMontadora("VolskWagem");
    }

}
