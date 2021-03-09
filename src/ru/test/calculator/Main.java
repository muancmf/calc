package ru.test.calculator;

import ru.test.calculator.controllers.CalculatorController;
import ru.test.calculator.models.CalculatorModel;
import ru.test.calculator.views.CalculatorView;

public class Main {

    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);

        view.setVisible(true);
    }
}
