# Desafio CRUD

Desafio de criar um WebService para realizar as operações de CRUD

## Inicio

O projeto deverá rodar em uma máquina linux.

### Prerequisitos

Servidor linux (qualquer distribuição)
Java 1.8
Database postgreSql 9.1
Wildfly 10.1.0
Plugin google chrome Advanced REST client
### Instalação

- O projeto deverá ser feito o deploy do arquivo DesafioCRUD.war em uma instância do wildfly
- É necessário criar uma dataBase com o nome desafioCRUD com usuario:teste, senha teste( caso deseja pode ser criado com outro usurio ou senha porém deverá alterar os dados no arquivo hibernate.cfg.xml)


## Iniciar e teste

O arquivo contendo o Wildfly deverá se extraído e iniciado como domain
Exemplo: rodar o arquivo domain.sh que está localizado no diretório /bin do wildfly 

Para o teste será necessário a utilização da extenção do navegador google chrome Advanced REST client nele poderá ser realizado todas as operações de CRUD



## Built With

* [http://hibernate.org/) - database FrameWork utilizado
* [Maven](https://maven.apache.org/) - Gerenciamento de dependência
* [https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo) - Ferramenta para testes.


## Autor
 - Juliano Razzo  https://github.com/jrmetal
