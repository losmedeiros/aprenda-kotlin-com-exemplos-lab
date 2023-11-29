enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    // Criando alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 120)

    // Criando uma formação e adicionando conteúdos
    val formacao = Formacao("Formação em Desenvolvimento de Software")
    formacao.conteudos.addAll(listOf(conteudo1, conteudo2))

    // Criando alguns usuários
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    // Matriculando os usuários na formação
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    // Exibindo informações
    println("Formação: ${formacao.nome}")
    println("Conteúdos:")
    formacao.conteudos.forEach { println("${it.nome} - ${it.duracao} minutos") }

    println("\nUsuários matriculados:")
    formacao.inscritos.forEach { println(it.nome) }
}

