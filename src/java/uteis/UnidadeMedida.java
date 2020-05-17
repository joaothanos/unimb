/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

/**
 *
 * @author joao-
 */
public enum UnidadeMedida {
    KG("KG"),
    M("M"),
    L("L"),
    CX("CX"),
    UN("UN");

    private String unidadeMedida;

    UnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    public String getUnidadeMedida() {
        return this.unidadeMedida;
    }
}
