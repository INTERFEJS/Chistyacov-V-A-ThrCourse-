// 5 ВАРИАНТ. Система анализа данных с использованием "Шаблонныго метода".
package TheTemplateMethodPattern;



// Абстрактный класс, представляющий шаблонный метод
abstract class DataAnalysis {
    // Шаблонный метод
    public final void analyzeData() {
        loadData();
        preprocessData();
        performAnalysis();
        generateReport();
    }

    // Шаги алгоритма, которые должны быть реализованы подклассами
    protected abstract void loadData();
    protected abstract void performAnalysis();

    // Общие шаги, которые могут быть переопределены при необходимости
    protected void preprocessData() {
        System.out.println("Default preprocessing of data...");
    }

    protected void generateReport() {
        System.out.println("Default report generation...");
    }
}

// Конкретный метод анализа: статистика
class StatisticalAnalysis extends DataAnalysis {
    @Override
    protected void loadData() {
        System.out.println("Loading data for statistical analysis...");
    }

    @Override
    protected void performAnalysis() {
        System.out.println("Performing statistical analysis...");
    }

    @Override
    protected void generateReport() {
        System.out.println("Generating statistical report...");
    }
}

// Конкретный метод анализа: машинное обучение
class MachineLearningAnalysis extends DataAnalysis {
    @Override
    protected void loadData() {
        System.out.println("Loading data for machine learning...");
    }

    @Override
    protected void preprocessData() {
        System.out.println("Preprocessing data for machine learning...");
    }

    @Override
    protected void performAnalysis() {
        System.out.println("Training machine learning model...");
    }

    @Override
    protected void generateReport() {
        System.out.println("Generating machine learning report...");
    }
}

// Конкретный метод анализа: генетические алгоритмы
class GeneticAlgorithmAnalysis extends DataAnalysis {
    @Override
    protected void loadData() {
        System.out.println("Loading data for genetic algorithm analysis...");
    }

    @Override
    protected void preprocessData() {
        System.out.println("Preprocessing data for genetic algorithm...");
    }

    @Override
    protected void performAnalysis() {
        System.out.println("Running genetic algorithm...");
    }

    @Override
    protected void generateReport() {
        System.out.println("Generating genetic algorithm report...");
    }
}

// Демонстрация работы паттерна "Шаблонный метод"
public class DataAnalysisSys {
    public static void main(String[] args) {
        // Анализ данных с использованием статистического метода
        DataAnalysis statisticalAnalysis = new StatisticalAnalysis();
        statisticalAnalysis.analyzeData();

        System.out.println();

        // Анализ данных с использованием машинного обучения
        DataAnalysis machineLearningAnalysis = new MachineLearningAnalysis();
        machineLearningAnalysis.analyzeData();

        System.out.println();

        // Анализ данных с использованием генетического алгоритма
        DataAnalysis geneticAlgorithmAnalysis = new GeneticAlgorithmAnalysis();
        geneticAlgorithmAnalysis.analyzeData();
    }
}



