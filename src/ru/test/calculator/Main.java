package ru.test.calculator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.test.calculator.views.CalculatorView;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        ((CalculatorView)context.getBean("calculatorView", "ru.test.calculator.views.CalculatorView")).setVisible(true);
    }
}
