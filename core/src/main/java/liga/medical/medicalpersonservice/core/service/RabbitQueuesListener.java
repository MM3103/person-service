package liga.medical.medicalpersonservice.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.common.dto.MessageType;
import liga.medical.common.dto.RabbitMessageDto;
import liga.medical.medicalpersonservice.core.model.QueueNames;
import liga.medical.medicalpersonservice.core.model.Signal;
import liga.medical.medicalpersonservice.core.repository.SignalRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitQueuesListener {

    private final SignalRepository signalRepository;

    private final PersonDataService personDataService;

    private final ObjectMapper objectMapper;

    public RabbitQueuesListener(SignalRepository signalRepository, PersonDataService personDataService, ObjectMapper objectMapper) {
        this.signalRepository = signalRepository;
        this.personDataService = personDataService;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = QueueNames.DAILY_QUEUE_NAME)
    public void listenDailyQueue(String message) throws JsonProcessingException {
        System.out.println(String.format("Сообщение %s получено из очереди %s .", message, QueueNames.DAILY_QUEUE_NAME));

        RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);

        Signal signal = new Signal();

        signal.setType(MessageType.DAILY);
        signal.setDescription(rabbitMessageDto.getDescription());
        signal.setPersonData(personDataService.getPersonDataById(rabbitMessageDto.getId()));

        signalRepository.save(signal);
    }

    @RabbitListener(queues = QueueNames.ALERT_QUEUE_NAME)
    public void listenAlertQueue(String message) throws JsonProcessingException {

        System.out.println(String.format("Сообщение %s получено из очереди %s .", message, QueueNames.ALERT_QUEUE_NAME));

        RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);

        Signal signal = new Signal();

        signal.setType(MessageType.ALERT);
        signal.setDescription(rabbitMessageDto.getDescription());
        signal.setPersonData(personDataService.getPersonDataById(rabbitMessageDto.getId()));

        signalRepository.save(signal);
    }

/*    @RabbitListener(queues = QueueNames.ERROR_QUEUE_NAME)
    public void listenErrorQueue(String message) {
        System.out.println(String.format("Сообщение %s получено из очереди %s .", message, QueueNames.ERROR_QUEUE_NAME));
    }*/
}
