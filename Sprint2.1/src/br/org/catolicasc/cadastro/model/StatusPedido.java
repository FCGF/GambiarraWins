/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.cadastro.model;

/**
 *
 * @author Cyber
 */
public enum StatusPedido {
    PAGAMENTO_PENDENTE,
    PAGAMENTO_APROVADO,
    CARENCIA_PARA_CANCELAMENTO,
    PRONTO_MANUSEIO,
    INICIAR_MANUSEIO,
    REPARANDO_ENTREGA,
    CANCELAMENTO_SOLICITADO,
    VERIFICANDO_ENVIO,
    FATURADO,CANCELAR,
    CANCELADO,ENVIADO;
    
}
