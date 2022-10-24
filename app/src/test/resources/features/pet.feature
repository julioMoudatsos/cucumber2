# language: pt

Funcionalidade: Testar lista de pets


 # Dado  tenha lista de pets
 # Quando  pesquiso os pets a available
 # Entao   me retorna uma lista de pets
 # E chama uma lista de animais available

  #Cenario: Contagem Lista Pets
  # Dado  a lista de pets sold esta vazio2
   #Quando  pesquiso os pets a2 sold
#   Entao   me retorna uma list2a com 0

  Esquema do Cenario: Esse é nosso esquema hehehe
    Dado  a lista de pets sold esta vazio
    Quando  pesquiso os pets a <status>
    Entao   me retorna uma lista com <quantidade>
    E chama uma lista de animais <status>

    Exemplos: exemplo de retrono com listas maior que 0
      | status    | quantidade |
      | available | 7          |
      | pending   | 2          |

    Exemplos: exemplo de retrono com listas igual que 0
      | status | quantidade |
      | sold   | 0          |


    Cenario:  Listas animais disponiveis para a venda
      Dado que eu possua animais available
      Quando pesquiso por todos os animais available
      Entao recebo a lista com 7 animais available
      E 3 animais possuem o nome Lion



