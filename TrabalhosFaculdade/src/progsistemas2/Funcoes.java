package progsistemas2;

import java.util.ArrayList;

public class Funcoes {
    private ArrayList<Cliente> listaDeClientes;

    public Funcoes() {
    	listaDeClientes = new ArrayList<>();
    }

    public void cadastroDeClientes(int id, String nome, String email, String telefone) {
    	System.out.println("\nCliente "+id+" adicionado!\n");
    	Cliente novoCliente = new Cliente(id, nome, email, telefone);
    	listaDeClientes.add(novoCliente);
    }

    public void listagemDeClientes() {
        if (listaDeClientes.isEmpty()) {
            System.out.println("\nNENHUM CLIENTE FOI CADSATRADO AINDA!\n");
        }else {
            for (Cliente cliente : listaDeClientes) {
                System.out.println(cliente.toString());
            }
        }
    }

    public boolean atualizacaoDeDadosDeClientes(int id, String nome, String email, String telefone) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getId() == id) {
            	System.out.println("\nClinete "+id+" atualizado!\n");
                cliente.setNome(nome);
                cliente.setEmail(email);
                cliente.setTelefone(telefone);
                return true;
            }
        }
        System.out.println("\nNÃO EXISTE NEHNUM CLIENTE CADASTRADO COM ESTE ID!\n");
        return false;
    }

    public boolean remocaoDeClientes(int id) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getId() == id) {
            	System.out.println("\nCliente "+id+" removido!\n");
            	listaDeClientes.remove(cliente);
                return true;
            }
        }
        System.out.println("\nNÃO EXISTE NEHNUM CLIENTE CADASTRADO COM ESTE ID!\n");
        return false;
    }

    public boolean buscaDeClientes(int id) {
    	for(Cliente cliente : listaDeClientes) {
			if(cliente.getId() == id) {
				System.out.println(cliente.toString());
				return true;
			}
		}
		System.out.println("\nNÃO EXISTE NEHNUM CLIENTE CADASTRADO COM ESTE ID!\n");
		return false;
    }
    
}
