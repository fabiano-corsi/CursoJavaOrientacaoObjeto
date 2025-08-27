package br.com.alura.consultacep.principal;

import br.com.alura.consultacep.factory.SingletonFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SingletonFactory.getInstance().getconsultaCepInterfaceDeUsuario().Execute();
    }
}