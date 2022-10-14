# FakeNewsDetector

## Descrição do Projeto
Este projeto tem como objetivo realizar uma compara��o entre textos digitados pelo usu�rio, ou pego aleatoriamente do site da globo, e compar�-los com um banco de fake news para determinar se o texto pode ser uma fake news ou n�o.

## Pré-Requisitos
  Java SE 17 ou mais recente.
  JavaFX sdk18 ou mais recente.
  
## Como compilar e rodar
Com o projeto aberto no Eclipse, utilize o bot�o direito do mouse em cima da pasta principal do projeto e seleciona a op��o de exportar, na aba de op��es escolha a pasta java e selecione o runnable JAR File, no launch configure selecione a opção da classe main, escolha o local do arquivo junto ao nome e clique em terminar. Pronto, agora você possui o executável do projeto para rodar basta clicar no executável. 
Também é possível executar o programa diretamente do eclipse, ao executar a classe main.
Atenção para o funcionamento do executável garanta a utilização da versão 17, ou superior, do javaruntime. Como também a atualização do VM argumemts, nas configurações de compilação, para '--module-path "SEU_CAMINHO\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml"
## .Como usar o programa
Ao executar o programa o usuário pode escolher entre digitar um texto direto na área de leitura, ou  utilizar o botão de pesquisar e pegar uma notícia dentro do site da globo, em seguida ele deve selecionar o método de comparação e clicar no botão de comparação onde será aberto uma janela informando se a notícia é fake ou não.
