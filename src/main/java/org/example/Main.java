package org.example;

public class Main {
    public static void main(String[] args) {
        int[] primesL = {2, 3, 5};
        int limit = 200;

        // для оптимизации посчитаем самое первое минимально возможное произведение
        int startValue = 1;
        for (int k : primesL) startValue *= k;

        // основной цикл проверки
        // будем проверять каждое возможное значение произведения от начального до предельного
        for (int val = startValue; val <= limit; val++) {
            int modVal = val; // копируем значение в переменную, которую будем дербанить

            int[] powersL = {0, 0, 0}; // инициализируем степени множителей

            boolean appropriate = true; // делится ли хотя бы на одно из списка делителей
            // пока число подходит (см. выше), и не раздербанили до конца
            while (appropriate && (modVal >= primesL[0])) {
                appropriate = false;
                // прогоняем по каждому делителю
                for (int i = 0; i < primesL.length; i++) {
                    int modulo = modVal % primesL[i];
                    // если делится на делитель из списка без остатка
                    if (modulo == 0) {
                        appropriate = true;
                        powersL[i]++;
                        modVal /= primesL[i];
                        break;
                    }
                }
            }

            if (!appropriate)
                continue;
            // проверка, что есть все множители, и каждый хотя бы в первой степени
            boolean fullSet = true;
            for (int k : powersL)
                if (k == 0) {
                    fullSet = false;
                    break;
                }
            if (!fullSet)
                continue;

            // вывод
            System.out.print(val);
            System.out.print("     ");
            for (int i = 0; i < primesL.length; i++) {
                for (int j = 1; j <= powersL[i]; j++) {
                    System.out.print(primesL[i]);
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();

        }

    }
}