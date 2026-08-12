import java.lang.reflect.Modifier

fun main() {
    // Parte 1 — Dez exercícios

    //Exercício 1   ·   val e var
    //O código abaixo não compila. Descubra por quê, corrija com a menor mudança possível e explique em uma frase o que a mensagem de erro estava dizendo.
    //fun main() {
    //    val disciplina = "Programação Mobile"
    //    val aulas = 20
    //    aulas = 21
    //    println("$disciplina tem $aulas aulas")
    //}
    //Entregue: o código corrigido e a frase de explicação.

    val diciplina = "programacao mobile"
    // unica mudança que foi feita o tipo de variavel o val e inmutavel e o var pode alterar a variavel quando precisar
    var aulas = 20
    aulas = 21
    println("$diciplina tem $aulas aulas")


    // Exercício 2   ·   val e var
    //Decida val ou var para cada declaração e escreva uma justificativa curta para cada escolha. Lembre da regra da aula: comece com val e só troque quando o compilador reclamar.
    //_____ nomeDoCurso = "Análise e Desenvolvimento de Sistemas"
    //_____ totalDeAlunos = 0        // aumenta conforme a chamada
    //_____ anoLetivo = 2026
    //_____ notaFinal = 0.0          // recalculada a cada avaliação
    //Entregue: as quatro declarações completas e as justificativas.

    val nomeDoCurso = "Análise e Desenvolvimento de Sistema" // o nome do curso nao pode ser alterado
    var totalDeAluno = 0 // eu escolhi o var por conta que dependendo do tempo a quantidade de aluno muda muita
    var anoLetivo = 2026 // eu escolhi o var por conta que o ano pode ser mudado com decorrer do tempo
    var nota_Final =0.0 // escolhi o var tambem por conta que a nota muda muito com o decorrer do semestre com as provas e atividades

    //Exercício 3   ·   tipos e inferência
    //Sem rodar nada, escreva o tipo que o Kotlin vai inferir para cada declaração. Depois rode no Playground e confira — anote quais você errou.
    //val a = 10
    //val b = 10.0
    //val c = "10"
    //val d = '1'
    //val e = true
    //val f = 10L
    //Entregue: a lista dos seis tipos e quais você errou na previsão.

    val a = 10 // tipo inteiro
    val b = 10.0 // tipo Double
    val c = "10" // tipo String
    val d = '1' // tipo char
    val e = true // tipo boolean
    val f = 10L // tipo Long

    //Exercício 4   ·   null safety
    //O código abaixo compila, mas quebra em tempo de execução. Rode e leia a exceção. Depois reescreva sem usar !!, de forma que o programa imprima SEM APELIDO quando o valor for nulo.
    //fun main() {
    //    val apelido: String? = null
    //    println(apelido!!.uppercase())
    //}
    //Entregue: o nome da exceção que apareceu e o código reescrito.


        val apelido: String? = null
        println(apelido?.uppercase()?:"SEM APELIDO") // SEM APELIDO

    // Exercício 5   ·   null safety
    //Complete a função abaixo para que ela devolva o tamanho do texto ou zero, se o texto for nulo. Escreva o corpo em uma única linha, usando corpo de expressão.
    //fun tamanhoSeguro(texto: String?): Int = TODO()
    //
    //fun main() {
    //    println(tamanhoSeguro("Kotlin"))   // deve imprimir 6
    //    println(tamanhoSeguro(null))       // deve imprimir 0
    //}
    //Entregue: a função completa.

   println(tamanhoSeguro("Kotlin")) // 6
   println(tamanhoSeguro(null)) //0



    //Exercício 6   ·   null safety
    //Duas propriedades podem ser nulas ao mesmo tempo. Complete o main para imprimir a cidade de cada aluno, ou o texto não informada quando a informação faltar em qualquer nível.
    //data class Endereco(val cidade: String?)
    //data class Aluno(val nome: String, val endereco: Endereco?)
    //
    //fun main() {
    //    val ana = Aluno("Ana", null)
    //    val beto = Aluno("Beto", Endereco("São Paulo"))
    //    val caio = Aluno("Caio", Endereco(null))
    //    // complete aqui
    //}
    //Entregue: o main completo e a saída que apareceu no console.


    val ana = Aluno("Ana", null)
    val beto = Aluno("Beto", Endereco("São Paulo"))
   val caio = Aluno("Caio", Endereco(null))

    // eu fiz uma list para colocar os alunos e coloquei dentro da lista os nomeas , fiz um for para rodar na quantidade que tem na lista e fiz uma verificacao se voce e null vai tem que informa que nao tem nenhuma informação
    val nomes : List<Aluno?> = listOf(ana,beto,caio)

    for (nome in nomes){

        println(nome?.endereco?.cidade?: "não informada") // a saida quando for null
    }


    // Exercício 7   ·   funções
    //Reescreva a função abaixo usando corpo de expressão única e dê ao parâmetro prefixo o valor padrão Olá. Depois mostre duas chamadas: uma usando o padrão e outra passando outro prefixo.
    //fun saudacao(nome: String, prefixo: String): String {
    //    return "$prefixo, $nome!"
    //}
    //Entregue: a função reescrita e as duas chamadas com a saída de cada uma.


    println(saudacao("Lukinhas","São paulo"))

    // Exercício 9   ·   lambdas
    //Declare uma lambda com o tipo explícito que receba um String e devolva o texto em maiúsculas. Em seguida, use filter e map na lista para ficar só com os nomes de mais de quatro letras, em maiúsculas. Escreva a versão com o parâmetro nomeado e a versão com it.
    //fun main() {
    //    val nomes = listOf("Ana", "Beatriz", "Caio", "Daniela")
    //    // 1) declare a lambda emMaiusculas
    //    // 2) versão com parâmetro nomeado
    //    // 3) versão com it
    //}
    //Entregue: as três partes e a saída impressa.

    val pessoas : List<String?> = listOf("Ana","Beatriz","Caio","Daniela")
    val maiusculo :(String)-> String = {pessoas->pessoas.uppercase()}
    val resultadoNomeado: Any = pessoas.filter { pessoas -> pessoas?.length!! >  4 }.map { pessoas->
        if (pessoas != null) {
            maiusculo(pessoas)
        }
    }
    val resultadoIt = pessoas
        .filter { it?.length!! > 4 }
        .map { it?.uppercase() ?: "" }

    println(resultadoNomeado)
    println(resultadoIt)

    // Exercício 10   ·   lambdas · ponte para o Compose
    //Complete a função para que ela receba uma segunda informação: o que fazer quando o botão for clicado. Depois chame a função usando a sintaxe de trailing lambda. Guarde este exercício: é a forma exata do Button do Jetpack Compose.
    //fun botao(rotulo: String /* falta um parâmetro aqui */) {
    //    println("[$rotulo] clicado")
    //    // execute aqui o que foi recebido
    //}
    //
    //fun main() {
    //    // chame botao com trailing lambda
    //}
    //Entregue: a função completa, a chamada com trailing lambda e a saída.
    // 


    botao("entrar"){
        println("fazendo login")
    }





}

fun tamanhoSeguro(nome: String?): Int = nome?.length?:0 // exercicio 5 ele vai validadar se null se nao for e String ele continua
// ele vai ver o tamanho da string e vai retorna o tamanho dela e se for null ele tem que me retorna 0 como eu pedi para ele

// Exercicio 7
fun saudacao(nome: String?,prefixo:String?): String ="$nome,$prefixo"

// exercicio 6
data class Endereco(val cidade: String?)
data class Aluno(val nome: String, val endereco: Endereco?)

// exercicio 10
fun botao(rotulo: String, acao: () -> Unit) {
    println("[$rotulo] clicado")
    acao()
}
