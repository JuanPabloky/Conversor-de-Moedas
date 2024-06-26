package Conversor.currency;

import Conversor.currency.ConverterCurrency;

import java.util.Scanner;

public class MenuConverter {
    private Scanner leitura = new Scanner(System.in);
    private Scanner valor = new Scanner(System.in);

    public void showMenu() {
        int option = 0;
        String menu = """
                ******************************************************************
                |--------------------Menu de Opções------------------|
                |----------------------------------------------------|
               
               |  1) Dólar (USD) para Peso Argentino(ARS)   |
               |  2) Peso Argentino (ARS) para Dólar        |
               |  3) Dólar (USD) para Real (BRL)            |
               |  4) Real (BRL) para Dólar (USD)            |
               |  5) Dólar (USD) para Peso Colombiano (COP) |
               |  6) Peso Colombiano (COP) =>>> Dólar (USD) |
               |  7) Sair                                   |
               
                Escolha uma das opções acima.
               
                ******************************************************************
                """;


        while (option != 7) {
            System.out.println(menu);
            option = leitura.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nVocê escolheu Dólar =>>> Peso Argentino");
                    System.out.println("Digite o valor em Dólar (USD): ");
                    double valorUSD = valor.nextDouble(); // Read the double value from the Scanner

                    double valorARS = ConverterCurrency.convertUSDtoARS(valorUSD); // Pass the actual double value
                    System.out.printf("\nValor convertido: %.2f ARS\n", valorARS);

                    break;
                case 2:
                    System.out.println("\nVocê escolheu Peso Argentino =>>> Dólar");
                    System.out.println("Digite o valor em Peso Argentio");
                    valorARS = valor.nextDouble();

                    valorUSD = ConverterCurrency.convertARStoUSD(valorARS);
                    System.out.printf("Valor convertido: %2f USD\n", valorUSD);
                    break;
                case 3:
                    System.out.println("\nVocê escolheu Dólar =>>> Real");
                    System.out.println("Digite o valor em Dólar");
                    valorUSD = valor.nextDouble();

                    double valorBRL = ConverterCurrency.convertUSDtoBRL(valorUSD);
                    System.out.printf("Valor convertido: %2f BRL\n", valorBRL);
                    break;
                case 4:
                    System.out.println("\nVocê escolheu Real =>>> Dólar");
                    System.out.println("Digite o valor em Real");
                    valorBRL = valor.nextDouble();

                    valorUSD = ConverterCurrency.convertBRLtoUSD(valorBRL);
                    System.out.printf("Valor convertido: %2f USD\n", valorUSD);
                    break;
                case 5:
                    System.out.println("\nVocê escolheu Dólar =>>> Peso Colombiano");
                    System.out.println("Digite o valor em Dólar");
                    valorUSD = valor.nextDouble();

                    double valorCOP = ConverterCurrency.convertCOPtoUSD(valorUSD);
                    System.out.printf("Valor convertido: %2f COP\n", valorCOP);

                    break;
                case 6:
                    System.out.println("\nVocê escolheu Peso Colombiano =>>> Dólar");
                    System.out.println("Digite o valor em Peso Colombiano");
                    valorCOP = valor.nextDouble();

                    valorUSD = ConverterCurrency.convertCOPtoUSD(valorCOP);
                    System.out.printf("Valor convertido: %2f USD\n", valorUSD);

                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma das opções acima.");
            }
        }
        leitura.close();
    }
}