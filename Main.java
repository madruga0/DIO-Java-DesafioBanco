package DesafioBanco.src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Cliente pedro = new Cliente();
        pedro.setNome("Pedro");
        Cliente maria = new Cliente();
        maria.setNome("Maria");
        Cliente joao = new Cliente();
        joao.setNome("Joao");

        Conta cc1 = new ContaCorrente(pedro);
        Conta cc2 = new ContaCorrente(joao);
        Conta cc3 = new ContaCorrente(maria);

        cc1.depositar(100);
        cc2.depositar(200);
        cc3.depositar(300);

        cc1.imprimirExtrato();
        cc2.imprimirExtrato();
        cc3.imprimirExtrato();

    }
}
