# LDTS_T04_G01 - ATTACKERS

# Tabela de Conteúdos
- [Introdução](#introdução)
- [Descrição](#descrição)
- [Autores](#autores)
- [Comandos](#comandos)
- [Demonstração](#demonstração)
- [Funcionalidades](#funcionalidades)
    - [Implementadas](#implementadas)
    - [Por implementar](#por-implementar)
- [Design](#design)
- [Padrão Arquitetural](#padrão-arquitetural)
    - [Contexto do problema](#contexto-do-problema)
    - [Design Pattern](#design-pattern)
    - [Implementação](#implementação)
    - [Consequências](#consequências)
- [Mudança de Estados de Jogo](#mudança-de-estados-de-jogo)
    - [Contexto do problema](#contexto-do-problema-1)
    - [Design Pattern](#design-pattern-1)
    - [Implementação](#implementação-1)
    - [Consequências](#consequências-1)
- [Game Loop](#game-loop)
    - [Contexto do problema](#contexto-do-problema-2)
    - [Design Pattern](#design-pattern-2)
    - [Implementação](#implementação-2)
    - [Consequências](#consequências-2)
- [BattleFieldBuilder](#battlefieldbuilder)
    - [Contexto do problema](#contexto-do-problema-3)
    - [Design Pattern](#design-pattern-3)
    - [Implementação](#implementação-3)
    - [Consequências](#consequências-3)
- [Lanterna](#lanterna)
    - [Contexto do problema](#contexto-do-problema-4)
    - [Design Pattern](#design-pattern-4)
    - [Implementação](#implementação-4)
    - [Consequências](#consequências-4)
- [Code Smells](#code-smells)
    - [Código Repetido](#codigo-repetido)
- [Testing](#testing)
    - [Coverage](#coverage)
- [Auto-avaliação](#auto-avaliação)

# Introdução
Numa versão reimagidada do clássico jogo Space Invaders, apresentamos Attackers. Neste jogo, o jogador é um soldado cujo propósito é matar os seus inimigos e ganhar a guerra.

# Descrição
O jogador surge num campo de batalha cheio de inimigos a marchar na sua direção. Apresenta como munição balas que matam os seus oponentes e paredes que o portegem, sendo eficazes até à terceira colisão de bombas lançadas pelo inimigo. O jogador começa com três vidas que podem incrementar caso consiga acumular pontos suficientes. Se o jogador conseguir eliminar todos os seus inimigos antes de estes o alcançarem, ganha o jogo.

# Autores
Este projeto foi realizado por:
- André Vieira (up202004159@fe.up.pt)
- Francisca Guimarães (up202004229@fe.up.pt))
- Pedro Oliveira (up202004324@fc.up.pt)

# Comandos
- **Q**: Premite aceder ao menu
- **Setas do teclado**
    - Jogador:
        - (Movimento) Seta da direita
        - (Movimento) Seta da esquerda
        - (Atirar a Bala) Barra do Espaço
    - Menu:
        - (Selecionar) Enter
        - (Navegar) Seta para cima
        - (Navegar) Seta para baixo


# Demonstração
<a href="url"><img src="https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/images/RunTime.gif" height="600" width="450" ></a> <a href="url"><img src="https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/images/menu.gif" height="600" width="450" ></a>


# Funcionalidades

## Implementadas
- Movimento do jogador: esquerda e direita utilizando as setas do teclado
- Atirar a bala: barra do espaço utilizando a barra do teclado
- Movimento do exército inimigo: esquerda ou direita até tocar na parede invertendo o movimento após descer uma linha
- Movimento da bala: move-se até atingir um inimigo ou uma parede
- Movimento das bombas: movem-se até atingirem o jogador ou uma parede
- Desenho das personagens: jogador, inimigos, campo de batalha, bala, bombas, margens e paredes de proteção desenhados usando lanterna
- Menu: menu com opções de iniciar o jogo, de sair do jogo, um menu de instruções e de sair ou voltar a jogar quando o jogador ganhe ou perca o jogo
- Atributos do jogador: as suas vidas e os pontos acumulados
- Paredes de Proteção: eficazes até à terceira colisão de bombas

## Por implementar:
- Niveis: implementar os diversos níveis
- Diferentes tipos de jogador: criar 3 tipos de jogador com cores e habilidades diferentes dando a opção de escolha ao utilizador
- Diferentes tipos de inimigo: criar 3 tipos de inimigo com habilidades diferentes e cores distintas para uma melhor compreensão

# Design

## Padrão Arquitetural

### Contexto do problema
O padrão arquitetural é uma das partes mais importantes de um projeto deste tipo, este é responsável pela maneira como organizamos o código do programa.

### Design Pattern
Como padrão arquitetural decidimos utilizar o padrão MVC (Model-View-Controller) apresentando a seguinte divisão:

- Model: Guarda a estrutura do jogo e a seu estado atual
- View: É a parte que trabalha com o utilizador, apresenta os dados do application.model e envia as ações do utilizador para o application.controller
- Controller: Coordena e processa os estados do programa, envia os dados do application.model para a application.view e interpreta as açoes do utilizador

### Implementação
![MVC UML](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/uml/MVC_UML.png)

### Consequências
- Fácil modificação
- Baixo acoplamento entre models, views ou controllers
- Boa coesão
- Mais facilmente testáveis

## Mudança de Estados de Jogo
### Contexto do Problema
Precisamos de alterar o estado do nosso jogo para vários estados de jogo como: MenuState, GameState, InstructionsState, etc.

### Design Pattern
Pensamos em usar o State Pattern que permite que um objeto aletere o seu comportamento quando o seu estado interno muda e aparenta que o objeto muda de classe.

### Implementação
![StatePattern](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/uml/StatePattern.png)

### Consequências
- Mais fácil de adicionar um novo estado ao jogo
- É mais fácil de localizar o comportamento para os diferentes estados, pois estes estão divididos
- Torna as transições de estado explícitas

## Game Loop
### Contexto do Problema
Durante o tempo de jogo, um ciclo do nosso jogo, attackers, ocorre continuamente. Em cada iteração é renderizada a imagem, processado o input do utilizador e o jogo é constantemente atualizado.

### Design Pattern
Escolhemos o padrão GameLoop que garante que o tempo do jogo é processado na mesma velocidade em todas as diferentes configurações de hardware. Este é um padrão importante e usando-o garantimos que a continuação do nosso jogo seja independente do input do utilizador e da velocidade do processador.

### Implementação
![GameLoopPattern](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/uml/GameLoopPattern.png)

### Consequências
- O jogo não bloqueia pela falta de input do utilizador
- A frame do jogo é atualizada constantemente
- As variáveis do nosso jogo são atualizadas metodicamente
- Permite uma maior gestão do ritmo da frame

## BattleFieldBuilder
### Contexto do Problema
O nosso campo de batalha consiste na aglomeração de vários elementos tal como paredes, bombas, balas, jogadores e inimigos. Com o objetivo inicial de incluir níveis no nosso jogo com elementos diferentes de nível para nível, concluímos que ter diferentes campos de batalha nos vários níveis utilizando um BattleFieldLoader que lê de um ficheiro e insere na sua superclasse (neste caso, a BattleFieldBuilder) os elementos necessários, em vez de ter de construir cada nível separadamente, era a forma mais eficiente. Assim é possível criar elementos específicos e gerar diferentes campos de batalha conforme as especificações dos níveis, sendo assim possível chamar apenas os parâmetros necessários a cada nível 

### Design Pattern
Escolhemos, para resolver estes problemas, os padrões Factory Method e Builder. São dois padrões de design criacional, o primeiro fornece uma interface para criação de objetos numa superclasse, permitindo, no entanto, que as subclasses alterem o tipo de objetos que serão criados. A segunda, permite construir objetos complexos passo a passo tornando o código mais simples.

### Implementação
![B_FM](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/uml/Builder_FactoryMethod.png)

### Consequências
- Evitamos o acoplamento entre o criador e os produtos concretos
- É possível introduzir novos tipos de produtos no programa sem danificar o código do cliente existente (Open/Closed Principle)
- É possível construir objetos passo a passo, adiar etapas de construção ou executar etapas recursivamente

## Lanterna
### Contexto do Problema
Os frameworks são sistemas complexos já que possuem mais recursos do que aqueles que serão realmente utilizados num projeto. Neste caso, desenvolvemos um text-based jogo e usamos o Lanterna como GUI framework. Se usássemos diretamente os métodos do Lanterna teríamos um código mais complexo e fortemente acoplado ao framework.

### Design Pattern
Facade é um padrão estrutural que fornece uma interface simplificada para uma biblioteca, um framework ou qualquer outro conjunto complexo de classes.

### Implementação
![FACADEPattern](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/uml/FACADEPattern.png)

### Consequências
- Melhorar a legibilidade do código
- Oferece uma interface específica ao contexto para funcionalidades mais genéricas

# Code Smells
## Código Repetido
Identificamos código repetido na criação dos estados do nosso jogo, mais especificamente nos estados (e consequentes model e controller) GameOverState e o GameWonState. Uma das vantagens de utilizar o State Pattern é a facilidade de localizar e adicionar código aos diferentes estados criados, pelo que julgamos que se justifique a existência deste code smell em prol de futuras modificações específicas a cada estado que poderemos querer vir a fazer.

# Testing
## Coverage
![Coverage](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/images/Coverage.png)
![TestSummary](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/images/TestSummary.png)
![Mutation](https://github.com/FEUP-LDTS-2021/ldts-project-assignment-g0401/blob/master/docs/images/Mutation.png)

# Auto-avaliação
- **André Vieira**: 33.3%
- **Francisca Guimarães**: 33.3%
- **Pedro Oliveira**: 33.3%

