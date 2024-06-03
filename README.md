# Kotlin Learn With Spring


This project Learn Kotlin with Spring for back-end API REST...


- Run Project in

```
  /src/main/kotlin/com.example.hamburger/Main.tk
```

### Method 
> POST /v1/alimento
```json
    {
      "nome": "string",
      "descricao": "string",
      "valor": "Long",
      "categoria": "string"
    }
```

> GET **/V1/alimento** Get all _alimento_

> GET **/V1/alimento/{name} | {id}**
> Get filtered _alimento_

> PUT  /v1/alimento/{id}

> DELETE /v1/alimento/{id}