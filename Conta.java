package DesafioBanco.src;

import java.util.ArrayList;
import java.util.List;

// heranca
public abstract class Conta implements iConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    // Lista para armazenar clientes
    private static List<Cliente> clientesCadastrados = new ArrayList<>();


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        clientesCadastrados.add(cliente);
    }

    @Override
    public void sacar(double valor) {
        saldo = saldo - valor;
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;

    }

    @Override
    public void transferir(double valor, iConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public static List<String> getNomesClientes() {
        List<String> nomes = new ArrayList<>();
        for(Cliente cliente : clientesCadastrados) {
            nomes.add(cliente.getNome());
        }
        return nomes;
    }

    protected void imprimirInfoComuns() {
        System.out.println(String.format("Titular da conta: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Clientes: %s", String.join(", ", getNomesClientes())));
    }
}
