# Sistema de Controle de Epidemias

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

Este projeto é um sistema construído usando Java e MySQL como banco de dados.

O sistema tem como objetivo apresentar um sistema de prevenção, controle e acompanhamento de epidemias na região de São Paulo, para melhor monitoramento e tratamento de casos epidemiológicos que podem aumentar a sua escala de forma rápida, para que sejam combatidos logo no seu início.

Os algoritmos desenvolvidos em Java nesse programa servem para interagir com um banco de dados. Ele fornece uma interface para inserir, alterar e excluir informações sobre doenças e cidades comparando-as.

## Índice

- [Pré Requisitos](#pré-requisitos)
- [Configuração](#configuração)
- [Instruções de Uso](#instruções-de-uso)
- [Contribuindo](#contribuindo)

## Pré Requisitos

1. Apaque Netbeans IDE 16
2. MySQL Workbench 8.0
3. Wampserver

## Configuração

1. Abra o Wampserver e certifique que todos os serviços estão sendo executados
2. Abra o MySQL Workbench e execute o script "BANCO DE DADOS.sql"
3. Abra o Netbeans e importe o driver de conexão com o banco de dados "DRIVER CONEXÃO"
4. O sistema está pronto para uso!

## Instruções de Uso
1. Ao executar o sistema irá iniciar a tela de "Doença", aonde existirá os campos a serem preenchidos.
2. Após preencher os campos, clica-se no icone de inserir
3. Após inserir, a tabela abaixo dos campos será atualizada automaticamente.
4. Com a tabela atualizada é possivel alterar ou deletar, apenas clicando na tabela qual Doença deseja alterar ou excluir.
5. Também há um botão de limpar os campos, caso seja necessário.
6. A segunda tela de "Cidades" se comporta da mesma forma citada acima.
7. A terceira tela de "Relatório", vai possuir uma lista suspensa aonde o usuário irá selecionar o tipo de comparação que deseja fazer e após selecionar a tabela será inserida com a comparação desejada.

## Contribuindo

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, abra um problema ou envie uma solicitação de pull para o repositório.

Ao contribuir para este projeto, siga o estilo de código existente, as convenções de commit e envie suas alterações em um branch separado.



