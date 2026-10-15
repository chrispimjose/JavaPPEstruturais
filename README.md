# JavaPPEstruturais

Exemplos didáticos de **Padrões de Projeto Estruturais em Java**, desenvolvidos para estudo e prática em sala de aula.

Os exemplos foram convertidos e organizados em **Java 21**, utilizando uma estrutura simples para execução no **Visual Studio Code**, sem Maven, Gradle ou outros gerenciadores de build.

## Objetivo

Este repositório apresenta exemplos práticos dos principais **Padrões de Projeto Estruturais**, demonstrando diferentes formas de organizar classes e objetos para facilitar integração, composição, reutilização e manutenção de sistemas.

Os códigos foram desenvolvidos com foco didático, utilizando:

- Java 21
- Visual Studio Code
- Projetos Java sem Build Tools
- Programas executados pelo console
- Classes comentadas
- Menus numéricos para facilitar a experimentação
- Exemplos simples e progressivos

---

# Padrões implementados

## 1. Proxy

O padrão **Proxy** utiliza um objeto intermediário para controlar o acesso a outro objeto.

No exemplo desenvolvido, o acesso ao objeto real `Cofre` é controlado pela classe:

```text
CofreProxy
```

O usuário não acessa diretamente o cofre.

Ele cria o objeto através da abstração:

```java
ICofre cofre =
        new CofreProxy(senha);
```

Ao solicitar:

```java
cofre.abrir();
```

o `CofreProxy` verifica se a senha informada está correta.

Somente depois da validação o objeto real é utilizado.

### Estrutura principal

```text
ICofre.java
Cofre.java
CofreProxy.java
App.java
```

### Organização do padrão

```text
Cliente
   |
   v
CofreProxy
   |
   | controla o acesso
   v
Cofre
```

### Conceitos demonstrados

- Controle de acesso
- Objeto intermediário
- Proteção do objeto real
- Lazy Loading
- Interface comum
- Encapsulamento do acesso

---

## 2. Flyweight

O padrão **Flyweight** permite reduzir o consumo de memória através do compartilhamento de objetos que possuem informações iguais.

No exemplo desenvolvido, várias árvores podem possuir o mesmo tipo.

Os dados compartilhados ficam em:

```text
TipoArvore
```

Por exemplo:

```text
Nome: Carvalho
Cor: Verde
```

Essas informações não precisam ser repetidas em cada árvore.

Cada objeto `Arvore` armazena apenas seus dados específicos:

```text
posição X
posição Y
```

A classe:

```text
FabricaArvores
```

é responsável por verificar se um determinado `TipoArvore` já foi criado.

Se existir, o mesmo objeto é reutilizado.

### Exemplo

```java
TipoArvore carvalho1 =
        fabrica.obterTipoArvore(
                "Carvalho",
                "Verde"
        );

TipoArvore carvalho2 =
        fabrica.obterTipoArvore(
                "Carvalho",
                "Verde"
        );
```

As duas variáveis apontam para o mesmo objeto compartilhado:

```java
System.out.println(
        carvalho1 == carvalho2
);
```

Resultado:

```text
true
```

### Estrutura principal

```text
TipoArvore.java
Arvore.java
FabricaArvores.java
App.java
```

### Organização do padrão

```text
Carvalho posição (10,20) ──┐
Carvalho posição (15,25) ──┼──> TipoArvore
Carvalho posição (30,50) ──┘     Carvalho / Verde
```

### Conceitos demonstrados

- Compartilhamento de objetos
- Estado intrínseco
- Estado extrínseco
- Reutilização de instâncias
- Redução do consumo de memória
- Flyweight Factory

---

## 3. Facade

O padrão **Facade** fornece uma classe que simplifica o acesso a um conjunto de classes ou subsistemas mais complexos.

No exemplo, o processo de fazer uma pizza envolve diferentes classes:

```text
Cozinha
Forno
Entrega
```

Sem o Facade, o cliente teria que controlar diretamente cada etapa:

```java
cozinha.prepararMassa();
cozinha.adicionarIngredientes("Mussarela");
forno.assarPizza();
entrega.entregarPizza();
```

Com o padrão Facade, todo o processo é centralizado na classe:

```text
PizzariaFacade
```

O cliente precisa executar apenas:

```java
pizzaria.fazerPedido(
        "Mussarela"
);
```

A classe `PizzariaFacade` coordena internamente todos os subsistemas necessários para concluir o pedido.

### Estrutura principal

```text
Cozinha.java
Forno.java
Entrega.java
PizzariaFacade.java
App.java
```

### Organização do padrão

```text
Cliente
   |
   v
PizzariaFacade
   |
   ├── Cozinha
   ├── Forno
   └── Entrega
```

### Conceitos demonstrados

- Simplificação do acesso
- Redução do acoplamento
- Coordenação de subsistemas
- Encapsulamento da complexidade
- Ponto central de acesso

---

## 4. Decorator

O padrão **Decorator** permite adicionar novas características ou responsabilidades a um objeto sem modificar sua classe original.

No exemplo, o objeto básico é:

```text
CafeSimples
```

A partir dele, podemos adicionar novos comportamentos utilizando decoradores.

Foram implementados:

```text
ComLeite
ComAcucar
```

Por exemplo:

```java
ICafe cafe =
        new ComLeite(
                new CafeSimples()
        );
```

Temos um café simples decorado com leite.

Também podemos combinar vários decoradores:

```java
ICafe cafeCompleto =
        new ComAcucar(
                new ComLeite(
                        new CafeSimples()
                )
        );
```

Nesse caso, cada decorador envolve o objeto anterior.

### Estrutura principal

```text
ICafe.java
CafeSimples.java
CafeDecorator.java
ComLeite.java
ComAcucar.java
App.java
```

### Organização do padrão

```text
ComAcucar
   |
   v
ComLeite
   |
   v
CafeSimples
```

### Conceitos demonstrados

- Composição de objetos
- Inclusão dinâmica de comportamento
- Decorador abstrato
- Decoradores concretos
- Encapsulamento
- Combinação de funcionalidades

---

## 5. Composite

O padrão **Composite** permite organizar objetos individuais e grupos de objetos em uma estrutura hierárquica.

No exemplo desenvolvido, temos:

```text
Funcionario
Departamento
```

`Funcionario` representa um elemento individual da estrutura.

Ele funciona como uma **folha**.

`Departamento` pode conter:

```text
Funcionários
Outros Departamentos
```

Por isso, ele funciona como um **Composite**.

Ambos implementam:

```text
IDepartamentoComponente
```

Isso permite tratá-los através do mesmo tipo.

### Exemplo de estrutura

```text
Empresa XYZ
├── TI
│   ├── Ana
│   ├── João
│   └── Infraestrutura
│       └── Pedro
└── RH
    └── Maria
```

Uma única chamada:

```java
empresa.mostrarNome();
```

percorre toda a estrutura.

### Estrutura principal

```text
IDepartamentoComponente.java
Funcionario.java
Departamento.java
App.java
```

### Organização do padrão

```text
IDepartamentoComponente
        |
        +----------------+
        |                |
        v                v
   Funcionario      Departamento
      Folha           Composite
```

### Conceitos demonstrados

- Estruturas hierárquicas
- Estruturas em árvore
- Folha
- Composite
- Recursividade
- Tratamento uniforme de objetos

---

## 6. Bridge

O padrão **Bridge** separa uma abstração da sua implementação, permitindo que as duas possam evoluir de forma independente.

No exemplo desenvolvido, temos dois grupos principais.

### Abstrações

```text
ControleRemoto
ControleAvancado
```

### Implementações

```text
TVSamsung
TVSony
```

Todas as TVs implementam:

```text
ITV
```

A classe `ControleRemoto` possui uma referência para:

```java
protected ITV tv;
```

Essa associação funciona como a ponte entre o controle e a implementação da televisão.

### Exemplo

```java
ITV tv =
        new TVSamsung();

ControleRemoto controle =
        new ControleRemoto(tv);
```

O mesmo controle pode trabalhar com outra implementação:

```java
ITV tv =
        new TVSony();

ControleRemoto controle =
        new ControleRemoto(tv);
```

Da mesma forma, podemos usar um controle avançado com qualquer TV.

### Estrutura principal

```text
ITV.java
TVSamsung.java
TVSony.java
ControleRemoto.java
ControleAvancado.java
App.java
```

### Organização do padrão

```text
ABSTRAÇÃO

ControleRemoto
      |
      └── ControleAvancado

      |
      | Bridge
      v

IMPLEMENTAÇÃO

ITV
├── TVSamsung
└── TVSony
```

### Conceitos demonstrados

- Separação entre abstração e implementação
- Composição
- Herança
- Polimorfismo
- Independência entre hierarquias
- Combinação de diferentes implementações

---

## 7. Adapter

O padrão **Adapter** permite integrar classes que possuem formas incompatíveis de funcionamento.

No exemplo desenvolvido, existe um sistema antigo:

```text
PagamentoAntigo
```

Esse sistema conhece apenas o método:

```java
processarEmReais(
        double valor
);
```

Porém, o sistema moderno espera:

```java
processarPagamento(
        String moeda,
        double valor
);
```

A classe:

```text
AdaptadorPagamento
```

faz a adaptação entre os dois sistemas.

Ela implementa:

```text
IPagamentoModerno
```

e internamente utiliza:

```text
PagamentoAntigo
```

### Exemplo

O sistema moderno pode executar:

```java
pagamento.processarPagamento(
        "USD",
        50
);
```

O Adapter realiza a conversão e chama o sistema antigo:

```java
pagamentoAntigo.processarEmReais(
        valorEmReais
);
```

Assim, o sistema antigo pode continuar sendo utilizado sem precisar ser modificado.

### Estrutura principal

```text
IPagamentoModerno.java
PagamentoAntigo.java
AdaptadorPagamento.java
App.java
```

### Organização do padrão

```text
Sistema Moderno
      |
      v
IPagamentoModerno
      |
      v
AdaptadorPagamento
      |
      | adapta
      v
PagamentoAntigo
      |
      v
processarEmReais()
```

### Conceitos demonstrados

- Adaptação de classes
- Integração com sistemas legados
- Conversão de chamadas
- Reutilização de código existente
- Interface esperada pelo cliente
- Encapsulamento da adaptação

---

# Organização sugerida

A pasta principal pode ser organizada da seguinte forma:

```text
JavaPPEstruturais
│
├── ProxyAcessoAoCofre
│   └── src
│       ├── ICofre.java
│       ├── Cofre.java
│       ├── CofreProxy.java
│       └── App.java
│
├── FlyweightArvoreNoMapa
│   └── src
│       ├── TipoArvore.java
│       ├── Arvore.java
│       ├── FabricaArvores.java
│       └── App.java
│
├── FacadePizza
│   └── src
│       ├── Cozinha.java
│       ├── Forno.java
│       ├── Entrega.java
│       ├── PizzariaFacade.java
│       └── App.java
│
├── DecoratorCafe
│   └── src
│       ├── ICafe.java
│       ├── CafeSimples.java
│       ├── CafeDecorator.java
│       ├── ComLeite.java
│       ├── ComAcucar.java
│       └── App.java
│
├── CompositeDepartamentos
│   └── src
│       ├── IDepartamentoComponente.java
│       ├── Funcionario.java
│       ├── Departamento.java
│       └── App.java
│
├── BridgeControleRemoto
│   └── src
│       ├── ITV.java
│       ├── TVSamsung.java
│       ├── TVSony.java
│       ├── ControleRemoto.java
│       ├── ControleAvancado.java
│       └── App.java
│
├── AdapterSistemaPagamento
│   └── src
│       ├── IPagamentoModerno.java
│       ├── PagamentoAntigo.java
│       ├── AdaptadorPagamento.java
│       └── App.java
│
└── README.md
```

---

# Como executar

Os exemplos foram preparados para **Java 21**.

Verifique a instalação do Java:

```bash
java -version
```

Exemplo esperado:

```text
openjdk version "21"
```

No Visual Studio Code, abra a pasta correspondente ao projeto e execute:

```text
App.java
```

Cada exemplo possui seu próprio método:

```java
public static void main(String[] args)
```

e pode ser executado independentemente.

---

# Resumo dos padrões

| Padrão | Objetivo principal |
|---|---|
| Proxy | Controlar o acesso a outro objeto |
| Flyweight | Compartilhar objetos para reduzir o consumo de memória |
| Facade | Simplificar o acesso a vários subsistemas |
| Decorator | Adicionar comportamento a um objeto dinamicamente |
| Composite | Organizar objetos individuais e grupos em estruturas hierárquicas |
| Bridge | Separar abstração e implementação |
| Adapter | Permitir a integração entre classes incompatíveis |

---

# Classificação

Todos os exemplos deste repositório pertencem à categoria:

```text
Padrões de Projeto Estruturais
```

Os padrões estruturais tratam principalmente da forma como **classes e objetos são organizados e relacionados**.

Eles ajudam a construir estruturas de software mais flexíveis, permitindo reutilizar componentes, reduzir dependências e integrar diferentes partes de uma aplicação.

---

# Comparação rápida

```text
Proxy
Controla o acesso a um objeto.

Flyweight
Compartilha objetos para economizar memória.

Facade
Simplifica o acesso a vários subsistemas.

Decorator
Adiciona comportamento sem alterar a classe original.

Composite
Organiza objetos em estruturas hierárquicas.

Bridge
Separa abstração e implementação.

Adapter
Faz classes incompatíveis trabalharem juntas.
```

---

# Tecnologias

```text
Java 21
Visual Studio Code
OpenJDK
```

---

Projeto desenvolvido para fins didáticos no estudo de **Engenharia de Software e Padrões de Projeto**.
