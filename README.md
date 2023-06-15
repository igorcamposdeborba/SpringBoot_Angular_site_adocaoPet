# Adocaopet
Site disponível em: https://adocaopet.vercel.app/

==================
PROGRAMAS PADRÃO:
- Instalar NPM
npm install -g npm@latest

- Instalar Node última versão
https://nodejs.org/en/download

- Instalar NVM (Para mudar  versão do Node em tempo de execução)
Download e instale nvm-setup.exe no link https://github.com/coreybutler/nvm-windows/releases

- Instalar node na versão 12.14.1
nvm install 12.14.1

- Usar o node na versão 12.14.1
nvm use 12.14.1

- Instalar plugin no Chrome ou edge para aceitar CORS origin em servidor local E ativar plugin clicando nele:
https://chrome.google.com/webstore/detail/allow-cors-access-control/lhobafahddgcelffkeicbaginigeejlf/related?hl=pt

- Instalar  MySQL Community Server 5.7.41 (GPL)
https://dev.mysql.com/downloads/mysql/

- Instalar CLI do Eclipse Spring Tool Suite 4: 
https://spring.io/tools

- Instalar Java JDK 11:
https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html

- Instalar Postman:
https://www.postman.com/downloads/

____________________
Como executar:
ANGULAR:
- Iniciar Angular liberando o CORS Origin
ng serve --proxy-config proxy.config.js

- Acessar site:
http://localhost:4200/
OU
https://adocaopet.vercel.app/

_____________________
Como executar:
SPRING BOOT e MYSQL:

- Iniciar MySQL Workbench:
criar banco de dados:
> nome: root
> senha: 123456
> path e porta: 127.0.0.1:3306

- Iniciar Spring Boot:
Clicar na seta verde em qualquer arquivo aberto do projeto.

- Testar endpoints pelo postman (colocar url na requisição e texto do body no campo body): 
> GET: PET+ONG - findAll
https://adocao-pet-backend-production.up.railway.app/catalog

> GET: PET+ONG - findById
https://adocao-pet-backend-production.up.railway.app/catalog/pets/1

> POST: ADOPTER - create/edit adopter and adopt pet
https://adocao-pet-backend-production.up.railway.app/adotante/4
Body: {
    "name": "Igor Campos de Borba",
    "email": "igor@hotmail.com",
    "telephone": "5551987874589"
}