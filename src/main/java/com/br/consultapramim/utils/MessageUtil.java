package com.br.consultapramim.utils;

public enum MessageUtil {

    // Alertas Genéricos
    MSG_A01("MSG_A01", "Dados inválidos."),
    MSG_A02("MSG_A02", "Acesso Negado."),

    // Erros Genéricos
    MSG_E01("MSG_E01", "Erro interno no sistema."),

    // Sucessos Específicos
    MSE_S01("MSE_S01", "Sucesso 1"),

    // Alertas Específicos
    MSE_A01("MSE_A01", "Alerta 1"),

    // Erros Específicos
    MSE_E01("MSE_E01", "Erro E1");

    private final String msgAbbreviation;
    private final String msgDescription;

    MessageUtil(String msgAbbreviation, String msgDescription) {
        this.msgAbbreviation = msgAbbreviation;
        this.msgDescription = msgDescription;
    }

    public static MessageUtil toEnum(String msgAbbreviation) {
        if (msgAbbreviation == null) {
            return null;
        }

        for (MessageUtil x : MessageUtil.values()) {
            if (msgAbbreviation.equals(x.getMsgAbbreviation())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + msgAbbreviation);
    }

    public String getMsgAbbreviation() {
        return msgAbbreviation;
    }

    public String getMsgDescription() {
        return msgDescription;
    }

    public String getMsgDescription(String field) {
        return msgDescription.replace("%s", field);
    }
}