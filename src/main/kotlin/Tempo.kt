data class Tempo(val nome: String,
                 val regiao: String,
                 val pais: String) {

    override fun toString(): String {
        return "Tempo API\n" +
                "Nome: $nome\n" +
                "region: $regiao\n" +
                "country: $pais"
    }
}