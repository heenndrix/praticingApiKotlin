import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

fun main(){
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=167f8d20fe81460c83a143355242301&q=brazil"))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val meuInfoTempo = gson.fromJson(json, InfoTempo::class.java)


    val time = InfoApiWeather(meuInfoTempo.location.name,
        meuInfoTempo.location.region,
        meuInfoTempo.location.country)

    println(time)
}