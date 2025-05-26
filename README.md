# Atividade-Principio-SOLID

# Open-Closed Principle (Princípio Aberto-Fechado)
Definição do Open-Closed Principle (OCP)
"Entidades de software (como classes, módulos, funções, etc.) devem estar abertas para extensão, mas fechadas para modificação."

O que isso significa?
Esse princípio diz que devemos poder adicionar novos comportamentos a um sistema sem precisar alterar o código existente. Ou seja:

"Aberto para extensão" → o sistema pode receber novos comportamentos ou funcionalidades.

"Fechado para modificação" → o código existente não deve ser alterado para isso.

O objetivo do OCP é evitar alterações em código já escrito e testado, o que reduz a chance de quebrar funcionalidades existentes. Para isso, usamos abstrações, como interfaces, herança ou composição, para que novas funcionalidades possam ser acopladas ao sistema de forma plugável.

Como aplicar?
Usar polimorfismo e interfaces/abstrações para que novos comportamentos possam ser implementados separadamente.

Aplicar o padrão de projeto Strategy, Decorator, ou outros que permitem adicionar funcionalidades sem modificar as classes existentes.

Projetar o sistema de forma que ele aceite novos módulos sem precisar reescrever os antigos.

Benefícios:
Reduz riscos ao não tocar em código já testado.

Torna o sistema mais modular, manutenível e extensível.

Facilita testes unitários, pois cada novo comportamento pode ser testado isoladamente.

Apoia a evolução do sistema sem causar efeitos colaterais indesejados.

# Single Responsibility Principle (SRP) — o Princípio da Responsabilidade Única

"Uma classe deve ter apenas um único motivo para mudar."
Ou seja, uma única responsabilidade.

No SRP, "responsabilidade" é entendida como um motivo para mudança.
Portanto, se uma classe tem mais de uma razão para ser alterada, ela não segue o SRP.

Na prática, isso significa que uma classe deve encapsular um único comportamento ou propósito coeso, servindo a um único ator ou interesse do sistema.

Uma responsabilidade = Uma coesão funcional
A ideia central é alta coesão interna e baixa acoplamento externo.

écnicamente, aplicar SRP envolve:
Separar lógicas distintas: se uma classe realiza operações relacionadas a persistência, lógica de negócio e apresentação, ela tem múltiplas responsabilidades.

Identificar os "atores" do sistema: cada classe deve servir a um único stakeholder ou papel no domínio.

Ex: o “Departamento Financeiro” pode ser um ator que exige cálculos financeiros.

O “Departamento de Marketing” pode exigir geração de relatórios.

Cada demanda deve ser atendida por classes separadas.

Seguir o princípio de coesão funcional: os métodos e atributos da classe devem trabalhar juntos para cumprir um único propósito.

Consequências práticas da violação
Se uma classe:

Tem múltiplas responsabilidades (ex: lida com regras de negócio e acesso a dados)

Muda por múltiplos motivos (ex: regra tributária e mudança no banco de dados)

...então:

Há acoplamento implícito entre responsabilidades não relacionadas

A manutenção é arriscada

O sistema se torna frágil e difícil de evoluir

 Benefícios técnicos de seguir o SRP
Isolamento de mudanças: mudanças em um comportamento afetam apenas uma classe

Facilidade de teste: cada classe pode ser testada independentemente

Reutilização: classes com responsabilidade única são mais reutilizáveis

Manutenção e evolução mais simples


Relação com outros princípios
O SRP é a base dos demais princípios SOLID. Por exemplo:

Open-Closed Principle depende de classes bem separadas por responsabilidades

Liskov Substitution Principle exige hierarquias com comportamentos coesos

Interface Segregation também reforça responsabilidades únicas em interfaces

# Interface Segregation Principle (ISP) — o Princípio da Segregação da Interface

Definição formal
"Uma classe não deve ser forçada a depender de interfaces que ela não utiliza."

Esse princípio diz que interfaces devem ser específicas e enxutas, com apenas os métodos que fazem sentido para o cliente (a classe que implementa ou usa a interface).

Ou seja:
Evite interfaces grandes e genéricas.
Prefira várias interfaces pequenas e coesas.

Qual o problema que o ISP resolve?
Imagine uma interface com 10 métodos, mas uma classe só precisa de 2.
Ainda assim, ela precisa implementar ou depender de todos os 10 métodos.

Isso gera:

Acoplamento desnecessário

Implementações vazias ou falsas

Maior complexidade para testar e manter

Sinais de violação do ISP
Classes que implementam métodos que não usam.

Interfaces que tentam ser “tudo para todos”.

Mudanças em uma interface quebrando múltiplas implementações que não deveriam ser afetadas.

Objetivo do ISP
Criar interfaces pequenas, especializadas e focadas em um único papel.
Isso permite que as classes dependam somente do que realmente precisam.

Analogias do mundo real
Imagine que você é um entregador. Você precisa de:

GPS

Lista de endereços

Mas te dão um sistema com:

Controle de estoque

Dashboard de vendas

Previsão de demanda

Gerador de relatórios financeiros

Você está sendo forçado a lidar com funções que não te dizem respeito.
Isso é exatamente o que o ISP combate.

Benefícios do ISP
Menor acoplamento

Implementações mais simples

Maior clareza de propósito

Facilidade para fazer manutenção e testes

# D — Dependency Inversion Principle (Princípio da Inversão da Dependência)

"Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações.
Abstrações não devem depender de detalhes. Detalhes devem depender de abstrações."

Esse princípio orienta a inverter a direção natural das dependências no código. Em vez de módulos de alto nível (que coordenam a lógica do sistema) dependerem diretamente de módulos de baixo nível (que fazem tarefas concretas, como acesso a banco, envio de e-mail, etc), ambos devem depender de uma abstração (por exemplo, uma interface).

O que o DIP promove?
Baixo acoplamento

Flexibilidade para trocar implementações

Testabilidade com mocks/stubs

Design orientado a abstrações

 Elementos-chave do DIP:
As interfaces (ou classes abstratas) se tornam o contrato entre as partes.

As implementações concretas são injetadas (geralmente via injeção de dependência).

O código de alto nível não sabe nem se importa com os detalhes de como algo é feito — ele apenas confia na abstração.

Objetivo do Projeto
Simular o funcionamento de pedidos em uma lanchonete, permitindo:

Adicionar produtos de diferentes tipos (lanches, bebidas, sobremesas);

Aplicar cupons de desconto (valores fixos ou percentuais);

Emitir recibos de forma flexível (ex: console, arquivo etc.);

Usar boas práticas de design com foco em modularidade, baixo acoplamento e alta coesão.

Estrutura dos Arquivos
Arquivo	Papel no sistema
Produto.java	Interface para todos os produtos
Lanche.java	Implementação de produto tipo lanche
Bebida.java	Implementação de produto tipo bebida
Sobremesa.java	Implementação de produto tipo doce
Cupom.java	Interface para estratégias de desconto
Pedido.java	Gerencia os itens do pedido e cupons
EmissorRecibo.java	Interface para diferentes formas de gerar recibo

Explicando Cada Componente
1. Produto (interface)
java
Copiar
Editar
public interface Produto {
    String getNome();
    double getPreco();
}
Contrato comum que todos os itens do cardápio devem seguir.

Promove baixo acoplamento: o sistema não precisa saber o tipo exato do produto, apenas que ele tem um nome e um preço.

2. Lanche, Bebida, Sobremesa
java
Copiar
Editar
public class Lanche implements Produto { ... }
public class Bebida implements Produto { ... }
public class Sobremesa implements Produto { ... }
Implementam Produto.

Cada classe trata de um tipo específico de item do cardápio.

Aplicam Liskov Substitution Principle (LSP) — qualquer uma pode ser usada como Produto.

Cada uma tem responsabilidade única (SRP): representar seus dados e comportamento básico.

3. Cupom (interface)
java
Copiar
Editar
public interface Cupom {
    double aplicarDesconto(double total);
}
Abstração de desconto. Serve como estratégia.

Permite ter vários tipos de cupom sem alterar a lógica do pedido (Open-Closed Principle).

Pedido trabalha com a abstração e não com implementação concreta, aplicando Dependency Inversion Principle (DIP).

4. Pedido
java
Copiar
Editar
public class Pedido {
    private List<Produto> itens;
    private Cupom cupom;

    public void adicionarProduto(Produto produto) { ... }
    public void aplicarCupom(Cupom cupom) { ... }
    public double calcularTotal() { ... }
    public List<Produto> getItens() { ... }
}
Centraliza a lógica do pedido: gerenciar produtos, aplicar cupom, calcular total.

Tem alta coesão e SRP: não lida com emissão de recibo nem com persistência, apenas com regras do pedido.

Aberto a novos tipos de cupons sem necessidade de alteração (OCP).

Depende apenas de abstrações: Produto e Cupom (DIP).

5. EmissorRecibo
java
Copiar
Editar
public interface EmissorRecibo {
    void emitir(Pedido pedido);
}
Define uma forma genérica de emitir um recibo.

Cada forma de emissão (console, impressão, PDF etc.) implementa sua própria lógica.

Mantém o sistema extensível sem modificar código existente (OCP).

Permite a substituição de formas de saída sem alterar Pedido, mantendo DIP.

Ciclo de uso do sistema
Criamos uma instância de Pedido.

Adicionamos produtos ao pedido (lanches, bebidas, etc.).

Aplicamos um Cupom se houver.

Chamamos calcularTotal() para obter o valor final.

Usamos um EmissorRecibo para gerar o recibo.

Qual problema esse sistema resolve?
Evita classes inchadas e facilita a manutenção.

Permite adicionar novos tipos de produtos, cupons e recibos sem mexer nas classes já existentes.

Favorece a testabilidade e a reusabilidade de código.

Segue uma arquitetura que isola responsabilidades, facilitando mudanças futuras.
