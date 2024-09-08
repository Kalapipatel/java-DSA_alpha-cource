package Strings;

public class angle_btw_hr_minute {
    public static float angle(String time) {
        float min_angle = 361;
        String hr = "";
        hr = hr + time.charAt(0) + time.charAt(1);

        String min = "";
        min = min + time.charAt(3) + time.charAt(4);

        int hour = Integer.parseInt(hr);
        int minute = Integer.parseInt(min);

        float a1 = (hour * 30) + (minute / 2);
        float a2 = (minute * 6);

        float angle = 0;
        if (a1 > a2)
            angle = a1 - a2;
        else
            angle = a1 + a2;

        min_angle = Math.min(angle, 360 - angle);
        // System.out.println(a1 + " " + a2);

        return min_angle;
    }

    public static void main(String args[]) {
        String time = "09:06";

        System.out.println(angle(time));
    }
}
