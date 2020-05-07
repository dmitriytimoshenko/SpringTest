package SpringInAction;

import SpringInAction.components.EmbeddedMessageSaver;
import SpringInAction.components.EmbeddedMessageSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // -------------- Формирование компонентов через XML -------------
        ApplicationContext context = new ClassPathXmlApplicationContext("activemq-conf.xml");
        EmbeddedMessageSender sender = (EmbeddedMessageSender) context.getBean("embeddedMessageSender");
        EmbeddedMessageSaver saver = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver");

        try {
            System.out.println("Начало отправки");
            sender.start();
            System.out.println("Поток запущен? " + sender.isAlive());
            sender.join();
            System.out.println("Отправка завершена");
            System.out.println("Поток запущен? " + sender.isAlive());


            System.out.println("Начало вычитки");
            saver.start();
            System.out.println("Поток запущен? " + saver.isAlive());
            saver.join();
            System.out.println("Вычитка завершена");
            System.out.println("Поток запущен? " + saver.isAlive());



        } catch (InterruptedException ie) {
            System.out.println("Поток прерван");
        }
        System.exit(0);
    }
}
