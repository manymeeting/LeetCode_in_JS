package datastruct;

import java.util.TreeMap;

/**
 * Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

 Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

 A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

 For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

 Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 Example 1:

 MyCalendar();
 MyCalendar.book(10, 20); // returns true
 MyCalendar.book(15, 25); // returns false
 MyCalendar.book(20, 30); // returns true
 Explanation:
 The first event can be booked.  The second can't because time 15 is already booked by another event.
 The third event can be booked, as the first event takes every time less than 20, but not including 20.


 Note:

 The number of calls to MyCalendar.book per test case will be at most 1000.
 In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].


 */

// TreeMap<start，end>来记录interval，每次取floorkey和ceilingkey，
// 如果treeMap.get(floorKey) > start 或者 ceilingKey < end 就说明有重叠，

// 注意取key之后先判断是否为null，否则运行时会出NPE

public class MyCalendarI729 {
    private TreeMap<Integer, Integer> treeMap;
    public MyCalendarI729() {
        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer floorKey = treeMap.floorKey(start);
        if(floorKey != null && treeMap.get(floorKey) > start) {
            return false;
        }

        Integer ceilingKey = treeMap.ceilingKey(start);
        if(ceilingKey != null && ceilingKey < end) {
            return false;
        }

        treeMap.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */