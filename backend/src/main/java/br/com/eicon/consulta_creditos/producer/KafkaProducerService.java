package br.com.eicon.consulta_creditos.producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaProducerService(
            KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public void enviarEvento(String topico, Object evento) {
        try {
            String json = objectMapper.writeValueAsString(evento);
            kafkaTemplate.send(topico, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}