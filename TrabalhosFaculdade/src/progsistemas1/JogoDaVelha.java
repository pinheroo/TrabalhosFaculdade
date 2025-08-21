package progsistemas1;

import java.util.Scanner;

public class JogoDaVelha {
    
    //CRIAÇÃO DA MATRIZ 3X3 QUE SERÁ O TABULEIRO DO JOGO DA VELHA
    private static char[][] matriz = new char[3][3];
    
    //VARIÁVEL PARA SABER QUAL SERÁ A JOGADA (X ou O)
    private static char jogada = 'X';
    
    //ENCHENDO O TABULEIRO DE '-' PARA SIMBOLIZAR VAZIO
    private static void preenchendoMatriz() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	matriz[i][j] = '-';				//IRÁ PREENCHER CADA POSIÇÃO DA MATRIZ COM '-'
            }
        }
    }
    
    //A MATRIZ SERÁ EXIBIDA, PARA O USUARIO SABER COMO O TABULEIRO ESTÁ
    private static void mostrarMatriz() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //VERIFICA SE A LINHA OU COLUNA DIGITADA ESTÁ ENTRE 0 E 2 OU SE ELA JÁ ESTÁ OCUPADA
    private static boolean jogadaInvalida(int linha, int coluna) {
    	return linha<0 || linha>2 || coluna<0 || coluna>2 || matriz[linha][coluna] == 'X' || matriz[linha][coluna] == 'O';
    }
    
    //VERIFICA SE A JOGADA ATUAL VENCEU A PARTIDA
    private static boolean jogadaVencedora() {
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == jogada && matriz[i][1] == jogada && matriz[i][2] == jogada) { //VERIFICANDO LINHAS
                return true;
            }
            if (matriz[0][i] == jogada && matriz[1][i] == jogada && matriz[2][i] == jogada) { //VERIFICANDO COLUNAS
                return true;
            }
        }
        if (matriz[0][0] == jogada && matriz[1][1] == jogada && matriz[2][2] == jogada) { //VERIFICANDO A DIAGONAL PRINCIPAL
            return true;
        }
        if (matriz[0][2] == jogada && matriz[1][1] == jogada && matriz[2][0] == jogada) { //VERIFICANDO A OUTRA DIAGONAL
            return true;
        }
        return false;
    }
    
    //VERIFICA SE A PARTIDA TERMINOU EMPATADA
    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == '-') {
                    return false;  //SE PELO MENOS UMA POSIÇÃO DA MATRIZ AINDA ESTIVER "VAZIA", O JOGO AINDA NAO TERMINOU
                }
            }
        }
        return true;
    }
    
    //TROCA A VEZ DE QUEM ESTÁ JOGANDO
    private static void trocarJogada() {
    	if(jogada == 'X') {
			jogada = 'O';
		}else {
			jogada = 'X';
		}
    }
    
    //EXECUTA O JOGO DA VELHA
    private static void jogoDaVelha() {
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.println("*** JOGO DA VELHA ***");
        
        while (true) {
        	
        	System.out.println();
        	mostrarMatriz();
        	
            System.out.println("\nJogador " + jogada + ", faça sua jogada.");
            System.out.print("Digite a linha (0-2): ");
            int linha = sc.nextInt();
            System.out.print("Agora, digite a coluna (0-2): ");
            int coluna = sc.nextInt();
            
            if(jogadaInvalida(linha, coluna) == true) {
            	System.out.println("\nJOGADA INVÁLIDA! TENTE NOVAMENTE");
            	continue;
            }
            
            matriz[linha][coluna] = jogada;
            
            //SE ALGUEM TIVER VENCIDO, O JOGO SERÁ ENCERRADO
            if (jogadaVencedora()) {
            	System.out.println();
            	mostrarMatriz();
                System.out.println("\nJogador " + jogada + " venceu!");
                break;
            }
            
            //SE O TABULEIRO ESTIVER COMPLETO E NINGUEM TIVER VENCIDO, O JOGO TERMINARÁ EMPATADO
            if (verificarEmpate()) {
            	System.out.println();
            	mostrarMatriz();
                System.out.println("\nEmpate! O jogo terminou sem vencedor.");
                break;
            }
            
            //TROCA DE VEZ (SE A ULTIMA JOGADA TIVER SIDO 'X', A PROXIMA SERÁ 'O'. E VICE-VERSA)
            trocarJogada();
        }
        
        //PERGUNTANDO SE OS JOGADORES DESEJAR ENCERRAR O PROGRAMA OU JOGAR NOVAMENTE
        System.out.print("Deseja jogar novamente? (s/n): ");
        char resposta = sc.next().charAt(0);
        if (resposta == 's' || resposta == 'S') {
        	preenchendoMatriz();
            jogoDaVelha();
        } else {
            System.out.println("\nObrigado por jogar!");
            System.out.println("Encerrado o programa...");
        }
        
        sc.close();
    }
    
    public static void main(String[] args) {
    	preenchendoMatriz();
        jogoDaVelha();
    }
}