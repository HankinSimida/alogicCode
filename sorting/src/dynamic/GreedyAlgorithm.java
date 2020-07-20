package dynamic; /**
 * @author hankin
 * @date 2020/7/13 12:53
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心算法：局部利益最大化，不一定是最优算法
 */
class Meeting implements Comparable<Meeting> {

    int meNum;
    int startTime;
    int endTime;

    public Meeting(int meNum, int startTime, int endTime) {
        this.meNum = meNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.endTime > o.endTime) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "dynamic.Meeting{" +
                "meNum=" + meNum +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

public class GreedyAlgorithm {
    public static void main(String[] args) {
        List<Meeting> meetingList = new ArrayList<>();
        meetingList.add(new Meeting(1, 8, 9));
        meetingList.add(new Meeting(2, 8, 10));
        meetingList.add(new Meeting(3, 9, 11));
        meetingList.add(new Meeting(4, 10, 11));
        meetingList.add(new Meeting(5, 11, 13));
        meetingList.add(new Meeting(6, 11, 15));
        meetingList.add(new Meeting(7, 12, 14));
        meetingList.add(new Meeting(8, 13, 15));
        meetingList.add(new Meeting(9, 14, 15));
        meetingList.add(new Meeting(10, 15, 16));
        meetingList.add(new Meeting(11, 16, 17));
        meetingList.sort(null);
        int curTime = 8;
        for (int i = 0; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.startTime >= curTime) {
                System.out.println(meeting.toString());
                curTime = meeting.endTime;
            }
        }
    }
}
