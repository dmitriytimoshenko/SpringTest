package SpringInAction.components;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmbeddedMessageSaver extends Thread {
    // Адрес брокера
    private String brokerName;

    // Имя очереди
    private String queueName;

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public void getFiveMessages() {

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            ConnectionFactory confactory = new ActiveMQConnectionFactory("vm://" + brokerName);

            // Создаем соединение
            Connection connection = confactory.createConnection();
            connection.start();

            // Создаем сессию
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            // Создаем очередь
            Destination destination = session.createQueue(queueName);

            // Создаем получателя
            MessageConsumer consumer = session.createConsumer(destination);

            // Принимаем сообщения
            System.out.println("Start recieve: " + dateFormat.format(new Date()));

            for (int i = 0; i < 100; i++) {
                Message message = consumer.receive();
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("Recieved message: '" + textMessage.getText() + "'");
                    session.commit();
                }


            }

            System.out.println("End recieve: " + dateFormat.format(new Date()));
            connection.close();
        } catch (JMSException je) {
            System.out.println("Ошибка сообщения: ");
            je.printStackTrace();
        }

    }

    @Override
    public void run() {
        getFiveMessages();
      }
}
