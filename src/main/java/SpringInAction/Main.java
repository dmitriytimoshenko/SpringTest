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
    }
}
