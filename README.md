# 📌 Explicação do Código – Interface + JavaBean

---

## 1. **Interface `IDBSuper`**

```java
public interface IDBSuper {
    public DragonBallSuper ler (String path) throws IOException;
    public String gravar (String path);
}
```

### ✨ O que faz:

* É uma **interface** que define **assinaturas de métodos** (sem implementação).
* Métodos obrigatórios para qualquer classe que a **implemente**:

  * `ler(String path)` → lê um personagem de um arquivo (pode lançar `IOException`).
  * `gravar(String path)` → grava os atributos em arquivo.

👉 **Função da interface**: garantir que qualquer classe que represente personagens de DB Super tenha a **capacidade de salvar e ler em arquivos**.

---

## 2. **Classe `DragonBallSuper`**

```java
public class DragonBallSuper implements IDBSuper {
```

* É um **JavaBean**, ou seja, uma classe que representa um **objeto com atributos privados** e **métodos getters e setters**.
* Implementa a interface `IDBSuper`, então é obrigada a implementar os métodos `ler` e `gravar`.

---

### 🔑 Atributos (encapsulados)

```java
private String nome;
private int ki;
private int tecnica;
private int velocidade;
private int transformacao;
```

* **Privados (`private`)** → só podem ser acessados indiretamente, através de métodos.
* Representam as características de um personagem.

---

### 🔧 Construtor

```java
public DragonBallSuper() { }
```

* Construtor **vazio** → permite criar um objeto sem definir valores iniciais.

---

### 📥 Getters e Setters

Exemplo:

```java
public String getNome() { return nome; }
public void setNome(String nome) { this.nome = nome; }
```

* **Getters**: retornam o valor de um atributo (`getNome`, `getKi`, etc.).
* **Setters**: alteram o valor de um atributo (`setNome`, `setKi`, etc.).
* Isso garante o **encapsulamento** (controle sobre como os atributos são acessados e modificados).

---

### 📂 Método `ler`

```java
public DragonBallSuper ler(String path) throws IOException {
    String nomeArquivo = nome.replaceAll(" ", "_").toLowerCase();
    BufferedReader br = new BufferedReader(
            new FileReader(path + "/" + nomeArquivo + ".txt"));

    nome = br.readLine();
    ki = Integer.parseInt(br.readLine());
    tecnica = Integer.parseInt(br.readLine());
    velocidade = Integer.parseInt(br.readLine());
    transformacao = Integer.parseInt(br.readLine());
    br.close();

    return this;
}
```

* **Função:** Lê os atributos de um personagem armazenados em um arquivo `.txt`.
* Usa `BufferedReader` para ler linha por linha.
* Preenche os atributos (`nome`, `ki`, etc.) com os valores do arquivo.
* Retorna o próprio objeto (`this`) já preenchido.

---

### 💾 Método `gravar`

```java
public String gravar(String path) {
    try {
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        String nomeArquivo = nome.replaceAll(" ", "_").toLowerCase();
        PrintWriter pw = new PrintWriter(path + "/" + nomeArquivo + ".txt");
        pw.println(nome);
        pw.println(ki);
        pw.println(tecnica);
        pw.println(velocidade);
        pw.println(transformacao);

        pw.flush();
        pw.close();
        return "Arquivo gravado com sucesso";
    } catch (IOException e) {
        return "Falha ao gravar arquivo: " + e.getMessage();
    }
}
```

* **Função:** Cria um arquivo `.txt` e grava os atributos do personagem.
* Se a pasta não existir, cria automaticamente (`dir.mkdir()`).
* O nome do arquivo é gerado a partir do nome do personagem (`replaceAll(" ", "_").toLowerCase()`).
* Retorna uma **mensagem de sucesso** ou **erro**.

---

# 📌 Estrutura Conceitual

### **Classe: `DragonBallSuper`**

* **Atributos privados:** `nome`, `ki`, `tecnica`, `velocidade`, `transformacao`.
* **Construtor:** padrão (sem parâmetros).
* **Getters e Setters:** permitem acessar e modificar atributos.
* **Métodos de persistência:**

  * `gravar(String path)` → grava dados em arquivo.
  * `ler(String path)` → lê dados do arquivo.

### **Interface: `IDBSuper`**

* Define a assinatura de `ler` e `gravar`.
* Garante que qualquer classe que implemente terá esses métodos.

---

# 📌 Diagrama UML Simplificado

```plaintext
           <<interface>>
             IDBSuper
      +--------------------------+
      | + ler(path: String): DragonBallSuper |
      | + gravar(path: String): String       |
      +--------------------------+

                 ▲ implements
                 |
        +-------------------------+
        |     DragonBallSuper     |
        +-------------------------+
        | - nome: String          |
        | - ki: int               |
        | - tecnica: int          |
        | - velocidade: int       |
        | - transformacao: int    |
        +-------------------------+
        | + getNome(): String     |
        | + setNome(String): void |
        | + getKi(): int          |
        | + setKi(int): void      |
        | + getTecnica(): int     |
        | + setTecnica(int): void |
        | + getVelocidade(): int  |
        | + setVelocidade(int): void |
        | + getTransformacao(): int |
        | + setTransformacao(int): void |
        | + ler(path: String): DragonBallSuper |
        | + gravar(path: String): String       |
        +-------------------------+
```

---

👉 Em resumo para sua apresentação:

* **`IDBSuper`** é uma **interface** → define o contrato (quem implementar precisa ter `ler` e `gravar`).
* **`DragonBallSuper`** é um **JavaBean** → contém **atributos privados + getters/setters**, e **implementa os métodos da interface** para salvar e ler arquivos.

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

---

# 📌 Exemplo de Execução do Programa

### 1. **Usuário escolhe a opção 1 – Cadastrar Personagem**

O programa pede as informações:

```
Digite o caminho da pasta onde será salvo as informações do personagem: C:/dbz
Digite o nome do personagem: Goku
Digite quantos pontos de KI esse personagem possui: 9000
Digite a quantos pontos de Técnica que esse personagem possui: 85
Digite a quantos pontos de velocidade que esse personagem possui: 95
Digite a quantidade de transformações que esse personagem faz: 3
```

👉 Internamente:

```java
personagem.setNome("Goku");
personagem.setKi(9000);
personagem.setTecnica(85);
personagem.setVelocidade(95);
personagem.setTransformacao(3);
personagem.gravar("C:/dbz");
```

---

### 2. **Arquivo gerado**

Caminho: `C:/dbz/goku.txt`

Conteúdo do arquivo:

```
Goku
9000
85
95
3
```

Mensagem exibida:

```
Arquivo gravado com sucesso
```

---

### 3. **Usuário escolhe a opção 2 – Procurar Personagem**

O programa pede:

```
Digite o caminho da pasta onde foi salvo o arquivo do personagem: C:/dbz
Digite o nome do personagem: Goku
```

👉 Internamente:

```java
personagem.setNome("Goku");
personagem = personagem.ler("C:/dbz");
```

---

### 4. **Arquivo lido**

O programa abre `C:/dbz/goku.txt` e preenche os atributos do objeto `personagem`.

---

### 5. **Saída exibida ao usuário**

```
Informações do Arquivo
Caminho: C:/dbz
Arquivo: goku.txt

Informações do Personagem
Nome: Goku
Pontos de KI: 9000
Pontos de Técnica: 85
Velocidade: 95
Transformações: 3
```

---

# 📌 Explicação 

1. O **usuário insere dados** → são armazenados em atributos do objeto `DragonBallSuper` por meio dos **setters**.
2. O método `gravar(path)` cria um **arquivo .txt** com esses dados.
3. Quando o usuário escolhe procurar, o método `ler(path)` abre o arquivo e usa os **getters** para exibir os dados.
4. O programa usa **interface gráfica simples (`JOptionPane`)** para interação e **persistência em arquivos texto** para salvar os personagens.

---

👉 Isso mostra **ciclo completo**:

* **Instância criada** → `new DragonBallSuper()`.
* **Atributos preenchidos** → via setters.
* **Dados persistidos** → com `gravar()`.
* **Dados recuperados** → com `ler()`.
* **Dados exibidos** → via getters.


