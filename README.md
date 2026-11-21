# Semestre 404

## Tecnologias
* Godot 4 - interface gráfica, cenas, personagens, diálogos, animações, escolhas e áudio
* Java + Spring Boot - API REST, regras de negócio, gerenciamento de usuários e progresso do jogo
* JUnit 5 - testes unitários das classes e regras de negócio do backend Java
* MySQL - armazenamento de usuários, personagens, escolhas e progresso

Outras tecnologias:
* JPA - mapeamento das classes Java para tabelas do MySQL
* HTTP / JSON - comunicação entre Godot e Spring Boot
* Git + GitHub - versionamento e colaboração do grupo

## Estrutura do repositório:

model/ - representação dos elementos, classes que representam objetos e conceitos do jogo
service/ - regras e funcionamento do jogo, classes responsáveis pelas operações e regras de negócio como atualizar atributos e processar dialogos
repository/ - comunicação com o MySQL
controller/ - comunicação com o frontend
dto/ - transferencia de dados
exception/ - tratamento de erros
test/ - testes unitários

## Autores
Este projeto foi desenvolvido por:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/biancassza">
        <img src="https://github.com/biancassza.png" width="100px;" style="border-radius: 50%;"/><br>
        <sub><b>Bianca Karolinne</b></sub>
      </a><br>
      <sub>Desenvolvedor</sub>
    </td>
    <td align="center">
      <a href="https://github.com/juliocesar-candido">
        <img src="https://github.com/juliocesar-candido.png" width="100px;" style="border-radius: 50%;"/><br>
        <sub><b>Júlio Cândido</b></sub>
      </a><br>
      <sub>Desenvolvedor</sub>
    </td>
    <td align="center">
      <a href="https://github.com/rafaalathais">
        <img src="https://github.com/rafaalathais.png" width="100px;" style="border-radius: 50%;"/><br>
        <sub><b>Rafaela Thaís</b></sub>
      </a><br>
      <sub>Desenvolvedor</sub>
    </td>
  </tr>
</table>

## Como compilar e rodar
./mvnw.cmd spring-boot:run -Dspring-boot.ru
n.profiles=local
