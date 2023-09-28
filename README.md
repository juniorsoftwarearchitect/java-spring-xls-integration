# Índice

1. [Requisitos de Desenvolvimento](#requisitos-de-desenvolvimento )
2. [Rodando a aplicação em Desenvolvimento](#rodando-a-aplicacao-em-desenvolvimento )
3. [Instalando serviço pelo System V Init](#Instalando-servico-pelo-system-v-init)
4. [Arquitetura Hexagonal](#arquitetura-hexagonal)

## Requisitos de Desenvolvimento

| Descrição     | Versão			  | 
|---------------|-------------------|
| Java OpenJDK  | 17                |
| Gradle        | 8.2.1 ou superior |


## Instalação - Desenvolvimento

Faça o pull do repositório e no diretório principal execute `./gradlew clean build` . O gradlew irá baixar o gradle em seu PC  e executar a construção do projeto.


## Rodando a aplicação em Desenvolvimento

Apoś fazer a construção do projeto execute `./gradlew bootRun` . O gradlew irá roda a aplicação executando o liquibase para criar as tabelas em memória no banco de dados H2.



## Instalando serviço pelo System V Init

Para instalar a API como um serviço `init.b`, crie um link simbólico da seguinte forma;
```
$ sudo ln -s /home/user/deploy/integration-xls.jar /etc/init.d/integration-xls
```

Para instalar o link de script de inicialização:

```
$ update-rc.d integration-xls defaults
```
Com o serviço instalado podemos utilizar os comandos  **start**,  **stop**,  **restart**  e  **status**  para manipulação a API

```
$ service integration-xls start | stop | restart | status
```


## Arquitetura Hexagonal

Desenvolvimento usa conseito de arquiteura hexagonal, para que seja possivel reaproveitar dominio e controle em demais aplicações.
![enter image description here](https://media.licdn.com/dms/image/D4D12AQFk-Y2UTErkkA/article-inline_image-shrink_1500_2232/0/1684756885462?e=1701302400&v=beta&t=JRH5_ahwhatS8IdsJKrAkEXfhHRucJQSdo6dCByR0N4)
Créditos da imagem - reflectoring.io

Para mais informações sobre a arquitetura hexagoanl acesse: https://reflectoring.io/spring-hexagonal/