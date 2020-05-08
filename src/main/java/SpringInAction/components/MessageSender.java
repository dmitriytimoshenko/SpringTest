package SpringInAction.components;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;

import javax.jms.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageSender extends Thread  {

    // Адрес брокера
    private String url;

    // Имя очереди
    private String queueName;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public void sendFiveMessages()  {


        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // Создаем Embedded брокер


        try {
            ConnectionFactory confactory = new ActiveMQConnectionFactory(url);

            // Создаем соединение
            Connection connection = confactory.createConnection();
            connection.start();

            // Создаем сессию
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            // Создаем очередь
            Destination destination = session.createQueue(queueName);

            // Создаем отправителя
            MessageProducer producer = session.createProducer(destination);

            // сообщение для отправки

            TextMessage messageOne = session.createTextMessage("Hello, Budas!");
            messageOne.setJMSDeliveryMode(DeliveryMode.PERSISTENT);

            System.out.println("Start sending: " + dateFormat.format(new Date()));

            for (int i = 0; i < 100; i++) {
                producer.send(messageOne);
                System.out.println("SEND_QUEUE printing: " + messageOne.getText());
                session.commit();

            }

            connection.close();
            System.out.println("End sending: " + dateFormat.format(new Date()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Override
    public void run() {
        sendFiveMessages();
    }
}
