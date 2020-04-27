## Descrição
Você decidiu abandonar o planeta Terra de vez, após o último colapso ecológico do planeta. Com os recursos que você possui, você pode comprar uma nave espacial, deixar a Terra e voar por toda a galáxia para vender metais de vários tipos.

Comprar e vender por toda a galáxia exige que você converta números e unidades, logo você decidiu escrever um programa para ajudá-lo.

Os números usados nas transações intergalácticas seguem convenção similar a dos numerais romanos, e devem ser traduzidos para que as transações possam se realizar.

[Sobre os numerais romanos](http://en.wikipedia.org/wiki/Roman_numerals)

As entradas para o seu programa consistem de linhas de texto em um arquivo texto detalhando as suas anotações sobre a conversão entre unidades intergalácticas e numerais romanos. Você deve lidar com anotações inválidas de forma apropriada e gerar a saída na tela.

Como se pode ver abaixo, as entradas podem ter até 7 linhas iniciais indicando a notação intergaláctica dos símbolos romanos, seguida de 0 ou mais linhas indicando o valor em créditos do número de unidades (expresso em intergaláctico) de metal sendo vendido. Na sequência, linhas com perguntas “quanto vale” / ”quantos créditos são”. Na última linha, um exemplo do que deve acontecer com uma anotação inválida.

Desenvolva o programa que processa estas entradas e gera estas saídas.

### Exemplos

Entradas (de Teste):

- glob is I
- prok is V
- pish is X
- tegj is L
- glob glob Silver is 34 Credits
- glob prok Gold is 57800 Credits
- pish pish Iron is 3910 Credits
- quanto vale pish tegj glob glob ?
- quantos créditos são glob prok Silver ?
- quantos créditos são glob prok Gold ?
- quantos créditos são glob prok Iron ?
- quanto vale wood could woodchuck mood ?

Saídas (do Teste):

- pish tegj glob glob is 42
- glob prok Silver is 68 Credits
- glob prok Gold is 57800 Credits
- glob prok Iron is 782 Credits
- I have no idea what you are talking about