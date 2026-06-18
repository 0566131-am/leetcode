class Solution {
    public double angleClock(int hour, int minutes) {
        double ma=minutes*6.0;
        double ha=(hour%12)*30.0+minutes*0.5;
        double diff=Math.abs(ma-ha);
        return Math.min(diff,360.0-diff);
    }
}