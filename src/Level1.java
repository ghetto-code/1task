public class Level1 {
    public static int Unmanned(int L, int N, int [][] track) {

        // пршедшее время на текущий момент
        int totalTime = track[0][0];

        // проходим по "участкам дороги"
        for (int i = 0; i < N; i ++) {

            // записываем время от начала дороги до текущего и до следующего участка с учетом свободной дороги
            int timeFromStartToCurrentPart = track[i][0];
            int timeFromStartToNextPart;

            // если мы не на последнем участке, тогда обновляем переменную с количеством времени от начала дороги до
            // следующей части на первое число в подмассиве "участок"
            if (i != N - 1) {
                timeFromStartToNextPart = track[i+1][0];
            } else {

                // иначе обновить эту переменную данными из L, где хранится весь путь от начала до конца с учетом
                // свободных дорог
                timeFromStartToNextPart = L;
            }

            // записываем время от текущего участка до следующего с учетом свободной дороги
            int timeFromCurrentPartToNextPart = timeFromStartToNextPart - timeFromStartToCurrentPart;

            // если время красного сигнал светофора больше, чем общее время
            if (track[i][1] >= totalTime) {

                // тогда мы к общему времени прибавляем время до следующего светофора + время, которое нужно простоять
                // на красном
                totalTime += (track[i][1] - totalTime) + timeFromCurrentPartToNextPart;

                // инчае если общее время больше времени горения красного сигнала, тогда
            } else if (track[i][1] < totalTime) {

                // узнаем какой сейчас цвет
                int x = totalTime % (track[i][1] + track[i][2]);
                if (x < track[i][1]) {
                    totalTime += track[i][1] - x;
                    totalTime += timeFromCurrentPartToNextPart;
                } else {
                    totalTime += timeFromCurrentPartToNextPart;
                }
            }
        }
        return totalTime;
    }
}
