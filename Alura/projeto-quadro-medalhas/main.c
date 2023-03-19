#include "relatorio.h"
#include <stdio.h>
#include <stdlib.h>

/**
 * @author Matheus Felipe
 */
int main() {
  gerarRelatorioInicial();

  char input;
  int quantidade, pais, modalidade, tipo;

  printf("Bem vindo(a) ao programa Quadro de Medalhas!\n");
  do {
    printf("\n----------------------------\n");
    printf("Digite uma das opcoes abaixo:\n");
    printf("1 - Editar uma entrada\n2 - Gerar relatorio\n3 - Visualizar "
           "possiveis melhorias\n0 - Sair\n\n");
    printf("Sua escolha: ");
    scanf(" %c", &input);

    switch (input) {
    case '0':
      printf("Muito obrigado por usar a nossa aplicacao!\n\n");
      gerarRelatorioFinal();
      return 0;

    case '1':
      printf("Digite a nova quantidade de medalhas\n");
      printf("Sua escolha: ");
      scanf("%d", &quantidade);

      printf("Digite qual pais tera suas medalhas modificadas\n");
      printf("Sua escolha: ");
      scanf("%d", &pais);

      printf("Digite a modalidade que tera sua medalha modificada\n");
      printf("Sua escolha: ");
      scanf("%d", &modalidade);

      printf("Digite o tipo de medalha a ser modificada\n\n");
      printf("1 - Ouro\n2 - Prata\n3 - Bronze\n\n");
      printf("Sua escolha: ");
      scanf("%d", &tipo);

      editarEntrada(quantidade, pais, modalidade, tipo);
      printf("\n");
      break;
    case '2':
      printf("Gerando relatorio...\n\n");

      gerarRelatorioInicial();

      printf("Relatorio gerado com sucesso!\n");
      break;
    case '3':
      printf("Principais problemas:\n\n");
      printf("1 - Nao e possivel ler numero de medalhas com mais de 2 digitos "
             "do arquivo de entrada\n");
      printf("2 - Codigo confuso: possui diversas repeticoes pelo criador nao "
             "saber como mandar e retornar uma matriz por uma funcao\n\n");
      break;
    default:
      printf("Opcao invalida, por favor digite uma opcao valida\n");
      break;
    }
  } while (input != 0);
  return 0;
}
