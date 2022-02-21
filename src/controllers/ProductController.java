package controllers;

import models.Product;
import utils.Rounder;
import views.SalesView;

// Controller
public class ProductController {

    Product model;
    SalesView view;

    // Конструктор
    public ProductController(Product model, SalesView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getInputs();

        // Здесь, реализуйте:
        // 1) получение имени товара через модель;
        // 2) вызов методов расчетов доходов и налога;
        // 3) округление расчетных значений;
        // 4) вывод расчетов по заданному формату.

        String output = String.format(
                "Наименование товара: %s\nОбщий доход (грн.): %.2f\nСумма налога (грн.): %.2f\nЧистый доход (грн.): %.2f",
                model.getName(),
                Rounder.round(model.calculateIncome()),
                Rounder.round(model.calculateTax(model.TAX_RATE)),
                Rounder.round(model.calculateIncome(model.TAX_RATE))
        );

        view.getOutput(output);

    }

}
