# FakeNewsDetector

## Descri��o do Projeto
Este projeto tem como objetivo realizar uma compara��o entre textos digitados pelo usu�rio, ou pego aleatoriamente do site da globo, e compar�-los com um banco de fake news para determinar se o texto pode ser uma fake news ou n�o.
## Pr�-Requisitos
Java SE 17 ou mais recente.
JavaFX sdk18 ou mais recente.
## Como compilar e rodar
Com o projeto aberto no Eclipse, utilize o bot�o direito do mouse em cima da pasta principal do projeto e seleciona a op��o de exportar, na aba de op��es escolha a pasta java e selecione o runnable JAR File, no launch configure selecione a op��o da classe main, escolha o local do arquivo junto ao nome e clique em terminar. Pronto, agora voc� possui o execut�vel do projeto para rodar basta clicar no execut�vel. 
Tamb�m � poss�vel executar o programa diretamente do eclipse, ao executar a classe main.
Aten��o para o funcionamento do execut�vel garanta a utiliza��o da vers�o 17, ou superior, do javaruntime. Como também a atualização do VM argumemts, nas configurações de compilação, para '--module-path "SEU_CAMINHO\javafx-sdk-18.0.1\lib" --add-modules javafx.controls,javafx.fxml"
## .Como usar o programa
Ao executar o programa o usu�rio pode escolher entre digitar um texto direto na �rea de leitura, ou  utilizar o bot�o de pesquisar e pegar uma not�cia dentro do site da globo, em seguida ele deve selecionar o m�todo de compara��o e clicar no bot�o de compara��o onde ser� aberto uma janela informando se a not�cia � fake ou n�o.
