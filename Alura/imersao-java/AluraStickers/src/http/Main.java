package http;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Fazer conexão HTTP e buscar os top 250 filmes
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		URI endereco = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request =  HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response =  client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		System.out.println(body);
		
		//Extrair só os dados que interessam  (título, poster, classificação)
		
		//Exibir e manipular os dados
	}

}
