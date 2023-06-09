# Adocaopet

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

____________________
ANGULAR:
- Instalar Angular por linha de comando:
npm install -g @angular/cli@12.0.3
OU
npm install -g @angular/cli@latest

- Novo projeto Angular (sem arquivos de teste)
ng new adocaopet --minimal

- Iniciar Angular
ng serve
OU se estiver rodando localmente (localhost) - neste projeto é opcional porque eu implementei p/ aceitar CORS origin no Angular e Spring:
ng serve --proxy-config proxy.config.js

_____________________
ANGULAR GERAR COMPONENTES:
- Criar Componente:
ng generate component components/nav

- Criar Service:
ng generate service services/pet
