# Desafio CRUD

Desafio de criar um WebService para realizar as operações de CRUD

## Início

O projeto deverá rodar em uma máquina linux.

### Pre-requisitos

- Servidor linux (qualquer distribuição)
- Java 1.8
- Database postgreSql 9.1
- Wildfly 10.1.0
- Plugin google chrome Advanced REST client

### Instalação

- No projeto deverá ser feito o deploy do arquivo DesafioCRUD.war em uma instância do wildfly
- É necessário criar uma dataBase com o nome desafioCRUD com usuário: teste, senha: teste( caso desejar pode ser criado com outro usuário ou senha porém deverá alterar os dados no arquivo hibernate.cfg.xml)


## Iniciar e teste

- O arquivo contendo o Wildfly deverá ser extraído e iniciado como domain
- Exemplo: rodar o arquivo domain.sh que está localizado no diretório /bin do wildfly 

- Para o teste será necessário a utilização da extenção do navegador google chrome Advanced REST client nele poderá ser realizado todas as operações de CRUD
- Urls para acesso aos serviços http://localhost:8280/DesafioCRUD/restUsuario/usuario http://localhost:8380/DesafioCRUD/restUsuario/usuario


## Built With

* [http://hibernate.org/) - database FrameWork utilizado
* [Maven](https://maven.apache.org/) - Gerenciamento de dependência
* [https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo) - Ferramenta para testes.


## Autor
 - Juliano Razzo  https://github.com/jrmetal
