package com.breeze;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : breeze
 * @date : 2020/12/21
 * @description : 自动打卡
 */
public class AutoClockIn {
    public static void main(String[] args) {

        long delaySecond = getDelaySecond(null, null);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(OperatePage::clockIn, delaySecond, TimeUnit.SECONDS);
        executorService.shutdown();

    }

    /**
     * 获取打卡延时时间 - 即多久后执行该方法
     * @param hour 打卡 时
     * @param min 打卡 分钟
     * @return
     */
    public static long getDelaySecond(Integer hour, Integer min) {

        if (hour == null) {
            hour = 7;
        }

        Random random = new Random();
        //获取分钟和秒随机数
        if (min == null) {
            min = random.nextInt(8) + 50;
        }
        int sec = random.nextInt(60);

        LocalDateTime now = LocalDateTime.now().withNano(0);
        //获取打卡时间 默认当前时间加一天的时间
        LocalDateTime clockInTime = now.plusDays(1).withHour(hour).withMinute(min).withSecond(sec).withNano(0);
        System.out.println(now);
        System.out.println(clockInTime);

        long nowLong = now.toEpochSecond(ZoneOffset.of("+8"));
        long clockInLong = clockInTime.toEpochSecond(ZoneOffset.of("+8"));
        long diffTime = clockInLong - nowLong;
        System.out.println(nowLong);
        System.out.println(clockInLong);
        System.out.println(diffTime);

        return diffTime;
    }
}
