package org.open.boot.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * https://www.cnblogs.com/snifferhu/p/3500864.html
 */
public class ServerServiceTest {
    Calendar calender_begin, calender_end;
    //记录测试开始时间，结束时间
    Long time_begin, time_end;
    int flagNumber = 1000000;// 迭代数
    Random r = new Random();
    int i = new Random().nextInt(100);//生成随机种子

    @Before
    public void setUp() throws Exception {
        calender_begin = new GregorianCalendar();
        time_begin = calender_begin.getTimeInMillis();
    }
    @After
    public void tearDown() throws Exception {
        calender_end = new GregorianCalendar();
        time_end = calender_end.getTimeInMillis();
        System.out.println(time_end - time_begin);
    }
    @Test
    public void ifTest() {
        for (int temp = 0; temp < flagNumber; temp++) {
            i = r.nextInt(100);
            if (i == 0) {
            } else if (i == 1) {
                continue;
            } else if (i == 2) {
                continue;
            } else if (i == 3) {
                continue;
            } else if (i == 4) {
                continue;
            } else if (i == 5) {
                continue;
            } else if (i == 6) {
                continue;
            } else if (i == 7) {
                continue;
            } else if (i == 8) {
                continue;
            } else if (i == 9) {
                continue;
            } else if (i == 10) {
                continue;
//            } else if (i == 11) {
//                continue;
//            } else if (i == 12) {
//                continue;
//            } else if (i == 13) {
//                continue;
//            } else if (i == 14) {
//                continue;
//            } else if (i == 15) {
//                continue;
//            } else if (i == 16) {
//                continue;
//            } else if (i == 17) {
//                continue;
//            } else if (i == 18) {
//                continue;
//            } else if (i == 19) {
//                continue;
//            } else if (i == 20) {
//                continue;
//            } else if (i == 21) {
//                continue;
//            } else if (i == 22) {
//                continue;
//            } else if (i == 23) {
//                continue;
//            } else if (i == 24) {
//                continue;
//            } else if (i == 25) {
//                continue;
//            } else if (i == 26) {
//                continue;
//            } else if (i == 27) {
//                continue;
//            } else if (i == 28) {
//                continue;
//            } else if (i == 29) {
//                continue;
//            } else if (i == 30) {
//                continue;
//            } else if (i == 31) {
//                continue;
//            } else if (i == 32) {
//                continue;
//            } else if (i == 33) {
//                continue;
//            } else if (i == 34) {
//                continue;
//            } else if (i == 35) {
//                continue;
//            } else if (i == 36) {
//                continue;
//            } else if (i == 37) {
//                continue;
//            } else if (i == 38) {
//                continue;
//            } else if (i == 39) {
//                continue;
//            } else if (i == 40) {
//                continue;
//            } else if (i == 41) {
//                continue;
//            } else if (i == 42) {
//                continue;
//            } else if (i == 43) {
//                continue;
//            } else if (i == 44) {
//                continue;
//            } else if (i == 45) {
//                continue;
//            } else if (i == 46) {
//                continue;
//            } else if (i == 47) {
//                continue;
//            } else if (i == 48) {
//                continue;
//            } else if (i == 49) {
//                continue;
//            } else if (i == 50) {
//                continue;
//            } else if (i == 51) {
//                continue;
//            } else if (i == 52) {
//                continue;
//            } else if (i == 53) {
//                continue;
//            } else if (i == 54) {
//                continue;
//            } else if (i == 55) {
//                continue;
//            } else if (i == 56) {
//                continue;
//            } else if (i == 57) {
//                continue;
//            } else if (i == 58) {
//                continue;
//            } else if (i == 59) {
//                continue;
//            } else if (i == 60) {
//                continue;
//            } else if (i == 61) {
//                continue;
//            } else if (i == 62) {
//                continue;
//            } else if (i == 63) {
//                continue;
//            } else if (i == 64) {
//                continue;
//            } else if (i == 65) {
//                continue;
//            } else if (i == 66) {
//                continue;
//            } else if (i == 67) {
//                continue;
//            } else if (i == 68) {
//                continue;
//            } else if (i == 69) {
//                continue;
//            } else if (i == 70) {
//                continue;
//            } else if (i == 71) {
//                continue;
//            } else if (i == 72) {
//                continue;
//            } else if (i == 73) {
//                continue;
//            } else if (i == 74) {
//                continue;
//            } else if (i == 75) {
//                continue;
//            } else if (i == 76) {
//                continue;
//            } else if (i == 77) {
//                continue;
//            } else if (i == 78) {
//                continue;
//            } else if (i == 79) {
//                continue;
//            } else if (i == 80) {
//                continue;
//            } else if (i == 81) {
//                continue;
//            } else if (i == 82) {
//                continue;
//            } else if (i == 83) {
//                continue;
//            } else if (i == 84) {
//                continue;
//            } else if (i == 85) {
//                continue;
//            } else if (i == 86) {
//                continue;
//            } else if (i == 87) {
//                continue;
//            } else if (i == 88) {
//                continue;
//            } else if (i == 89) {
//                continue;
//            } else if (i == 90) {
//                continue;
//            } else if (i == 91) {
//                continue;
//            } else if (i == 92) {
//                continue;
//            } else if (i == 93) {
//                continue;
//            } else if (i == 94) {
//                continue;
//            } else if (i == 95) {
//                continue;
//            } else if (i == 96) {
//                continue;
//            } else if (i == 97) {
//                continue;
//            } else if (i == 98) {
//                continue;
//            } else if (i == 99) {
//                continue;
//            } else if (i == 100) {
//                continue;
            } else {

            }
        }
    }
    @Test
    public void switchTest() throws InterruptedException {
        for (int temp = 0; temp < flagNumber; temp++) {
            i = r.nextInt(100);
            switch (i) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
//                case 11:
//                    break;
//                case 12:
//                    break;
//                case 13:
//                    break;
//                case 14:
//                    break;
//                case 15:
//                    break;
//                case 16:
//                    break;
//                case 17:
//                    break;
//                case 18:
//                    break;
//                case 19:
//                    break;
//                case 20:
//                    break;
//                case 21:
//                    break;
//                case 22:
//                    break;
//                case 23:
//                    break;
//                case 24:
//                    break;
//                case 25:
//                    break;
//                case 26:
//                    break;
//                case 27:
//                    break;
//                case 28:
//                    break;
//                case 29:
//                    break;
//                case 30:
//                    break;
//                case 31:
//                    break;
//                case 32:
//                    break;
//                case 33:
//                    break;
//                case 34:
//                    break;
//                case 35:
//                    break;
//                case 36:
//                    break;
//                case 37:
//                    break;
//                case 38:
//                    break;
//                case 39:
//                    break;
//                case 40:
//                    break;
//                case 41:
//                    break;
//                case 42:
//                    break;
//                case 43:
//                    break;
//                case 44:
//                    break;
//                case 45:
//                    break;
//                case 46:
//                    break;
//                case 47:
//                    break;
//                case 48:
//                    break;
//                case 49:
//                    break;
//                case 50:
//                    break;
//                case 51:
//                    break;
//                case 52:
//                    break;
//                case 53:
//                    break;
//                case 54:
//                    break;
//                case 55:
//                    break;
//                case 56:
//                    break;
//                case 57:
//                    break;
//                case 58:
//                    break;
//                case 59:
//                    break;
//                case 60:
//                    break;
//                case 61:
//                    break;
//                case 62:
//                    break;
//                case 63:
//                    break;
//                case 64:
//                    break;
//                case 65:
//                    break;
//                case 66:
//                    break;
//                case 67:
//                    break;
//                case 68:
//                    break;
//                case 69:
//                    break;
//                case 70:
//                    break;
//                case 71:
//                    break;
//                case 72:
//                    break;
//                case 73:
//                    break;
//                case 74:
//                    break;
//                case 75:
//                    break;
//                case 76:
//                    break;
//                case 77:
//                    break;
//                case 78:
//                    break;
//                case 79:
//                    break;
//                case 80:
//                    break;
//                case 81:
//                    break;
//                case 82:
//                    break;
//                case 83:
//                    break;
//                case 84:
//                    break;
//                case 85:
//                    break;
//                case 86:
//                    break;
//                case 87:
//                    break;
//                case 88:
//                    break;
//                case 89:
//                    break;
//                case 90:
//                    break;
//                case 91:
//                    break;
//                case 92:
//                    break;
//                case 93:
//                    break;
//                case 94:
//                    break;
//                case 95:
//                    break;
//                case 96:
//                    break;
//                case 97:
//                    break;
//                case 98:
//                    break;
//                case 99:
//                    break;
//                case 100:
//                    break;
                default:
                    break;
            }
        }
    }

    @Test
    public void testSwitch() {
        String a = "aa";
        switch (a) {
            case "aa":
                System.out.println("111");
                break;
            case "AaAa":
                System.out.println("222");
                break;
            case "AaBB":
                System.out.println("333");
                break;
        }
    }

}