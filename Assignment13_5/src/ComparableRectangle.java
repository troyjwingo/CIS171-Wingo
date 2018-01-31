
/**
     * Class: Comparable Rectangle
     * Developer: Troy Wingo
     * Date: 01/29/2018
     * Purpose: To get a better understanding of abstract and comparable interface
     */
public abstract class ComparableRectangle extends Rectangle
        implements Comparable<ComparableRectangle> {
            public ComparableRectangle(double Width, double Height) {
                super(Width, Height);
            }
            
            @Override
            public int compareTo(ComparableRectangle o) {
                if (getArea() > o.getArea())
                    return  1;
                else if (getArea() < o.getArea())
                    return -1;
                else
                    return 0;
            }
            public double getArea() {
                return this.Height * this.Width;
            }
        }
        
