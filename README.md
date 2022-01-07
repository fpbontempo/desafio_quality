# Bootcamp-Meli-W4-G9-Desafio-Testing
Desafio Testing - Grupo 9 - Wave 4 - Bootcamp Meli

## ATIVIDADE
Implementar validações e testes diferentes para um cenário determinado: A partir de um cenário conhecido, deverá se estabelecer os diferentes processos de validação de dados e processos de testes unitários necessários.

Para fazer isso, será necessário desenvolver uma API que forneça: <br>
1 - US-0001: Calcular a área total de uma propriedade. <br>
2 - US-0002: Indicar o preço dessa mesma propriedade com base na área total. Lembre-se que os preços por metro quadrado são determinados em função do bairro. <br>
3 - US-0003: Determinar qual é o maior cômodo da propriedade. <br>
4 - US-0004: Determinar a área de cada cômodo. <br>

O projeto tem padrões de qualidade muito elevado, uma vez que as transações de dinheiro realizadas são valores relativamente altos. Por questão de segurança foi estabelecido uma série de validações necessárias:

Campo nome Casa: <br>
1 - O campo não está vazio. <br>
2 - Comece com uma letra maiúscula. <br>
3 - Comprimento máximo de 30 caracteres.<br>

Campo bairro: <br>
1 - O campo não está vazio. <br>
2 - Comprimento não pode exceder de 45 caracteres. <br>

Campo Valor por metro Bairro: <br>
1 - O campo não está vazio. <br>
2 - Comprimento máximo de 30 caracteres. <br>

Campo Nome comodos: <br>
1 - O campo não está vazio. <br>
2 - O nome deve começar com uma letra Maiúscula. <br>
3 - Comprimento máximo de 30 caracteres. <br>

Campo largura do Comodo:  <br>
1 - O campo não está vazio. <br>
2 - Largura máxima de 25 metros. <br>

Campo comprimento Comodo: <br>
1 - O campo não está vazio. <br>
2 - Largura máxima de 33 metros. <br>

## Testes Unitários

### Situações de entrada
```sh
1 - Verifique se o total de metros quadrados calculados por propriedade está correto.

2 - Verifique se o bairro de entrada existe no repositório de bairros.

3 - Verifique se o maior cômodo foi realmente devolvido.

4 - Verifique se de fato o total de metros quadrados por cômodo está correto.
```
### Retornos
```sh
1 - Retorna o cálculo correto do total de metros quadrados de uma propriedade.

2 - Se cumprir: Permite continuar normalmente.
    Se não cumprir: Relate a incompatibilidade com uma exceção.

3 - Retorna o cômodo com o maior tamanho

4 - Retorna o cálculo correto do total de metros quadrados de um cômodo.
```

***
## Utilização
#### -> [Link para importar Collection](https://www.getpostman.com/collections/4c132e593eff4288e660) para o Postman (copiar e colar)
#### —> [Definições](https://drive.google.com/file/d/11nxa2r9uXn8GwaK1F0onKU7ZcfmGFZRD/view) a serem seguidas para completar o desafio.
```sh
POST/GET base -> http://localhost:8080/bairros
POST/GET base -> http://localhost:8080/casas
```

## Repositórios da Equipe 9
<b>Felipe Pereira Bontempo</b>
<br>[Repositório Git](https://github.com/fpbontempo)

<b>Fernando José Dias Netto</b>
<br>[Repositório Git](https://github.com/netto-meli)

<b>Leonardo Teixeira Assunção</b>
<br>[Repositório Git](https://github.com/LeoDevMeli)

<b>Marcos Vinicius Rodrigues De Sá</b>
<br>[Repositório Git](https://github.com/marcossa01)

<b>Rafael Menezes Da Silva</b>
<br>[Repositório Git](https://github.com/rafaelmenez)

## Meli Bootcamp IT - Wave 4
[Playground](https://br-playground.digitalhouse.com/login) - Digital House
<br>[Workplace](https://meli.workplace.com/) - Mercado Livre
