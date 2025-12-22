package ru.evstafeva.line;

import java.util.List;
import java.util.ArrayList;

public class Polyline {
    private List<Point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public int getPointCount() {
        return points.size();
    }

    public double getLength() {
        if (points.size() < 2) {
            return 0;
        }

        double length = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}