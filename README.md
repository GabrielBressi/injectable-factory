# Injectable Factory
Injectable Factory é um projeto de estudo centrado no Design Pattern Factory Method, e leva essa nome por trabalhar com injeção de dependêcia juntamente com o Pattern. Aqui, uma factory é desenvolvida para gerenciar formas de pagamento. Quando uma forma de pagamento é selecionada via API, a Factory entra em ação, validando e identificando o tipo de pagamento, e posteriormente instanciando a classe correspondente. As classes concretas não possuem lógica de pagamento, servindo apenas para registro de logs. Este projeto tem como objetivo explorar e aplicar o Design Pattern Factory Method em um contexto específico de gestão de formas de pagamento, destacando a separação de responsabilidades e a flexibilidade na criação de instâncias baseadas em tipos determinados.

## Pré-requisitos
- Java 17 ☕
- Spring Boot 3.3.2 🍃
- Maven ou Gradle

## Configuração do Projeto

1. Clone o repositório:

```bash
git clone https://github.com/GabrielBressi/injectable-factory
```
Importe o projeto em sua IDE favorita.

Certifique-se de que as dependências do Maven/Gradle estejam atualizadas.
Execute a aplicação Spring Boot.

### Uso
Acesse a API RESTFul conforme descrito na documentação.
API Endpoints
```bash
POST /api/payments/makePayment - Request a body with two attributes: amount and paymentMethod
The available Payment methods are :
CREDIT_CARD,
PAYPAL,
GOOGLE_PAY

which is declared in PaymentMethod Enum.
```

example:<br/>
![image](https://github.com/GabrielBressi/injectable-factory/assets/62081443/0680c1bb-3bcd-46e4-b61a-32d3122ec4e7)

### Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir um PR para melhorias, correções de bugs ou novos recursos.
