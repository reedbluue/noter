# Noter 📝

> Escolha um nome e comece a anotar!

Noter é um sistema abrangente de gerenciamento de documentos projetado para ajudá-lo a organizar e
editar seus documentos sem esforço. Com sua interface amigável e recursos facilitadores, o Noter
simplifica a maneira como você lida com seus documentos, seja para trabalho, estudo ou uso pessoal.

## Funcionalidades

✨ **Acesso sem Esforço**: Basta inserir o nome do documento para acessar/editar o seu conteúdo.

📝 **Editor de Markdown**: Edite seus documentos com facilidade usando o editor Markdown integrado do
Noter.

🔄 **Atualizações em Tempo Real**: Experimente atualizações em tempo real perfeitas ao colaborar em
documentos com outras pessoas.

## Como Começar

Para começar com o Noter, siga estas etapas simples:

### Backend

1. **Clonar o Repositório**: Clone o repositório do Noter em sua máquina local.

```
git clone https://github.com/reedbluue/noter.git
```

2. **Construir e Executar o Backend**: Navegue até o diretório do projeto backend e execute o
   seguinte comando para construir e executar o backend.

```
cd noter-backend
docker build -t noter-backend .
docker run -p 8081:8081 --env-file .env noter-backend
```

Certifique-se de configurar suas variáveis de ambiente no arquivo `.env` para configurar o banco de
dados, se necessário.

### Frontend

3. **Instalar Dependências**: Navegue até o diretório do projeto frontend e instale as dependências
   necessárias.

```
cd ../noter-frontend
npm install
```

4. **Construir e Executar o Frontend**: Execute o seguinte comando para construir e executar o
   frontend.

```
npm run build
docker build -t noter-frontend .
docker run -p 80:80 noter-frontend
```

## Variáveis de Ambiente

As seguintes variáveis de ambiente podem ser configuradas no arquivo `.env` para configurar o banco
de dados:

- `DB_USER`: Nome de usuário do banco de dados.
- `DB_PASSWORD`: Senha do banco de dados.
- `DB_HOST`: Host do banco de dados.
- `DB_PORT`: Porta do banco de dados.
- `DB_NAME`: Nome do banco de dados.

## Screenshots

![Noter Homepage](https://example.com/noter-homepage.png)
*Figura 1: Página Inicial do Noter*

![Noter Document Editor](https://example.com/noter-editor.png)
*Figura 2: Editor de Documentos do Noter*

## Tecnologias Utilizadas

- **Backend**: Java, Spring Boot
- **Frontend**: React, TypeScript
- **Banco de Dados**: PostgreSQL
- **Contêiner**: Docker
- **Implantação**: Amazon Corretto, NGINX

## Contribuições

Contribuições são bem-vindas! Se você tiver alguma sugestão, relatório de bug ou solicitação de
recurso, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o
arquivo [LICENSE](https://github.com/reedbluue/noter/blob/main/LICENSE) para obter detalhes.