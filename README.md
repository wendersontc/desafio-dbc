# Desafio

## Como executar
Clone o Projeto para um diretório qualquer em seu computador

```bash
git clone https://github.com/wendersontc/desafio-dbc.git
```

Depois navegue até o diretório criado
```bash
cd desafio-dbc
```

### Com Docker
É necessário instalar em sua maquina:
- [Docker](https://www.docker.com/) 

Execute o comando:
```bash
docker-compose up
```

### Sem Docker
É necessário instalar em sua maquina:
- [Apache Maven](https://maven.apache.org/)

Execute o comando:
```bash
mvn spring-boot:run
```

## Como acessar
Uma vez que o projeo esteja rodando corretamente, abra seu navegador e acesso a url
```
http://localhost:8286/ws-dbc/api/swagger-ui.html
```

Uma inteface do Swagger será exibida para que você possa navegar entre os endpoint criados

## Sobre o Desafio
- Questão 1: Pode ser validada através do metodo GET /linhas/findAll em azul no Swagger
- Questão 1: Pode ser validada através do metodo GET /itinerarios/{id} em azul o Swagger
- Questão 2: Pode ser validada através do metodo GET /linhas/nome/{nome} em azul no Swagger
- Questão 3: Pode ser validada através do controller de clientes
- Questão 4: Pode ser validada através do metodo GET/itinerarios/{unit}/{lat}/{lng}/{unit}" em azul no Swagger
- Questao 6: Para documentar a API foi utilizado o swagger e algumas justificativas, se encontram no arquivo doc.pdf no contexto da aplicação
