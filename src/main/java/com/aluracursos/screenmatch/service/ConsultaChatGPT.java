package com.aluracursos.screenmatch.service;
import com.theokanning.openai.OpenAiHttpException;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import retrofit2.HttpException;


public class ConsultaChatGPT {

    public static String obtenerTraduccion(String texto) {
        String apiKey = System.getenv("API_KEY");
        OpenAiService service = new OpenAiService(apiKey);

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();


        try {
            var respuesta = service.createCompletion(requisicion);
            return respuesta.getChoices().get(0).getText();
        } catch (HttpException e) {
            if (e.code() == 429) {
                // Manejo de error de cuota excedida
                System.err.println("Has excedido el límite de solicitudes a la API de OpenAI.");
            } else {
                // Manejo de otros posibles errores HTTP
                System.err.println("Error HTTP al conectar con la API de OpenAI: " + e.getMessage());
            }
            return "Error al obtener la traducción.";
        } catch (Exception e) {
            // Manejo de otros errores inesperados
            System.err.println("Error inesperado: " + e.getMessage());
            return "Error al obtener la traducción.";
        }
    }
}



