# FiadoPay-POO - Refatoração de API com base em engenharia 

Para assegurar as melhores práticas de desenvolvimento, fizemos uma refatoração do projeto fiadopay, que é um sistema 
financeiro baseado em controle de transações e reembolsos. 

## Design Patterns Aplicados

* Strategy -
* Chain of Responsibility - 
* Observer - 
* State - Utilizado para intercambiar entre estados de pagamento (Pending, Approved, )


## Anotações Customizadas e metadados

* @PaymentMethod -
* @AntiFraud -
* @WebhookSink -
* @CurrencyType -  

Anotações próprias do springboot, como @Component, @Service, @Repository foram utilizadas a fim de injeção de dependências, 
garantindo o funcionamento íntegro da aplicação. 

## Mecanismo de Reflexão 

## Threads

## Limites Conhecidos 

## Como Utilizar

clone o repositório:

```bash
git clone https://github.com/mafenandaup/FiadoPay-POO.git
```

Mude o diretório para a pasta principal do projeto

```bash
cd api-fiadopay
```

```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

Acione o seguinte comando no terminal da IDE:
```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

H2 console: http://localhost:8080/h2  
Swagger UI: http://localhost:8080/swagger-ui.html

## Fluxo

1) **Cadastrar merchant**
```bash
curl -X POST http://localhost:8080/fiadopay/admin/merchants   -H "Content-Type: application/json"   -d '{"name":"MinhaLoja ADS","webhookUrl":"http://localhost:8081/webhooks/payments"}'
```

2) **Obter token**
```bash
curl -X POST http://localhost:8080/fiadopay/auth/token   -H "Content-Type: application/json"   -d '{"client_id":"<clientId>","client_secret":"<clientSecret>"}'
```

3) **Criar pagamento**
```bash
curl -X POST http://localhost:8080/fiadopay/gateway/payments   -H "Authorization: Bearer FAKE-<merchantId>"   -H "Idempotency-Key: 550e8400-e29b-41d4-a716-446655440000"   -H "Content-Type: application/json"   -d '{"method":"CARD","currency":"BRL","amount":250.50,"installments":12,"metadataOrderId":"ORD-123"}'
```

4) **Consultar pagamento**
```bash
curl http://localhost:8080/fiadopay/gateway/payments/<paymentId>
```