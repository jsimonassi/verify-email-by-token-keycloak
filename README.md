Keycloak Provider: Verificador de e-mails por token
=============================
Um provider do keycloak adiciona novas funcionalides ao keycloak através da implementação de interfaces.

Este projeto possui o source code referente ao verificador de e-mail utilizado pela Technos. 
Note que no momento em que esse verificador foi implementado, existia a necessidade de se manter 
os dois padrões de validação disponíveis: Via Token e Via link.

Este projeto implementa a interface ```AdminRealmResourceProvider``` e ```AdminRealmResourceProviderFactory``` que, em conjunto, permitem a classe que as implementa adicionar novos endpoints ao keycloak e fazer o consumo dos dados de autenticação.


## Utilizando o artefato .jar

Para que o artefato esteja disponível, adicione o arquivo compilado .jar (Veja nas seções abaixo como gerar, caso não esteja disponível) a pasta providers do keycloak.
Se estiver utilizando o keycloak em modo standalone, basta adicionar diretamente na pasta providers.

Se estiver utilizando o projeto no keycloak do backend Technos, adicione ao Dockerfile do repositório smart-keycloak a referência de cópia para seu projeto. 
Exemplo:

```
COPY "./providers/verify-email-by-token-provider-1.2.jar" "/opt/keycloak/providers/verify-email-by-token-provider-1.2.jar"
```



<hr/>

## Endpoints disponíveis:

### POST - `{keycloakUrl}/admin/realms/{realmName}/verify-email-by-token/send`

Body da requisição:

```
{
    "email": "emailDoUsuario@email.com"
}
```

Response code:

200 - Email enviado com sucesso;

404 - Usuário não encontrado;


<hr/>

### GET - `{keycloakUrl}/admin/realms/{realmName}/verify-email-by-token/validate`

Query params:

token: ` Token enviado pelo usuário`

email: `email do usuário`

Response code:

200 - Email enviado com sucesso;

404 - Usuário não encontrado;


## Pré-requisitos para compilação

- Java 17.0 + Mvn;


## Compilando o projeto

Obs: É altamente recomendado utilizar o inteliJ IDE para facilitar a compilação e desenvolvimento.


No inteliJ, na aba direita, execute a task maven

```clean```

e em seguida execute a task maven

```package```


Em ./target será criado um arquivo .jar com o código compilado.

Altere o arquivo pom.xml para definições de versão.


OBS:

O arquivo ```VerifyEmailByTokenProviderFatory``` implementa a string ID. Esta string é utilizada na url dos endpoints. Ao alterar este valor, alterar também os clientes que consumem esses endpoints.