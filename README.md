# Calculadora Kotlin com Exp4j

Este projeto é uma **calculadora desenvolvida em Kotlin** que utiliza a biblioteca **Exp4j** para processar expressões matemáticas complexas, incluindo o uso de parênteses e outras operações matemáticas. A calculadora foi projetada para ser simples de usar, com uma interface intuitiva para realizar cálculos rápidos e precisos.

## Link para o vídeo explicativo:
[Vídeo explicativo sobre o projeto e a calculadora](https://youtu.be/x_y9hlbRL_g)

## Funcionalidades:
- Realiza cálculos com expressões numéricas.
- Suporta operações matemáticas como adição, subtração, multiplicação, divisão, seno, cosseno, tangente, e mais.
- Utiliza a biblioteca **Exp4j** para lidar com parênteses e expressões complexas.
- Suporte para valores em graus ou radianos (para funções trigonométricas).

## Instalação e Configuração da Biblioteca Exp4j

A biblioteca **Exp4j** é usada para fazer o parser e cálculo de expressões matemáticas. Para adicioná-la ao seu projeto Kotlin, siga as etapas abaixo:

1. **Abra o arquivo `build.gradle.kts (Module: app)`**:
   - Navegue até a pasta "Gradle Scripts" no seu projeto Android.
   - Encontre e abra o arquivo `build.gradle.kts` que está no módulo `app`.

2. **Adicione a dependência da biblioteca Exp4j**:
   - Dentro do arquivo, localize a chave `dependencies {}`.
   - Dentro da chave `dependencies`, adicione a seguinte linha:

     ```kotlin
     implementation("net.objecthunter:exp4j:0.4.8")
     ```

3. **Sincronize o projeto**:
   - Após adicionar a dependência, o Android Studio mostrará uma **lâmpada vermelha** ao lado da linha onde você fez a alteração.
   - Clique na lâmpada vermelha e escolha **"Sync"** para sincronizar o projeto e realizar o download da biblioteca.

Isso permitirá que o Exp4j seja integrado ao seu projeto para resolver expressões matemáticas.

## Como usar a Calculadora

1. **Interface**: A interface da calculadora foi projetada para ser simples, com botões para cada número, operação matemática e funções trigonométricas.
2. **Inserção de Expressões**: O usuário pode inserir expressões diretamente, incluindo parênteses, e as operações serão calculadas corretamente.
3. **Funções Trigonométricas**: As funções trigonométricas, como `sen`, `cos`, `tan`, aceitam ângulos em **graus** ou **radianos**, dependendo da configuração.

## Como Funciona:

A calculadora utiliza a **Exp4j** para interpretar e calcular expressões matemáticas. Ela lê a expressão do usuário, faz a conversão necessária para a biblioteca, e então retorna o resultado calculado.

### Exemplo de uso:
- O usuário pode digitar uma expressão como `(5 + 3) * (2 / 4)` ou `sin(90)`.
- O Exp4j fará o cálculo da expressão levando em conta parênteses e a ordem correta das operações.

## Como Contribuir

Se você gostaria de contribuir com melhorias para este projeto, sinta-se à vontade para fazer um **fork** e enviar um **pull request**. Você pode ajudar com:

- **Melhorias na UI**.
- **Aprimoramento nas funcionalidades**.
- **Correções de bugs**.

## Licença

Este projeto é livre para uso e alteração
