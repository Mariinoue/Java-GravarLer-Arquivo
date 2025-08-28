

---

## 📌 Explicação do Código `UsaDBSuper.java`

### 1. **Pacotes Importados**

```java
package br.com.fiap.main;

import br.com.fiap.bean.DragonBallSuper;
import javax.swing.*;
import java.io.IOException;
```

* `br.com.fiap.bean.DragonBallSuper`: Importa a classe **DragonBallSuper**, onde estão definidos os atributos e métodos de um personagem.
* `javax.swing.*`: Usado para criar **interfaces gráficas** com caixas de diálogo (`JOptionPane`).
* `java.io.IOException`: Tratamento de erros de entrada e saída de arquivos.

---

### 2. **Classe Principal**

```java
public class UsaDBSuper {
```

* É a **classe de teste** que contém o método `main`.
* Responsável pela interação com o usuário e manipulação de objetos da classe `DragonBallSuper`.

---

### 3. **Método `main`**

```java
public static void main(String[] args) {
```

* Ponto de entrada do programa.
* É aqui que a execução começa.

---

### 4. **Declaração de Variáveis**

```java
String nome, path;
int ki, tecnica, velocidade, transformacao;
int opcao;
DragonBallSuper personagem;
```

* `nome`, `path`: Strings para armazenar o **nome do personagem** e o **caminho da pasta**.
* `ki`, `tecnica`, `velocidade`, `transformacao`: Atributos numéricos do personagem.
* `opcao`: Controla o menu de opções (1 = cadastrar, 2 = procurar).
* `personagem`: Objeto do tipo **DragonBallSuper** (instância da classe).

---

### 5. **Laço `do...while`**

```java
do {
   ...
} while (JOptionPane.showConfirmDialog(...) == 0);
```

* Mantém o programa rodando enquanto o usuário quiser continuar.
* Exibe uma pergunta: "Deseja continuar?"

  * **Sim (0)** → repete.
  * **Não (1)** → encerra.

---

### 6. **Menu de Opções**

```java
opcao = Integer.parseInt(JOptionPane.showInputDialog(...));
personagem = new DragonBallSuper();
```

* O usuário escolhe:

  1. **Cadastrar personagem**
  2. **Procurar personagem**
* Em seguida, é criada uma **instância da classe** `DragonBallSuper`.

---

### 7. **Case 1 – Cadastrar um Personagem**

```java
personagem.setNome(nome);
personagem.setKi(ki);
personagem.setTecnica(tecnica);
personagem.setVelocidade(velocidade);
personagem.setTransformacao(transformacao);

JOptionPane.showMessageDialog(null, personagem.gravar(path));
```

* O usuário fornece os atributos do personagem.
* São usados **métodos setters** (`setNome`, `setKi`, etc.) para atribuir valores.
* O método `gravar(path)` salva os dados em um **arquivo `.txt`**.

---

### 8. **Case 2 – Procurar um Personagem**

```java
personagem.setNome(nome);
personagem = personagem.ler(path);
```

* Define o nome do personagem a ser procurado.
* Usa o método `ler(path)` para buscar os dados no arquivo.
* Se o personagem existir → exibe os atributos com **métodos getters** (`getNome`, `getKi`, etc.).
* Caso contrário → mostra aviso de erro.

---

### 9. **Tratamento de Exceções**

```java
catch (NumberFormatException e) { ... }
catch (IOException e) { ... }
catch (Exception e) { ... }
```

* **NumberFormatException**: Quando o usuário digita letras ao invés de números.
* **IOException**: Problemas com arquivos (não existe, sem permissão, etc.).
* **Exception**: Erros genéricos.

---

### 10. **Encerramento**

```java
JOptionPane.showMessageDialog(null, "Fim de Programa","Adeus de Programa",JOptionPane.WARNING_MESSAGE);
```

* Mensagem final quando o usuário escolhe **não continuar**.

---

## 📌 Estrutura Conceitual

* **Classe:** `UsaDBSuper` (controla a execução e interação).
* **Instância:** `DragonBallSuper personagem = new DragonBallSuper();`
* **Atributos (na classe DragonBallSuper):**

  * `nome`
  * `ki`
  * `tecnica`
  * `velocidade`
  * `transformacao`
* **Getters e Setters:**

  * `getNome()`, `setNome()`
  * `getKi()`, `setKi()`
  * `getTecnica()`, `setTecnica()`
  * `getVelocidade()`, `setVelocidade()`
  * `getTransformacao()`, `setTransformacao()`
* **Métodos de persistência:**

  * `gravar(path)` → grava atributos em um arquivo `.txt`.
  * `ler(path)` → lê os atributos de um arquivo `.txt`.

---

👉 Em resumo:
O programa **cadastra personagens de Dragon Ball Super**, salvando seus atributos em arquivos de texto, e também permite **procurar personagens salvos**, exibindo seus dados ao usuário via janelas gráficas.


