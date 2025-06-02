package ru.courses.geometry;

public class ClosedPolyLine extends PolyLine {
    
    public ClosedPolyLine() {
        super();
    }
    
    public ClosedPolyLine(Point... points) {
        super(points);
    }
    
    @Override
    public Line[] getLines() {
        if (points.length < 2) {
            return new Line[0];
        }
        
        Line[] parentLines = super.getLines();
        Line[] lines = new Line[parentLines.length + 1];
        
        for (int i = 0; i < parentLines.length; i++) {
            lines[i] = parentLines[i];
        }
        
        lines[lines.length - 1] = new Line(points[points.length - 1], points[0]);
        
        return lines;
    }
    
    @Override
    public double getLength() {
        if (points.length < 2) {
            return 0;
        }
        
        double parentLength = super.getLength();
        Line closingSegment = new Line(points[points.length - 1], points[0]);
        
        return parentLength + closingSegment.getLength();
    }
    
    @Override
    public String toString() {
        String res = "closedPolyLine [";
        for (int i = 0; i < points.length; i++) {
            res += points[i];
            if (i < points.length - 1) {
                res += ",";
            }
        }
        res += "]";
        return res;
    }
} 