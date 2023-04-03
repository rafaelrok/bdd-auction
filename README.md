<h2 align="center"> 
  Projeto: BDD-Auction
</h2>


<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->

<p align="center">
      <img alt="GitHub language count" src="https://img.shields.io/github/languages/top/rafaelrok/movieflix">
     <a href="https://github.com/bdd-auction/README.md/commits/master">
      <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/rafaelrok/bdd-auction">
     </a>
     <a href="https://github.com/rafaelrok/bdd-auction/blob/main/LICENSE">
      <img alt="License" src="https://img.shields.io/github/license/rafaelrok/bdd-auction">
     </a>  
     <a href="https://github.com/rafaelrok/README-ecoleta/stargazers">
      <img alt="Stargazers" src="https://img.shields.io/github/stars/rafaelrok/bdd-auction?style=social">
     </a>
     <a href="https://medium.com/@rafael">
      <img alt="medium" src="https://img.shields.io/twitter/url?label=Medium&logo=medium&style=social&url=https%3A%2F%2Fmedium.com%2F%40rafael.">
     </a>
  </p>

---
> Este projeto apresenta uma solução de "Leilão" em Java com Spring Boot e ênfase em testes utilizando Cucumber com BDD 
> seria uma aplicação que permitiria aos usuários participar de leilões de produtos ‘online’. A aplicação seria desenvolvida 
> usando a arquitetura RESTful, onde os usuários poderiam acessar a aplicação através de uma API.


---
#### BDD Fluxo:
A ideia desse projeto e demontrar a utilização do BDD (Behavior Driven Development) com Cucumber para enfatiza a colaboração e a comunicação 
entre as equipes de desenvolvimento, testes e negócios para garantir que o ‘software’ atenda às expectativas dos usuários e clientes. 
O Cucumber é uma ferramenta de automação de testes que permite a escrita de cenários de teste numa linguagem natural, permitindo que 
as equipes de negócios e testes se comuniquem com os desenvolvedores de forma mais eficaz. A imagem pode demostrar um pouco do fluxo de BDD e comparação com TDD.


<img src="https://res.cloudinary.com/dkar9uu7g/image/upload/v1680209132/rafaelvieira-dev/blog/posts/Fluxo_BDD_2x_kzqkvo.png">

---

### Implementação:
#### A aplicação teria as seguintes funcionalidades:
* Cadastro de usuários: os usuários poderiam criar uma conta na aplicação para participar de leilões.
* Cadastro de produtos: os usuários poderiam cadastrar produtos para leilão, incluindo uma descrição do produto, o preço inicial e o tempo de duração do leilão.
* Participação em leilões: os usuários poderiam participar de leilões, fazer lances e acompanhar o progresso do leilão.
* Finalização de leilões: quando o tempo de duração do leilão expirar, o produto será vendido ao usuário que fez o lance mais alto.

---
## Estrutura de testes: 

Para implementar a aplicação, seria utilizado o framework Spring Boot, que permite o desenvolvimento rápido e fácil de aplicações web em Java. Para os testes, seria utilizado o Cucumber com BDD, que é uma ferramenta que permite escrever testes em linguagem natural e executá-los automaticamente.

O projeto seria dividido em camadas, seguindo uma arquitetura MVC (Model-View-Controller), onde a camada de modelo seria responsável pelo acesso aos dados, a camada de visualização seria responsável pela interface do usuário e a camada de controle seria responsável pela lógica de negócios.

Os testes seriam escritos em linguagem natural usando o formato Gherkin, sendo uma linguagem que descreve o comportamento esperado da aplicação. Os cenários seriam escritos em arquivos .feature, que descrevem o comportamento da aplicação em termos de requisitos de negócios. Cada cenário seria composto de passos, que seriam executados automaticamente pelo Cucumber.

Para a execução dos testes, seria utilizado o JUnit, um framework de teste para Java. O Cucumber seria integrado ao JUnit, permitindo a execução dos testes automaticamente.

---
#### Alguma das Vantegenns do BDD com Cucumber:


 >1- Comunicação eficaz: O Cucumber permite que as equipes de negócios e testes escrevam cenários de teste numa linguagem natural, tornando a comunicação mais fácil e eficaz entre as equipes.

 >2- Foco nos comportamentos do sistema: O BDD enfoca o comportamento do sistema e não apenas as funções ou recursos. Isso ajuda as equipes a entenderem melhor o que o sistema deve fazer e o que não deve fazer.

 >3- Testes automatizados: com o Cucumber, é possível criar testes automatizados que verificam se o sistema se comporta conforme as expectativas dos usuários e clientes. Isso ajuda a reduzir o tempo e os custos associados à execução de testes manuais repetitivos.

 >4- Reutilização de código: O Cucumber permite a reutilização de código entre cenários de teste, ajudando a reduzir a duplicação de esforços e a manter os testes mais organizados e fáceis de gerenciar.

 >5- Integração com outras ferramentas: O Cucumber pode ser facilmente integrado com outras ferramentas de desenvolvimento, como o Maven e o Jenkins, o que ajuda a automatizar todo o processo de construção e teste.

 >6-Documentação viva: com o Cucumber, os cenários de teste servem como documentação viva do sistema e ajudam a manter todos os envolvidos no projeto atualizados sobre o comportamento do sistema.

 >7- Foco no valor para o negócio: O BDD enfatiza o valor para o negócio e ajuda a garantir que o software entregue atenda às expectativas do cliente e gere valor real para o negócio.

 >8-Facilidade de manutenção: com o Cucumber, os cenários de teste são escritos numa linguagem natural, facilitando para as equipes de desenvolvimento e testes manterem e atualizarem os testes ao longo do tempo.

 >9- Feedback rápido: O BDD com Cucumber permite a execução rápida de testes automatizados, permitindo que as equipes obtenham feedback imediato sobre a qualidade do software.

 >10- Cobertura abrangente de testes: com o Cucumber, é possível criar testes abrangentes que cobrem todos os aspectos do sistema, incluindo os casos de borda e as interações entre os diferentes componentes.

 >11- Melhoria da qualidade do código: O BDD com Cucumber incentiva o uso de boas práticas de programação, como o desenvolvimento orientado a objetos (OO) e o design pattern, o que ajuda a melhorar a qualidade do código entregue.

 >12- Melhoria da colaboração: O BDD com Cucumber enfatiza a colaboração entre as diferentes equipes envolvidas no desenvolvimento do software, o que ajuda a melhorar a qualidade do software entregue e a reduzir os conflitos entre as equipes.

## Utilizando `BDD-Auction`

Para Utilizar o projeto `BDD-Auction`, após o procedimento acima, siga estas etapas:

* Abra o terminal e utilize o `git clonegit@github.com:rafaelrok/bdd-auction.git`

#### Siga estas etapas:

```
- Após execute o projeto com sua IDEA de preferência.

- Devera configurar o aplications-test.properties | aplications-prod.properties e informar as configurações de seu banco H2 ou DB em ambiente Dev.

- Após só executar sua apliacação com spring-boot:run
```
- Link para documentação do [Cucumber](https://cucumber.io/docs/cucumber/).
- Link para documentação do [Selenium](https://www.selenium.dev/pt-br/documentation/).

Com o Cucumber, é possível criar cenários de teste em linguagem natural que descrevem o comportamento esperado do software e, em seguida, traduzi-los em código de teste que pode ser executado automaticamente. Isso ajuda a garantir que o software esteja funcionando corretamente e de acordo com as especificações do cliente.

O Cucumber é uma ferramenta de código aberto que pode ser usada em vários idiomas de programação, como Java, Ruby, Python e JavaScript, e é suportado por muitas ferramentas de teste populares, como o Selenium WebDriver e o Appium. Ele é amplamente utilizado em projetos de software em todo o mundo e é considerado uma das principais ferramentas de automação de teste de software no mercado atualmente.

## Desenvolvedor
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/8467131?v=4" width="100px;" alt="Foto do Rafael Vieira no GitHub"/><br>
        <sub>
          <b>Rafael Vieira</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
<table>
  <tr>
    <a href="https://www.linkedin.com/in/rafaelvieira-s/">
      <img alt="linkedin" src="https://img.shields.io/twitter/url?label=Linkedin&logo=linkedin&style=social&url=https%3A%2F%2Fwww.linkedin.com%2Fin%2Frafaelvieira-s%2F">
    </a>
    <a href="https://medium.com/@rafael">
      <img alt="medium" src="https://img.shields.io/twitter/url?label=Medium&logo=medium&style=social&url=https%3A%2F%2Fmedium.com%2F%40rafael.">
    </a>
    <a href = "mailto:rafaelrok25@gmail.com">
      <img alt="gmail" src="https://img.shields.io/twitter/url?label=gmail&logo=gmail&style=social&url=https%3A%2F%2Fmail.google.com%2F">
    </a>
  </tr>
</table>


## 📝 Licença

Esse projeto está sob licença. Observe o arquivo [LICENÇA](LICENSE.md) para mais detalhes.


[⬆ Voltar ao topo](#bdd-auction)<br>
