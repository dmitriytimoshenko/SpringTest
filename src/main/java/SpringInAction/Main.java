package SpringInAction;

import SpringInAction.components.EmbeddedMessageSaver;
import SpringInAction.components.EmbeddedMessageSender;
import SpringInAction.components.MessageSaver;
import SpringInAction.components.MessageSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // -------------- Формирование компонентов через XML -------------
        ApplicationContext context = new ClassPathXmlApplicationContext("activemq-conf.xml");
        //Бины внутреннего брокера
        EmbeddedMessageSender sender = (EmbeddedMessageSender) context.getBean("embeddedMessageSender");
        EmbeddedMessageSaver saver0 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver0");
        EmbeddedMessageSaver saver1 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver1");
        EmbeddedMessageSaver saver2 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver2");
        EmbeddedMessageSaver saver3 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver3");
        EmbeddedMessageSaver saver4 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver4");
        EmbeddedMessageSaver saver5 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver5");
        EmbeddedMessageSaver saver6 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver6");
        EmbeddedMessageSaver saver7 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver7");
        EmbeddedMessageSaver saver8 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver8");
        EmbeddedMessageSaver saver9 = (EmbeddedMessageSaver) context.getBean("embeddedMessageSaver9");

        //Бины внешнего брокера
        MessageSender qsender = (MessageSender) context.getBean("MessageSender");
        MessageSaver qsaver0 = (MessageSaver) context.getBean("MessageSaver0");
        MessageSaver qsaver1 = (MessageSaver) context.getBean("MessageSaver1");
        MessageSaver qsaver2 = (MessageSaver) context.getBean("MessageSaver2");
        MessageSaver qsaver3 = (MessageSaver) context.getBean("MessageSaver3");
        MessageSaver qsaver4 = (MessageSaver) context.getBean("MessageSaver4");
        MessageSaver qsaver5 = (MessageSaver) context.getBean("MessageSaver5");
        MessageSaver qsaver6 = (MessageSaver) context.getBean("MessageSaver6");
        MessageSaver qsaver7 = (MessageSaver) context.getBean("MessageSaver7");
        MessageSaver qsaver8 = (MessageSaver) context.getBean("MessageSaver8");
        MessageSaver qsaver9 = (MessageSaver) context.getBean("MessageSaver9");
/*
        try {

            System.out.println("Начало отправки");
            sender.start();
            System.out.println("Поток sender запущен? " + sender.isAlive());
            System.out.println("Отправка завершена");
            sender.join();
            System.out.println("Поток sender запущен? " + sender.isAlive());


            System.out.println("Начало вычитки");
            saver0.start();
            System.out.println("Поток saver0 запущен? " + saver0.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver0 запущен? " + saver0.isAlive());


            System.out.println("Начало вычитки");
            saver1.start();
            System.out.println("Поток saver1 запущен? " + saver1.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver1 запущен? " + saver1.isAlive());

            System.out.println("Начало вычитки");
            saver2.start();
            System.out.println("Поток saver2 запущен? " + saver2.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver2 запущен? " + saver2.isAlive());

            System.out.println("Начало вычитки");
            saver3.start();
            System.out.println("Поток saver3 запущен? " + saver3.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver3 запущен? " + saver3.isAlive());

            System.out.println("Начало вычитки");
            saver4.start();
            System.out.println("Поток saver4 запущен? " + saver4.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver4 запущен? " + saver4.isAlive());

            System.out.println("Начало вычитки");
            saver5.start();
            System.out.println("Поток saver5 запущен? " + saver5.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver5 запущен? " + saver5.isAlive());

            System.out.println("Начало вычитки");
            saver6.start();
            System.out.println("Поток saver6 запущен? " + saver6.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver6 запущен? " + saver6.isAlive());

            System.out.println("Начало вычитки");
            saver7.start();
            System.out.println("Поток saver7 запущен? " + saver7.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver7 запущен? " + saver7.isAlive());

            System.out.println("Начало вычитки");
            saver8.start();
            System.out.println("Поток saver8 запущен? " + saver8.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver8 запущен? " + saver8.isAlive());

            System.out.println("Начало вычитки");
            saver9.start();
            System.out.println("Поток saver9 запущен? " + saver9.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver9 запущен? " + saver9.isAlive());


            saver0.join();
            saver1.join();
            saver2.join();
            saver3.join();
            saver4.join();
            saver5.join();
            saver6.join();
            saver7.join();
            saver8.join();
            saver9.join();




        } catch (InterruptedException ie) {
            System.out.println("Поток прерван");
        }
        System.exit(0);

 */

        try {

            System.out.println("Начало отправки");
            qsender.start();
            System.out.println("Поток sender запущен? " + qsender.isAlive());
            System.out.println("Отправка завершена");
            qsender.join();
            System.out.println("Поток sender запущен? " + qsender.isAlive());


            System.out.println("Начало вычитки");
            qsaver0.start();
            System.out.println("Поток saver0 запущен? " + qsaver0.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver0 запущен? " + qsaver0.isAlive());


            System.out.println("Начало вычитки");
            qsaver1.start();
            System.out.println("Поток saver1 запущен? " + qsaver1.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver1 запущен? " + qsaver1.isAlive());

            System.out.println("Начало вычитки");
            qsaver2.start();
            System.out.println("Поток saver2 запущен? " + qsaver2.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver2 запущен? " + qsaver2.isAlive());

            System.out.println("Начало вычитки");
            qsaver3.start();
            System.out.println("Поток saver3 запущен? " + qsaver3.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver3 запущен? " + qsaver3.isAlive());

            System.out.println("Начало вычитки");
            qsaver4.start();
            System.out.println("Поток saver4 запущен? " + qsaver4.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver4 запущен? " + qsaver4.isAlive());

            System.out.println("Начало вычитки");
            qsaver5.start();
            System.out.println("Поток saver5 запущен? " + qsaver5.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver5 запущен? " + qsaver5.isAlive());

            System.out.println("Начало вычитки");
            qsaver6.start();
            System.out.println("Поток saver6 запущен? " + qsaver6.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver6 запущен? " + qsaver6.isAlive());

            System.out.println("Начало вычитки");
            qsaver7.start();
            System.out.println("Поток saver7 запущен? " + qsaver7.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver7 запущен? " + qsaver7.isAlive());

            System.out.println("Начало вычитки");
            qsaver8.start();
            System.out.println("Поток saver8 запущен? " + qsaver8.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver8 запущен? " + qsaver8.isAlive());

            System.out.println("Начало вычитки");
            qsaver9.start();
            System.out.println("Поток saver9 запущен? " + qsaver9.isAlive());
            System.out.println("Вычитка завершена");
            System.out.println("Поток saver9 запущен? " + qsaver9.isAlive());


            qsaver0.join();
            qsaver1.join();
            qsaver2.join();
            qsaver3.join();
            qsaver4.join();
            qsaver5.join();
            qsaver6.join();
            qsaver7.join();
            qsaver8.join();
            qsaver9.join();




        } catch (InterruptedException ie) {
            System.out.println("Поток прерван");
        }
        System.exit(0);

    }
}
