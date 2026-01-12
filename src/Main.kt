
enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }


data class Usuario(val nome: String)


data class ConteudoEducacional(
    val nome: String,
    val duracao: Int = 60
)


data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()


    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }


    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        inscritos.forEach { println("- ${it.nome}") }
    }


    fun cargaHorariaTotal(): Int {
        return conteudos.sumOf { it.duracao }
    }
}

fun main() {

    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 90)
    val poo = ConteudoEducacional("Programação Orientada a Objetos", 120)
    val colecoes = ConteudoEducacional("Coleções em Kotlin", 80)


    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(kotlinBasico, poo, colecoes)
    )


    val usuario1 = Usuario("Marcos")
    val usuario2 = Usuario("Ana")
    val usuario3 = Usuario("Carlos")


    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)


    formacaoKotlin.listarInscritos()


    println("Carga horária total da formação: ${formacaoKotlin.cargaHorariaTotal()} minutos")
}
