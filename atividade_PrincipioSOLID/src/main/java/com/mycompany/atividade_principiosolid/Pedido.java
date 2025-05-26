/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_principiosolid;

/**
 *
 * @author victor
 */
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> itens;
    private Cupom cupom;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public void aplicarCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : itens) {
            total += produto.getPreco();
        }

        if (cupom != null) {
            total = cupom.aplicarDesconto(total);
        }

        return total;
    }

    public List<Produto> getItens() {
        return itens;
    }
}
