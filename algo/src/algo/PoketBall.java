package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PoketBall {
    static class Point {
        double x;
        double y;
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static int[][] holes = {{0, 0}, {127, 0}, {254, 0}, {0, 127}, {127, 127}, {254, 127}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double dx = 0;
        double dy = 0;
        int[][] balls = new int[2][2];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                balls[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Point target = new Point(balls[1][0], balls[1][1]);
        Point me = new Point(balls[0][0], balls[0][1]);
        Point hole = findBestHole(me, target);

//        System.out.println(hole.toString());
        Point hitPoint = getHitPoint(me, target, hole);
        double ansAngle = getAngle(me, hitPoint);
        System.out.println(ansAngle);
    }

    // 히트 포인트 구하기
    public static Point getHitPoint(Point me, Point target, Point hole) {
        double dx = hole.x - target.x;
        double dy = hole.y - target.y;
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));

        // 비례식 5.73 : distance = ? : dx or dy
        dx = 5.73 * dx / distance;
        dy = 5.73 * dy / distance;
        Point hitPoint = new Point(target.x - dx, target.y - dy);
        System.out.println(hitPoint);
        System.out.println(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
        return hitPoint;
    }

    // 제일 치기 쉬운 홀 찾기
    public static Point findBestHole(Point me, Point target) {
        double min = 300000.0;
        Point ret = new Point(0, 0);
        for (int i = 0; i < 6; i++) {
            Point hole = new Point(holes[i][0], holes[i][1]);
            double angle = betweenAngle(me, target, hole);
            if (angle < min) {
                min = Math.min(angle, min);
                ret = hole;
            }
        }
        System.out.println(ret);
        return ret;
    }

    // 홀과 공, 홀과 타깃공 사이 각도 구하기
    public static double betweenAngle(Point me, Point target, Point hole) {
        // 흰공과 홀 사이 거리
        double a = Math.sqrt(Math.pow(hole.x - me.x, 2) + Math.pow(hole.y - me.y, 2));
        // 흰공과 타깃 사이 거리
        double b = Math.sqrt(Math.pow(me.x - target.x, 2) + Math.pow(me.y - target.y, 2));
        // 타깃과 홀 사이 거리
        double c = Math.sqrt(Math.pow(hole.x - target.x, 2) + Math.pow(hole.y - target.y, 2));

        double angle = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
        return Math.toDegrees(angle);
    }

    // 각도 구하기
    public static double getAngle(Point me, Point hitPoint) {
        double dx = Math.abs(hitPoint.x - me.x);
        double dy = Math.abs(hitPoint.y - me.y);
        double angle = Math.atan2(dy, dx);
        if (getLocation(me, hitPoint) == 1)
            return Math.toDegrees(angle);
        else if (getLocation(me, hitPoint) == 2)
            return 180 - Math.toDegrees(angle);
        else if (getLocation(me, hitPoint) == 3)
            return 180 + Math.toDegrees(angle);
        else
            return 360 - Math.toDegrees(angle);
    }

    //상대적으로 몇사분면인지
    public static int getLocation(Point me, Point hitPoint) {
        if (hitPoint.x - me.x >= 0 && hitPoint.y - me.y < 0)
            return 1;
        else if (hitPoint.x - me.x < 0 && hitPoint.y - me.y <= 0)
            return 2;
        else if (hitPoint.x - me.x <= 0 && hitPoint.y - me.y > 0)
            return 3;
        else if (hitPoint.x - me.x > 0 && hitPoint.y - me.y >= 0)
            return 4;
        return 0;
    }
}
